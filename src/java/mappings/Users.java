package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1

import java.io.Serializable;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

    private Integer userid;
    private String username;
    private String password;
    private boolean admin;

    public Users() {
    }

    public Users(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
