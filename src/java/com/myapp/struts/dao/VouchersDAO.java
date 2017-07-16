package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mappings.Vouchers;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VouchersDAO {

    private static final Logger log = Logger.getLogger(VouchersDAO.class);

    public int saveVoucher(Vouchers vouchers, boolean edit)
            throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /*  33 */ if (edit) {
                /*  34 */ session.update(vouchers);
            } else {
                /*  36 */ session.save(vouchers);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  47 */ return vouchers.getVoucherid().intValue();
    }

    public List<Vouchers> getVouchers(String vouchertype) throws Exception {
        /*  51 */ List<Vouchers> list_vouchers = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            /*  56 */ Query q = session.createSQLQuery("select * from Vouchers where vouchertype='" + vouchertype + "' order by updateddate desc").addEntity(Vouchers.class);

            /*  58 */ list_vouchers = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  67 */ return list_vouchers;
    }

    public List<Vouchers> getVouchers(int voucherid) throws Exception {
        /*  71 */ List<Vouchers> list_vouchers = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            /*  77 */ Query q = session.createSQLQuery("select * from Vouchers where voucherid=" + voucherid + " order by updateddate desc").addEntity(Vouchers.class);

            /*  79 */ list_vouchers = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  88 */ return list_vouchers;
    }

    public Vouchers cancelVoucher(int voucherid) throws Exception {
        Vouchers vouchers = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            /*  98 */ vouchers = (Vouchers) session.load(Vouchers.class, voucherid);

            /* 100 */ session.delete(vouchers);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 106 */ return vouchers;
    }

    public HashMap getVouchers(String year, String vouchertype) throws Exception {
        /* 110 */ List<Vouchers> list_vouchers = null;
        Session session = null;
        Transaction transaction = null;

        /* 115 */ HashMap hmvouchers = new HashMap();
        /* 116 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            session = HibernateConnector.getInstance().getSession();

            Query q;
            /* 121 */ q = session.createSQLQuery("select * from Vouchers where YEAR(voucherdate) = " + year + " and vouchercategory in('" + vouchertype + "','Copper','Ornament') order by vouchertype").addEntity(Vouchers.class);


            /* 127 */ list_vouchers = q.list();

            /* 130 */ for (int i = 0; i < list_vouchers.size(); i++) {
                /* 131 */ Vouchers vouchers = (Vouchers) list_vouchers.get(i);

                /* 133 */ if (hmvouchers.get(sdf.format(vouchers.getVoucherdate())) == null) {
                    /* 134 */ List<Vouchers> list_vouchertemp = new ArrayList();
                    /* 135 */ list_vouchertemp.add(vouchers);
                    /* 136 */ hmvouchers.put(sdf.format(vouchers.getVoucherdate()), list_vouchertemp);
                } else {
                    /* 138 */ List<Vouchers> list_vouchertemp = (List) hmvouchers.get(sdf.format(vouchers.getVoucherdate()));
                    /* 139 */ list_vouchertemp.add(vouchers);
                    /* 140 */ hmvouchers.put(sdf.format(vouchers.getVoucherdate()), list_vouchertemp);
                }
            }
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 150 */ return hmvouchers;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\VouchersDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
