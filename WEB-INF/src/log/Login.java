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
import resources.HtmlTemplates;
import resources.Md5;

public class Login extends HttpServlet {

    String blogName = "", primaryColor = "", secondaryColor = "", textPrimaryColor = "", textSecondaryColor = "",
            entrysString = "", blogBackground="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ST html;

        Connection conn = null;
        try {
            String url = "jdbc:sqlite:blogX.db";
            Class.forName("org.sqlite.JDBC")
                    .getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    Statement stmt;
                    String sqlSelect;
                    PreparedStatement pstmt;
                    ResultSet cursor;

                    stmt = conn.createStatement();
                    sqlSelect = "SELECT * FROM blogSettings";
                    cursor = stmt.executeQuery(sqlSelect);
                    while (cursor.next()) {

                        blogName = cursor.getString("blogName");
                        primaryColor = cursor.getString("primaryColor");
                        secondaryColor = cursor.getString("secondaryColor");
                        textPrimaryColor = cursor.getString("textPrimaryColor");
                        textSecondaryColor = cursor.getString("textSecondaryColor");
                        textSecondaryColor = cursor.getString("textSecondaryColor");
                        blogBackground =  cursor.getString("blogBackground");

                    }

                    html = new ST(HtmlTemplates.LoginPage(), '$', '$');

                    html.add("blog_name", blogName);
                    html.add("primary_color", primaryColor);
                    html.add("secondary_color", secondaryColor);
                    html.add("text_primary_color", textPrimaryColor);
                    html.add("text_secondary_color", textSecondaryColor);
                    html.add("blog_background", blogBackground);

                    conn.close();

                    out.println(html.render());
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

}
