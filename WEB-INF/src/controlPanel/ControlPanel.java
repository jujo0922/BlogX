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
import resources.HtmlTemplates;
import resources.Md5;

public class ControlPanel extends HttpServlet {
    
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
        html = new ST(HtmlTemplates.controlPanelPage(), '$', '$');

        sesion = req.getSession(false);

        if (sesion != null) {
            loadPage();
        } else {
            if (sesion != null)
                System.out.println(sesion + ", " + sesion.getAttribute("permissionLevel"));

            resp.sendRedirect(req.getContextPath() + "/home");
        }

    }

    private void loadPage() {

        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }
}
