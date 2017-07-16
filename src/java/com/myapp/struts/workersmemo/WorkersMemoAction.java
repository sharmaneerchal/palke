package com.myapp.struts.workersmemo;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.beans.WorkersMemoBean;
import com.myapp.struts.dao.EmployeesDAO;
import com.myapp.struts.dao.GoldStockDAO;
import com.myapp.struts.dao.WorkersMemoDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Employees;
import mappings.Goldstock;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class WorkersMemoAction
        extends DispatchAction {

    private int workmemoid;
    private HashMap hmEmp = new HashMap();
    private final HashMap hmQty = new HashMap();
    private final HashMap hmMemos = new HashMap();

    public ActionForward loadWorkersMemoListPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /*  40 */ if (Constants.isSessionActive(request)) {
            /*  41 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;
            try {
                /*  44 */ wmemoForm.getLstWorkersMemos().clear();
                /*  45 */ wmemoForm.getLstWorkersMemos().addAll(new WorkersMemoDAO().getWorkMemo());
                wmemoForm.setMessage("");
            } catch (Exception e) {
            }
            /*  48 */ return mapping.findForward("display");
        }
        /*  50 */ return mapping.findForward("exp");
    }

    public ActionForward loadWorkersMemos(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  56 */ if (Constants.isSessionActive(request)) {
            /*  57 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;
            wmemoForm.setMessage("");
            try {
                /*  59 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

                /*  62 */ wmemoForm.getLstWorkersMemos().clear();
                /*  63 */ wmemoForm.getLstWorkersMemos().addAll(new WorkersMemoDAO().getWorkMemo());


                //wmemoForm.setMessage("");
                /*  65 */ wmemoForm.getLstWorkersMemo().clear();
                /*  66 */ for (int i = 0; i < wmemoForm.getLstWorkersMemos().size(); i++) {
                    /*  67 */ Workersmemo vouchers = (Workersmemo) wmemoForm.getLstWorkersMemos().get(i);

                    /*  69 */ WorkersMemoBean bean = new WorkersMemoBean();
                    /*  70 */ bean.setWorkersmemoid(vouchers.getWorkersmemoid());
                    /*  71 */ bean.setWorkermemono(vouchers.getWorkermemono());
                    /*  72 */ bean.setGoldweight(vouchers.getGoldweight() == null ? 0.0D : vouchers.getGoldweight());
                    /*  73 */ bean.setSilverweight(vouchers.getSilverweight() == null ? 0.0D : vouchers.getSilverweight());
                    /*  74 */ bean.setStoneweight(vouchers.getStoneweight() == null ? 0.0D : vouchers.getStoneweight());
                    /*  75 */ bean.setDiamondweight(vouchers.getDiamondweight() == null ? 0.0D : vouchers.getDiamondweight());
                    /*  76 */ bean.setEmployee(vouchers.getEmployee());
                    /*  77 */ bean.setDate(sdf.format(vouchers.getDate()));
                    /*  78 */ bean.setCreateddate(sdf.format(vouchers.getCreateddate()));
                    /*  79 */ bean.setRemarks(vouchers.getRemarks());
                    bean.setOrderno(vouchers.getOrderno());
                    bean.setJewel(vouchers.getJewel());
                    bean.setNetweight(vouchers.getNetweight() == null ? 0.0 : vouchers.getNetweight());
                    bean.setSize(vouchers.getSize());
                    bean.setReadydate(vouchers.getReadydate() == null ? "" : sdf.format(vouchers.getReadydate()));

                    /*  81 */ wmemoForm.getLstWorkersMemo().add(bean);
                    /*  82 */ this.hmMemos.put(bean.getWorkersmemoid() + "", bean);
                }
            } catch (Exception e) {
                e.getMessage();
            }

            /*  89 */ return mapping.findForward("display");
        }
        /*  91 */ return mapping.findForward("exp");
    }

    public ActionForward loadWorkMemoPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  97 */ if (Constants.isSessionActive(request)) {
            /*  98 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;

            /* 100 */ HashMap hmMap = new EmployeesDAO().getEmployee();
            /* 101 */ wmemoForm.setLstEmp((List) hmMap.get("list"));
            /* 102 */ this.hmEmp = ((HashMap) hmMap.get("map"));

            /* 104 */ wmemoForm.setIndex(-1);
            /* 105 */ wmemoForm.setTranstype("add");
            /* 106 */ wmemoForm.setMessage("");
            /* 107 */ wmemoForm.getLstWorkersMemo().clear();
            /* 108 */ this.hmMemos.clear();
            /* 109 */ clearWorkMemo(mapping, form, request, response);
            /* 110 */ return mapping.findForward("display");
        }
        /* 112 */ return mapping.findForward("exp");
    }

    public ActionForward pickEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 118 */ if (Constants.isSessionActive(request)) {
            /* 119 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;
            try {
                /* 121 */ Employees emp = (Employees) this.hmEmp.get(wmemoForm.getEmployeeid() + "");
                /* 122 */ wmemoForm.setEmployee(emp.getName());
                /* 123 */ wmemoForm.setEmployeeid(emp.getEmployeeid());
                wmemoForm.setMessage("");
            } catch (Exception e) {
            }
            /* 126 */ return mapping.findForward("display");
        }
        /* 128 */ return mapping.findForward("exp");
    }

    public ActionForward addWorkMemo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Workersmemo workermemo = new Workersmemo();
            wmemoForm.setPrint(false);
            try {
                double goldissue = 0.0D;
                double silverissue = 0.0D;
                double stoneissue = 0.0D;
                double diamondissue = 0.0D;

                if (wmemoForm.getEmployee().equals("")) {
                    wmemoForm.setMessage("Employee is not selected !!!");
                    return mapping.findForward("display");
                }

                if (wmemoForm.getWorkersmemoid() == 0) {

                    if (wmemoForm.getGoldweight() != 0.0D) {

                        double goldstock = new GoldStockDAO().getStockQuantity("Gold");
                        goldissue = wmemoForm.getGoldweight();
                        if (goldstock < wmemoForm.getGoldweight()) {
                            wmemoForm.setMessage("Gold Issue Quantity is exceeding Stock quantity. Gold Stock Qty :" + goldstock + " (g)");
                            return mapping.findForward("display");
                        }
                    }
                    if (wmemoForm.getSilverweight() != 0.0D) {
                        double silverstock = new GoldStockDAO().getStockQuantity("Silver");
                        silverissue = wmemoForm.getSilverweight();

                        if (silverstock < wmemoForm.getSilverweight()) {
                            wmemoForm.setMessage("Silver Issue quantity exceeding stock quantity. Silver Stock :" + silverstock + " (g)");
                            return mapping.findForward("display");
                        }
                    }
                    if (wmemoForm.getStoneweight() != 0.0D) {
                        double stonestock = new GoldStockDAO().getStockQuantity("Stone, Pearls etc");
                        stoneissue = wmemoForm.getStoneweight();

                        if (stonestock < wmemoForm.getStoneweight()) {
                            wmemoForm.setMessage("Stone, Pearls etc issue quantity exceeding stone stock quantity. Stone Stock :" + stonestock + " Grms");
                            return mapping.findForward("display");
                        }
                    }
                    if (wmemoForm.getDiamondweight() != 0.0D) {
                        double diamondstock = new GoldStockDAO().getStockQuantity("Diamonds");
                        diamondissue = wmemoForm.getDiamondweight();

                        if (diamondstock < wmemoForm.getDiamondweight()) {
                            wmemoForm.setMessage("Diamonds issue quantity exceeding stone stock quantity. Diamonds Stock :" + diamondstock + " Grms");
                            return mapping.findForward("display");
                        }
                    }
                }

                workermemo.setWorkermemono(Integer.parseInt(wmemoForm.getWorkermemono()));
                workermemo.setDate(sdf.parse(wmemoForm.getDate()));
                workermemo.setEmployee(wmemoForm.getEmployee());
                workermemo.setOrderno(wmemoForm.getOrderno());
                workermemo.setJewel(wmemoForm.getJewel());
                workermemo.setNetweight(wmemoForm.getNetweight());
                workermemo.setSize(wmemoForm.getSize());
                if (!wmemoForm.getReadydate().equals("")) {
                    workermemo.setReadydate(sdf.parse(wmemoForm.getReadydate()));
                }
                workermemo.setRemarks(wmemoForm.getRemarks());

                if (wmemoForm.getGoldweight() != 0.0D) {
                    workermemo.setGoldweight(wmemoForm.getGoldweight());
                }
                if (wmemoForm.getSilverweight() != 0.0D) {
                    workermemo.setSilverweight(wmemoForm.getSilverweight());
                }
                if (wmemoForm.getStoneweight() != 0.0D) {
                    workermemo.setStoneweight(wmemoForm.getStoneweight());
                }
                if (wmemoForm.getDiamondweight() != 0.0D) {
                    workermemo.setDiamondweight(wmemoForm.getDiamondweight());
                }

                if (wmemoForm.getWorkersmemoid() != 0) {
                    workermemo.setWorkersmemoid(wmemoForm.getWorkersmemoid());
                    workermemo.setCreateddate(new Date());
                } else {
                    workermemo.setCreateddate(new Date());
                }

                if (wmemoForm.getWorkersmemoid() == 0) {

                    workmemoid = new WorkersMemoDAO().save(workermemo);

                    if (wmemoForm.getGoldweight() != 0.0D) {
                        List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Gold");
                        for (int j = 0; j < lstGold.size(); j++) {
                            Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            if (goldissue - goldstockbean.getWeight() == 0.0D) {
                                new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                goldissue = 0.0D;
                            }
                            if (goldissue - goldstockbean.getWeight() < 0.0D) {
                                new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - goldissue);
                                goldissue = 0.0D;
                            }
                            if (goldissue - goldstockbean.getWeight() > 0.0D) {
                                new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                goldissue -= goldstockbean.getWeight();
                            }
                            if (goldissue == 0.0D) {
                                break;
                            }
                        }
                    }

                    /* 284 */ if (wmemoForm.getSilverweight() != 0.0D) {
                        /* 285 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Silver");
                        /* 286 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 287 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 289 */ if (silverissue - goldstockbean.getWeight() == 0.0D) {
                                /* 290 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 291 */ silverissue = 0.0D;
                            }
                            /* 293 */ if (silverissue - goldstockbean.getWeight() < 0.0D) {
                                /* 294 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - silverissue);
                                /* 295 */ silverissue = 0.0D;
                            }
                            /* 297 */ if (silverissue - goldstockbean.getWeight() > 0.0D) {
                                /* 298 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 299 */ silverissue -= goldstockbean.getWeight();
                            }
                            /* 301 */ if (silverissue == 0.0D) {
                                break;
                            }
                        }
                    }
                    /* 306 */ if (wmemoForm.getStoneweight() != 0.0D) {
                        /* 307 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Stone, Pearls etc");
                        /* 308 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 309 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 311 */ if (stoneissue - goldstockbean.getWeight() == 0.0D) {
                                /* 312 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 313 */ stoneissue = 0.0D;
                            }
                            /* 315 */ if (stoneissue - goldstockbean.getWeight() < 0.0D) {
                                /* 316 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - stoneissue);
                                /* 317 */ stoneissue = 0.0D;
                            }
                            /* 319 */ if (stoneissue - goldstockbean.getWeight() > 0.0D) {
                                /* 320 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 321 */ stoneissue -= goldstockbean.getWeight();
                            }
                            /* 323 */ if (stoneissue == 0.0D) {
                                break;
                            }
                        }
                    }
                    /* 328 */ if (wmemoForm.getDiamondweight() != 0.0D) {
                        /* 329 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Diamonds");
                        /* 330 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 331 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 333 */ if (diamondissue - goldstockbean.getWeight() == 0.0D) {
                                /* 334 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 335 */ diamondissue = 0.0D;
                            }
                            /* 337 */ if (diamondissue - goldstockbean.getWeight() < 0.0D) {
                                /* 338 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - diamondissue);
                                /* 339 */ diamondissue = 0.0D;
                            }
                            /* 341 */ if (diamondissue - goldstockbean.getWeight() > 0.0D) {
                                /* 342 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 343 */ diamondissue -= goldstockbean.getWeight();
                            }
                            /* 345 */ if (diamondissue == 0.0D) {
                                break;
                            }
                        }
                    }
                    /* 350 */ wmemoForm.setMessage("Worker Memo saved. (Click on on Load Memos to view) ");
                } else {
                    /* 352 */ workmemoid = new WorkersMemoDAO().update(workermemo);

                    /* 354 */ double oldgoldissue = Double.parseDouble(this.hmQty.get("gold").toString());
                    /* 355 */ double oldsilverissue = Double.parseDouble(this.hmQty.get("silver").toString());
                    /* 356 */ double oldstoneissue = Double.parseDouble(this.hmQty.get("stone").toString());
                    /* 357 */ double olddiamondissue = Double.parseDouble(this.hmQty.get("diamond").toString());

                    /* 359 */ goldissue = wmemoForm.getGoldweight();
                    /* 360 */ silverissue = wmemoForm.getSilverweight();
                    /* 361 */ stoneissue = wmemoForm.getSilverweight();
                    /* 362 */ diamondissue = wmemoForm.getDiamondweight();

                    /* 365 */ if (goldissue > oldgoldissue) {

                        /* 368 */ double goldstock = new GoldStockDAO().getStockQuantity("Gold") + oldgoldissue;
                        /* 369 */ if (goldstock < goldissue) {
                            /* 370 */ wmemoForm.setMessage("Gold Issue Quantity is exceeding Stock quantity. Gold Stock Qty :" + goldstock + " (g)");
                            /* 371 */ return mapping.findForward("display");
                        }
                        /* 373 */ goldissue -= oldgoldissue;
                        /* 374 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Gold");
                        /* 375 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 376 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 378 */ if (goldissue - goldstockbean.getWeight() == 0.0D) {
                                /* 379 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 380 */ goldissue = 0.0D;
                            }
                            /* 382 */ if (goldissue - goldstockbean.getWeight() < 0.0D) {
                                /* 383 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - goldissue);
                                /* 384 */ goldissue = 0.0D;
                            }
                            /* 386 */ if (goldissue - goldstockbean.getWeight() > 0.0D) {
                                /* 387 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 388 */ goldissue -= goldstockbean.getWeight();
                            }
                            /* 390 */ if (goldissue == 0.0D) {
                                break;
                            }

                        }
                    } /* 396 */ else if (goldissue < oldgoldissue) {
                        /* 398 */ Goldstock stock = new Goldstock();
                        /* 399 */ stock.setRefernceid(workmemoid);
                        /* 400 */ stock.setRefernceno(Integer.parseInt(wmemoForm.getWorkermemono()));
                        /* 401 */ stock.setRemarks("Memo edit stock return");
                        /* 402 */ stock.setType("Gold");
                        /* 403 */ stock.setUpdateddate(new Date());
                        /* 404 */ stock.setWeight(oldgoldissue - goldissue);
                        /* 405 */ stock.setVoucherdate(null);
                        /* 406 */ stock.setVouchertype("WM RTN");
                        /* 407 */ new GoldStockDAO().saveGoldStock(stock, false);
                    }

                    /* 411 */ if (silverissue > oldsilverissue) {

                        /* 414 */ double goldstock = new GoldStockDAO().getStockQuantity("Silver") + oldsilverissue;
                        /* 415 */ if (goldstock < silverissue) {
                            /* 416 */ wmemoForm.setMessage("Silver Issue Quantity is exceeding Stock quantity. Silver Stock Qty :" + goldstock + " (g)");
                            /* 417 */ return mapping.findForward("display");
                        }
                        /* 419 */ silverissue -= oldsilverissue;
                        /* 420 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Silver");
                        /* 421 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 422 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 424 */ if (silverissue - goldstockbean.getWeight() == 0.0D) {
                                /* 425 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 426 */ silverissue = 0.0D;
                            }
                            /* 428 */ if (silverissue - goldstockbean.getWeight() < 0.0D) {
                                /* 429 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - silverissue);
                                /* 430 */ silverissue = 0.0D;
                            }
                            /* 432 */ if (silverissue - goldstockbean.getWeight() > 0.0D) {
                                /* 433 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 434 */ silverissue -= goldstockbean.getWeight();
                            }
                            /* 436 */ if (silverissue == 0.0D) {
                                break;
                            }

                        }
                    } /* 442 */ else if (silverissue < oldsilverissue) {
                        /* 444 */ Goldstock stock = new Goldstock();
                        /* 445 */ stock.setRefernceid(workmemoid);
                        /* 446 */ stock.setRefernceno(Integer.parseInt(wmemoForm.getWorkermemono()));
                        /* 447 */ stock.setRemarks("Memo edit stock return");
                        /* 448 */ stock.setType("Silver");
                        /* 449 */ stock.setUpdateddate(new Date());
                        /* 450 */ stock.setWeight(oldgoldissue - goldissue);
                        /* 451 */ stock.setVoucherdate(null);
                        /* 452 */ stock.setVouchertype("WM RTN");
                        /* 453 */ new GoldStockDAO().saveGoldStock(stock, false);
                    }

                    /* 457 */ if (stoneissue > oldstoneissue) {

                        /* 460 */ double goldstock = new GoldStockDAO().getStockQuantity("Stone, Pearls etc") + oldstoneissue;
                        /* 461 */ if (goldstock < stoneissue) {
                            /* 462 */ wmemoForm.setMessage("Stone Issue Quantity is exceeding Stock quantity. Stone Stock Qty :" + goldstock + " (g)");
                            /* 463 */ return mapping.findForward("display");
                        }
                        /* 465 */ stoneissue -= oldstoneissue;
                        /* 466 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Stone, Pearls etc");
                        /* 467 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 468 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 470 */ if (stoneissue - goldstockbean.getWeight() == 0.0D) {
                                /* 471 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 472 */ stoneissue = 0.0D;
                            }
                            /* 474 */ if (stoneissue - goldstockbean.getWeight() < 0.0D) {
                                /* 475 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - stoneissue);
                                /* 476 */ stoneissue = 0.0D;
                            }
                            /* 478 */ if (stoneissue - goldstockbean.getWeight() > 0.0D) {
                                /* 479 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 480 */ stoneissue -= goldstockbean.getWeight();
                            }
                            /* 482 */ if (stoneissue == 0.0D) {
                                break;
                            }

                        }
                    } /* 488 */ else if (stoneissue < oldstoneissue) {
                        /* 490 */ Goldstock stock = new Goldstock();
                        /* 491 */ stock.setRefernceid(workmemoid);
                        /* 492 */ stock.setRefernceno(Integer.parseInt(wmemoForm.getWorkermemono()));
                        /* 493 */ stock.setRemarks("Memo edit stock return");
                        /* 494 */ stock.setType("Stone, Pearls etc");
                        /* 495 */ stock.setUpdateddate(new Date());
                        /* 496 */ stock.setWeight(oldgoldissue - goldissue);
                        /* 497 */ stock.setVoucherdate(null);
                        /* 498 */ stock.setVouchertype("WM RTN");
                        /* 499 */ new GoldStockDAO().saveGoldStock(stock, false);
                    }

                    /* 503 */ if (diamondissue > olddiamondissue) {

                        /* 506 */ double goldstock = new GoldStockDAO().getStockQuantity("Diamonds") + olddiamondissue;
                        /* 507 */ if (goldstock < diamondissue) {
                            /* 508 */ wmemoForm.setMessage("Diamonds Issue Quantity is exceeding Stock quantity. Diamonds Stock Qty :" + goldstock + " (g)");
                            /* 509 */ return mapping.findForward("display");
                        }
                        /* 511 */ diamondissue -= olddiamondissue;
                        /* 512 */ List<Goldstock> lstGold = new GoldStockDAO().getStockDescending("Diamonds");
                        /* 513 */ for (int j = 0; j < lstGold.size(); j++) {
                            /* 514 */ Goldstock goldstockbean = (Goldstock) lstGold.get(j);

                            /* 516 */ if (diamondissue - goldstockbean.getWeight() == 0.0D) {
                                /* 517 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 518 */ diamondissue = 0.0D;
                            }
                            /* 520 */ if (diamondissue - goldstockbean.getWeight() < 0.0D) {
                                /* 521 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), goldstockbean.getWeight() - diamondissue);
                                /* 522 */ diamondissue = 0.0D;
                            }
                            /* 524 */ if (diamondissue - goldstockbean.getWeight() > 0.0D) {
                                /* 525 */ new GoldStockDAO().updateStockWeight(goldstockbean.getGoldstockid(), 0.0D);
                                /* 526 */ diamondissue -= goldstockbean.getWeight();
                            }
                            /* 528 */ if (diamondissue == 0.0D) {
                                break;
                            }

                        }
                    } /* 534 */ else if (diamondissue < olddiamondissue) {
                        /* 536 */ Goldstock stock = new Goldstock();
                        /* 537 */ stock.setRefernceid(workmemoid);
                        /* 538 */ stock.setRefernceno(Integer.parseInt(wmemoForm.getWorkermemono()));
                        /* 539 */ stock.setRemarks("Memo edit stock return");
                        /* 540 */ stock.setType("Diamonds");
                        /* 541 */ stock.setUpdateddate(new Date());
                        /* 542 */ stock.setWeight(oldgoldissue - goldissue);
                        /* 543 */ stock.setVoucherdate(null);
                        /* 544 */ stock.setVouchertype("WM RTN");
                        /* 545 */ new GoldStockDAO().saveGoldStock(stock, false);
                    }

                    /* 548 */ wmemoForm.setMessage("Worker Memo updated.");
                    wmemoForm.setWorkersmemoid(workmemoid);
                }

                /* 552 */ wmemoForm.setTranstype("add");
                /* 553 */ wmemoForm.setDate("");
                /* 554 */ wmemoForm.setEmployee("");
                /* 555 */ wmemoForm.setRemarks("");
                /* 556 */ wmemoForm.setGoldweight(0.0D);
                /* 557 */ wmemoForm.setSilverweight(0.0D);
                /* 558 */ wmemoForm.setStoneweight(0.0D);
                /* 559 */ wmemoForm.setDiamondweight(0.0D);
                /* 560 */ wmemoForm.setWorkermemono("");
                /* 561 */ wmemoForm.setWorkersmemoid(0);
                /* 562 */ wmemoForm.setOrderno("");
                /* 563 */ wmemoForm.setIndex(-1);
                /* 564 */ this.hmQty.clear();
                /* 565 */ clearWorkMemo(mapping, form, request, response);

                loadWorkersMemos(mapping, form, request, response);

                wmemoForm.setPrint(true);
                printMemo(mapping, form, request, response);
            } catch (Exception e) {
                /* 568 */ wmemoForm.setMessage("Error while saving. !!!\n" + e.getMessage());
                /* 569 */ return mapping.findForward("display");
            }
            /* 571 */ return mapping.findForward("display");
        }
        /* 573 */ return mapping.findForward("exp");
    }

    public ActionForward editWorkersMemo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 579 */ if (Constants.isSessionActive(request)) {
            /* 580 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;

            wmemoForm.setMessage("");
            /* 582 */ WorkersMemoBean bean = (WorkersMemoBean) this.hmMemos.get(wmemoForm.getIndex() + "");
            /* 583 */ wmemoForm.setWorkersmemoid(bean.getWorkersmemoid());
            /* 584 */ wmemoForm.setWorkermemono(bean.getWorkermemono() + "");
            /* 585 */ wmemoForm.setEmployee(bean.getEmployee());
            /* 586 */ wmemoForm.setGoldweight(bean.getGoldweight());
            /* 587 */ wmemoForm.setSilverweight(bean.getSilverweight());
            /* 588 */ wmemoForm.setStoneweight(bean.getStoneweight());
            /* 589 */ wmemoForm.setDiamondweight(bean.getDiamondweight());
            /* 590 */ wmemoForm.setDate(bean.getDate());
            /* 591 */ wmemoForm.setRemarks(bean.getRemarks());
            /* 592 */ wmemoForm.setTranstype("update");
            /* 593 */ wmemoForm.setIndex(wmemoForm.getIndex());
            /* 594 */ wmemoForm.setOrderno(bean.getOrderno());
            /* 595 */ wmemoForm.setCreateddate(bean.getCreateddate());
            wmemoForm.setJewel(bean.getJewel());
            wmemoForm.setNetweight(bean.getNetweight());
            wmemoForm.setSize(bean.getSize());
            wmemoForm.setReadydate(bean.getReadydate());
            /* 597 */ this.hmQty.put("gold", bean.getGoldweight());
            /* 598 */ this.hmQty.put("silver", bean.getSilverweight());
            /* 599 */ this.hmQty.put("stone", bean.getStoneweight());
            /* 600 */ this.hmQty.put("diamond", bean.getDiamondweight());

            /* 602 */ return mapping.findForward("display");
        }
        /* 604 */ return mapping.findForward("exp");
    }

    public ActionForward clearWorkMemo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 610 */ if (Constants.isSessionActive(request)) {
            /* 611 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;
            /* 612 */ wmemoForm.setIndex(-1);
            /* 613 */ wmemoForm.setTranstype("add");
            /* 614 */ wmemoForm.setWorkersmemoid(0);
            /* 615 */ wmemoForm.setWorkermemono("");
            /* 616 */ wmemoForm.setGoldweight(0.0D);
            /* 617 */ wmemoForm.setSilverweight(0.0D);
            /* 618 */ wmemoForm.setStoneweight(0.0D);
            /* 619 */ wmemoForm.setDiamondweight(0.0D);
            /* 620 */ wmemoForm.setDate("");
            /* 621 */ wmemoForm.setRemarks("");
            /* 622 */ wmemoForm.setOrderno("");
            /* 623 */ wmemoForm.setEmployee("");
            /* 624 */ wmemoForm.setEmployeeid(0);
            wmemoForm.setJewel("");
            wmemoForm.setNetweight(0.0D);
            wmemoForm.setReadydate("");
            wmemoForm.setSize("");

            /* 626 */ wmemoForm.getLstWorkersMemos().clear();
            /* 627 */ wmemoForm.getLstWorkersMemo().clear();
            /* 628 */ this.hmMemos.clear();
            /* 629 */ return mapping.findForward("display");
        }
        /* 631 */ return mapping.findForward("exp");
    }

    public ActionForward removeWorkersMemo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 638 */ if (Constants.isSessionActive(request)) {
            /* 639 */ WorkersMemoActionForm wmemoForm = (WorkersMemoActionForm) form;
            try {
                /* 641 */ wmemoForm.setWorkersmemoid(wmemoForm.getIndex());
                /* 642 */ new WorkersMemoDAO().delete(wmemoForm.getWorkersmemoid());
                /* 643 */ WorkersMemoBean bean = (WorkersMemoBean) this.hmMemos.get(wmemoForm.getWorkersmemoid() + "");
                /* 644 */ if (bean.getGoldweight() != 0.0D) {
                    /* 645 */ Goldstock stock = new Goldstock();
                    /* 646 */ stock.setRefernceid(bean.getWorkersmemoid());
                    /* 647 */ stock.setRefernceno(bean.getWorkermemono());
                    /* 648 */ stock.setRemarks("Memo stock return");
                    /* 649 */ stock.setType("Gold");
                    /* 650 */ stock.setUpdateddate(new Date());
                    /* 651 */ stock.setWeight(bean.getGoldweight());
                    /* 652 */ stock.setVoucherdate(new Date());
                    /* 653 */ stock.setVouchertype("WM RTN");
                    /* 654 */ stock.setCreateddate(new Date());
                    /* 655 */ new GoldStockDAO().saveGoldStock(stock, false);
                }
                /* 657 */ if (bean.getSilverweight() != 0.0D) {
                    /* 658 */ Goldstock stock = new Goldstock();
                    /* 659 */ stock.setRefernceid(bean.getWorkersmemoid());
                    /* 660 */ stock.setRefernceno(bean.getWorkermemono());
                    /* 661 */ stock.setRemarks("Memo stock return");
                    /* 662 */ stock.setType("Silver");
                    /* 663 */ stock.setUpdateddate(new Date());
                    /* 664 */ stock.setWeight(bean.getSilverweight());
                    /* 665 */ stock.setVoucherdate(new Date());
                    /* 666 */ stock.setVouchertype("WM RTN");
                    /* 667 */ stock.setCreateddate(new Date());
                    /* 668 */ new GoldStockDAO().saveGoldStock(stock, false);
                }
                /* 670 */ if (bean.getStoneweight() != 0.0D) {
                    /* 671 */ Goldstock stock = new Goldstock();
                    /* 672 */ stock.setRefernceid(bean.getWorkersmemoid());
                    /* 673 */ stock.setRefernceno(bean.getWorkermemono());
                    /* 674 */ stock.setRemarks("Memo stock return");
                    /* 675 */ stock.setType("Stone, Pearls etc");
                    /* 676 */ stock.setUpdateddate(new Date());
                    /* 677 */ stock.setWeight(bean.getStoneweight());
                    /* 678 */ stock.setVoucherdate(new Date());
                    /* 679 */ stock.setVouchertype("WM RTN");
                    /* 680 */ stock.setCreateddate(new Date());
                    /* 681 */ new GoldStockDAO().saveGoldStock(stock, false);
                }
                /* 683 */ if (bean.getDiamondweight() != 0.0D) {
                    /* 684 */ Goldstock stock = new Goldstock();
                    /* 685 */ stock.setRefernceid(bean.getWorkersmemoid());
                    /* 686 */ stock.setRefernceno(bean.getWorkermemono());
                    /* 687 */ stock.setRemarks("Memo stock return");
                    /* 688 */ stock.setType("Diamonds");
                    /* 689 */ stock.setUpdateddate(new Date());
                    /* 690 */ stock.setWeight(bean.getDiamondweight());
                    /* 691 */ stock.setVoucherdate(new Date());
                    /* 692 */ stock.setVouchertype("WM RTN");
                    /* 693 */ stock.setCreateddate(new Date());
                    /* 694 */ new GoldStockDAO().saveGoldStock(stock, false);
                }
                /* 696 */ wmemoForm.setMessage("Memo deleted.");

                /* 698 */ wmemoForm.setIndex(-1);
                /* 699 */ loadWorkersMemos(mapping, form, request, response);

            } catch (Exception e) {
            }
        } else {
            /* 703 */ return mapping.findForward("exp");
        }
        /* 705 */ return mapping.findForward("display");
    }

    public ActionForward printMemo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        if (Constants.isSessionActive(request)) {
            WorkersMemoActionForm memoForm = (WorkersMemoActionForm) form;
            memoForm.setPrint(workmemoid == 0 ? true : memoForm.isPrint());

            int memoid = workmemoid == 0 ? memoForm.getIndex() : workmemoid;

            WorkersMemoBean bean = (WorkersMemoBean) this.hmMemos.get(memoid + "");

            Employees emp = new EmployeesDAO().getEmployee(bean.getEmployee());

            memoForm.setPrintOrderno(bean.getOrderno());
            memoForm.setPrintaddress(emp.getAddress());
            memoForm.setPrintgoldweight(bean.getGoldweight());
            memoForm.setPrintjewel(bean.getJewel());
            memoForm.setPrintmemoid(bean.getWorkermemono() + "");
            memoForm.setPrintnetweight(bean.getNetweight());
            memoForm.setPrintreadydate(bean.getReadydate());
            memoForm.setPrintsize(bean.getSize());
            memoForm.setPrintstoneweight(bean.getStoneweight());
            memoForm.setPrintworker(bean.getEmployee());
            memoForm.setPrintdate(bean.getDate());

            workmemoid = 0;
        }

        return mapping.findForward("display");
    }

    public ActionForward viewPrintPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward("print");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\workersmemo\WorkersMemoAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
