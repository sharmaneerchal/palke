///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.myapp.struts.dao;
//
//import hibernateUtil.HibernateUtil;
//import java.util.Iterator;
//import java.util.List;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
///**
// *
// * @author Lenovo
// */
//public class PVDAO {
//
//    public int savePV(Purchasevoucher objpv) throws Exception {
//        int pvid;
//
//        try {
//            SessionFactory sf = new Configuration().configure().buildSessionFactory();
//            Session s = sf.openSession();
//            Transaction tx = s.beginTransaction();
//
//            s.save(objpv);
//
//            tx.commit();
//
//            pvid = objpv.getPvid();
//            for (Iterator it = objpv.getPurchasevoucherdetailses().iterator(); it.hasNext();) {
//                Purchasevoucherdetails obj = (Purchasevoucherdetails) it.next();
//
//                s = sf.openSession();
//                tx = s.beginTransaction();
//                s.update(obj);
//                tx.commit();
//            }
//        } catch (HibernateException e) {
//            throw e;
//        } finally {
//
//        }
//        return pvid;
//    }
//
//    public String getPurchaseVoucherNo() throws Exception {
//        List<Purchasevoucher> list_pv = null;
//        try {
//            SessionFactory sf = new Configuration().configure().buildSessionFactory();
//            Session s = sf.openSession();
//            Transaction tx = s.beginTransaction();
//
//            Query q = s.createSQLQuery("select * from purchasevoucher order by createddate")
//                    .addEntity(Purchasevoucher.class);
//
//            list_pv = (List<Purchasevoucher>) q.list();
//            tx.commit();
//        } catch (HibernateException e) {
//            throw e;
//        }
//
//        if (list_pv.size() > 0) {
//
//            String[] pvno = list_pv.get(0).getPvno().split("-");
//            String nextPVno = pvno[0] + "-" + Integer.parseInt(pvno[1]) + 1;
//            return nextPVno;
//        } else {
//            return "PV-01";
//        }
//    }
//
//}
