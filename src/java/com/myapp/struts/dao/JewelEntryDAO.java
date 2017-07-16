//package com.myapp.struts.dao;
//
//import com.myapp.struts.Utility.HibernateConnector;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import mappings.Jewelentry;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class JewelEntryDAO {
//
//    private static final Logger log = Logger.getLogger(JewelEntryDAO.class);
//
//    public void saveJewel(Jewelentry jewel, boolean edit)
//            throws Exception {
//        Session session = null;
//        Transaction transaction = null;
//
//        try {
//            session = HibernateConnector.getInstance().getSession();
//            transaction = session.beginTransaction();
//
//            /*  31 */ if (edit) {
//                /*  32 */ session.update(jewel);
//            } else {
//                /*  34 */ session.save(jewel);
//            }
//            transaction.commit();
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//    }
//
//    public HashMap getJewel(String year) throws Exception {
//        /*  44 */ List<Jewelentry> list_Jewelentry = null;
//        Session session = null;
//        Transaction transaction = null;
//        /*  49 */ HashMap hmJewel = new HashMap();
//        /*  50 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            session = HibernateConnector.getInstance().getSession();
//
//
//            /*  53 */ Query q = session.createSQLQuery("select * from jewelentry where YEAR(date)=" + year).addEntity(Jewelentry.class);
//
//            /*  56 */ list_Jewelentry = q.list();
//
//            /*  59 */ for (int i = 0; i < list_Jewelentry.size(); i++) {
//                /*  60 */ Jewelentry jewel = (Jewelentry) list_Jewelentry.get(i);
//
//                /*  62 */ if (hmJewel.get(sdf.format(jewel.getDate())) == null) {
//                    /*  63 */ List<Jewelentry> list_Jewelentrytemp = new ArrayList();
//                    /*  64 */ list_Jewelentrytemp.add(jewel);
//                    /*  65 */ hmJewel.put(sdf.format(jewel.getDate()), list_Jewelentrytemp);
//                } else {
//                    /*  67 */ List<Jewelentry> list_Jewelentrytemp = (List) hmJewel.get(sdf.format(jewel.getDate()));
//                    /*  68 */ list_Jewelentrytemp.add(jewel);
//                    /*  69 */ hmJewel.put(sdf.format(jewel.getDate()), list_Jewelentrytemp);
//                }
//            }
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /*  79 */ return hmJewel;
//    }
//
//    public HashMap getJewels(String year) throws Exception {
//        /*  83 */ List<Jewelentry> list_Jewelentry = null;
//        Session session = null;
//        /*  88 */ HashMap hmJewel = new HashMap();
//        /*  89 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            session = HibernateConnector.getInstance().getSession();
//
//
//            /*  92 */ Query q = session.createSQLQuery("select * from jewelentry where YEAR(date)=" + year).addEntity(Jewelentry.class);
//
//            /*  95 */ list_Jewelentry = q.list();
//
//            /*  98 */ for (int i = 0; i < list_Jewelentry.size(); i++) {
//                /*  99 */ Jewelentry jewel = (Jewelentry) list_Jewelentry.get(i);
//
//                /* 101 */ if (hmJewel.get(jewel.getWorkermemono()) == null) {
//                    /* 102 */ List<Jewelentry> list_Jewelentrytemp = new ArrayList();
//                    /* 103 */ list_Jewelentrytemp.add(jewel);
//                    /* 104 */ hmJewel.put(jewel.getWorkermemono(), list_Jewelentrytemp);
//                } else {
//                    /* 106 */ List<Jewelentry> list_Jewelentrytemp = (List) hmJewel.get(jewel.getWorkermemono());
//                    /* 107 */ list_Jewelentrytemp.add(jewel);
//                    /* 108 */ hmJewel.put(jewel.getWorkermemono(), list_Jewelentrytemp);
//                }
//            }
//
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /* 118 */ return hmJewel;
//    }
//
//    public double getTotalGoldUsed(String workermemono) throws Exception {
//        /* 123 */ double totaljewelsweight = 0.0D;
//
//        Session session = null;
//        try {
//            session = HibernateConnector.getInstance().getSession();
//
//            /* 130 */ Query q = session.createSQLQuery("select sum(netweight) as weight from jewelentry where workermemono='" + workermemono + "'");
//            /* 131 */ totaljewelsweight = q.uniqueResult() == null ? 0.0D : ((Double) q.uniqueResult());
//
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /* 136 */ return totaljewelsweight;
//    }
//
//    public List<Jewelentry> getJewelEntries(int workermemoid, int itemid) throws Exception {
//        /* 140 */ List<Jewelentry> list_Jewelentry = null;
//        Session session = null;
//        try {
//            session = HibernateConnector.getInstance().getSession();
//
//            /* 146 */ Query q = session.createSQLQuery("select * from jewelentry where workermemoid=" + workermemoid + " and itemid=" + itemid+" order by jewelentryid desc").addEntity(Jewelentry.class);
//
//            /* 149 */ list_Jewelentry = q.list();
//            for (Iterator<Jewelentry> iterator = list_Jewelentry.iterator(); iterator.hasNext();) {
//                Jewelentry next = iterator.next();
//                
//            }
//
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /* 158 */ return list_Jewelentry;
//    }
//
//    public Jewelentry cancelJewelentry(int jewelentryid) throws Exception {
//        Session session = null;
//        Transaction transaction = null;
//        Jewelentry jewelentry = null;
//        try {
//            session = HibernateConnector.getInstance().getSession();
//            transaction = session.beginTransaction();
//
//            /* 168 */ jewelentry = (Jewelentry) session.load(Jewelentry.class, jewelentryid);
//
//            /* 170 */ session.delete(jewelentry);
//            transaction.commit();
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /* 176 */ return jewelentry;
//    }
//}
//
//
///* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\JewelEntryDAO.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */
