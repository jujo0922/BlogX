package controlPanel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
import resources.DB;
import resources.HtmlTemplates;
import resources.Md5;

public class ControlPanelEditUser extends HttpServlet {

    ST html;
    HttpSession sesion;
    PrintWriter out;
    String userNick, oldPassword, newPassword;
    HttpServletResponse resp;
    HttpServletRequest req;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        this.resp = resp;
        this.req = req;
        resp.setCharacterEncoding("UTF-8");
        html = new ST(HtmlTemplates.controlPanelEditUserPage(), '$', '$');

        userNick = req.getParameter("ncik");

        sesion = req.getSession(false);

        String level = (String) sesion.getAttribute("permissionLevel");

        if (sesion != null && (level.equals("0") || level.equals("1"))) {
            loadPage();
        } else {

            // TODO -> ERROR HTTP 403
        }

    }

    private void loadPage() {

        html.add("user_nick", userNick);
        html.add("set_checked", DB.getUserPermissionLevel(userNick).equals("1")? "":"checked");
        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }

}
