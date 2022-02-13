package home;

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

public class Home extends HttpServlet {

    PrintWriter out;
    ST html = new ST(HtmlTemplates.homePage(), '$', '$');
    List<BlogEntry> blogEntriesOrdereredByDate = new ArrayList<>();
    String entrysString = "";
    BlogEntry latestBlogEntry;
    HttpSession sesion;
    HttpServletRequest req;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        out = resp.getWriter();
        
        resp.setCharacterEncoding("UTF-8");
        sesion = req.getSession(false);

        html = new ST(HtmlTemplates.homePage(), '$', '$');
        blogEntriesOrdereredByDate = new ArrayList<>();
        BlogEntry latestBlogEntry;

                    List<BlogEntry> entradas = DB.getAllEntrys();

                    blogEntriesOrdereredByDate = entradas.stream()
                            .sorted((b1, b2) -> b2.getFecha().compareTo(b1.getFecha())).collect(Collectors.toList());

                    if (!blogEntriesOrdereredByDate.isEmpty()) {

                        latestBlogEntry = blogEntriesOrdereredByDate.get(0);

                        if (blogEntriesOrdereredByDate.size() > 1) {
                            for (int i = 1; i < blogEntriesOrdereredByDate.size(); i++) {
                                ST entryBody = new ST(HtmlTemplates.entryBody(), '$', '$');

                                entryBody.add("id_entry", blogEntriesOrdereredByDate.get(i).getId());
                                entryBody.add("entry_image", blogEntriesOrdereredByDate.get(i).getImagen());
                                entryBody.add("card_title", blogEntriesOrdereredByDate.get(i).getTitulo());

                                entrysString += entryBody.render() + "\n";
                            }

                            html.add("all_entrys", entrysString);
                        }

                        html.add("id_entry", latestBlogEntry.getId());
                        html.add("entry_image", latestBlogEntry.getImagen());
                        html.add("card_title", latestBlogEntry.getTitulo());
                        html.add("entry_date", latestBlogEntry.getFecha());

                        entrysString = "";
                    }

                    loadPage();
             
        }

    

    private void loadPage() {

        out.println(BlogThemeApplicator.loader(html, sesion).render());
    }
}
