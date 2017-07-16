package com.myapp.struts.dao;

import com.myapp.struts.Utility.HibernateConnector;
import com.myapp.struts.beans.JewelBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import mappings.Items;
import mappings.Ornamentstock;
import mappings.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrnamentStockDAO implements java.io.Serializable {

    private static final Logger log = Logger.getLogger(OrnamentStockDAO.class);

    public void saveOrnamentStock(Ornamentstock ornamentstock, boolean edit)
            throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  32 */ if (edit) {
                /*  33 */ session.update(ornamentstock);
            } else {
                /*  35 */ session.save(ornamentstock);
            }
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public int getStockid(int referenceid) throws Exception {
        /*  45 */ List<Ornamentstock> lstgold = null;
        Session session = null;

        try {
            session = HibernateConnector.getInstance().getSession();

            /*  51 */ Query q = session.createSQLQuery("select * from Ornamentstock where refernceid=" + referenceid).addEntity(Ornamentstock.class);

            /*  53 */ lstgold = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  59 */ return ((Ornamentstock) lstgold.get(0)).getOrnamentstockid();
    }

    public int getNextStockno(int itemid) throws Exception {
        int ornamentstockno = 0;
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /*  69 */ Query q = session.createSQLQuery("select max(CAST(ornamentstockno AS UNSIGNED)) as ornamentstockno  from Ornamentstock where itemid=" + itemid);
            ornamentstockno = Integer.parseInt(q.uniqueResult().toString());
            ornamentstockno = ornamentstockno + 1;
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /*  77 */ return ornamentstockno;
    }
//stock

    public List<JewelBean> getGoldOrnamentsStock(int itemid) throws Exception {
        Session session = null;
        List<JewelBean> lstornament = new ArrayList<JewelBean>();
        try {
            HashMap hmMap = new ItemsDAO().getItemsMap();

            session = HibernateConnector.getInstance().getSession();
            Query q = session.createSQLQuery("select * from Ornamentstock where itemid=" + itemid + "").addEntity(Ornamentstock.class);
            List<Ornamentstock> lstgold = q.list();

            for (int i = 0; i < lstgold.size(); i++) {
                Ornamentstock ornamentstock = (Ornamentstock) lstgold.get(i);
                JewelBean object = new JewelBean(ornamentstock.getOrnamentstockid(), ornamentstock.getOrnamentstockno(), ornamentstock.getDescription(), ornamentstock.getItemid(), ornamentstock.getMemono(), ornamentstock.getMemoid(), ornamentstock.getGrossweight(), ornamentstock.getGoldweight(), ornamentstock.getStoneweight(), ornamentstock.getStonetype(), ornamentstock.getNetweight(), ornamentstock.getWastage(), ornamentstock.getTotalglodused(), ornamentstock.getInsertdate(), ornamentstock.getRevgrossweight(), ornamentstock.getRevnetweight(), ornamentstock.getRevwastage(), ornamentstock.getRevtotalglodused(), ornamentstock.isSold(), ornamentstock.isTransfered(), 0, ornamentstock.getInsertdate(), "");

                Items items = (Items) hmMap.get(object.getItemid() + "");
                if (object.isSold()) {
                    HashMap hmsales = new SalesDAO().getSales(session, object.getOrnamentstockid());
                    if (!hmsales.isEmpty()) {
                        String billno = ((Sales) hmsales.get(object.getOrnamentstockid() + "")).getBillno();
                        object.setBillno(billno.equals("") ? "??" : billno);
                    } else {
                        object.setBillno("###");
                    }
                }
                String worker = WorkersMemoDAO.getWorker(ornamentstock.getMemoid());
                object.setDescription(items.getItem() + " - " + object.getDescription());
                object.setWorker(worker);
                object.setOrnamentstockno(items.getItemcode() + "-" + object.getOrnamentstockno());
                lstornament.add(object);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 102 */ return lstornament;
    }
//sales

    public List<JewelBean> getOrnamentsStock(int itemid) throws Exception {
        List<JewelBean> lstornament = new ArrayList<JewelBean>();
        Session session = null;
        try {
            /* 142 */ HashMap hmMap = new ItemsDAO().getItemsMap();

            session = HibernateConnector.getInstance().getSession();

            /* 137 */ Query q = session.createSQLQuery("select * from Ornamentstock where itemid=" + itemid + " and sold=0").addEntity(Ornamentstock.class);

            /* 139 */ List<Ornamentstock> lstgold = q.list();

            /* 143 */ for (int i = 0; i < lstgold.size(); i++) {
                /* 144 */ Ornamentstock ornamentstock = (Ornamentstock) lstgold.get(i);

                JewelBean object = new JewelBean(ornamentstock.getOrnamentstockid(), ornamentstock.getOrnamentstockno(), ornamentstock.getDescription(), ornamentstock.getItemid(), ornamentstock.getMemono(), ornamentstock.getMemoid(), ornamentstock.getGrossweight(), ornamentstock.getGoldweight(), ornamentstock.getStoneweight(), ornamentstock.getStonetype(), ornamentstock.getNetweight(), ornamentstock.getWastage(), ornamentstock.getTotalglodused(), ornamentstock.getInsertdate(), ornamentstock.getRevgrossweight(), ornamentstock.getRevnetweight(), ornamentstock.getRevwastage(), ornamentstock.getRevtotalglodused(), ornamentstock.isSold(), ornamentstock.isTransfered(), 0, ornamentstock.getInsertdate(), "");

                /* 145 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                /* 146 */ object.setDescription(items.getItem() + " - " + object.getDescription());
                /* 147 */ object.setOrnamentstockno(items.getItemcode() + " " + object.getOrnamentstockno());
                lstornament.add(object);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 152 */ return lstornament;
    }

    public TreeMap getTotal(int itemid) throws Exception {
        TreeMap hmOrnament = new TreeMap();
        Session session = null;
        try {
            double grosstotal = 0;
            double nettotal = 0;
            double revgrosstotal = 0;
            double revnettotal = 0;

            session = HibernateConnector.getInstance().getSession();

            Query q = session.createSQLQuery("select sum(grossweight),sum(netweight),sum(revgrossweight),sum(revnetweight) from Ornamentstock where itemid=" + itemid + "");

            Object[] temp = q.list().toArray();
            if (temp != null) {
                Object[] temp2 = (Object[]) temp[0];
                grosstotal = Double.parseDouble(temp2[0].toString());
                nettotal = Double.parseDouble(temp2[1].toString());
                revgrosstotal = Double.parseDouble(temp2[2].toString());
                revnettotal = Double.parseDouble(temp2[3].toString());
            }

            hmOrnament.put("grosstotal", grosstotal);
            hmOrnament.put("nettotal", nettotal);
            hmOrnament.put("revgrosstotal", revgrosstotal);
            hmOrnament.put("revnettotal", revnettotal);
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 102 */ return hmOrnament;
    }

    public List<JewelBean> getOrnamentsStockbymemo(int memoid, int itemid) throws Exception {
        /* 106 */ List<JewelBean> lstornament = new ArrayList<JewelBean>();
        Session session = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 112 */ Query q = session.createSQLQuery("select * from Ornamentstock where memoid=" + memoid + " and itemid=" + itemid + " order by ornamentstockid desc").addEntity(Ornamentstock.class);
            List<Ornamentstock> lstgold = null;
            /* 114 */ lstgold = q.list();

            /* 117 */ HashMap hmMap = new ItemsDAO().getItemsMap();
            /* 118 */ for (int i = 0; i < lstgold.size(); i++) {
                /* 119 */ Ornamentstock ornamentstock = (Ornamentstock) lstgold.get(i);

                JewelBean object = new JewelBean(ornamentstock.getOrnamentstockid(), ornamentstock.getOrnamentstockno(), ornamentstock.getDescription(), ornamentstock.getItemid(), ornamentstock.getMemono(), ornamentstock.getMemoid(), ornamentstock.getGrossweight(), ornamentstock.getGoldweight(), ornamentstock.getStoneweight(), ornamentstock.getStonetype(), ornamentstock.getNetweight(), ornamentstock.getWastage(), ornamentstock.getTotalglodused(), ornamentstock.getInsertdate(), ornamentstock.getRevgrossweight(), ornamentstock.getRevnetweight(), ornamentstock.getRevwastage(), ornamentstock.getRevtotalglodused(), ornamentstock.isSold(), ornamentstock.isTransfered(), 0, ornamentstock.getInsertdate(), "");

                /* 120 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                /* 121 */ object.setDescription(items.getItem() + " - " + object.getDescription());
                /* 122 */ object.setOrnamentstockno(items.getItemcode() + object.getOrnamentstockno());
                lstornament.add(object);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 127 */ return lstornament;
    }

    public List<Ornamentstock> getSilverOrnamentsStock() throws Exception {
        /* 156 */ List<Ornamentstock> lstgold = null;
        Session session = null;

        try {
            session = HibernateConnector.getInstance().getSession();


            /* 162 */ Query q = session.createSQLQuery("select * from Ornamentstock where type='Silver Ornaments' order by updateddate").addEntity(Ornamentstock.class);

            /* 164 */ lstgold = q.list();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 170 */ return lstgold;
    }

    public void deleteStock(int ornamentstockid) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 180 */ Ornamentstock ornamentstock = (Ornamentstock) session.load(Ornamentstock.class, ornamentstockid);

            /* 183 */ session.delete(ornamentstock);

            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void updateOrnament(JewelBean obj) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 198 */ Ornamentstock ornamentstock = (Ornamentstock) session.load(Ornamentstock.class, obj.getOrnamentstockid());

            /* 200 */ ornamentstock.setRevtotalglodused(obj.getRevtotalglodused());
            /* 201 */ ornamentstock.setRevgrossweight(obj.getRevgrossweight());
            /* 202 */ ornamentstock.setRevnetweight(obj.getRevnetweight());
            /* 203 */ ornamentstock.setRevwastage(obj.getRevwastage());
            if (obj.getStonetype().equals("")) {
                ornamentstock.setStonetype(ornamentstock.getStonetype());
            } else {
                ornamentstock.setStonetype(obj.getStonetype());
            }
            session.update(ornamentstock);

            transaction.commit();

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void updateOrnamentFlag(JewelBean jewel, boolean flag) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 220 */ Ornamentstock ornamentstock = (Ornamentstock) session.load(Ornamentstock.class, jewel.getOrnamentstockid());

            /* 162 */ //Query q = session.createSQLQuery("select * from Ornamentstock where ornamentstockid=" + Ornamentstockid).addEntity(Ornamentstock.class);
            //List<Ornamentstock> lstgold = q.list();
            //ornamentstock = lstgold.get(0);
            ornamentstock.setRevgrossweight(jewel.getRevgrossweight());
            ornamentstock.setRevnetweight(jewel.getRevnetweight());
            ornamentstock.setRevtotalglodused(jewel.getRevtotalglodused());
            ornamentstock.setRevwastage(jewel.getRevwastage());
            ornamentstock.setSold(flag);
            session.update(ornamentstock);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void updateOrnamentTransFlag(JewelBean jewel, boolean flag) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 220 */ Ornamentstock ornamentstock = (Ornamentstock) session.load(Ornamentstock.class, jewel.getOrnamentstockid());

            /* 162 */ //Query q = session.createSQLQuery("select * from Ornamentstock where ornamentstockid=" + Ornamentstockid).addEntity(Ornamentstock.class);
            //List<Ornamentstock> lstgold = q.list();
            //ornamentstock = lstgold.get(0);
            ornamentstock.setRevgrossweight(jewel.getRevgrossweight());
            ornamentstock.setRevnetweight(jewel.getRevnetweight());
            ornamentstock.setRevtotalglodused(jewel.getRevtotalglodused());
            ornamentstock.setRevwastage(jewel.getRevwastage());
            ornamentstock.setSold(false);
            ornamentstock.setTransfered(true);
            session.update(ornamentstock);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void updateOrnamentFlag(int Ornamentstockid, boolean flag) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();

            /* 220 */ Ornamentstock ornamentstock = (Ornamentstock) session.load(Ornamentstock.class, Ornamentstockid);

            ornamentstock.setSold(flag);
            session.update(ornamentstock);
            transaction.commit();
        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
    }

    public List<JewelBean> getOrnaments(String jewelcodes) throws Exception {
        /* 232 */ List<JewelBean> lstornament = new ArrayList<JewelBean>();
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();


            /* 238 */ Query q = session.createSQLQuery("select * from Ornamentstock where ornamentstockid in(" + jewelcodes + ")").addEntity(Ornamentstock.class);
            List<Ornamentstock> lstgold = null;
            /* 240 */ lstgold = q.list();
            /* 242 */ HashMap hmMap = new ItemsDAO().getItemsMap();
            /* 243 */ for (int i = 0; i < lstgold.size(); i++) {
                /* 244 */ Ornamentstock ornamentstock = (Ornamentstock) lstgold.get(i);

                JewelBean object = new JewelBean(ornamentstock.getOrnamentstockid(), ornamentstock.getOrnamentstockno(), ornamentstock.getDescription(), ornamentstock.getItemid(), ornamentstock.getMemono(), ornamentstock.getMemoid(), ornamentstock.getGrossweight(), ornamentstock.getGoldweight(), ornamentstock.getStoneweight(), ornamentstock.getStonetype(), ornamentstock.getNetweight(), ornamentstock.getWastage(), ornamentstock.getTotalglodused(), ornamentstock.getInsertdate(), ornamentstock.getRevgrossweight(), ornamentstock.getRevnetweight(), ornamentstock.getRevwastage(), ornamentstock.getRevtotalglodused(), ornamentstock.isSold(), ornamentstock.isTransfered(), 0, ornamentstock.getInsertdate(), "");

                /* 245 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                /* 246 */ object.setDescription(items.getItem() + " - " + object.getDescription());
                /* 247 */ object.setOrnamentstockno(items.getItemcode() + " - " + object.getOrnamentstockno());
                lstornament.add(object);
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 253 */ return lstornament;
    }

    public HashMap getJewelbyYear(String year) throws Exception {
        /* 257 */
        Session session = null;
        List<JewelBean> list_Jewels = null;
        /* 262 */ HashMap hmJewel = new HashMap();
        /* 263 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 266 */ Query q = session.createSQLQuery("select * from Ornamentstock where YEAR(insertdate)=" + year).addEntity(Ornamentstock.class);
            List<Ornamentstock> list_Jewelentry = null;
            /* 269 */ list_Jewelentry = q.list();
            HashMap hmMap = new ItemsDAO().getItemsMap();
            /* 272 */ for (int i = 0; i < list_Jewelentry.size(); i++) {
                /* 273 */ Ornamentstock ornamentstock = (Ornamentstock) list_Jewelentry.get(i);

                JewelBean object = new JewelBean(ornamentstock.getOrnamentstockid(), ornamentstock.getOrnamentstockno(), ornamentstock.getDescription(), ornamentstock.getItemid(), ornamentstock.getMemono(), ornamentstock.getMemoid(), ornamentstock.getGrossweight(), ornamentstock.getGoldweight(), ornamentstock.getStoneweight(), ornamentstock.getStonetype(), ornamentstock.getNetweight(), ornamentstock.getWastage(), ornamentstock.getTotalglodused(), ornamentstock.getInsertdate(), ornamentstock.getRevgrossweight(), ornamentstock.getRevnetweight(), ornamentstock.getRevwastage(), ornamentstock.getRevtotalglodused(), ornamentstock.isSold(), ornamentstock.isTransfered(), 0, ornamentstock.getInsertdate(), "");

                /* 275 */ if (hmJewel.get(object.getMemono()) == null) {
                    /* 276 */ List<JewelBean> list_Jewelentrytemp = new ArrayList();

                    /* 245 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                    /* 247 */ object.setOrnamentstockno(items.getItemcode() + " - " + object.getOrnamentstockno());

                    /* 277 */ list_Jewelentrytemp.add(object);
                    /* 278 */ hmJewel.put(object.getMemono(), list_Jewelentrytemp);
                } else {
                    /* 280 */ List<JewelBean> list_Jewelentrytemp = (List) hmJewel.get(object.getMemono());
                    /* 245 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                    /* 247 */ object.setOrnamentstockno(items.getItemcode() + " - " + object.getOrnamentstockno());

                    /* 281 */ list_Jewelentrytemp.add(object);
                    /* 282 */ hmJewel.put(object.getMemono(), list_Jewelentrytemp);
                }
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 292 */ return hmJewel;
    }

    public HashMap getJewel(String year) throws Exception {
        /* 257 */
        Session session = null;
        List<JewelBean> list_Jewels = null;
        /* 262 */ HashMap hmJewel = new HashMap();
        /* 263 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 266 */ Query q = session.createSQLQuery("select * from Ornamentstock where YEAR(insertdate)=" + year).addEntity(Ornamentstock.class);
            List<Ornamentstock> list_Jewelentry = null;
            /* 269 */ list_Jewelentry = q.list();
            HashMap hmMap = new ItemsDAO().getItemsMap();
            /* 272 */ for (int i = 0; i < list_Jewelentry.size(); i++) {
                /* 273 */ Ornamentstock ornamentstock = (Ornamentstock) list_Jewelentry.get(i);

                JewelBean object = new JewelBean(ornamentstock.getOrnamentstockid(), ornamentstock.getOrnamentstockno(), ornamentstock.getDescription(), ornamentstock.getItemid(), ornamentstock.getMemono(), ornamentstock.getMemoid(), ornamentstock.getGrossweight(), ornamentstock.getGoldweight(), ornamentstock.getStoneweight(), ornamentstock.getStonetype(), ornamentstock.getNetweight(), ornamentstock.getWastage(), ornamentstock.getTotalglodused(), ornamentstock.getInsertdate(), ornamentstock.getRevgrossweight(), ornamentstock.getRevnetweight(), ornamentstock.getRevwastage(), ornamentstock.getRevtotalglodused(), ornamentstock.isSold(), ornamentstock.isTransfered(), 0, ornamentstock.getInsertdate(), "");

                /* 275 */ if (hmJewel.get(sdf.format(object.getInsertdate())) == null) {
                    /* 276 */ List<JewelBean> list_Jewelentrytemp = new ArrayList();

                    /* 245 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                    /* 247 */ object.setOrnamentstockno(items.getItemcode() + " - " + object.getOrnamentstockno());

                    /* 277 */ list_Jewelentrytemp.add(object);
                    /* 278 */ hmJewel.put(sdf.format(object.getInsertdate()), list_Jewelentrytemp);
                } else {
                    /* 280 */ List<JewelBean> list_Jewelentrytemp = (List) hmJewel.get(sdf.format(object.getInsertdate()));
                    /* 245 */ Items items = (Items) hmMap.get(object.getItemid() + "");
                    /* 247 */ object.setOrnamentstockno(items.getItemcode() + " - " + object.getOrnamentstockno());

                    /* 281 */ list_Jewelentrytemp.add(object);
                    /* 282 */ hmJewel.put(sdf.format(object.getInsertdate()), list_Jewelentrytemp);
                }
            }

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 292 */ return hmJewel;
    }
// remove 

    public double getTotalGoldUsed(String workermemono) throws Exception {
        /* 123 */ double totaljewelsweight = 0.0D;

        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();

            /* 130 */ Query q = session.createSQLQuery("select sum(netweight+wastage) as weight from ornamentstock where memono='" + workermemono + "'");
            /* 131 */ totaljewelsweight = q.uniqueResult() == null ? 0.0D : ((Double) q.uniqueResult());

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 136 */ return totaljewelsweight;
    }

    public double getGoldReturned(String memoNo) throws Exception {

        double goldUsed = 0.0;
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query q = session.createSQLQuery("select sum(netweight+wastage) as weight from ornamentstock where memoid in(" + memoNo + ")");
            goldUsed = q.uniqueResult() == null ? 0.0D : ((Double) q.uniqueResult());

        } catch (HibernateException e) {
            log.error(e);
        } finally {
            session.close();
        }
        /* 136 */ return goldUsed;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\dao\OrnamentStockDAO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
