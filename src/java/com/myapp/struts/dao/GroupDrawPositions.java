//package com.myapp.struts.dao;
//
//import com.myapp.struts.Utility.HibernateConnector;
//import java.util.ArrayList;
//import java.util.List;
//import mappings.Groupdrawpositions;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class GroupDrawPositions {
//
//    private static final Logger log = Logger.getLogger(Groupdrawpositions.class);
//
//    public List<Groupdrawpositions> getPositions(int groupdrawdetailsid)
//            throws Exception {
//
//        Session session = null;
//        Transaction transaction = null;
//
//        /* 25 */ List<Groupdrawpositions> list_Groupdrawpositions = new ArrayList();
//        try {
//
//            session = HibernateConnector.getInstance().getSession();
//            transaction = session.beginTransaction();
//
//            /* 31 */ Query q = session.createSQLQuery("select * from Groupdrawpositions where groupdrawdetailsid=" + groupdrawdetailsid + " order by positionid").addEntity(Groupdrawpositions.class);
//
//            /* 33 */ list_Groupdrawpositions = q.list();
//
//            /* 35 */ transaction.commit();
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /* 39 */ return list_Groupdrawpositions;
//    }
//}
//
//
///* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\GroupDrawPositions.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */
