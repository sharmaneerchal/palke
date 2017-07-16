package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mappings.Members;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MembersDAO {

    private static final Logger log = Logger.getLogger(MembersDAO.class);

    public int getNextMemberID()
            throws Exception {
        /*  26 */ List<Members> list_Members = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  32 */ Query q = session.createSQLQuery("select * from members").addEntity(Members.class);

            /*  34 */ list_Members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  39 */ Random random = new Random(97979L);
        /*  40 */ return list_Members.size() + random.nextInt();
    }

    public int getNextMemberNo(int groupid) throws Exception {
        /*  44 */ int NextMemberno = 1;
        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();


            /*  46 */ List<Members> list_Members = null;

            /*  51 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid + " order by memberno desc").addEntity(Members.class);

            /*  53 */ list_Members = q.list();

            /*  55 */ if (list_Members.size() > 0) {
                /*  56 */ NextMemberno = ((Members) list_Members.get(0)).getMemberno() + 1;
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  61 */ return NextMemberno;
    }

    public Members getmemberbymemberid(int memberid) throws Exception {
        /*  65 */ int NextMemberno = 1;
        /*  66 */ Members members = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /*  73 */ Query q = session.createSQLQuery("select * from members where memberid=" + memberid).addEntity(Members.class);

            /*  75 */ members = (Members) q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  81 */ return members;
    }

    public int checkGroupStatus(int groupid) throws Exception {
        /*  85 */
        Session session = null;
        int returnInt = 0;
        try {
            List<Members> list_Members = new ArrayList();
            session = HibernateConnector.getInstance().getSession();

            /*  92 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid).addEntity(Members.class);
            /*  94 */ list_Members = q.list();

            if (list_Members.isEmpty()) {
                returnInt = 0;
            } else {
                q = session.createSQLQuery("select * from members where status='In Progress' and groupid=" + groupid).addEntity(Members.class);
                list_Members = q.list();

                if (list_Members.isEmpty()) {
                    returnInt = 2;
                } else {
                    returnInt = 1;
                }
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 100 */ return returnInt;
    }

    public void saveMember(Members objMember, boolean edit) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 108 */ if (edit) {

                /* 112 */ session.update(objMember);
            } else {
                /* 114 */ session.save(objMember);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public List<Members> getMemberDetails(int groupid) throws Exception {
        /* 125 */ List<Members> list_Members = new ArrayList();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 131 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid + " order by memberno desc").addEntity(Members.class);

            /* 133 */ list_Members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 141 */ return list_Members;
    }

    public List<Members> getMemberDetails(int groupid, int memberid) throws Exception {
        /* 145 */ List<Members> list_Members = new ArrayList();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 151 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid + " and memberno=" + memberid + "order by memberno desc").addEntity(Members.class);

            /* 153 */ list_Members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 161 */ return list_Members;
    }

    public void removeMember(Members objMember) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 171 */ Members c1 = (Members) session.load(Members.class, objMember.getMemberid());
            /* 172 */ c1.setRemarks("");
            /* 173 */ session.delete(c1);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public List<Members> getMemebersInfo(int groupid) throws Exception {
        /* 183 */ List<Members> list_Members = new ArrayList();
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /* 189 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid).addEntity(Members.class);

            /* 191 */ list_Members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 197 */ return list_Members;
    }

    public List<Members> getMembers(int groupid) throws Exception {
        /* 201 */ List<Members> list_members = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 207 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid).addEntity(Members.class);

            /* 209 */ list_members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 213 */ return list_members;
    }

    public List<Members> getMembers(int groupid, String SearchTerm) throws Exception {
        /* 217 */ List<Members> list_members = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 223 */ Query q = session.createSQLQuery("select * from members where groupid=" + groupid + " and (membername LIKE '%" + SearchTerm + "%' or memberno like '%" + SearchTerm + "%')").addEntity(Members.class);

            /* 225 */ list_members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 230 */ return list_members;
    }

    public Members getMembersInfo(int memberno, int groupid) throws Exception {
        /* 234 */ List<Members> list_members = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 240 */ Query q = session.createSQLQuery("select * from members where memberno=" + memberno + " and groupid=" + groupid).addEntity(Members.class);

            /* 242 */ list_members = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 247 */ return (Members) list_members.get(0);
    }

    public void updateMember(int memberid, String remarks) throws Exception {
        /* 251 */ List<Members> list_members = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 257 */ Members obj = (Members) session.load(Members.class, Integer.valueOf(memberid));
            /* 258 */ obj.setRemarks(remarks);
            /* 259 */ obj.setStatus("Settled");
            /* 260 */ session.update(obj);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);

        } finally {
            session.close();
        }
    }

    public Members getmemberdetails(int paymentid) throws Exception {
        /* 269 */ List<Members> lstmem = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 275 */ Query q = session.createSQLQuery("select * from members where memberid in(select memberid from payment where paymentid=" + paymentid + ")").addEntity(Members.class);

            /* 277 */ lstmem = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 283 */ return lstmem != null ? (Members) lstmem.get(0) : null;
    }
}

/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\MembersDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
