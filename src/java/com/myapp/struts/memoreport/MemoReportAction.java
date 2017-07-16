package com.myapp.struts.memoreport;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.BalanceDetails;
import com.myapp.struts.beans.JewelBean;
import com.myapp.struts.beans.MemoBalanceReportBean;
import com.myapp.struts.beans.YearsBean;
import com.myapp.struts.dao.ItemsDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.WorkersMemoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Items;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class MemoReportAction
        extends DispatchAction {

    public ActionForward loadReportPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  41 */ if (Constants.isSessionActive(request)) {
            /*  42 */ MemoReportForm memoReportForm = (MemoReportForm) form;

            /*  44 */ memoReportForm.getLstMemos().clear();
            /*  45 */ memoReportForm.getLstyears().clear();
            /*  46 */ int year = 2015;
            /*  47 */ memoReportForm.setYear(year + 1 + "");
            /*  48 */ for (int i = year; i < 2030; i++) {
                /*  49 */ YearsBean yr = new YearsBean();
                /*  50 */ yr.setYear(year);
                /*  51 */ yr.setYears(year + "");
                /*  52 */ memoReportForm.getLstyears().add(yr);
                /*  53 */ year++;
            }

            /*  56 */ loadTransactions(mapping, form, request, response);
            /*  57 */ return mapping.findForward("display");
        }
        /*  59 */ return mapping.findForward("exp");
    }

    public ActionForward loadTransactions(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  65 */ if (Constants.isSessionActive(request)) {
            try {
                /*  67 */ MemoReportForm memoReportForm = (MemoReportForm) form;

                /*  69 */ memoReportForm.getLstMemos().clear();

                /*  71 */ HashMap hmJewels = new OrnamentStockDAO().getJewelbyYear(memoReportForm.getYear());
                /*  72 */ HashMap hmMemos = new WorkersMemoDAO().getWorkersMemos(memoReportForm.getYear());

                /*  74 */ memoReportForm.setLstMemos(setReportList(Integer.parseInt(memoReportForm.getYear()), hmJewels, hmMemos));
            } catch (Exception e) {
                /*  77 */ e.printStackTrace();
            }

            /*  80 */ return mapping.findForward("display");
        }
        /*  82 */ return mapping.findForward("exp");
    }

    public List<MemoBalanceReportBean> setReportList(int year, HashMap hmJewels, HashMap hmMemos) {
        /*  87 */ List<MemoBalanceReportBean> lstTrans = new ArrayList();
        try {
            /*  90 */ HashMap hmItems = new ItemsDAO().getItemsMap();
            /*  91 */ Iterator it = hmMemos.entrySet().iterator();
            /*  92 */ while (it.hasNext()) {
                /*  93 */ Map.Entry pair = (Map.Entry) it.next();
                /*  94 */ int memono = Integer.parseInt(pair.getKey().toString());
                /*  95 */ List<Workersmemo> listwm = (List) pair.getValue();
                /*  96 */ if (listwm != null) {
                    /*  97 */ for (int j = 0; j < listwm.size(); j++) {
                        /*  98 */ Workersmemo memo = (Workersmemo) listwm.get(j);

                        /* 100 */ List<JewelBean> listjewel = (List) hmJewels.get(memo.getWorkermemono() + "");

                        /* 102 */ if (listjewel != null) {
                            /* 104 */ MemoBalanceReportBean bean = new MemoBalanceReportBean();

                            /* 106 */ bean.setMemono(memo.getWorkermemono());
                            /* 107 */ bean.setMemodate(memo.getDate());
                            /* 108 */ bean.setGoldweight(memo.getGoldweight());

                            /* 110 */ for (int i = 0; i < listjewel.size(); i++) {
                                /* 111 */ JewelBean jewel = (JewelBean) listjewel.get(i);

                                /* 113 */ BalanceDetails det = new BalanceDetails();

                                /* 115 */ det.setNetweight(Constants.amountRounding(jewel.getNetweight()));
                                /* 116 */ det.setGrossweight(Constants.amountRounding(jewel.getGrossweight()));
                                /* 117 */ det.setJewelDate(jewel.getDate());
                                /* 118 */ det.setJewelentryid(jewel.getOrnamentstockid());
                                /* 119 */ det.setGoldused(jewel.getTotalglodused());
                                /* 120 */ Items item = (Items) hmItems.get(jewel.getItemid() + "");
                                /* 121 */ det.setItem(item.getItem());
                                /* 122 */ bean.setTotalgrossweight(bean.getTotalgrossweight() + det.getGrossweight());
                                /* 123 */ bean.setTotalnetweight(bean.getTotalnetweight() + det.getNetweight());
                                /* 124 */ bean.getLstDetails().add(det);
                            }

                            /* 127 */ bean.setNetbalance(bean.getGoldweight() - bean.getTotalnetweight());
                            /* 128 */ bean.setGrossbalance(bean.getGoldweight() - bean.getTotalgrossweight());

                            /* 130 */ lstTrans.add(bean);
                        }
                    }
                }
            }
        } catch (Exception e) {
            /* 137 */ e.printStackTrace();
        }

        /* 140 */ return lstTrans;
    }

    public ActionForward printView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /* 294 */ if (Constants.isSessionActive(request)) {
            /* 295 */ MemoReportForm memoReportForm = (MemoReportForm) form;
            try {
                memoReportForm.getLstMemos().clear();
                memoReportForm.setLstMemos(memoReportForm.getLstMemos());
            } catch (Exception e) {
            }
            /* 334 */ return mapping.findForward("print");
        }
        /* 336 */ return mapping.findForward("exp");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\memoreport\MemoReportAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */