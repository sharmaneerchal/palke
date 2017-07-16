package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.List;
import mappings.Members;
import mappings.Payment;
import mappings.Paymentdetails;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentDAO {

    private static final Logger log = Logger.getLogger(PaymentDAO.class);

    public List<Payment> getPayment(int paymentid)
            throws Exception {
        /*  26 */ List<Payment> list_Payment = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /*  32 */ Query q = session.createSQLQuery("select * from payment where paymentid=" + paymentid).addEntity(Payment.class);

            /*  34 */ list_Payment = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  40 */ return list_Payment;
    }

    public List<Payment> getPaymentStatus(int groupid, String fromdate, String todate, int recpnofrom, int recpto) throws Exception {
        /*  44 */ List<Payment> list_Payment = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  50 */ String query = "select * from payment where canceled=0";
            /*  51 */ if ((recpnofrom != 0) && (recpto != 0)) {
                /*  52 */ query = query + " and paymentid between " + recpnofrom + " and " + recpto;
                /*  53 */            } else if ((!fromdate.equals("")) && (!todate.equals(""))) {
                /*  54 */ query = query + " and paiddate between '" + fromdate + "' and '" + todate + "'";
            }
            /*  56 */ if (groupid != 0) {
                /*  57 */ query = query + " and memberid in(select memberid from members where groupid in(select groupid from groups where groupid=" + groupid + "))";
            }

            /*  60 */ Query q = session.createSQLQuery(query).addEntity(Payment.class);

            /*  62 */ list_Payment = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  67 */ return list_Payment;
    }

    public List<Payment> getPaymentData(int memberid) throws Exception {
        /*  71 */ List<Payment> list_Payment = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /*  77 */ Query q = session.createSQLQuery("select * from payment where memberid=" + memberid).addEntity(Payment.class);

            /*  79 */ list_Payment = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  85 */ return list_Payment;
    }

    public List<Payment> getPayments(int memberid, int term) throws Exception {
        /*  89 */ List<Payment> list_Payment = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  95 */ Query q = session.createSQLQuery("select * from payment where memberid=" + memberid + " and paymentid in(select paymentid from paymentdetails where term=" + term + ") and canceled=0").addEntity(Payment.class);

            /*  97 */ list_Payment = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 102 */ return list_Payment;
    }

    public int getTotalAmount(int memberid) throws Exception {
        /* 106 */ Double amount = 0.0D;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 112 */ Query q = session.createSQLQuery("select sum(paidamount) as paidamount from payment where memberid=" + memberid + " and canceled=0");

            /* 114 */ Object[] temp = q.list().toArray();
            /* 115 */ if ((temp != null) && (temp[0] != null)) {
                /* 116 */ amount = Double.parseDouble(temp[0].toString());
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 122 */ return amount.intValue();
    }

    public int savePayment(Payment objPayment, List<Paymentdetails> paymentDetails, boolean flag, boolean edit) throws Exception {
        int paymentid = 0;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            if (edit) {
                paymentid = objPayment.getPaymentid();
                session.update(objPayment);

                for (Paymentdetails obj : paymentDetails) {
                    obj.setPaymentid(objPayment.getPaymentid());
                    session.update(obj);
                }
            } else {
                session.save(objPayment);
                paymentid = objPayment.getPaymentid();

                for (Paymentdetails obj : paymentDetails) {
                    obj.setPaymentid(paymentid);
                    session.save(obj);
                }
            }
            if (flag) {
                /* 155 */ Members obj = (Members) session.load(Members.class, objPayment.getMemberid());
                /* 156 */ obj.setCompleted(true);
                /* 157 */ obj.setRemarks("");
                /* 158 */ obj.setStatus("Completed");
                /* 159 */ session.update(obj);
            } else {
                /* 165 */ Members obj = (Members) session.load(Members.class, objPayment.getMemberid());
                /* 166 */ obj.setCompleted(false);
                /* 167 */ obj.setRemarks("");
                /* 168 */ obj.setStatus("In Progress");
                /* 169 */ session.update(obj);
            }
            transaction.commit();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 178 */ return paymentid;
    }

    public void cancelPayment(int paymentid) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 187 */ Payment payment = (Payment) session.load(Payment.class, paymentid);
            /* 188 */ payment.setCanceled(true);
            /* 189 */ session.update(payment);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\PaymentDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
