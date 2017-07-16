package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.List;
import mappings.Paymentmodes;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentModeDAO {

    private static final Logger log = Logger.getLogger(PaymentModeDAO.class);

    public List<Paymentmodes> getPaymentModes()
            throws Exception {
        /* 25 */ List<Paymentmodes> list_paymentmodes = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /* 31 */ Query q = session.createSQLQuery("select * from paymentmodes").addEntity(Paymentmodes.class);

            /* 33 */ list_paymentmodes = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 38 */ return list_paymentmodes;
    }

    public String getPaymentMode(int paymentmodeid) throws Exception {
        /* 42 */ List<Paymentmodes> list_Payment = new ArrayList();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /* 48 */ Query q = session.createSQLQuery("select * from paymentmodes where paymentmodeid=" + paymentmodeid).addEntity(Paymentmodes.class);

            /* 50 */ list_Payment = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 56 */ return ((Paymentmodes) list_Payment.get(0)).getPaymentmode();
    }

    public void savePaymentmodes(Paymentmodes paymentmodes) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 65 */ session.save(paymentmodes);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deletePaymentmodes(Paymentmodes paymentmodes) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 79 */ session.delete(paymentmodes);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}

/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\PaymentModeDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
