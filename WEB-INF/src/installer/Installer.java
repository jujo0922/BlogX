package installer;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Permission;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.stringtemplate.v4.ST;

import resources.Md5;
import resources.HtmlTemplates;

public class Installer extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ST html = new ST(HtmlTemplates.installerDBPage(),'$','$');
        
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        String blogName = req.getParameter("blogname");
        String permissionLevel;

        String status = "installerEndMessageError.html";

        Connection conn = null;
        StringBuffer respuesta = new StringBuffer();
        try {
            String url = "jdbc:sqlite:blogX.db";
            // Se crea la conexión a la base de datos:
		    Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    //creo la tabla entardas
                    String sql = "CREATE TABLE entradas (\n"
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + "titulo TEXT,\n"
                        + "imagen TEXT,\n"
                        + "texto TEXT,\n"
                        + "fecha INTEGER\n"
                        + ");";
                    Statement stmt = conn.createStatement();
                    stmt.execute(sql);
                    // creo la tabla usuarios
                    sql = "CREATE TABLE usuarios (\n"
                    + "user TEXT PRIMARY KEY,\n"
                    + "password TEXT,\n"
                    + "permissionLevel TEXT\n"
                    + ");";
                    stmt = conn.createStatement();
                    stmt.execute(sql);
                    //creo la tabla de ajustes del blog
                    sql = "CREATE TABLE blogSettings (\n"
                    + "blogName TEXT,\n"
                    + "primaryColor TEXT,\n"
                    + "secondaryColor TEXT,\n"
                    + "textPrimaryColor TEXT,\n"
                    + "textSecondaryColor TEXT,\n"
                    + "blogBackground TEXT\n"
                    + ");";
                    stmt = conn.createStatement();
                    stmt.execute(sql);
                    //inserto el usuario
                    String sqlInsert = 
				    "INSERT INTO usuarios(user, password, permissionLevel) VALUES(?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);

                    if(user.equals("") || password.equals("") || user.equals(" ") || password.equals(" ") ){
                        user = "admin";
                        password = "admin";
                    }
                    
                    permissionLevel = "0";

                    pstmt.setString(1, user);
                    pstmt.setString(2, Md5.createMd5(password));
                    pstmt.setString(3, "0");
                    pstmt.executeUpdate();
                    //inserto los ajustes predefindos del blog
                    sqlInsert = 
				    "INSERT INTO blogSettings(blogName, primaryColor, secondaryColor, textPrimaryColor, textSecondaryColor, blogBackground) VALUES(?,?,?,?,?,?)";
                    pstmt = conn.prepareStatement(sqlInsert);

                    if(blogName.equals("") || blogName.equals(" ")){
                        blogName = "BlogX";
                    }

                    pstmt.setString(1, blogName);
                    pstmt.setString(2, "#f2007a");
                    pstmt.setString(3, "#EDF2F4");
                    pstmt.setString(4, "#ffffff");
                    pstmt.setString(5, "#000000");
                    pstmt.setString(6, "https://images.unsplash.com/photo-1535478044878-3ed83d5456ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3582&q=80");
                    pstmt.executeUpdate();

                    conn.close();
                    //el truco es, que si no llega a esta linea, el status siempre es de error, si en alguna linea superior explota, se quedara con la pagina de error.
                    status = "installerEndMessageOk.html";
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

        html.add("status_page", status);

        out.println(html.render());
    }



}
