package com.myapp.struts.memoaccept;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.JewelBean;
import com.myapp.struts.dao.GoldStockDAO;
import com.myapp.struts.dao.ItemsDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.VouchersDAO;
import com.myapp.struts.dao.WorkersMemoDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Goldstock;
import mappings.Items;
import mappings.Ornamentstock;
import mappings.Vouchers;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class MemoAcceptAction
        extends DispatchAction {

    public ActionForward loadMemoAcceptPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  43 */ if (Constants.isSessionActive(request)) {
            /*  44 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            /*  45 */ memoForm.setLstmemos(new WorkersMemoDAO().getWorkMemo());
            /*  46 */ memoForm.setLstitems(new ItemsDAO().getItems());

            /*  48 */ memoForm.setLstvouchers(new VouchersDAO().getVouchers("Workers Memo"));
            memoForm.setReturnmsg("");
            memoForm.setJewelmsg("");
            clearJewelForm(mapping, form, request, response);
            /*  56 */ return mapping.findForward("display");
        }
        /*  58 */ return mapping.findForward("exp");
    }

    public ActionForward loadselectedMemo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  64 */ if (Constants.isSessionActive(request)) {
            /*  65 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;

            /*  67 */ Workersmemo memo = (Workersmemo) memoForm.getLstmemos().get(memoForm.getIndex());

            /*  69 */ memoForm.setMemono(memo.getWorkermemono() + "");
            /*  70 */ memoForm.setMemodate(memo.getDate());
            /*  71 */ memoForm.setMemoid(memo.getWorkersmemoid());
            /*  72 */ memoForm.setMemogweight(memo.getGoldweight());
            /*  73 */ memoForm.setMemosweight(memo.getSilverweight() == null ? 0.0D : memo.getSilverweight());
            /*  74 */ memoForm.setMemostweight(memo.getStoneweight() == null ? 0.0D : memo.getStoneweight());
            /*  75 */ memoForm.setMemodweight(memo.getDiamondweight() == null ? 0.0D : memo.getDiamondweight());
            memoForm.setMemoemp(memo.getEmployee());
            /*  76 */ memoForm.setReturnmsg("");
            memoForm.setJewelmsg("");
            /*  78 */ double usedWeight = new OrnamentStockDAO().getTotalGoldUsed(memo.getWorkermemono() + "");
            /*  79 */ double weightbalance = memo.getGoldweight() - usedWeight;
            /*  80 */ memoForm.setUsedWeight(usedWeight);
            /*  81 */ memoForm.setMemobalance(weightbalance);
            /*  82 */ if (weightbalance == 0.0D) {
                /*  83 */ memoForm.setJewelmsg("Issued gold is already returned completely.");
            }
            memoForm.setIndex(-1);
            /*  87 */ return mapping.findForward("display");
        }
        /*  89 */ return mapping.findForward("exp");
    }

    public ActionForward clearReturn(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  95 */ if (Constants.isSessionActive(request)) {
            /*  96 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;

            /*  98 */ memoForm.setReturnweight(0.0D);
            /*  99 */ memoForm.setIndex(-1);
            /* 100 */ memoForm.setReturndate(null);
            memoForm.setReturnmsg("");

            /* 102 */ return mapping.findForward("display");
        }
        /* 104 */ return mapping.findForward("exp");
    }

    public ActionForward saveStockReturn(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 110 */ if (Constants.isSessionActive(request)) {
            /* 111 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            try {
                /* 113 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                /* 115 */ if (memoForm.getMemono().equals("")) {
                    /* 116 */ memoForm.setReturnmsg("Select Workers Memo from the list.");
                    /* 117 */ return mapping.findForward("display");
                }
                /* 119 */ Vouchers vouchers = new Vouchers();
                /* 120 */ vouchers.setVouchertype("Workers Memo");

                /* 122 */ vouchers.setVouchercategory(memoForm.getCategory());
                /* 123 */ vouchers.setVoucherno(memoForm.getMemono());
                /* 124 */ vouchers.setVoucherdate(sdf.parse(memoForm.getReturndate()));
                /* 125 */ vouchers.setWeight(memoForm.getReturnweight());
                /* 126 */ vouchers.setAmount("");
                /* 127 */ vouchers.setRemarks("");
                /* 128 */ vouchers.setCreateddate(new Date());
                /* 129 */ vouchers.setUpdateddate(new Date());

                /* 131 */ int voucherid = new VouchersDAO().saveVoucher(vouchers, false);

                /* 133 */ Goldstock goldstock = new Goldstock();
                /* 134 */ goldstock.setCreateddate(new Date());

                /* 136 */ goldstock.setPrice(0.0D);

                /* 138 */ goldstock.setRefernceid(voucherid);
                /* 139 */ goldstock.setRefernceno(Integer.parseInt(memoForm.getMemono()));
                /* 140 */ goldstock.setRemarks("");
                /* 141 */ goldstock.setType(memoForm.getCategory());
                /* 142 */ goldstock.setUpdateddate(new Date());
                /* 143 */ goldstock.setWeight(memoForm.getReturnweight());
                /* 144 */ goldstock.setVouchertype("Workers Memo");
                /* 145 */ goldstock.setVoucherdate(sdf.parse(memoForm.getReturndate()));

                /* 147 */ new GoldStockDAO().saveGoldStock(goldstock, false);

                loadMemoAcceptPage(mapping, form, request, response);
                memoForm.setReturnmsg("Saved successfully.");
                /* 150 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /* 153 */ memoForm.setReturnmsg("Error while saving.");
                /* 154 */ return mapping.findForward("error");
            }
        }
        /* 157 */ return mapping.findForward("exp");
    }

    public ActionForward deleteStockReturn(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 163 */ if (Constants.isSessionActive(request)) {
            /* 164 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            try {
                /* 166 */ int voucherid = memoForm.getIndex();
                /* 167 */ new VouchersDAO().cancelVoucher(voucherid);
                /* 168 */ new GoldStockDAO().updateStock(voucherid);
                /* 169 */ memoForm.setIndex(-1);
                /* 170 */ memoForm.setLstvouchers(new VouchersDAO().getVouchers("Workers Memo"));
                /* 171 */ memoForm.setReturnmsg("Deleted successfully.");

                /* 173 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /* 176 */ memoForm.setReturnmsg("Error while saving.");
                /* 177 */ return mapping.findForward("error");
            }
        }
        /* 180 */ return mapping.findForward("exp");
    }

    public ActionForward clearJewelForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 186 */ if (Constants.isSessionActive(request)) {
            /* 187 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            /*  50 */ memoForm.setMemono("");
            /*  51 */ memoForm.setMemodate(null);
            /*  52 */ memoForm.setMemoid(0);
            /*  53 */ memoForm.setReturnweight(0.0D);
            /*  54 */ memoForm.setCategory("");
            memoForm.setAction("");
            /*  55 */// memoForm.setReturnmsg("");
            // memoForm.setJewelmsg("");
            memoForm.setItemid(0);
            memoForm.setItem("");
            memoForm.setUsedWeight(0);
            memoForm.setMemoemp("");
            memoForm.setMemogweight(0);
            memoForm.setMemobalance(0);

            /* 189 */ memoForm.setJeweldate(null);
            /* 191 */ memoForm.setGoldweight(0.0D);
            /* 192 */ memoForm.setStonetype("American Diamond");
            /* 193 */ memoForm.setStonesweight(0.0D);
            /* 194 */ memoForm.setGrossweight(0.0D);
            /* 195 */ memoForm.setNetweight(0.0D);
            /* 196 */ memoForm.setWastage(0.0D);
            /* 197 */ memoForm.setTotalgoldused(0.0D);
            /* 198 */ memoForm.setDescription("");
            memoForm.setOrnamentstockno("");

            /* 201 */ memoForm.setIndex(-1);
            /* 202 */ return mapping.findForward("display");
        }
        /* 204 */ return mapping.findForward("exp");
    }

    public ActionForward calulateWeight(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 210 */ if (Constants.isSessionActive(request)) {
            /* 211 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            /* 212 */ double netWeight = memoForm.getGrossweight() - (memoForm.getStonesweight());

            /* 214 */ memoForm.setNetweight(Constants.amountRounding(netWeight));
            /* 215 */ memoForm.setGoldweight(memoForm.getGrossweight());

            /* 217 */ double totalgoldused = memoForm.getNetweight() + memoForm.getWastage();
            /* 218 */ memoForm.setTotalgoldused(Constants.amountRounding(totalgoldused));
            /* 219 */ return mapping.findForward("display");
        }
        /* 221 */ return mapping.findForward("exp");
    }

    public ActionForward setItem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 227 */ if (Constants.isSessionActive(request)) {
            /* 228 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            /* 229 */ memoForm.getLstentry().clear();
            /* 230 */ memoForm.getLstentry().addAll(loadJewelEntry(memoForm.getMemoid(), memoForm.getItemid()));
            memoForm.setJewelmsg("");
            /* 231 */ return mapping.findForward("display");
        }
        /* 233 */ return mapping.findForward("exp");
    }

    public List<JewelBean> loadJewelEntry(int memoid, int itemid) {
        /* 238 */ List<JewelBean> lstentry = new ArrayList();
        try {
            /* 241 */ List<JewelBean> lstornaments = new OrnamentStockDAO().getOrnamentsStockbymemo(memoid, itemid);

            /* 245 */ for (int i = 0; i < lstornaments.size(); i++) {
                /* 246 */ JewelBean bean = new JewelBean();
                /* 247 */ JewelBean ornamentstock = (JewelBean) lstornaments.get(i);

                /* 250 */ bean.setDate(ornamentstock.getDate());
                /* 251 */ bean.setDescription(ornamentstock.getDescription());
                /* 253 */ bean.setGoldweight(ornamentstock.getGoldweight());
                /* 254 */ bean.setGrossweight(ornamentstock.getGrossweight());
                /* 255 */ bean.setInsertdate(ornamentstock.getInsertdate());
                /* 256 */ bean.setItemid(ornamentstock.getItemid());
                /* 257 */ bean.setJewelentryid(ornamentstock.getJewelentryid());
                /* 258 */ bean.setMemono(ornamentstock.getMemono());
                /* 259 */ bean.setMemoid(ornamentstock.getMemoid());
                /* 260 */ bean.setNetweight(ornamentstock.getNetweight());
                /* 261 */ bean.setOrnamentstockid(ornamentstock.getOrnamentstockid());
                /* 262 */ bean.setOrnamentstockno(ornamentstock.getOrnamentstockno());
                /* 263 */ bean.setRevgrossweight(ornamentstock.getRevgrossweight());
                /* 264 */ bean.setRevnetweight(ornamentstock.getRevnetweight());
                /* 265 */ bean.setRevtotalglodused(ornamentstock.getRevtotalglodused());
                /* 266 */ bean.setRevwastage(ornamentstock.getRevwastage());
                /* 267 */ bean.setStonetype(ornamentstock.getStonetype());
                /* 268 */ bean.setSold(ornamentstock.isSold());
                /* 269 */ bean.setStoneweight(ornamentstock.getStoneweight());
                /* 270 */ bean.setTotalglodused(ornamentstock.getTotalglodused());
                /* 271 */ bean.setWastage(ornamentstock.getWastage());
                /* 272 */ lstentry.add(bean);
            }

        } catch (Exception ex) {
            /* 278 */ Logger.getLogger(MemoAcceptAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* 280 */ return lstentry;
    }

    public ActionForward saveJewels(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /* 285 */ if (Constants.isSessionActive(request)) {
            /* 286 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            try {


                /* 288 */ if (memoForm.getMemoid() != 0) {

                    if (memoForm.getNetweight() > memoForm.getMemobalance()) {
                        /* 291 */ memoForm.setJewelmsg("Gold balance is less than " + memoForm.getMemobalance());
                        /* 292 */ return mapping.findForward("display");
                    }

                    /* 290 */ if (memoForm.getMemobalance() == 0.0D) {
                        /* 291 */ memoForm.setJewelmsg("Issued gold already returned completely.");
                        /* 292 */ return mapping.findForward("display");
                    }
                    /* 294 */ if (memoForm.getItemid() == 0) {
                        /* 295 */ memoForm.setJewelmsg("Please select Item");
                        /* 296 */ return mapping.findForward("display");
                    }
                    /* 298 */ if (memoForm.getGrossweight() == 0.0D) {
                        /* 299 */ memoForm.setJewelmsg("Please enter gross weight");
                        /* 300 */ return mapping.findForward("display");
                    }
                    /* 302 */ if (memoForm.getJeweldate().equals("")) {
                        /* 303 */ memoForm.setJewelmsg("Please enter Date");
                        /* 304 */ return mapping.findForward("display");
                    }
                    /* 306 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//                    /* 308 */ Jewelentry jewel = new Jewelentry();
//                    /* 310 */ jewel.setDate(sdf.parse(memoForm.getJeweldate()));
//                    /* 312 */ jewel.setGrossweight(memoForm.getGrossweight());
//                    /* 313 */ jewel.setInsertdate(new Date());
//                    /* 314 */ jewel.setNetweight(memoForm.getNetweight());
//                    /* 315 */ jewel.setStonetype(memoForm.getStonetype());
//                    /* 316 */ jewel.setStoneweight(memoForm.getStonesweight());
//                    /* 317 */ jewel.setTotalglodused(memoForm.getTotalgoldused());
//                    /* 318 */ jewel.setWastage(memoForm.getWastage());
//                    /* 319 */ jewel.setWorkermemoid(memoForm.getMemoid());
//                    /* 320 */ jewel.setWorkermemono(memoForm.getMemono());
//                    /* 321 */ jewel.setDescription(memoForm.getDescription());
//                    /* 322 */ jewel.setItemid(memoForm.getItemid());
//                    if (memoForm.getAction().equals("edit")) {
//                        jewel.setJewelentryid(memoForm.getJewelid());
//                        new JewelEntryDAO().saveJewel(jewel, true);
//                    } else {
//                        /* 324 */ new JewelEntryDAO().saveJewel(jewel, false);
//                    }
                    /* 326 */ Ornamentstock stock = new Ornamentstock();

                    /* 329 */ stock.setGrossweight(memoForm.getGrossweight());
                    /* 330 */ stock.setInsertdate(sdf.parse(memoForm.getJeweldate()));
                    /* 331 */ stock.setNetweight(memoForm.getNetweight());
                    /* 332 */ stock.setStonetype(memoForm.getStonetype());
                    /* 333 */ stock.setStoneweight(memoForm.getStonesweight());
                    /* 334 */ stock.setTotalglodused(memoForm.getTotalgoldused());
                    /* 335 */ stock.setWastage(memoForm.getWastage());
                    /* 336 */ stock.setMemoid(memoForm.getMemoid());
                    /* 337 */ stock.setMemono(memoForm.getMemono());
                    /* 338 */ stock.setDescription(memoForm.getDescription());
                    /* 339 */ stock.setItemid(memoForm.getItemid());
                    /* 340 */ stock.setRevgrossweight(0.0D);
                    /* 341 */ stock.setRevnetweight(0.0D);
                    /* 342 */ stock.setRevtotalglodused(0.0D);
                    /* 343 */ stock.setRevwastage(0.0D);
                    if (memoForm.getAction().equals("edit")) {
                        //edit
                        memoForm.setOrnamentstockno(memoForm.getOrnamentstockno().replaceAll("[A-Z]", ""));
                        stock.setOrnamentstockno(memoForm.getOrnamentstockno());
                        stock.setOrnamentstockid(memoForm.getOrnamentid());
                        new OrnamentStockDAO().saveOrnamentStock(stock, true);
                        memoForm.setAction("");
                    } else {
                        stock.setOrnamentstockno(new OrnamentStockDAO().getNextStockno(memoForm.getItemid()) + "");
                        new OrnamentStockDAO().saveOrnamentStock(stock, false);
                    }
                    /* 347 */ memoForm.setJewelmsg("Saved successfully.");
                    /* 349 */ memoForm.getLstentry().clear();

                    /* 350 */ memoForm.getLstentry().addAll(loadJewelEntry(memoForm.getMemoid(), memoForm.getItemid()));
                    /* 348 */ clearJewelForm(mapping, form, request, response);

                    /* 351 */ return mapping.findForward("display");
                }
                /* 353 */ memoForm.setJewelmsg("Worker memo not selected.");
                /* 354 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /* 357 */ memoForm.setJewelmsg("Error while saving.");
                /* 358 */ return mapping.findForward("error");
            }
        }
        /* 361 */ return mapping.findForward("exp");
    }

    public ActionForward deleteJewels(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 367 */ if (Constants.isSessionActive(request)) {
            /* 368 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            try {
                /* 370 */ int jewelentryid = memoForm.getIndex();

                /* 373 */ for (int i = 0; i < memoForm.getLstentry().size(); i++) {
                    /* 374 */ JewelBean jewelBean = (JewelBean) memoForm.getLstentry().get(i);
                    /* 375 */ if (jewelBean.getJewelentryid() == jewelentryid) {
                        /* 376 */ new OrnamentStockDAO().deleteStock(jewelBean.getOrnamentstockid());
                        /* 377 */ break;
                    }
                }
                /* 380 */ memoForm.setJewelmsg("Deleted successfully.");
                /* 381 */ memoForm.getLstentry().clear();
                /* 382 */ memoForm.getLstentry().addAll(loadJewelEntry(memoForm.getMemoid(), memoForm.getItemid()));
                /* 383 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /* 386 */ memoForm.setJewelmsg("Error while deleting.");
                /* 387 */ return mapping.findForward("error");
            }
        }
        /* 390 */ return mapping.findForward("exp");
    }

    public ActionForward editJewelsEntry(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 367 */ if (Constants.isSessionActive(request)) {
            /* 368 */ MemoAcceptForm memoForm = (MemoAcceptForm) form;
            try {
                JewelBean get = (JewelBean) memoForm.getLstentry().get(memoForm.getIndex());
                memoForm.setAction("edit");

                memoForm.setMemono(get.getMemono());

                /*  67 */ Workersmemo memo = new WorkersMemoDAO().getWorkMemo(Integer.parseInt(memoForm.getMemono()));
                /*  69 */ memoForm.setMemono(memo.getWorkermemono() + "");
                /*  70 */ memoForm.setMemodate(memo.getDate());
                /*  71 */ memoForm.setMemoid(memo.getWorkersmemoid());
                /*  72 */ memoForm.setMemogweight(memo.getGoldweight());
                /*  73 */ memoForm.setMemosweight(memo.getSilverweight() == null ? 0.0D : memo.getSilverweight());
                /*  74 */ memoForm.setMemostweight(memo.getStoneweight() == null ? 0.0D : memo.getStoneweight());
                /*  75 */ memoForm.setMemodweight(memo.getDiamondweight() == null ? 0.0D : memo.getDiamondweight());
                memoForm.setMemoemp(memo.getEmployee());
                /*  76 */ memoForm.setReturnmsg("");

                /*  78 */ double usedWeight = new OrnamentStockDAO().getTotalGoldUsed(memo.getWorkermemono() + "");
                /*  79 */ double weightbalance = memo.getGoldweight() - usedWeight;
                /*  80 */ memoForm.setUsedWeight(usedWeight);
                /*  81 */ memoForm.setMemobalance(weightbalance);

                memoForm.setItemid(get.getItemid());
                Items item = new ItemsDAO().getItem(memoForm.getItemid());
                memoForm.setItem(item.getItem());

                memoForm.setDescription(get.getDescription());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                memoForm.setJeweldate(sdf.format(get.getDate()));
                memoForm.setGrossweight(get.getGrossweight());
                memoForm.setStonetype(get.getStonetype());
                memoForm.setStonesweight(get.getStoneweight());
                memoForm.setNetweight(get.getNetweight());
                memoForm.setWastage(get.getWastage());
                memoForm.setTotalgoldused(get.getTotalglodused());
                memoForm.setOrnamentstockno(get.getOrnamentstockno());
                memoForm.setOrnamentid(get.getOrnamentstockid());
                memoForm.setJewelid(get.getJewelentryid());
                /* 383 */ return mapping.findForward("display");

            } catch (Exception ex) {
                /* 386 */ memoForm.setJewelmsg("Error while loading data.");
                /* 387 */ return mapping.findForward("error");
            }
        }
        /* 390 */ return mapping.findForward("exp");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\memoaccept\MemoAcceptAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
