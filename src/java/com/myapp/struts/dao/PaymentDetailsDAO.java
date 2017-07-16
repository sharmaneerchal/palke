package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.List;
import mappings.Payment;
import mappings.Paymentdetails;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentDetailsDAO {

    private static final Logger log = Logger.getLogger(PaymentDetailsDAO.class);

    public static List<Paymentdetails> getTerms(int memberid)
            throws Exception {
        /*  25 */ List<Paymentdetails> list_Paymentdetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /*  31 */ Query q = session.createSQLQuery("select * from paymentdetails where paymentid in(select paymentid from payment where memberid=" + memberid + ") order by term").addEntity(Paymentdetails.class);

            /*  33 */ list_Paymentdetails = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  39 */ return list_Paymentdetails;
    }

    public List<Paymentdetails> getPaymentDetails(int memberid) throws Exception {
        /*  43 */ List<Paymentdetails> list_Paymentdetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /*  49 */ Query q = session.createSQLQuery("select * from paymentdetails where paymentid in(select paymentid from payment where memberid=" + memberid + " and canceled=0)").addEntity(Paymentdetails.class);

            /*  51 */ list_Paymentdetails = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  56 */ return list_Paymentdetails;
    }

    public int getLastTerm(int memberid) throws Exception {
        /*  60 */ int Term = 0;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /*  67 */ Query q = session.createSQLQuery("select * from paymentdetails where paymentid in(select paymentid from payment where memberid=" + memberid + " and canceled=0) order by term desc").addEntity(Paymentdetails.class);

            /*  69 */ List<Paymentdetails> list_paymentdetails = q.list();
            /*  70 */ if (list_paymentdetails.size() > 0) {
                /*  71 */ Term = ((Paymentdetails) list_paymentdetails.get(0)).getTerm();
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  78 */ return Term;
    }

    public List<Paymentdetails> getPaymentDetailsData(int paymentid)
            throws Exception {
        /* 108 */ List<Paymentdetails> list_Paymentdetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 112 */ Transaction tx = session.beginTransaction();

            /* 114 */ Query q = session.createSQLQuery("select * from paymentdetails where paymentid=" + paymentid + " order by term").addEntity(Paymentdetails.class);

            /* 116 */ list_Paymentdetails = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 121 */ return list_Paymentdetails;
    }

    public void insertPaymentDetails(int paymentid, int count, int lastterm) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 129 */ for (int i = 0; i < count; i++) {
                /* 130 */ Paymentdetails obj = new Paymentdetails();
                /* 133 */ obj.setPaymentid(paymentid);
                /* 134 */ lastterm++;
                /* 135 */ obj.setTerm(lastterm);
                /* 136 */ session.save(obj);
            }

            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deletePaymentDetails(int paymentid, int count) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 150 */ List<Paymentdetails> list_Paymentdetails = null;

            /* 152 */ Query q = session.createSQLQuery("select * from paymentdetails where paymentid=" + paymentid + " order by term desc").addEntity(Paymentdetails.class);

            /* 154 */ list_Paymentdetails = q.list();
            /* 155 */ for (int i = 0; i < count; i++) {
                /* 156 */ Paymentdetails paymentdetails = (Paymentdetails) list_Paymentdetails.get(i);
                /* 157 */ session.delete(paymentdetails);
            }
            /* 159 */ q = session.createSQLQuery("select * from paymentdetails where paymentid=" + paymentid + " order by term desc").addEntity(Paymentdetails.class);

            /* 161 */ list_Paymentdetails = q.list();
            /* 162 */ if (list_Paymentdetails.isEmpty()) {
                /* 163 */ Payment payment = (Payment) session.load(Payment.class, Integer.valueOf(paymentid));
                /* 164 */ session.delete(payment);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\PaymentDetailsDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
