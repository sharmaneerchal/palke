package com.myapp.struts.transactionreport;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.DetailsBean;
import com.myapp.struts.beans.JewelBean;
import com.myapp.struts.beans.TransactionReportBean;
import com.myapp.struts.beans.YearsBean;
import com.myapp.struts.dao.BalanceDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.SalesDAO;
import com.myapp.struts.dao.VouchersDAO;
import com.myapp.struts.dao.WorkersMemoDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Balance;
import mappings.Sales;
import mappings.Vouchers;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class TransactionReportAction
        extends DispatchAction {

    /*  48 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /*  49 */    double creditsum = 0.0D;
    /*  50 */    double deditsum = 0.0D;
    /*  51 */    double balancesum = 0.0D;
    /*  52 */    double carryBalance = 0.0D;
    /*  53 */    double NetweightcarryBalance = 0.0D;
    /*  54 */    double GrossweightcarryBalance = 0.0D;
    /*  55 */    Font font = FontFactory.getFont("Helvetica", 8.0F);

    public ActionForward loadTransactionPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /*  59 */ if (Constants.isSessionActive(request)) {
            /*  60 */ TransactionReportForm transForm = (TransactionReportForm) form;
            /*  61 */ transForm.getLsttrgold().clear();
            /*  62 */ transForm.getLsttrsilver().clear();
            /*  63 */ transForm.getLsttrstone().clear();
            /*  64 */ transForm.getLsttrdiamond().clear();
            /*  65 */ transForm.getLstyears().clear();
            /*  66 */ int year = 2017;
            /*  67 */ transForm.setYear(Calendar.getInstance().get(1) + "");
            /*  68 */ for (int i = year; i < 2030; i++) {
                /*  69 */ YearsBean yr = new YearsBean();
                /*  70 */ yr.setYear(year);
                /*  71 */ yr.setYears(year + "");
                /*  72 */ transForm.getLstyears().add(yr);
                /*  73 */ year++;
            }

            /*  76 */ loadTransactions(mapping, form, request, response);
            /*  77 */ return mapping.findForward("display");
        }
        /*  79 */ return mapping.findForward("exp");
    }

    public ActionForward loadTransactions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  85 */ if (Constants.isSessionActive(request)) {
            try {
                /*  87 */ TransactionReportForm transForm = (TransactionReportForm) form;

                /*  89 */ transForm.getLsttrgold().clear();
                /*  90 */ transForm.getLsttrsilver().clear();
                /*  91 */ transForm.getLsttrstone().clear();
                /*  92 */ transForm.getLsttrdiamond().clear();

                /*  95 */ HashMap hmgoldVouchers = new VouchersDAO().getVouchers(transForm.getYear(), "Gold");

                /* 103 */ HashMap hmWorkersMemo = new WorkersMemoDAO().getWorkersMemo(transForm.getYear());

                /* 109 */ this.creditsum = 0.0D;
                /* 110 */ this.deditsum = 0.0D;
                /* 111 */ this.balancesum = 0.0D;

                /* 113 */ transForm.setLsttrgold(setTransactionListNew(Integer.parseInt(transForm.getYear()), hmgoldVouchers, hmWorkersMemo));
                /* 114 */ transForm.setCredittotal1(this.creditsum);
                /* 115 */ transForm.setDebittotal1(this.deditsum);
                /* 116 */ transForm.setBalancetotal1(this.balancesum);

                /* 118 */ Balance ba = new Balance();
                /* 119 */ ba.setBalance(((TransactionReportBean) transForm.getLsttrgold().get(transForm.getLsttrgold().size() - 1)).getBalance());
                /* 120 */ ba.setYear(Integer.parseInt(transForm.getYear()));
                /* 121 */ ba.setInsertdate(new Date());
                /* 122 */ ba.setType("GS11");
                /* 123 */ new BalanceDAO().update(ba);

                /* 150 */ transForm.setCarrybalance(this.carryBalance);
            } catch (Exception e) {
                /* 152 */ e.printStackTrace();
            }

            /* 155 */ return mapping.findForward("display");
        }
        /* 157 */ return mapping.findForward("exp");
    }

    public List<TransactionReportBean> setTransactionListNew(int year, HashMap hmVouchers, HashMap hmWorkersMemo) {
        /* 162 */ List<TransactionReportBean> lstTrans = new ArrayList();

        /* 165 */ int count = 0;
        /* 166 */ ArrayList<String> dates = new ArrayList();
        /* 167 */ Calendar cal = Calendar.getInstance();
        /* 168 */ Date dat = new Date();
        /* 169 */ cal.set(year, 0, 1);
        try {
            /* 171 */ int index = 1;
            /* 172 */ while (cal.get(1) == year) {
                /* 173 */ DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                /* 174 */ String date = df.format(cal.getTime());
                /* 175 */ dates.add(date);

                /* 179 */ double creditweightperday = 0.0D;
                /* 180 */ double deditweightperday = 0.0D;

                /* 183 */ List<Vouchers> lstVouchers = (List) hmVouchers.get(date);

                /* 186 */ List<Workersmemo> lstworkersmemo = (List) hmWorkersMemo.get(date);

                /* 188 */ TransactionReportBean bean = new TransactionReportBean();

                /* 190 */ if ((lstVouchers != null) || (lstworkersmemo != null)) {
                    /* 191 */ if (lstVouchers != null) {
                        /* 192 */ for (int j = 0; j < lstVouchers.size(); j++) {
                            /* 193 */ Vouchers vouchers = (Vouchers) lstVouchers.get(j);

                            /* 195 */ DetailsBean det = new DetailsBean();
                            /* 196 */ if (vouchers.getVouchertype().equals("Purchase Voucher")) {
                                if (vouchers.getVouchercategory().equals("Copper")) {
                                    /* 199 */ det.setDesc("Copper " + vouchers.getVoucherno());
                                    /* 200 */ det.setWeight(Constants.amountRounding(vouchers.getWeight()));
                                } else {
                                    /* 203 */ det.setDesc("PV - " + vouchers.getVoucherno());
                                    /* 204 */ det.setWeight(Constants.amountRounding(vouchers.getWeight()));
                                }
                            } else if (vouchers.getVouchertype().equals("Receipt Voucher")) {
                                if (vouchers.getVouchercategory().equals("Copper")) {
                                    /* 199 */ det.setDesc("Copper " + vouchers.getVoucherno());
                                    /* 200 */ det.setWeight(Constants.amountRounding(vouchers.getWeight()));
                                } else {
                                    /* 213 */ det.setDesc("RV - " + vouchers.getVoucherno());
                                    /* 214 */ det.setWeight(Constants.amountRounding(vouchers.getWeight()));
                                }
                            } else if (vouchers.getVouchertype().equals("Workers Memo")) {
                                /* 223 */ det.setDesc("WM - " + vouchers.getVoucherno() + "- Ravi");
                                /* 224 */ det.setWeight(Constants.amountRounding(vouchers.getWeight()));
                            } else if (vouchers.getVouchertype().equals("Transfer from GS12")) {
                                /* 223 */ det.setDesc("GS 12 - " + vouchers.getVoucherno());
                                /* 224 */ det.setWeight(Constants.amountRounding(vouchers.getWeight()));
                            }

                            /* 227 */ creditweightperday += vouchers.getWeight();
                            /* 228 */ bean.getLstcredit().add(det);
                        }
                    }
                    /* 231 */ if (lstworkersmemo != null) {
                        /* 232 */ for (int j = 0; j < lstworkersmemo.size(); j++) {
                            /* 233 */ Workersmemo workersmemo = (Workersmemo) lstworkersmemo.get(j);

                            /* 235 */ DetailsBean det = new DetailsBean();

                            /* 238 */ det.setDesc("WM - " + workersmemo.getWorkermemono() + "");
                            /* 239 */ det.setWeight(Constants.amountRounding(workersmemo.getGoldweight()));
                            /* 241 */ deditweightperday += workersmemo.getGoldweight();
                            /* 259 */ bean.getLstdebit().add(det);
                        }
                        /* 261 */ deditweightperday = Constants.amountRounding(deditweightperday);
                    }
                    /* 263 */ bean.setDate(date);

                    /* 265 */ if (index == 1) {
                        /* 266 */ this.carryBalance = new BalanceDAO().getBalance(year - 1, "GS11");
                        /* 267 */ bean.setBalance(this.carryBalance);
                    }
                    /* 269 */ index++;
                    /* 270 */ if (lstTrans.isEmpty()) {
                        /* 271 */ bean.setBalance(Constants.amountRounding(bean.getBalance() + (creditweightperday - deditweightperday)));
                    } else {
                        /* 273 */ bean.setBalance(Constants.amountRounding(bean.getBalance() + ((TransactionReportBean) lstTrans.get(lstTrans.size() - 1)).getBalance() + (creditweightperday - deditweightperday)));
                    }
                    /* 275 */ lstTrans.add(bean);
                }

                /* 278 */ this.creditsum = Constants.amountRounding(this.creditsum + creditweightperday);
                /* 279 */ this.deditsum = Constants.amountRounding(this.deditsum + deditweightperday);
                /* 280 */ this.balancesum = Constants.amountRounding(this.creditsum - this.deditsum);

                /* 282 */ System.out.println(date);
                /* 283 */ cal.add(5, 1);
            }
        } catch (Exception e) {
            /* 286 */ e.printStackTrace();
        }

        /* 289 */ return lstTrans;
    }

    public ActionForward printView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /* 294 */ if (Constants.isSessionActive(request)) {
            /* 295 */ TransactionReportForm transForm = (TransactionReportForm) form;
            try {
                /* 297 */ transForm.setCredittotal(0.0D);
                /* 298 */ transForm.setDebittotal(0.0D);
                /* 299 */ transForm.setBalancetotal(0.0D);
                /* 300 */ transForm.getLstprint().clear();

                /* 302 */ transForm.setReportdate(new Date());

                /* 304 */ if (transForm.getType().equals("Gold")) {
                    /* 305 */ transForm.getLstprint().addAll(transForm.getLsttrgold());

                    /* 307 */ transForm.setCredittotal(transForm.getCredittotal1());
                    /* 308 */ transForm.setDebittotal(transForm.getDebittotal1());
                    /* 309 */ transForm.setBalancetotal(transForm.getBalancetotal1());
                }
                /* 311 */ if (transForm.getType().equals("Silver")) {
                    /* 312 */ transForm.getLstprint().addAll(transForm.getLsttrsilver());

                    /* 314 */ transForm.setCredittotal(transForm.getCredittotal2());
                    /* 315 */ transForm.setDebittotal(transForm.getDebittotal2());
                    /* 316 */ transForm.setBalancetotal(transForm.getBalancetotal2());
                }
                /* 318 */ if (transForm.getType().equals("Stone, Pearls etc")) {
                    /* 319 */ transForm.getLstprint().addAll(transForm.getLsttrstone());

                    /* 321 */ transForm.setCredittotal(transForm.getCredittotal3());
                    /* 322 */ transForm.setDebittotal(transForm.getDebittotal3());
                    /* 323 */ transForm.setBalancetotal(transForm.getBalancetotal3());
                }
                /* 325 */ if (transForm.getType().equals("Diamonds")) {
                    /* 326 */ transForm.getLstprint().addAll(transForm.getLsttrdiamond());

                    /* 328 */ transForm.setCredittotal(transForm.getCredittotal4());
                    /* 329 */ transForm.setDebittotal(transForm.getDebittotal4());
                    /* 330 */ transForm.setBalancetotal(transForm.getBalancetotal4());
                }
            } catch (Exception e) {
            }
            /* 334 */ return mapping.findForward("print");
        }
        /* 336 */ return mapping.findForward("exp");
    }

    public ActionForward loadGS12Page(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 343 */ if (Constants.isSessionActive(request)) {
            /* 344 */ TransactionReportForm transForm = (TransactionReportForm) form;

            /* 346 */ transForm.getLstjewel().clear();
            /* 347 */ transForm.getLstyears().clear();

            /* 349 */ int year = 2017;
            /* 350 */ transForm.setYear(Calendar.getInstance().get(1) + "");
            /* 351 */ for (int i = year; i < 2030; i++) {
                /* 352 */ YearsBean yr = new YearsBean();
                /* 353 */ yr.setYear(year);
                /* 354 */ yr.setYears(year + "");
                /* 355 */ transForm.getLstyears().add(yr);
                /* 356 */ year++;
            }
            /* 358 */ loadGS12Transactions(mapping, form, request, response);
            /* 359 */ return mapping.findForward("display");
        }
        /* 361 */ return mapping.findForward("exp");
    }

    public ActionForward loadGS12Transactions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 367 */ if (Constants.isSessionActive(request)) {
            try {
                /* 369 */ TransactionReportForm transForm = (TransactionReportForm) form;

                /* 371 */ transForm.getLstjewel().clear();

                /* 375 */ HashMap hmJewels = new OrnamentStockDAO().getJewel(transForm.getYear());

                /* 378 */ HashMap hmSales = new SalesDAO().getSales(transForm.getYear());

                /* 380 */ this.creditsum = 0.0D;
                /* 381 */ this.deditsum = 0.0D;
                /* 382 */ this.balancesum = 0.0D;
                /* 383 */ transForm.setLstjewel(setGS12(Integer.parseInt(transForm.getYear()), hmJewels, hmSales));
                /* 384 */ transForm.setCredittotal1(this.creditsum);
                /* 385 */ transForm.setDebittotal1(this.deditsum);
                /* 386 */ transForm.setBalancetotal1(this.balancesum);
                /* 387 */ transForm.setNetcarryBalance(this.NetweightcarryBalance);
                /* 388 */ transForm.setGrosscarryBalance(this.GrossweightcarryBalance);

                /* 390 */ if (!transForm.getLstjewel().isEmpty()) {
                    /* 391 */ Balance ba = new Balance();
                    /* 392 */ ba.setBalance(((TransactionReportBean) transForm.getLstjewel().get(transForm.getLstjewel().size() - 1)).getNetweightbalance());
                    /* 393 */ ba.setYear(Integer.parseInt(transForm.getYear()));
                    /* 394 */ ba.setInsertdate(new Date());
                    /* 395 */ ba.setType("NETGS12");
                    /* 396 */ new BalanceDAO().update(ba);

                    /* 398 */ ba = new Balance();
                    /* 399 */ ba.setBalance(((TransactionReportBean) transForm.getLstjewel().get(transForm.getLstjewel().size() - 1)).getGrossweightbalance());
                    /* 400 */ ba.setYear(Integer.parseInt(transForm.getYear()));
                    /* 401 */ ba.setInsertdate(new Date());
                    /* 402 */ ba.setType("GROSSGS12");
                    /* 403 */ new BalanceDAO().update(ba);
                }
            } catch (Exception e) {
                /* 406 */ e.printStackTrace();
            }

            /* 409 */ return mapping.findForward("display");
        }
        /* 411 */ return mapping.findForward("exp");
    }

    public List<TransactionReportBean> setGS12(int year, HashMap hmJewels, HashMap hmSales) {
        /* 416 */ List<TransactionReportBean> lstTrans = new ArrayList();

        /* 419 */ int count = 0;
        /* 420 */ ArrayList<String> dates = new ArrayList();
        /* 421 */ Calendar cal = Calendar.getInstance();
        /* 422 */ Date dat = new Date();
        /* 423 */ cal.set(year, 0, 1);
        try {
            /* 425 */ int index = 1;
            /* 426 */ while (cal.get(1) == year) {
                /* 427 */ DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                /* 428 */ String date = df.format(cal.getTime());
                /* 429 */ dates.add(date);

                /* 433 */ double netweightperdayR = 0.0D;
                /* 434 */ double grossweightperdayR = 0.0D;

                /* 436 */ double netweightperdayS = 0.0D;
                /* 437 */ double grossweightperdayS = 0.0D;

                /* 439 */ List<JewelBean> lstJewels = (List) hmJewels.get(date);

                /* 442 */ List<Sales> lstSales = (List) hmSales.get(date);

                /* 444 */ TransactionReportBean bean = new TransactionReportBean();

                /* 446 */ if ((lstJewels != null) || (lstSales != null)) {
                    /* 447 */ if (lstJewels != null) {
                        /* 448 */ for (int j = 0; j < lstJewels.size(); j++) {
                            /* 449 */ JewelBean jewel = (JewelBean) lstJewels.get(j);

                            /* 451 */ DetailsBean det = new DetailsBean();

                            /* 453 */ det.setNetweight(Constants.amountRounding(jewel.getNetweight()));
                            /* 454 */ det.setGrossweight(Constants.amountRounding(jewel.getGrossweight()));
                            /* 455 */ det.setMemono(jewel.getMemono() + " - " + jewel.getOrnamentstockno());

                            /* 457 */ netweightperdayR += jewel.getNetweight();
                            /* 458 */ grossweightperdayR += jewel.getGrossweight();

                            /* 460 */ bean.getLstreceipt().add(det);
                        }
                    }
                    /* 463 */ if (lstSales != null) {
                        /* 464 */ for (int j = 0; j < lstSales.size(); j++) {
                            /* 466 */ Sales sales = (Sales) lstSales.get(j);
                            /* 467 */
 /* 469 */ List<JewelBean> listOrnament = new OrnamentStockDAO().getOrnaments(sales.getJewelcodes());
                            /* 470 */ for (int i = 0; i < listOrnament.size(); i++) {
                                /* 471 */ JewelBean ornamentstock = (JewelBean) listOrnament.get(i);

                                DetailsBean det = new DetailsBean();
                                if (sales.getBillno().equals("0")) {
                                    det.setNetweight(Constants.amountRounding(ornamentstock.getNetweight()));
                                    det.setGrossweight(Constants.amountRounding(ornamentstock.getGrossweight()));

                                    /* 478 */ netweightperdayS += ornamentstock.getNetweight();
                                    /* 479 */ grossweightperdayS += ornamentstock.getGrossweight();

                                } else {
                                    det.setNetweight(Constants.amountRounding(ornamentstock.getRevnetweight()));
                                    det.setGrossweight(Constants.amountRounding(ornamentstock.getRevgrossweight()));

                                    /* 478 */ netweightperdayS += ornamentstock.getRevnetweight();
                                    /* 479 */ grossweightperdayS += ornamentstock.getRevgrossweight();

                                }
                                /* 476 */ det.setMemono(sales.getBillno() + " - " + ornamentstock.getOrnamentstockno());

                                /* 481 */ bean.getLstsales().add(det);
                            }
                        }
                    }

                    /* 487 */ bean.setDate(date);
                    /* 488 */ if (index == 1) {
                        /* 489 */ this.NetweightcarryBalance = new BalanceDAO().getBalance(year - 1, "NETGS12");
                        /* 490 */ this.GrossweightcarryBalance = new BalanceDAO().getBalance(year - 1, "GROSSGS12");
                        /* 491 */ bean.setNetweightbalance(this.NetweightcarryBalance);
                        /* 492 */ bean.setGrossweightbalance(this.GrossweightcarryBalance);
                    }
                    /* 494 */ index++;
                    /* 495 */ if (lstTrans.isEmpty()) {
                        /* 496 */ bean.setNetweightbalance(Constants.amountRounding(bean.getNetweightbalance() + (netweightperdayR - netweightperdayS)));
                        /* 497 */ bean.setGrossweightbalance(Constants.amountRounding(bean.getGrossweightbalance() + (grossweightperdayR - grossweightperdayS)));
                    } else {
                        /* 499 */ bean.setNetweightbalance(Constants.amountRounding(bean.getNetweightbalance() + (((TransactionReportBean) lstTrans.get(lstTrans.size() - 1)).getNetweightbalance() + (netweightperdayR - netweightperdayS))));

                        /* 501 */ bean.setGrossweightbalance(Constants.amountRounding(bean.getGrossweightbalance() + ((TransactionReportBean) lstTrans.get(lstTrans.size() - 1)).getGrossweightbalance() + (grossweightperdayR - grossweightperdayS)));
                    }
                    /* 503 */ lstTrans.add(bean);
                }

                /* 506 */ System.out.println(date);
                /* 507 */ cal.add(5, 1);
            }
        } catch (Exception e) {
            /* 510 */ e.printStackTrace();
        }

        /* 513 */ return lstTrans;
    }

    public ActionForward printViewGS12(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /* 518 */ if (Constants.isSessionActive(request)) {
            /* 519 */ TransactionReportForm transForm = (TransactionReportForm) form;
            try {
                /* 521 */ transForm.getLstprint().clear();
                /* 522 */ transForm.setReportdate(new Date());
                /* 523 */ transForm.getLstprint().addAll(transForm.getLstjewel());
            } catch (Exception e) {
            }

            /* 527 */ return mapping.findForward("print");
        }
        /* 529 */ return mapping.findForward("exp");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\transactionreport\TransactionReportAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
