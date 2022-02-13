package resources;

public class BlogUser {

    private String nick;
    private String password;
    private int permissionLevel;

    public BlogUser(String nick, String password, int permissionLevel) {
        super();
        this.nick = nick;
        this.password = password;
        this.permissionLevel = permissionLevel;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "BlogUser [nick=" + nick + ", password=" + password + ", permissionLevel=" + permissionLevel + "]";
    }

}
