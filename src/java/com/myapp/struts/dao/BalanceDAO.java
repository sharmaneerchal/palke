package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.List;
import mappings.Balance;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BalanceDAO {

    private static final Logger log = Logger.getLogger(BalanceDAO.class);

    public void update(Balance balance)
            throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            session.save(balance);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public double getBalance(int year, String type) {
        Session session = null;
        Transaction transaction = null;

        /* 43 */ List<Balance> listBalance = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 45 */ Query q = session.createSQLQuery("select * from balance where year=" + year + " and type='" + type + "' order by insertdate desc").addEntity(Balance.class);

            /* 47 */ listBalance = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 53 */ return listBalance.isEmpty() ? 0.0D : ((Balance) listBalance.get(0)).getBalance();
    }

    public boolean isExist(int year) {
        Session session = null;
        Transaction transaction = null;

        /* 60 */ List<Balance> listBalance = new ArrayList();
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 62 */ Query q = session.createSQLQuery("select * from balance ").addEntity(Balance.class);

            /* 64 */ listBalance = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 70 */ return !listBalance.isEmpty();
    }

    public void resetBalance() throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 78 */ Query q = session.createSQLQuery("select * from balance").addEntity(Balance.class);

            /* 80 */ List<Balance> listBalance = q.list();
            /* 81 */ for (int i = 0; i < listBalance.size(); i++) {
                /* 82 */ Balance balance = (Balance) listBalance.get(i);
                /* 83 */ session.delete(balance);
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\BalanceDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
