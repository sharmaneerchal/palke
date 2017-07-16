package com.myapp.struts.dao;

import com.myapp.struts.Login.LoginForm;
import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.List;
import mappings.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersDAO {

    private static final Logger log = Logger.getLogger(UsersDAO.class);

    public void saveUser(Users users) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(users);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void changePassword(Users users) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /*  50 */ session.update(users);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public List<Users> getUsers() {
        Session session = null;
        Transaction transaction = null;

        /*  62 */ List<Users> listusers = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();

            /*  64 */ Query q = session.createSQLQuery("select * from users").addEntity(Users.class);

            /*  66 */ listusers = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  72 */ return listusers;
    }

    public void deleteUser(Users obj) throws Exception {
        Session session = null;
        Transaction transaction = null;
        /*  79 */ List<Users> listusers = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  81 */ session.delete(obj);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public Users validateForm(LoginForm form) throws Exception {
        /*  91 */ List<Users> list_users = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /*  97 */ Query q = session.createSQLQuery("select * from users where username='" + form.getUserName() + "' and password='" + form.getPassword() + "'").addEntity(Users.class);

            /* 100 */ list_users = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 106 */ if (list_users.size() > 0) {
            /* 107 */ return (Users) list_users.get(0);
        }
        /* 109 */ return null;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\UsersDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
