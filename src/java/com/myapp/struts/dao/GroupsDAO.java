package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mappings.Groupdrawdetails;
import mappings.Groupdrawpositions;
import mappings.Groups;
import mappings.Members;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupsDAO {

    private static final Logger log = Logger.getLogger(GroupsDAO.class);

    public HashMap getGroups()
            throws Exception {
        /*  30 */ HashMap hmGroups = new HashMap();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  37 */ Query q = session.createSQLQuery("select * from groups").addEntity(Groups.class);

            /*  39 */ List<Groups> list_groups = q.list();
            /*  40 */ hmGroups.put("Group", list_groups);
            /*  41 */ for (int i = 0; i < list_groups.size(); i++) {
                /*  42 */ Groups groups = (Groups) list_groups.get(i);
                /*  43 */ hmGroups.put(groups.getGroupid() + "", groups);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  49 */ return hmGroups;
    }

    public List<Groups> getGroup() throws Exception {
        /*  53 */ List<Groups> list_groups = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  59 */ Query q = session.createSQLQuery("select * from groups").addEntity(Groups.class);

            /*  61 */ list_groups = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  67 */ return list_groups;
    }

    public List<Groups> getGroupDetails() throws Exception {
        /*  71 */ List<Groups> list_Groups = new ArrayList();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  77 */ Query q = session.createSQLQuery("select * from groups").addEntity(Groups.class);

            /*  79 */ list_Groups = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  85 */ return list_Groups;
    }

    public Groups getGroupDetails(int groupid) throws Exception {
        /*  89 */ List<Groups> list_Groups = new ArrayList();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  95 */ Query q = session.createSQLQuery("select * from groups where groupid=" + groupid).addEntity(Groups.class);

            /*  97 */ list_Groups = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 103 */ return (Groups) list_Groups.get(0);
    }

    public void saveGroup(Groups objGroup, boolean edit) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 111 */ if (edit) {
                /* 112 */ session.update(objGroup);
            } else {
                /* 114 */ session.save(objGroup);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deleteGroup(int Groupid) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 129 */ Query q = session.createSQLQuery("select * from Groupdrawdetails where groupid=" + Groupid).addEntity(Groupdrawdetails.class);

            /* 131 */ List<Groupdrawdetails> list_Groupdrawdetails = q.list();
            /* 132 */ for (int i = 0; i < list_Groupdrawdetails.size(); i++) {
                /* 133 */ Groupdrawdetails groupdrawdetails = (Groupdrawdetails) list_Groupdrawdetails.get(i);
                /* 134 */ q = session.createSQLQuery("select * from Groupdrawpositions where groupdrawdetailsid=" + groupdrawdetails.getGroupdrawdetailsid()).addEntity(Groupdrawpositions.class);

                /* 137 */ List<Groupdrawpositions> list_Groupdrawpositions = q.list();
                /* 138 */ for (int j = 0; j < list_Groupdrawpositions.size(); j++) {
                    /* 139 */ Groupdrawpositions groupdrawpositions = (Groupdrawpositions) list_Groupdrawpositions.get(j);
                    /* 140 */ session.delete(groupdrawpositions);
                }
                /* 142 */ session.delete(groupdrawdetails);
            }

            /* 145 */ Groups c1 = (Groups) session.load(Groups.class, Integer.valueOf(Groupid));
            /* 146 */ session.delete(c1);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deleteGroupwithMember(int Groupid) throws Exception {

        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 160 */ Query q = session.createSQLQuery("select * from members where groupid=" + Groupid).addEntity(Members.class);

            /* 162 */ List<Members> lstmembers = q.list();

            /* 164 */ for (int i = 0; i < lstmembers.size(); i++) {
                /* 165 */ Members members = (Members) lstmembers.get(i);
                /* 166 */ session.delete(members);
            }

            /* 169 */ q = session.createSQLQuery("select * from Groupdrawdetails where groupid=" + Groupid).addEntity(Groupdrawdetails.class);

            /* 171 */ List<Groupdrawdetails> list_Groupdrawdetails = q.list();
            /* 172 */ for (int i = 0; i < list_Groupdrawdetails.size(); i++) {
                /* 173 */ Groupdrawdetails groupdrawdetails = (Groupdrawdetails) list_Groupdrawdetails.get(i);
                /* 174 */ q = session.createSQLQuery("select * from Groupdrawpositions where groupdrawdetailsid=" + groupdrawdetails.getGroupdrawdetailsid()).addEntity(Groupdrawpositions.class);

                /* 177 */ List<Groupdrawpositions> list_Groupdrawpositions = q.list();
                /* 178 */ for (int j = 0; j < list_Groupdrawpositions.size(); j++) {
                    /* 179 */ Groupdrawpositions groupdrawpositions = (Groupdrawpositions) list_Groupdrawpositions.get(j);
                    /* 180 */ session.delete(groupdrawpositions);
                }
                /* 182 */ session.delete(groupdrawdetails);
            }

            /* 185 */ Groups c1 = (Groups) session.load(Groups.class, Integer.valueOf(Groupid));
            /* 186 */ session.delete(c1);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public Groups getgroupdetails(int paymentid) throws Exception {
        /* 195 */ Groups Groups = null;
        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateConnector.getInstance().getSession();


            /* 202 */ Query q = session.createSQLQuery("select * from groups where groupid in(select groupid from members where memberid in(select memberid from payment where paymentid=" + paymentid + "))").addEntity(Groups.class);

            /* 204 */ List<Groups> lstgroup = q.list();
            /* 205 */ if (lstgroup != null) {
                /* 206 */ Groups = (Groups) lstgroup.get(0);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 213 */ return Groups;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\GroupsDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
