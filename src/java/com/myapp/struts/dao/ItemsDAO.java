package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.HashMap;
import java.util.List;
import mappings.Items;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemsDAO {

    private static final Logger log = Logger.getLogger(ItemsDAO.class);

    public List<Items> getItems()
            throws Exception {
        /* 25 */ List<Items> list_items = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 30 */ Query q = session.createSQLQuery("select * from items").addEntity(Items.class);

            /* 32 */ list_items = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 38 */ return list_items;
    }

    public Items getItem(int itemid)
            throws Exception {
        /* 25 */ List<Items> list_items = null;
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 30 */ Query q = session.createSQLQuery("select * from items where itemid=" + itemid).addEntity(Items.class);

            /* 32 */ list_items = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 38 */ return list_items.get(0);
    }

    public HashMap getItemsMap() throws Exception {
        /* 42 */ HashMap hmitems = new HashMap();
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 47 */ Query q = session.createSQLQuery("select * from items").addEntity(Items.class);

            /* 49 */ List<Items> list_items = q.list();

            /* 51 */ for (int i = 0; i < list_items.size(); i++) {
                /* 52 */ Items items = (Items) list_items.get(i);
                /* 53 */ hmitems.put(items.getItemid() + "", items);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 59 */ return hmitems;
    }

    public void saveItem(Items obj, boolean edit) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 67 */ if (edit) {
                /* 68 */ session.update(obj);
            } else {
                /* 70 */ session.save(obj);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\ItemsDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
