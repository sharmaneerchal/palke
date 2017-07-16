package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.List;
import mappings.Drawtypes;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DrawTypesDAO {

    private static final Logger log = Logger.getLogger(DrawTypesDAO.class);

    public List<Drawtypes> getDrawTypes()
            throws Exception {
        /* 25 */ List<Drawtypes> list_drawtypes = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 31 */ Query q = session.createSQLQuery("select * from drawtypes").addEntity(Drawtypes.class);
            /* 33 */ list_drawtypes = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 39 */ return list_drawtypes;
    }

    public static List<Drawtypes> getDrawtypesforshow(int drawtypeid) throws Exception {
        /* 43 */ List<Drawtypes> list_Drawtypes = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 49 */ Query q = session.createSQLQuery("select * from drawtypes where drawtypeid=" + drawtypeid).addEntity(Drawtypes.class);

            /* 51 */ list_Drawtypes = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 55 */ return list_Drawtypes;
    }

    public List<Drawtypes> getDrawtypes() {
        Session session = null;
        Transaction transaction = null;

        /* 62 */ List<Drawtypes> listDrawtypes = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 64 */ Query q = session.createSQLQuery("select * from Drawtypes").addEntity(Drawtypes.class);

            /* 66 */ listDrawtypes = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 72 */ return listDrawtypes;
    }

    public void saveDrawtypes(Drawtypes drawtypes) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 81 */ session.save(drawtypes);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deleteDrawtypes(Drawtypes drawtypes) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 95 */ session.delete(drawtypes);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\DrawTypesDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
