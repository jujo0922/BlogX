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
import resources.DB;
import resources.HtmlTemplates;
import resources.Md5;

public class ControlPanelUpdateTheme extends HttpServlet {

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
        sesion = req.getSession(false);

        String level = (String) sesion.getAttribute("permissionLevel");
        String blogName = req.getParameter("blogName");
        String primaryColor = req.getParameter("primaryColor");
        String secondaryColor = req.getParameter("secondaryColor");
        String textPrimaryColor = req.getParameter("primaryColorText");
        String textSecondaryColor= req.getParameter("secondaryColorText");
        String blogBackground = req.getParameter("blogImage");

        if (sesion != null && level.equals("0")) {
            DB.editTheme(blogName, primaryColor, secondaryColor, textPrimaryColor, textSecondaryColor, blogBackground);
            resp.sendRedirect(req.getContextPath() + "/UpdatePage");
        } else {

            // TODO -> ERROR HTTP 403
        }


    }
}
