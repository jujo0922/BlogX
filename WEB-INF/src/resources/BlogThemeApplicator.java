package resources;

import org.stringtemplate.v4.ST;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

public class BlogThemeApplicator {

    public static ST loader(ST html, HttpSession sesion) {

        Optional<Map<String, String>> colours = DB.getThemeColours();

        if (colours.isPresent()) {
            html.add("blog_name", colours.get().get("blogName"));
            html.add("primary_color", colours.get().get("primaryColor"));
            html.add("secondary_color", colours.get().get("secondaryColor"));
            html.add("text_primary_color", colours.get().get("textPrimaryColor"));
            html.add("text_secondary_color", colours.get().get("textSecondaryColor"));
            html.add("blog_background", colours.get().get("blogBackground"));
        } else {
            html.add("blog_name", "BlogX");
            html.add("primary_color", "#f2007a");
            html.add("secondary_color", "#EDF2F4");
            html.add("text_primary_color", "#ffffff");
            html.add("text_secondary_color", "#000000");
            html.add("blog_background", "https://images.unsplash.com/photo-1535478044878-3ed83d5456ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=3582&q=80");
        }

        if (sesion != null) {

            ST cp = new ST(HtmlTemplates.controlPanelNav(), '$', '$');
            ST status = new ST(HtmlTemplates.logOutButton(), '$', '$');

            html.add("control_panel_nav", cp.render());
            html.add("session_status", status.render());
        } else {

            ST status = new ST(HtmlTemplates.loginButton(), '$', '$');
            html.add("control_panel_nav", "");
            html.add("session_status", status);
        }

        return html;

    }

}
