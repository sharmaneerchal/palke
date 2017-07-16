/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.usersettings;

import java.util.ArrayList;
import java.util.List;
import mappings.Users;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Lenovo
 */
public class usersettingsForm extends ActionForm {

    private int userid;
    private String username;
    private String password;
    private String confirmpassword;
    private String oldpassword;
    private boolean admin;
    private List<Users> lstusers;

    public usersettingsForm() {
        this.lstusers = new ArrayList<Users>();
    }

    public usersettingsForm(int userid, String username, String password, String confirmpassword, String oldpassword, boolean admin, List<Users> lstusers) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.oldpassword = oldpassword;
        this.admin = admin;
        this.lstusers = lstusers;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<Users> getLstusers() {
        return lstusers;
    }

    public void setLstusers(List<Users> lstusers) {
        this.lstusers = lstusers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
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
