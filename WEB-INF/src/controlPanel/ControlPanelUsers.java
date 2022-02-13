package controlPanel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.stringtemplate.v4.ST;

import resources.BlogEntry;
import resources.BlogThemeApplicator;
import resources.BlogUser;
import resources.DB;
import resources.HtmlTemplates;
import resources.Md5;

public class ControlPanelUsers extends HttpServlet {

    ST html;
    HttpSession sesion;
    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        html = new ST(HtmlTemplates.controlPanelUsersPage(), '$', '$');

        sesion = req.getSession(false);

        String level = (String) sesion.getAttribute("permissionLevel");

        if (sesion != null && level.equals("0")) {
            loadPage();
        } else {

            // TODO -> ERROR HTTP 403
            
            resp.sendRedirect(req.getContextPath() + "/ControlPanelEntrys");
        }

    }

    private void loadPage() {

        loadUsers();

        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }

    private void loadUsers() {

        List<BlogUser> blogUsers = DB.getAllUsers();
        List<BlogUser> blogBlogUsersOrderedByNick;
        String controlPanelUserFormStringList = "";

        blogBlogUsersOrderedByNick = blogUsers.stream()
                .sorted((b1, b2) -> b1.getNick().compareTo(b2.getNick()))
                .collect(Collectors.toList());

        if (!blogBlogUsersOrderedByNick.isEmpty()) {

                for (int i = 0; i < blogBlogUsersOrderedByNick.size(); i++) {

                    ST controlPanelEntryForm = new ST(HtmlTemplates.controlPanelUserForm(), '$', '$');

                    controlPanelEntryForm.add("user_nick", blogBlogUsersOrderedByNick.get(i).getNick());

                    controlPanelUserFormStringList += controlPanelEntryForm.render() + "\n";
                }

                html.add("all_users", controlPanelUserFormStringList);

                controlPanelUserFormStringList = "";
            

        }
    }
}