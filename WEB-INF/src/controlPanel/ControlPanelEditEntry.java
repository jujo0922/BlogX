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

public class ControlPanelEditEntry extends HttpServlet {

    ST html;
    HttpSession sesion;
    PrintWriter out;
    String entryId;
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
        html = new ST(HtmlTemplates.controlPanelEditEntryPage(), '$', '$');

        entryId = req.getParameter("id");

        sesion = req.getSession(false);

        String level = (String) sesion.getAttribute("permissionLevel");

        if (sesion != null && (level.equals("0") || level.equals("1"))) {
            loadPage();
        } else {

            // TODO -> ERROR HTTP 403
        }

    }

    private void loadPage() {

        loadEntry();

        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }

    private void loadEntry() {

        Optional<BlogEntry> entry = DB.getEntryByID(entryId);
        List<BlogEntry> blogEntriesOrdereredByID;

        if (entry.isPresent()) {

            html.add("entry_title", entry.get().getTitulo());
            html.add("entry_image", entry.get().getImagen());
            html.add("entry_body", entry.get().getTexto());
            html.add("entry_id", entry.get().getId());

        } else {

            try{

                resp.sendRedirect(req.getContextPath() + "/ControlPanelEntrys");

            }catch(IOException e){
                System.err.println(e.getMessage());
            }

        }

    }
}
