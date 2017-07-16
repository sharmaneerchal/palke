//package com.myapp.struts.dao;
//
//import com.myapp.struts.Utility.HibernateConnector;
//import java.util.ArrayList;
//import java.util.List;
//import mappings.Groupdrawdetails;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class GroupDrawDetailsDAO {
//
//    private static final Logger log = Logger.getLogger(GroupDrawDetailsDAO.class);
//
//    public List<Groupdrawdetails> getGroupDrawDetails(int groupid)
//            throws Exception {
//
//        Session session = null;
//        Transaction transaction = null;
//
//        List<Groupdrawdetails> list_Groups = new ArrayList();
//        try {
//            session = HibernateConnector.getInstance().getSession();
//
//
//            /* 31 */ Query q = session.createSQLQuery("select * from groupdrawdetails where groupid=" + groupid).addEntity(Groupdrawdetails.class);
//
//            /* 33 */ list_Groups = q.list();
//
//        } catch (HibernateException e) {
//            log.error(e);
//        } finally {
//            session.close();
//        }
//        /* 39 */ return list_Groups;
//    }
//}
//
//
///* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\GroupDrawDetailsDAO.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */
