package home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

public class Entry extends HttpServlet {

    PrintWriter out;
    ST html;
    HttpSession sesion;
    String entryId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        out = resp.getWriter();
        html = new ST(HtmlTemplates.entryPage(), '$', '$');

        sesion = req.getSession(false);

        entryId = req.getParameter("id");

        loadPage();

    }

    private void loadPage() {

        entryLoader();

        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }

    private void entryLoader() {

        Optional<BlogEntry> entry = DB.getEntryByID(entryId);

        if (entry.isPresent()) {
            html.add("entry_image", entry.get().getImagen());
            html.add("entry_title", entry.get().getTitulo());
            html.add("entry_date", entry.get().getFecha());
            html.add("entry_body", entry.get().getTexto());
        } else {
            html.add("entry_image", "Error 404");
            html.add("entry_title", "Error 404");
            html.add("entry_date", "Error 404");
            html.add("entry_body", "Error 404");
        }
    }

}
