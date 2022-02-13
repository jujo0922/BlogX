package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DB {

    static Statement stmt;
    static String sqlSelect;
    static ResultSet cursor;
    static PreparedStatement pstmt;
    static Connection conn;
    final static String dbName = "blogX.db";

    private static void openDBconnection() {

        try {

            String url = "jdbc:sqlite:" + dbName;
            Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {

            System.err.println("Error creating conexion to DB.");
            System.err.println(e.getMessage());

        }
    }

    private static void closeDBconnection() {

        try {

            conn.close();

        } catch (SQLException e) {
            System.err.println("Error closing conexion to DB.");
            System.err.println(e.getMessage());
        }
    }


    public static boolean insertUser(BlogUser user) {
        boolean error = true;

        try {
            openDBconnection();

            String sqlInsert = "INSERT INTO usuarios(user, password, permissionLevel) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, user.getNick());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, Integer.toString(user.getPermissionLevel()));
            pstmt.executeUpdate();

            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println("An error ocurred while insertting an user, see message bellow for more information:");
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static boolean insertEntry(String titulo, String imagen, String texto, LocalDate fecha) {
        boolean error = true;

        try {
            openDBconnection();

            String sqlInsert = "INSERT INTO entradas(titulo, imagen, texto, fecha) VALUES(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, titulo);
            pstmt.setString(2, imagen);
            pstmt.setString(3, texto);
            pstmt.setString(4, fecha.toString());
            pstmt.executeUpdate();

            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static boolean deleteEntry(String id) {
        boolean error = true;
        
        try {
            openDBconnection();

        
            stmt = conn.createStatement();
            sqlSelect = "DELETE FROM entradas WHERE id=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static boolean deleteUser(String nick) {
        boolean error = true;
        
        try {
            openDBconnection();
        
            stmt = conn.createStatement();
            sqlSelect = "DELETE FROM usuarios WHERE user=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, nick);
            pstmt.executeUpdate();
            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static List<BlogUser> getAllUsers() {

        List<BlogUser> users = new ArrayList<>();

        try {

            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT * FROM usuarios";
            cursor = stmt.executeQuery(sqlSelect);

            while (cursor.next()) {

                BlogUser usuer = new BlogUser(cursor.getString("user"), cursor.getString("password"), Integer.parseInt(cursor.getString("permissionlevel")));

                users.add(usuer);
            }

            closeDBconnection();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return users;

    }

    public static List<BlogEntry> getAllEntrys() {

        List<BlogEntry> entries = new ArrayList<>();

        try {

            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT * FROM entradas";
            cursor = stmt.executeQuery(sqlSelect);

            while (cursor.next()) {

                BlogEntry entrada = new BlogEntry(cursor.getString("id"),
                        cursor.getString("titulo"), cursor.getString("imagen"), cursor.getString("texto"),
                        LocalDate.parse(cursor.getString("fecha")));

                entries.add(entrada);
            }

            closeDBconnection();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return entries;

    }

    public static String getUserPermissionLevel(String user) {
        String level = "";

        try {
            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT permissionLevel FROM usuarios WHERE user=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, user);

            cursor = pstmt.executeQuery();
            cursor.next();

            level = cursor.getString("permissionLevel");

            closeDBconnection();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return level;
    }

    public static String getUserMd5Password(String user) {
        String password = "";

        try {
            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT password FROM usuarios WHERE user=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, user);

            cursor = pstmt.executeQuery();
            cursor.next();

            password = cursor.getString("password");

            closeDBconnection();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return password;
    }

    public static boolean userLoginCheck(String user, String md5PasswordForm) {
        boolean error = true;
        String md5PasswordDB = "";

        try {
            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT password FROM usuarios WHERE user=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, user);

            cursor = pstmt.executeQuery();
            cursor.next();

            md5PasswordDB = cursor.getString("password");

            if (md5PasswordForm.equals(md5PasswordDB))
                error = false;

            closeDBconnection();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static Optional<BlogUser> getUserbyNick(String nick) {

        Optional<BlogUser> user = Optional.empty();
        BlogUser u;

        try {

            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT * FROM usuarios WHERE user=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, nick);

            cursor = pstmt.executeQuery();
            cursor.next();

            u = new BlogUser(cursor.getString("user"), cursor.getString("password"), Integer.parseInt(cursor.getString("permissionlevel")));

            closeDBconnection();

            user = Optional.of(u);

        } catch (SQLException er) {
            System.err.println("An error ocurred while getting an user.");
            System.err.println(er.getMessage());
        }

        return user;

    }

    public static Optional<BlogEntry> getEntryByID(String id) {

        Optional<BlogEntry> entry = Optional.empty();
        BlogEntry e;

        try {

            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT * FROM entradas WHERE id=?";
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, id);

            cursor = pstmt.executeQuery();
            cursor.next();

            e = new BlogEntry(cursor.getString("id"), cursor.getString("titulo"), cursor.getString("imagen"),
                    cursor.getString("texto"), LocalDate.parse(cursor.getString("fecha")));

            closeDBconnection();

            entry = Optional.of(e);

        } catch (SQLException er) {
            System.err.println("An error ocurred while getting an entry.");
            System.err.println(er.getMessage());
        }

        return entry;

    }

    public static boolean editEntry(String id, String titulo, String imagen, String texto) {
        boolean error = true;

        try {
            openDBconnection();

            String sqlInsert = "UPDATE entradas SET titulo =?, imagen=?, texto=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, titulo);
            pstmt.setString(2, imagen);
            pstmt.setString(3, texto);
            pstmt.setString(4, id);
            pstmt.executeUpdate();

            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static boolean editTheme(String blogName, String primaryColor, String secondaryColor, String textPrimaryColor, String textsecondaryColor, String blogBackground) {
        boolean error = true;

        try {
            openDBconnection();

            String sqlInsert = "UPDATE blogSettings SET blogName=?, primaryColor=?, secondaryColor=?, textPrimaryColor=?, textSecondaryColor=?, blogBackground=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, blogName);
            pstmt.setString(2, primaryColor);
            pstmt.setString(3, secondaryColor);
            pstmt.setString(4, textPrimaryColor);
            pstmt.setString(5, textsecondaryColor);
            pstmt.setString(6, blogBackground);
            pstmt.executeUpdate();

            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static boolean editUser(BlogUser user) {
        boolean error = true;

        try {
            openDBconnection();

            String sqlInsert = "UPDATE usuarios SET password =?, permissionLevel=? WHERE user=?";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, Integer.toString(user.getPermissionLevel()));
            pstmt.setString(3, user.getNick());
            pstmt.executeUpdate();

            closeDBconnection();

            error = false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return error;
    }

    public static Optional<Map<String, String>> getThemeColours() {

        Optional<Map<String, String>> mapTheme = Optional.empty();
        Map<String, String> theme = new HashMap<>();
        String blogName = "", primaryColor = "", secondaryColor = "", textPrimaryColor = "", textSecondaryColor = "", blogBackground = "";

        try {

            openDBconnection();

            stmt = conn.createStatement();
            sqlSelect = "SELECT * FROM blogSettings";
            cursor = stmt.executeQuery(sqlSelect);
            while (cursor.next()) {

                blogName = cursor.getString("blogName");
                primaryColor = cursor.getString("primaryColor");
                secondaryColor = cursor.getString("secondaryColor");
                textPrimaryColor = cursor.getString("textPrimaryColor");
                textSecondaryColor = cursor.getString("textSecondaryColor");
                blogBackground = cursor.getString("blogBackground");

            }

            theme.put("blogName", blogName);
            theme.put("primaryColor", primaryColor);
            theme.put("secondaryColor", secondaryColor);
            theme.put("textPrimaryColor", textPrimaryColor);
            theme.put("textSecondaryColor", textSecondaryColor);
            theme.put("blogBackground", blogBackground);

            closeDBconnection();

        } catch (SQLException e) {
            System.err.println("Error getting theme colours");
            System.err.println(e.getMessage());
        }

        mapTheme = Optional.of(theme);
        return mapTheme;
    }
}