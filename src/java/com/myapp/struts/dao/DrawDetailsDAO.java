package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.List;
import mappings.Drawdetails;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DrawDetailsDAO {

    private static final Logger log = Logger.getLogger(DrawTypesDAO.class);

    public List<Drawdetails> getDrawData(int memberid)
            throws Exception {
        /*  25 */ List<Drawdetails> list_Drawdetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /*  31 */ Query q = session.createSQLQuery("select * from drawdetails where memberid=" + memberid).addEntity(Drawdetails.class);

            /*  33 */ list_Drawdetails = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  39 */ return list_Drawdetails;
    }

    public static void Save(Drawdetails obj, boolean insert) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  48 */ if (insert) {
                /*  49 */ session.save(obj);
            } else {
                /*  51 */ session.update(obj);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void delete(int drawdetailsid) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  67 */ Drawdetails dd = (Drawdetails) session.load(Drawdetails.class, drawdetailsid);
            /*  68 */ session.delete(dd);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public static List<Drawdetails> getDrawdetails(int memberid) throws Exception {
        /*  76 */ List<Drawdetails> list_Drawdetails = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /*  82 */ Query q = session.createSQLQuery("select * from drawdetails where memberid=" + memberid).addEntity(Drawdetails.class);

            /*  84 */ list_Drawdetails = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  88 */ return list_Drawdetails;
    }

    public static List<Drawdetails> getDrawdetailsData(int groupid) throws Exception {
        /*  92 */ List<Drawdetails> list_Drawdetails = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /*  98 */ Query q = session.createSQLQuery("select * from drawdetails where memberid in(select memberid from members where groupid=" + groupid + ") order by drawdate").addEntity(Drawdetails.class);

            /* 100 */ list_Drawdetails = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 104 */ return list_Drawdetails;
    }

    public static List<Drawdetails> getDrawDetails(int memberid) throws Exception {
        /* 108 */ List<Drawdetails> list_Drawdetails = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 114 */ Query q = session.createSQLQuery("select * from drawdetails where memberid=" + memberid).addEntity(Drawdetails.class);

            /* 116 */ list_Drawdetails = q.list();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 120 */ return list_Drawdetails;
    }

    public int getSumOfDrawAmount(int memberid) throws Exception {
        /* 124 */ Double payment = 0.0D;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
        
            /* 130 */ Query q = session.createSQLQuery("select sum(Amount) as Amount from drawdetails where memberid=" + memberid);
            /* 131 */ Object[] temp = q.list().toArray();
            /* 132 */ if (temp[0] != null) {
                /* 133 */ payment = Double.parseDouble(temp[0].toString());
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 140 */ return payment.intValue();
    }

    public boolean isDrawExist(int memberid, int term) throws Exception {
        /* 144 */ List<Drawdetails> list_Drawdetails = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
        
            /* 150 */ Query q = session.createSQLQuery("select * from drawdetails where term=" + term + " and memberid=" + memberid).addEntity(Drawdetails.class);

            /* 152 */ list_Drawdetails = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 158 */ return list_Drawdetails.size() > 0;
    }

    public static void main(String[] args) {
        /* 162 */ String name = "this is sentence";
        /* 163 */ for (String word : name.split(" ")) {
            /* 164 */ int wordlenth = word.length();
            /* 165 */ System.out.print(" ");
            /* 166 */ while (wordlenth != 0) {
                /* 167 */ System.out.print(word.charAt(wordlenth - 1));
                /* 168 */ wordlenth--;
            }
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\DrawDetailsDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
