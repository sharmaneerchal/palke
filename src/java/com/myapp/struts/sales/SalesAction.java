package com.myapp.struts.sales;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.JewelBean;
import com.myapp.struts.dao.ItemsDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.SalesDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Sales;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class SalesAction
        extends DispatchAction {

    /*  31 */ private HashMap hmadded = new HashMap();

    public ActionForward loadSalesPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /*  35 */ if (Constants.isSessionActive(request)) {
            /*  36 */ SalesForm stockForm = (SalesForm) form;
            try {
                /*  38 */ stockForm.getLstornaments().clear();
                /*  39 */ stockForm.getLstoradded().clear();
                stockForm.setCount(0);


                // /*  40 */ stockForm.setLstItems(new ItemsDAO().getItems());
                ///*  41 */ stockForm.setLstbills(new SalesDAO().getSales());
                /*  42 */ clearForm(mapping, form, request, response);
                /*  43 */ stockForm.setMessage("");
            } catch (Exception e) {
            }
            /*  46 */ return mapping.findForward("display");
        }
        /*  48 */ return mapping.findForward("exp");
    }

    public ActionForward clearForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        /*  54 */ if (Constants.isSessionActive(request)) {
            /*  55 */ SalesForm stockForm = (SalesForm) form;
            try {
                /*  57 */ stockForm.getLstornaments().clear();
                /*  58 */ stockForm.getLstoradded().clear();
                stockForm.setCount(stockForm.getLstoradded().size());
                /*  60 */ stockForm.setBillamount(0.0D);
                /*  61 */ stockForm.setBilldate("");
                /*  62 */ stockForm.setBillno("");
                /*  63 */ stockForm.setDiscount(0.0D);
                /*  64 */ stockForm.setItem("");
                /*  65 */ stockForm.setItemid(0);
                stockForm.setSalesid(0);
                /*  66 */ this.hmadded.clear();
                /*  40 */ stockForm.setLstItems(new ItemsDAO().getItems());
                /*  41 */ stockForm.setLstbills(new SalesDAO().getSales());

            } catch (Exception e) {
            }
            /*  69 */ return mapping.findForward("display");
        }
        /*  71 */ return mapping.findForward("exp");
    }

    public ActionForward loadOrnamentStockDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  77 */ if (Constants.isSessionActive(request)) {
            /*  78 */ SalesForm stockForm = (SalesForm) form;
            try {
                stockForm.setLstornaments(new ArrayList<JewelBean>());
                /*  81 */ stockForm.setMessage("");
                /*  82 */ stockForm.getLstornaments().addAll(new OrnamentStockDAO().getOrnamentsStock(stockForm.getItemid()));
            } catch (Exception e) {
                /*  84 */ throw e;
            }
            /*  86 */ return mapping.findForward("display");
        }
        /*  88 */ return mapping.findForward("exp");
    }

    public ActionForward addOrnament(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  94 */ if (Constants.isSessionActive(request)) {
            /*  95 */ SalesForm stockForm = (SalesForm) form;
            /*  96 */ stockForm.setMessage("");
            try {
                /*  99 */ for (int i = 0; i < stockForm.getLstornaments().size(); i++) {
                    /* 100 */ JewelBean object = (JewelBean) stockForm.getLstornaments().get(i);
                    /* 101 */ if (stockForm.getJewelcode() == object.getOrnamentstockid()) {
                        if (object.getRevtotalglodused() != 0) {
                            if (this.hmadded.get(object.getOrnamentstockid() + "") == null) {
                                stockForm.getLstoradded().add(object);
                                this.hmadded.put(object.getOrnamentstockid() + "", object);
                                stockForm.setMessage(object.getOrnamentstockno() + " is added to the list.");
                                stockForm.setCount(stockForm.getLstoradded().size());
                                break;
                            } else {
                                stockForm.setMessage("Jewel already added to the list.");
                                break;
                            }
                        } else {
                            stockForm.setMessage("Jewel value not revised.");
                            break;
                        }
                    }

                }
            } catch (Exception e) {
                /* 115 */ throw e;
            }
            /* 117 */ return mapping.findForward("display");
        }
        /* 119 */ return mapping.findForward("exp");
    }

    public ActionForward removeOrnament(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 125 */ if (Constants.isSessionActive(request)) {
            /* 126 */ SalesForm stockForm = (SalesForm) form;
            try {
                /* 128 */ if (stockForm.getSalesid() == 0) {
                    /* 129 */ for (int i = 0; i < stockForm.getLstoradded().size(); i++) {
                        /* 130 */ JewelBean object = (JewelBean) stockForm.getLstoradded().get(i);
                        /* 131 */ if (stockForm.getJewelcode() == object.getOrnamentstockid()) {
                            /* 132 */ stockForm.getLstoradded().remove(object);
                            /* 133 */ this.hmadded.remove(object.getOrnamentstockid() + "");
                            /* 134 */ break;
                        }
                    }
                } else {
                    /* 139 */ for (int i = 0; i < stockForm.getLstoradded().size(); i++) {
                        /* 140 */ JewelBean object = (JewelBean) stockForm.getLstoradded().get(i);
                        /* 141 */ if (stockForm.getJewelcode() == object.getOrnamentstockid()) {
                            /* 142 */ stockForm.getLstoradded().remove(object);
                            /* 143 */ this.hmadded.remove(object.getOrnamentstockid() + "");
                            /* 144 */ break;
                        }
                    }
                    StringBuilder jewelcode = new StringBuilder();
                    /* 165 */ for (int i = 0; i < stockForm.getLstoradded().size(); i++) {
                        /* 166 */ JewelBean object = (JewelBean) stockForm.getLstoradded().get(i);
                        /* 167 */ jewelcode.append(object.getOrnamentstockid()).append("");
                        /* 168 */ jewelcode.append(",");
                    }
                    /* 172 */ jewelcode.append("0");
                    /* 196 */ Sales sales = new Sales();

                    /* 198 */ sales.setBillamount(stockForm.getBillamount());
                    /* 199 */ sales.setBilldate(stockForm.getBilldate());
                    /* 200 */ sales.setBillno(stockForm.getBillno());
                    /* 201 */ sales.setDiscounts(stockForm.getDiscount());
                    /* 202 */ sales.setJewelcodes(jewelcode.toString());
                    /* 203 */ sales.setTax(stockForm.getBillamount());
                    /* 204 */ sales.setUpdatedate(new Date());
                    /* 205 */ sales.setSalesid(stockForm.getSalesid());

                    /* 207 */ new SalesDAO().saveSales(sales, true);
                    /* 147 */ new OrnamentStockDAO().updateOrnamentFlag(stockForm.getJewelcode(), false);
                    stockForm.setCount(stockForm.getLstoradded().size());
                }
            } catch (Exception e) {
                /* 150 */ throw e;
            }
            /* 152 */ return mapping.findForward("display");
        }
        /* 154 */ return mapping.findForward("exp");
    }

    public ActionForward deletBill(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 125 */ if (Constants.isSessionActive(request)) {
            /* 126 */ SalesForm stockForm = (SalesForm) form;
            try {

                /* 207 */ new SalesDAO().deleteSales(stockForm.getSalesid());
                for (int i = 0; i < stockForm.getLstoradded().size(); i++) {
                    new OrnamentStockDAO().updateOrnamentFlag(stockForm.getLstoradded().get(i), false);
                }
                clearForm(mapping, form, request, response);

            } catch (Exception e) {
                /* 150 */ throw e;
            }
            /* 152 */ return mapping.findForward("display");
        }

        /* 154 */ return mapping.findForward("exp");
    }

    public ActionForward saveSales(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 160 */ if (Constants.isSessionActive(request)) {
            /* 161 */ SalesForm stockForm = (SalesForm) form;

            if (stockForm.getLstoradded().isEmpty()) {
                stockForm.setMessage("Jewel(s) not added to the Bill. Please add the Jewel.");
                return mapping.findForward("display");
            }
            if (stockForm.getSalesid() == 0) {
                if (new SalesDAO().isBillExist(stockForm.getBillno().trim())) {
                    stockForm.setMessage("The bill is already exist.");
                    return mapping.findForward("display");
                }
            }
            /* 162 */ StringBuilder jewelcode = new StringBuilder();
            /* 163 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

            try {
                /* 165 */ for (int i = 0; i < stockForm.getLstoradded().size(); i++) {
                    /* 166 */ JewelBean object = (JewelBean) stockForm.getLstoradded().get(i);
                    /* 167 */ jewelcode.append(object.getOrnamentstockid()).append("");
                    /* 168 */ jewelcode.append(",");

                    /* 170 */ new OrnamentStockDAO().updateOrnamentFlag(object, true);
                }
                /* 172 */ jewelcode.append("0");
                /* 173 */ if (stockForm.getSalesid() == 0) {
                    /* 175 */ Sales sales = new Sales();

                    /* 177 */ sales.setBillamount(stockForm.getBillamount());
                    /* 178 */ sales.setBilldate(stockForm.getBilldate());
                    /* 179 */ //System.out.println(sales.getBilldate());
                    /* 180 */ sales.setBillno(stockForm.getBillno());
                    /* 181 */ sales.setDiscounts(stockForm.getDiscount());
                    /* 182 */ sales.setInsertdate(new Date());
                    /* 183 */ sales.setJewelcodes(jewelcode.toString());
                    /* 184 */ sales.setTax(stockForm.getBillamount());
                    /* 185 */ sales.setUpdatedate(new Date());

                    /* 187 */ new SalesDAO().saveSales(sales, false);

                    /* 189 */ this.hmadded.clear();

                    /* 191 */ stockForm.setMessage("Bill saved successfully.");
                    /* 192 */ clearForm(mapping, form, request, response);
                } else {
                    /* 196 */ Sales sales = new Sales();

                    /* 198 */ sales.setBillamount(stockForm.getBillamount());
                    /* 199 */ sales.setBilldate(stockForm.getBilldate());
                    /* 200 */ sales.setBillno(stockForm.getBillno());
                    /* 201 */ sales.setDiscounts(stockForm.getDiscount());
                    /* 202 */ sales.setJewelcodes(jewelcode.toString());
                    /* 203 */ sales.setTax(stockForm.getBillamount());
                    /* 204 */ sales.setUpdatedate(new Date());
                    /* 205 */ sales.setSalesid(stockForm.getSalesid());

                    /* 207 */ new SalesDAO().saveSales(sales, true);
                    /* 208 */ this.hmadded.clear();

                    /* 210 */ stockForm.setMessage("Bill saved successfully.");
                    /* 211 */ clearForm(mapping, form, request, response);
                }
            } catch (Exception e) {
                /* 214 */ throw e;
            }
            /* 216 */ return mapping.findForward("display");
        }
        /* 218 */ return mapping.findForward("exp");
    }

    public ActionForward loadOrnamentSales(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 224 */ if (Constants.isSessionActive(request)) {
            /* 225 */ SalesForm stockForm = (SalesForm) form;
            try {
                /* 227 */ stockForm.getLstornaments().clear();
                /* 228 */ stockForm.setMessage("");
                /* 229 */ stockForm.setLstbills(new SalesDAO().getSales());

            } catch (Exception e) {
                /* 234 */ throw e;
            }
            /* 236 */ return mapping.findForward("display");
        }
        /* 238 */ return mapping.findForward("exp");
    }

    public ActionForward openBill(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 244 */ if (Constants.isSessionActive(request)) {
            /* 245 */ SalesForm stockForm = (SalesForm) form;
            /* 246 */ SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
            try {
                /* 248 */ stockForm.getLstornaments().clear();
                /* 249 */ stockForm.setMessage("");
                /* 250 */ Sales salses = new SalesDAO().getBill(stockForm.getSalesid());

                /* 252 */ stockForm.setBillamount(salses.getBillamount().doubleValue());
                /* 253 */ stockForm.setBilldate(salses.getBilldate());
                /* 254 */ stockForm.setBillno(salses.getBillno());
                /* 255 */ stockForm.setDiscount(salses.getDiscounts().doubleValue());

                /* 257 */ stockForm.setSalesid(salses.getSalesid().intValue());

                /* 259 */ stockForm.setLstoradded(new OrnamentStockDAO().getOrnaments(salses.getJewelcodes()));
                /* 260 */ for (int i = 0; i < stockForm.getLstoradded().size(); i++) {
                    /* 261 */ JewelBean object = (JewelBean) stockForm.getLstoradded().get(i);
                    /* 262 */ this.hmadded.put(object.getOrnamentstockid() + "", object);
                }
                stockForm.setCount(stockForm.getLstoradded().size());
            } catch (Exception e) {
                /* 267 */ throw e;
            }
            /* 269 */ return mapping.findForward("display");
        }
        /* 271 */ return mapping.findForward("exp");
    }

    public ActionForward updateOrnamentValues(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 100 */ if (Constants.isSessionActive(request)) {
            SalesForm stockForm = (SalesForm) form;
            try {
                /* 103 */ for (int i = 0; i < stockForm.getLstornaments().size(); i++) {
                    /* 104 */ JewelBean object = (JewelBean) stockForm.getLstornaments().get(i);
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
                loadOrnamentStockDetails(mapping, form, request, response);
            } catch (Exception e) {
                /* 116 */ throw e;
            }
            /* 118 */ return mapping.findForward("display");
        }
        /* 120 */ return mapping.findForward("exp");
    }

}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\sales\SalesAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
