package log;

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
import resources.DB;
import resources.HtmlTemplates;
import resources.Md5;

public class LoginCheck extends HttpServlet {

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

        String password = req.getParameter("password");
        String user = req.getParameter("user");
        String level;

        if (!DB.userLoginCheck(user, Md5.createMd5(password))) {
            level = DB.getUserPermissionLevel(user);

            if(!level.equals("")){
                
            sesion = req.getSession(true);
            sesion.setAttribute("permissionLevel", level);
            sesion.setMaxInactiveInterval(60*10);
            resp.sendRedirect(req.getContextPath() + "/home");
            }


        } else {

            html = new ST(HtmlTemplates.loginErrorPage(), '$', '$');
            loadPage();

        }

    }

    private void loadPage(){
        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }

}
