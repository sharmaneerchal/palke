package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mappings.Goldstock;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GoldStockDAO {

    private static final Logger log = Logger.getLogger(GoldStockDAO.class);

    public void saveGoldStock(Goldstock goldstock, boolean edit)
            throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  30 */ if (edit) {
                /*  31 */ session.update(goldstock);
            } else {
                /*  33 */ session.save(goldstock);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public int getStockid(int referenceid) throws Exception {
        /*  43 */ List<Goldstock> lstgold = null;
        Session session = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  49 */ Query q = session.createSQLQuery("select * from Goldstock where refernceid=" + referenceid).addEntity(Goldstock.class);

            /*  51 */ lstgold = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  57 */ return ((Goldstock) lstgold.get(0)).getGoldstockid();
    }

    public List<Goldstock> getStock(String type) throws Exception {
        /*  61 */ List<Goldstock> lstgold = null;
        Session session = null;
        try {

            session = HibernateConnector.getInstance().getSession();


            /*  67 */ Query q = session.createSQLQuery("select * from Goldstock where type='" + type + "' order by updateddate").addEntity(Goldstock.class);

            /*  72 */ lstgold = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  78 */ return lstgold;
    }

    public List<Goldstock> getStockDescending(String type) throws Exception {
        /*  82 */ List<Goldstock> lstgold = new ArrayList();
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /*  89 */ Query q = session.createSQLQuery("select * from Goldstock where type='" + type + "' and (remarks <> 'DELETED' OR REMARKS IS NULL)").addEntity(Goldstock.class);

            /*  91 */ lstgold = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  97 */ return lstgold;
    }

    public double getStockQuantity(String type) throws Exception {
        /* 101 */ double totalweight = 0.0D;
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 107 */ Query query = session.createSQLQuery("select sum(weight) as weight from Goldstock where type='" + type + "' and remarks <> 'DELETED'");
            /* 108 */
            if (query.uniqueResult() != null) {
                totalweight = ((Double) query.uniqueResult());
            } else {
                totalweight = 0;
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 114 */ return totalweight;
    }

    public void updateStock(int voucherid) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 125 */ Query q = session.createSQLQuery("select * from Goldstock where refernceid=" + voucherid).addEntity(Goldstock.class);

            /* 127 */ List<Goldstock> lstgold = q.list();

            /* 129 */ Goldstock goldstock = (Goldstock) session.load(Goldstock.class, ((Goldstock) lstgold.get(0)).getGoldstockid());
            /* 130 */ goldstock.setRemarks("DELETED");
            /* 131 */ goldstock.setUpdateddate(new Date());
            /* 132 */ session.update(goldstock);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void updateStockWeight(int stockid, double weight) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 147 */ Goldstock obj = (Goldstock) session.load(Goldstock.class, stockid);
            /* 148 */ obj.setWeight(weight);

            /* 150 */ session.update(obj);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\GoldStockDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
