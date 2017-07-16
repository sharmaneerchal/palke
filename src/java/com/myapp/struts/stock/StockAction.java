package com.myapp.struts.stock;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.JewelBean;
import com.myapp.struts.dao.GoldStockDAO;
import com.myapp.struts.dao.ItemsDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.SalesDAO;
import com.myapp.struts.dao.VouchersDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Sales;
import mappings.Vouchers;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class StockAction
        extends DispatchAction {

    /*  27 */ GoldStockDAO gs = new GoldStockDAO();

    public ActionForward loadStock(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  32 */ if (Constants.isSessionActive(request)) {
            /*  33 */ StockForm stockForm = (StockForm) form;
            try {
                /*  35 */ stockForm.getLstgold().clear();
                /*  39 */ stockForm.setGoldweight(0.0D);
                /*  43 */ stockForm.getLstgold().addAll(this.gs.getStock("Gold"));

                /*  48 */ stockForm.setGoldweight(Math.round(this.gs.getStockQuantity("Gold")));
            } catch (Exception e) {
            }
            /*  54 */ return mapping.findForward("display");
        }
        /*  56 */ return mapping.findForward("exp");
    }

    public ActionForward loadOrnamentStock(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  62 */ if (Constants.isSessionActive(request)) {
            /*  63 */ StockForm stockForm = (StockForm) form;
            try {
                stockForm.getLstorgold().clear();
                stockForm.setGrosstotal(0);
                stockForm.setNettotal(0);
                stockForm.setRevgrosstotal(0);
                stockForm.setRevnettotal(0);
                stockForm.setMsg("");
                stockForm.setItem("");
                stockForm.setItemid(0);
                stockForm.setLstItems(new ItemsDAO().getItems());
            } catch (Exception e) {
            }
            /*  72 */ return mapping.findForward("display");
        }
        /*  74 */ return mapping.findForward("exp");
    }

    public ActionForward loadOrnamentStockDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  80 */ if (Constants.isSessionActive(request)) {
            /*  81 */ StockForm stockForm = (StockForm) form;
            try {
                /*  83 */ stockForm.setLstorgold(new ArrayList<JewelBean>());
                /*  85 */ stockForm.setMsg("");
                stockForm.getLstorgold().addAll(new OrnamentStockDAO().getGoldOrnamentsStock(stockForm.getItemid()));
                //loadTotal(mapping, form, request, response);
                stockForm.setGrosstotal(0);
                stockForm.setNettotal(0);
                stockForm.setRevgrosstotal(0);
                stockForm.setRevnettotal(0);
            } catch (Exception e) {
                /*  90 */ throw e;
            }
            /*  92 */ return mapping.findForward("display");
        }
        /*  94 */ return mapping.findForward("exp");
    }

    public ActionForward loadTotal(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  80 */ if (Constants.isSessionActive(request)) {
            /*  81 */ StockForm stockForm = (StockForm) form;
            try {

                TreeMap total = new OrnamentStockDAO().getTotal(stockForm.getItemid());

                stockForm.setGrosstotal(Double.parseDouble(total.get("grosstotal").toString()));
                stockForm.setNettotal(Double.parseDouble(total.get("nettotal").toString()));
                stockForm.setRevgrosstotal(Double.parseDouble(total.get("revgrosstotal").toString()));
                stockForm.setRevnettotal(Double.parseDouble(total.get("revnettotal").toString()));
            } catch (Exception e) {
                /*  90 */ throw e;
            }
            /*  92 */ return mapping.findForward("display");
        }
        /*  94 */ return mapping.findForward("exp");
    }

    public ActionForward updateOrnamentValues(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 100 */ if (Constants.isSessionActive(request)) {
            /* 101 */ StockForm stockForm = (StockForm) form;
            try {
                /* 103 */ for (int i = 0; i < stockForm.getLstorgold().size(); i++) {
                    /* 104 */ JewelBean object = (JewelBean) stockForm.getLstorgold().get(i);
                    /* 105 */ if (stockForm.getIndex() == object.getOrnamentstockid()) {
                        /* 106 */ object.setRevgrossweight(stockForm.getRevgrossweight());
                        /* 107 */ object.setRevnetweight(stockForm.getRevnetweight());
                        /* 108 */ object.setRevwastage(stockForm.getRevwastage());
                        object.setStonetype(stockForm.getStonetype());
                        /* 109 */ object.setRevtotalglodused(stockForm.getRevnetweight() + stockForm.getRevwastage());
                        /* 110 */ new OrnamentStockDAO().updateOrnament(object);
                        /* 111 */ break;
                    }
                }
                /* 114 */ stockForm.setMsg("Jewel details updated.");
            } catch (Exception e) {
                /* 116 */ throw e;
            }
            /* 118 */ return mapping.findForward("display");
        }
        /* 120 */ return mapping.findForward("exp");
    }

    public ActionForward updateStockTransfer(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            StockForm stockForm = (StockForm) form;
            try {
                for (int i = 0; i < stockForm.getLstorgold().size(); i++) {
                    JewelBean object = (JewelBean) stockForm.getLstorgold().get(i);
                    if (stockForm.getIndex() == object.getOrnamentstockid()) {

                        Vouchers vouchers = new Vouchers();
                        vouchers.setVouchertype("Transfer from GS12");
                        vouchers.setVouchercategory("Ornament");
                        vouchers.setVoucherno(object.getOrnamentstockno());
                        vouchers.setVoucherdate(new Date());
                        vouchers.setWeight(object.getNetweight());
                        vouchers.setAmount("");
                        vouchers.setRemarks("");

                        vouchers.setCreateddate(new Date());
                        vouchers.setUpdateddate(new Date());
                        int voucherid = new VouchersDAO().saveVoucher(vouchers, false);

                        new OrnamentStockDAO().updateOrnamentTransFlag(object, true);

                        //update gs 12
                        Sales sales = new Sales();

                        sales.setBillamount(0.0);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
                        sales.setBilldate(sdf.format(new Date()));
                        sales.setBillno("0");
                        sales.setDiscounts(0.0);
                        sales.setInsertdate(new Date());
                        sales.setJewelcodes(object.getOrnamentstockid() + "");
                        sales.setTax(0.0);
                        sales.setUpdatedate(new Date());

                        new SalesDAO().saveSales(sales, false);

                        loadOrnamentStockDetails(mapping, form, request, response);
                        break;
                    }
                }

            } catch (Exception e) {
            }

        } else {
            return mapping.findForward("exp");
        }
        return mapping.findForward("display");
    }
}
/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\stock\StockAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
