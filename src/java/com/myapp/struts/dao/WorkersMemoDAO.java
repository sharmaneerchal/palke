package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mappings.Workersmemo;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WorkersMemoDAO {

    private static final Logger log = Logger.getLogger(WorkersMemoDAO.class);

    public List<Workersmemo> getWorkMemo()
            throws Exception {
        /*  27 */ List<Workersmemo> lst_wm = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            /*  33 */ Query q = session.createSQLQuery("select * from workersmemo order by workersmemoid desc").addEntity(Workersmemo.class);

            /*  35 */ lst_wm = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  41 */ return lst_wm;
    }

    public List<Workersmemo> getWorkMemoByWorker(String worker)
            throws Exception {
        List<Workersmemo> lst_wm = null;

        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query q = session.createSQLQuery("select * from workersmemo where employee='" + worker + "'").addEntity(Workersmemo.class);

            lst_wm = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        return lst_wm;
    }

    public Workersmemo getWorkMemo(int memono)
            throws Exception {
        /*  27 */ List<Workersmemo> lst_wm = null;

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            /*  33 */ Query q = session.createSQLQuery("select * from Workersmemo where workermemono=" + memono).addEntity(Workersmemo.class);

            /*  35 */ lst_wm = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  41 */ return lst_wm.get(0);
    }

    public int save(Workersmemo wm) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /*  50 */ session.save(wm);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  60 */ return wm.getWorkersmemoid().intValue();
    }

    public int update(Workersmemo wm) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /*  72 */ session.update(wm);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  81 */ return wm.getWorkersmemoid();
    }

    public void delete(int id) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /*  90 */ Workersmemo c1 = (Workersmemo) session.load(Workersmemo.class, id);
            /*  91 */ session.delete(c1);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public HashMap getWorkersMemo(String year) throws Exception {
        /* 103 */ List<Workersmemo> list_vouchers = null;
        Session session = null;
        Transaction transaction = null;

        /* 108 */ HashMap hmworkersMemo = new HashMap();
        /* 113 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 116 */ Query q = session.createSQLQuery("select * from Workersmemo where YEAR(date) = " + year + " ").addEntity(Workersmemo.class);

            /* 118 */ list_vouchers = q.list();

            /* 121 */ for (int i = 0; i < list_vouchers.size(); i++) {
                /* 122 */ Workersmemo vouchers = (Workersmemo) list_vouchers.get(i);

                /* 124 */ if ((vouchers.getGoldweight() != null) && (vouchers.getGoldweight().doubleValue() != 0.0D)) {
                    /* 125 */ if (hmworkersMemo.get(sdf.format(vouchers.getDate())) == null) {
                        /* 126 */ List<Workersmemo> list_vouchertemp = new ArrayList();
                        /* 127 */ list_vouchertemp.add(vouchers);
                        /* 128 */ hmworkersMemo.put(sdf.format(vouchers.getDate()), list_vouchertemp);
                    } else {
                        /* 130 */ List<Workersmemo> list_vouchertemp = (List) hmworkersMemo.get(sdf.format(vouchers.getDate()));
                        /* 131 */ list_vouchertemp.add(vouchers);
                        /* 132 */ hmworkersMemo.put(sdf.format(vouchers.getDate()), list_vouchertemp);
                    }
                }
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 184 */ return hmworkersMemo;
    }

    public HashMap getWorkersMemos(String year) throws Exception {
        /* 188 */ List<Workersmemo> list_vouchers = null;

        /* 194 */ HashMap hmworkersMemo = new HashMap();

        /* 196 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            /* 202 */ Query q = session.createSQLQuery("select * from Workersmemo where YEAR(date)='" + year + "'").addEntity(Workersmemo.class);

            /* 205 */ list_vouchers = q.list();

            /* 209 */ for (int i = 0; i < list_vouchers.size(); i++) {
                /* 210 */ Workersmemo vouchers = (Workersmemo) list_vouchers.get(i);

                /* 212 */ if (hmworkersMemo.get(vouchers.getWorkermemono() + "") == null) {
                    /* 213 */ List<Workersmemo> list_vouchertemp = new ArrayList();
                    /* 214 */ list_vouchertemp.add(vouchers);
                    /* 215 */ hmworkersMemo.put(vouchers.getWorkermemono() + "", list_vouchertemp);
                } else {
                    /* 217 */ List<Workersmemo> list_vouchertemp = (List) hmworkersMemo.get(vouchers.getWorkermemono() + "");
                    /* 218 */ list_vouchertemp.add(vouchers);
                    /* 219 */ hmworkersMemo.put(vouchers.getWorkermemono() + "", list_vouchertemp);
                }
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 225 */ return hmworkersMemo;
    }

    public static String getWorker(int memoid) throws Exception {
        Session session = null;
        Transaction transaction = null;
        String worker = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            /* 202 */ Query q = session.createSQLQuery("select employee from workersmemo where workersmemoid=" + memoid);

            worker = (String) q.uniqueResult();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 225 */ return worker;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\WorkersMemoDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
