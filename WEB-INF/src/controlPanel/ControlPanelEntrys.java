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

public class ControlPanelEntrys extends HttpServlet {

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
        html = new ST(HtmlTemplates.controlPanelEntrysPage(), '$', '$');

        sesion = req.getSession(false);

        String level = (String) sesion.getAttribute("permissionLevel");

        if (sesion != null && (level.equals("0") || level.equals("1"))) {
            loadPage();
        } else {

            // TODO -> ERROR HTTP 403
        }

    }

    private void loadPage() {

        loadEntries();

        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }

    private void loadEntries() {

        List<BlogEntry> blogEntries = DB.getAllEntrys();
        List<BlogEntry> blogEntriesOrdereredByID;
        String controlPanelEntryFormStringList = "";

        blogEntriesOrdereredByID = blogEntries.stream()
                .sorted((b1, b2) -> Integer.compare(Integer.parseInt(b2.getId()), Integer.parseInt(b1.getId())))
                .collect(Collectors.toList());

        if (!blogEntriesOrdereredByID.isEmpty()) {

            if (blogEntriesOrdereredByID.size() > 0) {
                for (int i = 0; i < blogEntriesOrdereredByID.size(); i++) {

                    ST controlPanelEntryForm = new ST(HtmlTemplates.controlPanelEntryForm(), '$', '$');

                    controlPanelEntryForm.add("entry_title", blogEntriesOrdereredByID.get(i).getTitulo());
                    controlPanelEntryForm.add("entry_date", blogEntriesOrdereredByID.get(i).getFecha());
                    controlPanelEntryForm.add("entry_id", blogEntriesOrdereredByID.get(i).getId());

                    controlPanelEntryFormStringList += controlPanelEntryForm.render() + "\n";
                }

                html.add("all_entrys", controlPanelEntryFormStringList);

                controlPanelEntryFormStringList = "";
            }

        }
    }
}
