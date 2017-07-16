/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Login;

import com.myapp.struts.dao.UsersDAO;
import com.myapp.struts.Utility.mailsending;
import com.myapp.struts.dao.BackupDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappings.Users;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * *
 * @author Sharma
 */
public class LoginAction extends Action {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        LoginForm loginForm = (LoginForm) form;
        UsersDAO dao = new UsersDAO();
        HttpSession session = request.getSession(false);
        Users user = dao.validateForm(loginForm);
        loginForm.setMessage("");
        if (user == null) {
            loginForm.setMessage("Username or Password entered wrong.");
            
            loginForm.setUserName("");
            loginForm.setPassword("");
            
            return mapping.findForward("failure");
            
        } else {
            loginForm.setMessage("");
            session.setAttribute("user", user);
            session.setAttribute("userid", user.getUserid());
            session.setAttribute("userName", user.getUsername());
            session.setAttribute("admin", user.isAdmin());
            
            session.setAttribute("brand", "Palke Jewellers");
            
            loginForm.setPassword("");
            new mailsending().Backupdbtosql();
            SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dat1 = new SimpleDateFormat("ddMMyyyy");
            String Date1 = dat.format(new Date());
            String Date2 = dat1.format(new Date());
            if (!new BackupDAO().isBackupdone(new Date())) {
                new mailsending().sendMailWithAttachment("shy.developers@gmail.com", "Palke Backup - " + Date1, "D:/Backupfiles/backup" + Date2 + ".sql", "Backup of the day");
            }
            return mapping.findForward("display");
        }
    }
}
