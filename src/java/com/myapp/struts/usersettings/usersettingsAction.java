/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.usersettings;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.dao.UsersDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappings.Users;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Lenovo
 */
public class usersettingsAction extends DispatchAction {

    public ActionForward displayUsers(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            usersettingsForm settingsForm = (usersettingsForm) form;
            settingsForm.setUsername("");
            settingsForm.setPassword("");
            settingsForm.setAdmin(false);
            settingsForm.getLstusers().clear();
            HttpSession session = request.getSession();
            boolean admin = (Boolean) session.getAttribute("admin");

            if (!admin) {

                return mapping.findForward("fail");
            }
            try {
                UsersDAO dao = new UsersDAO();
                settingsForm.getLstusers().addAll(dao.getUsers());

            } catch (Exception e) {
            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }

    }

    public ActionForward changePassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            usersettingsForm settingsForm = (usersettingsForm) form;
            settingsForm.setUsername("");
            settingsForm.setPassword("");
            settingsForm.setConfirmpassword("");
            settingsForm.setOldpassword("");
            settingsForm.setAdmin(false);
            settingsForm.getLstusers().clear();

            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("userName");
            settingsForm.setUsername(username);

            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }

    }

    public ActionForward saveUserDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        if (Constants.isSessionActive(request)) {
            usersettingsForm settingsForm = (usersettingsForm) form;
            UsersDAO dao = new UsersDAO();

            try {
                Users obj = new Users();
                obj.setAdmin(settingsForm.isAdmin());
                obj.setPassword(settingsForm.getPassword());
                obj.setUsername(settingsForm.getUsername());
                dao.saveUser(obj);
                settingsForm.setUsername("");
                settingsForm.setPassword("");
                settingsForm.setConfirmpassword("");
                settingsForm.setUserid(0);
                settingsForm.setAdmin(false);
                settingsForm.getLstusers().clear();
                settingsForm.getLstusers().addAll(dao.getUsers());

            } catch (Exception e) {
            }

            request.setAttribute("messageUsercreation", "messageUsercreation");
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            usersettingsForm settingsForm = (usersettingsForm) form;
            UsersDAO dao = new UsersDAO();
            try {
                for (int i = 0; i < settingsForm.getLstusers().size(); i++) {
                    if (settingsForm.getUserid() == settingsForm.getLstusers().get(i).getUserid()) {
                        dao.deleteUser(settingsForm.getLstusers().get(i));
                        break;
                    }
                }
                settingsForm.getLstusers().clear();
                settingsForm.getLstusers().addAll(dao.getUsers());

            } catch (Exception e) {
            }

            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }

    }

    public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {
        if (Constants.isSessionActive(request)) {
            usersettingsForm settingsForm = (usersettingsForm) form;
            UsersDAO dao = new UsersDAO();

            Users obj = new Users();
            HttpSession session = request.getSession();
            try {
                obj = (Users) session.getAttribute("user");
                obj.setPassword(settingsForm.getPassword());
                dao.changePassword(obj);
                settingsForm.setUsername("");
                settingsForm.setPassword("");
                settingsForm.setConfirmpassword("");
                settingsForm.setUserid(0);
                settingsForm.setAdmin(false);
                settingsForm.getLstusers().clear();

            } catch (Exception e) {
            }

            request.setAttribute("messageUsercreation", "messageUsercreation");
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

}
