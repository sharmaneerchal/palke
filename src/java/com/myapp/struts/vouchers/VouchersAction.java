package com.myapp.struts.vouchers;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.VoucherBean;
import com.myapp.struts.dao.GoldStockDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.VouchersDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Goldstock;
import mappings.Vouchers;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class VouchersAction
        extends DispatchAction {

    /*  32 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public ActionForward loadVouchersPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  37 */ if (Constants.isSessionActive(request)) {
            /*  39 */ VouchersForm voucherForm = (VouchersForm) form;

            /*  41 */ if ((voucherForm.getVoucherid() != 0) && (voucherForm.getIndex() != 1)) {
                /*  43 */ List<Vouchers> lstVouchers = new VouchersDAO().getVouchers(voucherForm.getVoucherid());
                /*  44 */ voucherForm.getLstVouchers().clear();
                /*  45 */ for (int i = 0; i < lstVouchers.size(); i++) {
                    /*  46 */ Vouchers vouchers = (Vouchers) lstVouchers.get(i);

                    /*  48 */ VoucherBean bean = new VoucherBean();
                    /*  49 */ bean.setVoucherno(vouchers.getVoucherno());
                    /*  50 */ bean.setVoucherdate(this.sdf.format(vouchers.getVoucherdate()));
                    /*  51 */ bean.setWeight(vouchers.getWeight());
                    /*  52 */ bean.setOldweight(vouchers.getWeight());
                    /*  53 */ bean.setAmount(vouchers.getAmount() + "");
                    /*  54 */ bean.setRemarks(vouchers.getRemarks());
                    /*  55 */ bean.setVouchertype(vouchers.getVouchertype());
                    /*  56 */ bean.setCategory(vouchers.getVouchercategory());
                    /*  57 */ bean.setVoucherid(vouchers.getVoucherid());
                    /*  58 */ voucherForm.getLstVouchers().add(bean);
                }
                /*  60 */ voucherForm.setIndex(-1);
                /*  61 */ voucherForm.setPtranstype("add");
                /*  62 */ voucherForm.setRtranstype("add");
                /*  63 */ voucherForm.setMessage("");
            } else {
                /*  66 */ voucherForm.setIndex(-1);
                /*  67 */ voucherForm.setPtranstype("add");
                /*  68 */ voucherForm.setRtranstype("add");
                /*  69 */ voucherForm.getLstVouchers().clear();
                /*  70 */ voucherForm.setVouchertype("Purchase Voucher");
                /*  71 */ voucherForm.setVoucherid(0);
                /*  72 */ voucherForm.setMessage("");
                /*  73 */ voucherForm.getLstVouchers().clear();
                /*  74 */ voucherForm.getLstVoucherslst().clear();
                /*  75 */ voucherForm.setPvoucherdate(this.sdf.format(new Date()));
                /*  76 */ voucherForm.setRvoucherdate(this.sdf.format(new Date()));
            }
            /*  78 */ return mapping.findForward("display");
        }
        /*  80 */ return mapping.findForward("exp");
    }

    public ActionForward loadVoucherListPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  86 */ if (Constants.isSessionActive(request)) {
            /*  87 */ VouchersForm voucherForm = (VouchersForm) form;

            /*  89 */ voucherForm.setVouchertype("");
            /*  90 */ voucherForm.getLstVoucherslst().clear();
            /*  91 */ voucherForm.setMessage("");
            /*  92 */ voucherForm.setMessage("");
            /*  93 */ voucherForm.setVoucherid(0);

            /*  95 */ return mapping.findForward("display");
        }
        /*  97 */ return mapping.findForward("exp");
    }

    public ActionForward loadVouchers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 103 */ if (Constants.isSessionActive(request)) {
            /* 104 */ VouchersForm voucherForm = (VouchersForm) form;

            voucherForm.setMessage("Vouchers loaded.");
            /* 106 */ List<Vouchers> lstvouchers = new VouchersDAO().getVouchers(voucherForm.getVouchertype());
            /* 108 */ voucherForm.getLstVouchers().clear();

            /* 110 */ for (int i = 0; i < lstvouchers.size(); i++) {
                /* 111 */ Vouchers vouchers = (Vouchers) lstvouchers.get(i);

                /* 113 */ VoucherBean bean = new VoucherBean();
                /* 114 */ bean.setVoucherno(vouchers.getVoucherno());
                /* 115 */ bean.setVoucherdate(this.sdf.format(vouchers.getVoucherdate()));
                /* 116 */ bean.setWeight(vouchers.getWeight());
                /* 117 */ bean.setOldweight(vouchers.getWeight());
                /* 118 */ bean.setAmount(vouchers.getAmount() + "");
                /* 119 */ bean.setRemarks(vouchers.getRemarks());
                /* 120 */ bean.setVouchertype(vouchers.getVouchertype());
                /* 121 */ bean.setCategory(vouchers.getVouchercategory());
                /* 122 */ bean.setVoucherid(vouchers.getVoucherid());
                /* 123 */ voucherForm.getLstVouchers().add(bean);
            }

            /* 126 */ return mapping.findForward("display");
        }
        /* 128 */ return mapping.findForward("exp");
    }

    public ActionForward editVoucher(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 277 */ if (Constants.isSessionActive(request)) {
            /* 279 */ VouchersForm voucherForm = (VouchersForm) form;

            /* 281 */ VoucherBean bean = (VoucherBean) voucherForm.getLstVouchers().get(voucherForm.getIndex());

            /* 283 */ if (bean.getVouchertype().equals("Purchase Voucher")) {
                /* 284 */ if (voucherForm.getRtranstype().equals("update")) {
                    /* 285 */ voucherForm.setMessage("Receipt Voucer is in edit.");
                } else {
                    /* 287 */ voucherForm.setPvoucherno(bean.getVoucherno());
                    /* 288 */ voucherForm.setVoucherid(bean.getVoucherid());
                    /* 289 */ voucherForm.setPvoucherdate(bean.getVoucherdate());
                    /* 290 */ voucherForm.setPweight(bean.getWeight());
                    /* 291 */ voucherForm.setPamount(bean.getAmount());
                    /* 292 */ voucherForm.setPoldweight(bean.getWeight());
                    /* 293 */ voucherForm.setPremarks(bean.getRemarks());
                    /* 294 */ voucherForm.setVouchertype(bean.getVouchertype());
                    /* 295 */ voucherForm.setCategory(bean.getCategory());
                    /* 296 */ voucherForm.setPtranstype("update");
                    /* 297 */ voucherForm.setIndex(voucherForm.getIndex());
                }
                /* 299 */            } else if (bean.getVouchertype().equals("Receipt Voucher")) {
                /* 300 */ if (voucherForm.getPtranstype().equals("update")) {
                    /* 301 */ voucherForm.setMessage("Purchase Voucer is in edit.");
                } else {
                    /* 303 */ voucherForm.setRvoucherno(bean.getVoucherno());
                    /* 304 */ voucherForm.setVoucherid(bean.getVoucherid());
                    /* 305 */ voucherForm.setRvoucherdate(bean.getVoucherdate());
                    /* 306 */ voucherForm.setRweight(bean.getWeight());
                    /* 307 */ voucherForm.setRamount(bean.getAmount());
                    /* 308 */ voucherForm.setRoldweight(bean.getWeight());
                    /* 309 */ voucherForm.setRremarks(bean.getRemarks());
                    /* 310 */ voucherForm.setVouchertype(bean.getVouchertype());
                    /* 311 */ voucherForm.setCategory(bean.getCategory());
                    /* 312 */ voucherForm.setRtranstype("update");
                    /* 313 */ voucherForm.setIndex(voucherForm.getIndex());
                }
            }
            /* 316 */ return mapping.findForward("display");
        }
        /* 318 */ return mapping.findForward("exp");
    }

    public ActionForward cancelVocuher(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 324 */ if (Constants.isSessionActive(request)) {
            /* 326 */ VouchersForm voucherForm = (VouchersForm) form;
            /* 327 */ voucherForm.setIndex(-1);
            /* 328 */ voucherForm.setPvoucherno("");
            /* 329 */ voucherForm.setPvoucherdate("");
            /* 330 */ voucherForm.setPweight(0.0D);
            /* 331 */ voucherForm.setPamount("");

            /* 333 */ voucherForm.setPremarks("");
            /* 334 */ voucherForm.setVouchertype("");
            /* 335 */ voucherForm.setCategory("");
            /* 336 */ voucherForm.setPtranstype("add");
            /* 337 */ voucherForm.setVoucherid(0);

            /* 339 */ voucherForm.setRvoucherno("");
            /* 340 */ voucherForm.setRvoucherdate("");
            /* 341 */ voucherForm.setRweight(0.0D);
            /* 342 */ voucherForm.setRamount("");
            /* 343 */ voucherForm.setRremarks("");
            /* 344 */ voucherForm.setRtranstype("add");

            /* 346 */ return mapping.findForward("display");
        }
        /* 348 */ return mapping.findForward("exp");
    }

    public ActionForward saveVouchers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 367 */ if (Constants.isSessionActive(request)) {
            /* 369 */ VouchersForm voucherForm = (VouchersForm) form;
            /* 370 */ VoucherBean bean = new VoucherBean();
            try {
                /* 373 */ if (voucherForm.getVouchertype().equals("Purchase Voucher")) {
                    /* 375 */ if (voucherForm.getCategory().equals("Copper")) {
                        /* 376 */ if (voucherForm.getVouchertype().equals("")) {
                            /* 377 */ voucherForm.setMessage("Voucher Type not found.");
                            /* 378 */ return mapping.findForward("display");
                        }
                        /* 379 */ if (voucherForm.getCategory().equals("")) {
                            /* 380 */ voucherForm.setMessage("Pick Voucher Category.");
                            /* 381 */ return mapping.findForward("display");
                        }
                        /* 382 */ if (voucherForm.getPvoucherdate().equals("")) {
                            /* 383 */ voucherForm.setMessage("Please enter Vocher Date");
                            /* 384 */ return mapping.findForward("display");
                        }
                        /* 385 */ if (voucherForm.getPweight() == 0.0D) {
                            /* 386 */ voucherForm.setMessage("Please enter weight.");
                            /* 387 */ return mapping.findForward("display");
                        }
                    } else {
                        /* 390 */ if (voucherForm.getVouchertype().equals("")) {
                            /* 391 */ voucherForm.setMessage("Voucher Type not found.");
                            /* 392 */ return mapping.findForward("display");
                        }
                        /* 393 */ if (voucherForm.getCategory().equals("")) {
                            /* 394 */ voucherForm.setMessage("Pick Voucher Category.");
                            /* 395 */ return mapping.findForward("display");
                        }
                        /* 396 */ if (voucherForm.getPvoucherno().equals("")) {
                            /* 397 */ voucherForm.setMessage("Please enter Vocher No.");
                            /* 398 */ return mapping.findForward("display");
                        }
                        /* 399 */ if (voucherForm.getPvoucherdate().equals("")) {
                            /* 400 */ voucherForm.setMessage("Please enter Vocher Date");
                            /* 401 */ return mapping.findForward("display");
                        }
                        /* 402 */ if (voucherForm.getPweight() == 0.0D) {
                            /* 403 */ voucherForm.setMessage("Please enter weight.");
                            /* 404 */ return mapping.findForward("display");
                        }
                        /* 405 */ if (voucherForm.getPamount().equals("")) {
                            /* 406 */ voucherForm.setMessage("Please enter amount.");
                            /* 407 */ return mapping.findForward("display");
                        }
                    }
                    /* 410 */ bean.setVoucherno(voucherForm.getPvoucherno());
                    /* 411 */ bean.setVoucherid(voucherForm.getVoucherid());
                    /* 412 */ bean.setVoucherdate(voucherForm.getPvoucherdate());
                    /* 413 */ bean.setWeight(voucherForm.getPweight());
                    /* 414 */ bean.setOldweight(voucherForm.getPoldweight());
                    /* 415 */ bean.setAmount(voucherForm.getPamount());
                    /* 416 */ bean.setRemarks(voucherForm.getPremarks());
                    /* 417 */ bean.setVouchertype(voucherForm.getVouchertype());
                    /* 418 */ bean.setCategory(voucherForm.getCategory());
                } /* 420 */ else if (voucherForm.getVouchertype().equals("Receipt Voucher")) {
                    /* 422 */ if (voucherForm.getCategory().equals("Copper")) {
                        /* 423 */ if (voucherForm.getVouchertype().equals("")) {
                            /* 424 */ voucherForm.setMessage("Voucher Type not found.");
                            /* 425 */ return mapping.findForward("display");
                        }
                        /* 426 */ if (voucherForm.getCategory().equals("")) {
                            /* 427 */ voucherForm.setMessage("Pick Voucher Category.");
                            /* 428 */ return mapping.findForward("display");
                        }
                        /* 429 */ if (voucherForm.getRvoucherdate().equals("")) {
                            /* 430 */ voucherForm.setMessage("Please enter Vocher Date");
                            /* 431 */ return mapping.findForward("display");
                        }
                        /* 432 */ if (voucherForm.getRweight() == 0.0D) {
                            /* 433 */ voucherForm.setMessage("Please enter weight.");
                            /* 434 */ return mapping.findForward("display");
                        }
                    } else {
                        /* 437 */ if (voucherForm.getVouchertype().equals("")) {
                            /* 438 */ voucherForm.setMessage("Voucher Type not found.");
                            /* 439 */ return mapping.findForward("display");
                        }
                        /* 440 */ if (voucherForm.getCategory().equals("")) {
                            /* 441 */ voucherForm.setMessage("Pick Voucher Category.");
                            /* 442 */ return mapping.findForward("display");
                        }
                        /* 443 */ if (voucherForm.getRvoucherno().equals("")) {
                            /* 444 */ voucherForm.setMessage("Please enter Vocher No.");
                            /* 445 */ return mapping.findForward("display");
                        }
                        /* 446 */ if (voucherForm.getRvoucherdate().equals("")) {
                            /* 447 */ voucherForm.setMessage("Please enter Vocher Date");
                            /* 448 */ return mapping.findForward("display");
                        }
                        /* 449 */ if (voucherForm.getRweight() == 0.0D) {
                            /* 450 */ voucherForm.setMessage("Please enter weight.");
                            /* 451 */ return mapping.findForward("display");
                        }
                    }

                    /* 455 */ bean.setVoucherno(voucherForm.getRvoucherno());
                    /* 456 */ bean.setVoucherid(voucherForm.getVoucherid());
                    /* 457 */ bean.setVoucherdate(voucherForm.getRvoucherdate());
                    /* 458 */ bean.setWeight(voucherForm.getRweight());
                    /* 459 */ bean.setOldweight(voucherForm.getRoldweight());
                    /* 460 */ bean.setAmount("");
                    /* 461 */ bean.setRemarks(voucherForm.getRremarks());
                    /* 462 */ bean.setVouchertype(voucherForm.getVouchertype());
                    /* 463 */ bean.setCategory(voucherForm.getCategory());
                }

                /* 467 */ if (voucherForm.getTranstype().equals("add")) {
                    /* 469 */ Vouchers vouchers = new Vouchers();
                    /* 470 */ vouchers.setVouchertype(bean.getVouchertype());
                    /* 471 */ vouchers.setVouchercategory(bean.getCategory());
                    /* 472 */ vouchers.setVoucherno(bean.getVoucherno());
                    /* 473 */ SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    /* 474 */ vouchers.setVoucherdate(sdf1.parse(bean.getVoucherdate()));
                    /* 475 */ vouchers.setWeight(bean.getWeight());

                    /* 477 */ if ((bean.getAmount() != null) && (!bean.getAmount().equals(""))) {
                        /* 478 */ vouchers.setAmount(bean.getAmount());
                    }
                    /* 480 */ if ((bean.getRemarks() != null) && (!bean.getRemarks().equals(""))) {
                        /* 481 */ vouchers.setRemarks(bean.getRemarks());
                    }

                    /* 484 */ vouchers.setCreateddate(new Date());
                    /* 485 */ vouchers.setUpdateddate(new Date());

                    /* 487 */ int voucherid = new VouchersDAO().saveVoucher(vouchers, false);

                    /* 489 */ Goldstock goldstock = new Goldstock();
                    /* 490 */ goldstock.setCreateddate(new Date());
                    /* 491 */ if ((bean.getAmount() != null) && (!bean.getAmount().equals(""))) {
                        /* 492 */ goldstock.setPrice(Double.parseDouble(bean.getAmount()));
                    }
                    goldstock.setRefernceid(voucherid);
                    goldstock.setRefernceno((bean.getVoucherno().equals("")) || (bean.getVoucherno() == null) ? 0 : Integer.parseInt(bean.getVoucherno()));
                    goldstock.setRemarks(bean.getRemarks());
                    goldstock.setType(bean.getCategory());
                    goldstock.setUpdateddate(new Date());
                    goldstock.setWeight(bean.getWeight());
                    goldstock.setVouchertype(bean.getVouchertype());
                    goldstock.setVoucherdate(sdf1.parse(bean.getVoucherdate()));
                    goldstock.setRemarks("");
                    new GoldStockDAO().saveGoldStock(goldstock, false);
                } else {
                    /* 506 */ voucherForm.getLstVouchers().set(voucherForm.getIndex(), bean);

                    /* 508 */ Vouchers vouchers = new Vouchers();
                    /* 509 */ vouchers.setVouchertype(bean.getVouchertype());
                    /* 510 */ vouchers.setVouchercategory(bean.getCategory());
                    /* 511 */ vouchers.setVoucherno(bean.getVoucherno());
                    /* 512 */ SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

                    /* 514 */ vouchers.setVoucherdate(sdf1.parse(bean.getVoucherdate()));
                    /* 515 */ vouchers.setWeight(bean.getWeight());
                    /* 516 */ if ((bean.getAmount() != null) && (!bean.getAmount().equals(""))) {
                        /* 517 */ vouchers.setAmount(bean.getAmount());
                    }
                    /* 519 */ if ((bean.getRemarks() != null) && (!bean.getRemarks().equals(""))) {
                        /* 520 */ vouchers.setRemarks(bean.getRemarks());
                    }
                    /* 522 */ vouchers.setVoucherid(bean.getVoucherid());
                    /* 523 */ vouchers.setUpdateddate(new Date());

                    /* 525 */ int voucherid = vouchers.getVoucherid();
                    /* 526 */ new VouchersDAO().saveVoucher(vouchers, true);

                    /* 528 */ int stockid = new GoldStockDAO().getStockid(voucherid);

                    /* 530 */ Goldstock goldstock = new Goldstock();
                    /* 531 */ if ((bean.getAmount() != null) && (!bean.getAmount().equals(""))) {
                        /* 532 */ goldstock.setPrice(Double.parseDouble(bean.getAmount()));
                    }
                    /* 534 */ goldstock.setGoldstockid(stockid);
                    /* 535 */ goldstock.setRefernceid(voucherid);
                    /* 536 */ goldstock.setRefernceno(Integer.parseInt(bean.getVoucherno()));
                    /* 537 */ goldstock.setRemarks(bean.getRemarks());
                    /* 538 */ goldstock.setType(bean.getCategory());
                    /* 539 */ goldstock.setUpdateddate(new Date());
                    /* 540 */ goldstock.setWeight(bean.getWeight());
                    /* 541 */ goldstock.setVoucherdate(sdf1.parse(bean.getVoucherdate()));
                    /* 542 */ goldstock.setVouchertype(bean.getVouchertype());

                    /* 544 */ new GoldStockDAO().saveGoldStock(goldstock, true);
                }
                /* 546 */ voucherForm.setRtranstype("add");
                /* 547 */ voucherForm.setCategory("");
                /* 548 */ voucherForm.setRvoucherdate("");
                /* 549 */ voucherForm.setRvoucherno("");
                /* 550 */ voucherForm.setRweight(0.0D);
                /* 551 */ voucherForm.setRamount("");
                /* 552 */ voucherForm.setRremarks("");
                /* 553 */ voucherForm.setMessage("");

                /* 555 */ voucherForm.setPtranstype("add");
                /* 556 */ voucherForm.setPvoucherdate("");
                /* 557 */ voucherForm.setPvoucherno("");
                /* 558 */ voucherForm.setPweight(0.0D);
                /* 559 */ voucherForm.setPamount("");
                /* 560 */ voucherForm.setPremarks("");

                /* 562 */ voucherForm.setVoucherid(0);
                /* 563 */ voucherForm.setIndex(-1);

                /* 565 */ voucherForm.setMessage("Voucher saved successfully.");

                /* 567 */ loadVouchers(mapping, form, request, response);
            } catch (Exception e) {
                /* 570 */ return mapping.findForward("display");
            }
        } else {
            /* 574 */ return mapping.findForward("exp");
        }

        /* 577 */ return mapping.findForward("display");
    }

    public ActionForward deleteVouchers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 584 */ if (Constants.isSessionActive(request)) {
            /* 585 */ VouchersForm voucherForm = (VouchersForm) form;
            try {
                /* 587 */ int voucherid = voucherForm.getVoucherid();
                /* 588 */ String category = voucherForm.getCategory();

                /* 591 */ Vouchers vouchers = new VouchersDAO().cancelVoucher(voucherid);
                /* 592 */ if ((category.equals("Gold Ornaments")) || (category.equals("Silver Ornaments"))) {
                    /* 594 */ new OrnamentStockDAO().deleteStock(voucherid);
                } else {
                    /* 597 */ new GoldStockDAO().updateStock(vouchers.getVoucherid());
                }
                /* 599 */ voucherForm.setVoucherid(0);
                /* 600 */ voucherForm.setCategory("");
                /* 601 */ voucherForm.setMessage("Voucher deleted.");
                /* 602 */ loadVouchers(mapping, form, request, response);
            } catch (Exception e) {
            }

            /* 606 */ return mapping.findForward("display");
        }
        /* 608 */ return mapping.findForward("exp");
    }

    public ActionForward printrvVoucher(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        if (Constants.isSessionActive(request)) {
            VouchersForm voucherForm = (VouchersForm) form;

            VoucherBean bean = (VoucherBean) voucherForm.getLstVouchers().get(voucherForm.getIndex());

            voucherForm.setSlno(bean.getVoucherid());
            voucherForm.setPrintname(bean.getRemarks());
            voucherForm.setPrintdate(bean.getVoucherdate());
            voucherForm.setDescription(bean.getRemarks());
            voucherForm.setPurity("");
            voucherForm.setNetweight(bean.getWeight());
            voucherForm.setVoucherno(bean.getVoucherno());

        }

        return mapping.findForward("rvprint");
    }

    public ActionForward printpvVoucher(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        if (Constants.isSessionActive(request)) {
            VouchersForm voucherForm = (VouchersForm) form;

            VoucherBean bean = (VoucherBean) voucherForm.getLstVouchers().get(voucherForm.getIndex());

            voucherForm.setSlno(bean.getVoucherid());
            voucherForm.setPrintname(bean.getRemarks());
            voucherForm.setPrintdate(bean.getVoucherdate());
            voucherForm.setDescription(bean.getRemarks());
            voucherForm.setPurity("");
            voucherForm.setNetweight(bean.getWeight());
            voucherForm.setVoucherno(bean.getVoucherno());
            voucherForm.setPrintamount(bean.getAmount());

        }

        return mapping.findForward("pvprint");
    }

}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\vouchers\VouchersAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
