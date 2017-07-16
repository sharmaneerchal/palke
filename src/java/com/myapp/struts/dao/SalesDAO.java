package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mappings.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalesDAO {

    private static final Logger log = Logger.getLogger(SalesDAO.class);

    public int saveSales(Sales sales, boolean edit)
            throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  35 */ if (edit) {
                /*  36 */ session.update(sales);
            } else {
                /*  38 */ session.save(sales);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  48 */ return sales.getSalesid();
    }

    public void deleteSales(int salesid)
            throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            Sales sales = (Sales) session.load(Sales.class, salesid);
            session.delete(sales);

            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public List<Sales> getSales() throws Exception {
        /*  52 */ List<Sales> lstsales = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /*  58 */ Query q = session.createSQLQuery("select * from Sales where billno <> 0").addEntity(Sales.class);

            /*  60 */ lstsales = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  69 */ return lstsales;
    }

    public Sales getBill(int salesid) throws Exception {
        /*  73 */ List<Sales> lstsales = null;
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateConnector.getInstance().getSession();
            /*  79 */ Query q = session.createSQLQuery("select * from Sales where salesid=" + salesid).addEntity(Sales.class);

            /*  81 */ lstsales = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  87 */ return (Sales) lstsales.get(0);
    }

    public HashMap getSales(String year) throws Exception {
        /*  91 */ List<Sales> list_Sales = null;
        Session session = null;

        /*  96 */ HashMap hmJewel = new HashMap();
        /*  97 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 100 */ Query q = session.createSQLQuery("select * from Sales where YEAR(STR_TO_DATE(billdate, '%d/%m/%Y'))=" + year).addEntity(Sales.class);

            /* 103 */ list_Sales = q.list();

            /* 106 */ for (int i = 0; i < list_Sales.size(); i++) {
                /* 107 */ Sales jewel = (Sales) list_Sales.get(i);
                /* 109 */ if (hmJewel.get(jewel.getBilldate()) == null) {
                    /* 110 */ List<Sales> list_Salestemp = new ArrayList();
                    /* 111 */ list_Salestemp.add(jewel);
                    /* 112 */ hmJewel.put(jewel.getBilldate(), list_Salestemp);
                } else {
                    /* 114 */ List<Sales> list_Salestemp = (List) hmJewel.get(jewel.getBilldate());
                    /* 115 */ list_Salestemp.add(jewel);
                    /* 116 */ hmJewel.put(jewel.getBilldate(), list_Salestemp);
                }
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 126 */ return hmJewel;
    }

    public boolean isBillExist(String billno) throws Exception {
        /*  73 */ List<Sales> lstsales = null;
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateConnector.getInstance().getSession();
            Query q = session.createSQLQuery("select * from Sales where billno='" + billno + "'").addEntity(Sales.class);

            /*  81 */ lstsales = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 136 */ return !lstsales.isEmpty();
    }

    public HashMap getSales(Session session, int ornamentstockid) throws Exception {
        HashMap hmSales = new HashMap();
        try {
            Query q = session.createSQLQuery("select * from Sales where jewelcodes like '%" + ornamentstockid + "%'").addEntity(Sales.class);
            List<Sales> lstsales = q.list();
            for (Sales sales : lstsales) {
                hmSales.put(ornamentstockid + "", sales);
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            //        session.close();
        }
        return hmSales;
    }

}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\SalesDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
