package oceniarka.Domain;

/**
 * Created by rafal on 29.11.15.
 */
public class Authority {

    private int id;

    private String username;

    private String authority;

    public Authority() {

    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
