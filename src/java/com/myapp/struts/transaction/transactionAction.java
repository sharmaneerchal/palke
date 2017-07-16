
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.transaction;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.myapp.struts.Utility.Constants;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.PrintBill;
import com.myapp.struts.beans.transactionDispBean;
import com.myapp.struts.dao.DrawDetailsDAO;
import com.myapp.struts.dao.DrawTypesDAO;
import com.myapp.struts.dao.GroupsDAO;
import com.myapp.struts.dao.MembersDAO;
import com.myapp.struts.dao.PaymentDAO;
import com.myapp.struts.dao.PaymentDetailsDAO;
import com.myapp.struts.dao.PaymentModeDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappings.Drawdetails;
import mappings.Drawtypes;
import mappings.Groups;
import mappings.Members;
import mappings.Payment;
import mappings.Paymentdetails;
import mappings.Paymentmodes;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Lenovo
 */
public class transactionAction extends DispatchAction {

    private final GroupsDAO objGroupDAO = new GroupsDAO();
    private final MembersDAO objMemebrsDAO = new MembersDAO();
    private final PaymentDAO objPaymentDAO = new PaymentDAO();
    private final PaymentDetailsDAO objPaymentDetails = new PaymentDetailsDAO();
    private final PaymentModeDAO objPaymentModeDAO = new PaymentModeDAO();
    private HashMap hmGroups = new HashMap();
    private TreeMap hmPayments = new TreeMap();

    public ActionForward loadPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        HttpSession session = request.getSession();
        if (Constants.isSessionActive(request)) {

            transactionForm transactionform = (transactionForm) form;

            try {
                transactionform.setTotalpaidamount("");
                transactionform.setTotalamount("");
                transactionform.setSettlementcomment("");
                transactionform.setStatus("");
                transactionform.setUpdatepayment(0);
                transactionform.setDrawamount("");
                transactionform.setOldpayment(0);
                transactionform.setGroupid(0);
                transactionform.setGroup("");
                transactionform.setSelectedmember("");
                transactionform.setAmount(0);
                SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
                transactionform.setDate(dat.format(new Date()));
                transactionform.setDrawtypeid(0);
                transactionform.setLstPayment(new ArrayList<transactionDispBean>());
                transactionform.setMemberaddress("");
                transactionform.setMembercontactno("");
                transactionform.setMemberid(0);
                transactionform.setMemberno(0);
                transactionform.setMessage("");
                transactionform.setPaymentmode("");
                transactionform.setPrizeamount(0);
                transactionform.setRemarks("");
                transactionform.setMessage("");
                transactionform.getLstMembers().clear();
                //Groups filling
                List<DropDownFill> dropDowListDT;
                dropDowListDT = new ArrayList<DropDownFill>();

                hmGroups = objGroupDAO.getGroups();
                List<Groups> lstGroups = (List<Groups>) hmGroups.get("Group");
                for (int i = 0; i < lstGroups.size(); i++) {
                    Groups groups = lstGroups.get(i);
                    dropDowListDT.add(new DropDownFill(groups.getGroupid(), groups.getGroupname()));
                }
                transactionform.setGroups(dropDowListDT);
                //fill drawtypes
                List<Drawtypes> lstDrawtypes = new DrawTypesDAO().getDrawtypes();
                List<DropDownFill> dropDrown;
                dropDrown = new ArrayList<DropDownFill>();

                for (int i = 0; i < lstDrawtypes.size(); i++) {
                    Drawtypes Drawtypes = lstDrawtypes.get(i);
                    dropDrown.add(new DropDownFill(Drawtypes.getDrawtypeid(), Drawtypes.getDrawtypes()));
                }
                transactionform.setDrawtypes(dropDrown);
                //fill Amount
                List<DropDownFill> dropDrownA;
                dropDrownA = new ArrayList<DropDownFill>();
                for (int i = 500; i <= 5000;) {
                    dropDrownA.add(new DropDownFill(i, i + ""));
                    i = i + 500;
                }
                transactionform.setAmountlst(dropDrownA);
                session = request.getSession();
                session.setAttribute("groupid", "");

                return mapping.findForward("display");
            } catch (Exception e) {
                return mapping.findForward("fail");
            }
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward changeGroup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        HttpSession session = request.getSession();
        if (Constants.isSessionActive(request)) {

            transactionForm transactionform = (transactionForm) form;
            try {

                List<Members> lstMembers = new MembersDAO().getMembers(transactionform.getGroupid());
                transactionform.setLstMembers(lstMembers);
                session = request.getSession();
                session.setAttribute("groupid", transactionform.getGroupid() + "");

                return mapping.findForward("display");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return mapping.findForward("fail");
            }
        } else {
            return mapping.findForward("exp");
        }
    }

    private TreeMap getPaymentDetails(int memberid) throws Exception {
        TreeMap hmPayment = new TreeMap();
        List<Paymentdetails> lstPaymentdetails = objPaymentDetails.getPaymentDetails(memberid);
        for (int i = 0; i < lstPaymentdetails.size(); i++) {
            Paymentdetails paymentdetails = lstPaymentdetails.get(i);
            //can be pass paymentid if relation is removed.
            List<Payment> lstPayments = objPaymentDAO.getPayments(memberid, paymentdetails.getTerm());
            if (lstPayments.size() > 0) {
                hmPayment.put(paymentdetails.getTerm() + "", lstPayments.get(0));
            } else {
                System.out.println("For term" + paymentdetails.getTerm() + " payment entry data not found.");
            }
        }
        return hmPayment;
    }

    private HashMap getPrizeDetails(int memberid) throws Exception {
        HashMap hmPrizes = new HashMap();
        //prize details
        List<Drawdetails> lstDrawdetail = DrawDetailsDAO.getDrawDetails(memberid);
        for (int i = 0; i < lstDrawdetail.size(); i++) {
            Drawdetails drawdetails = lstDrawdetail.get(i);

            hmPrizes.put(drawdetails.getTerm() + "", drawdetails);
        }
        return hmPrizes;
    }

    public ActionForward fillPaymentDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        HttpSession session = request.getSession();
        if (Constants.isSessionActive(request)) {

            transactionForm transactionform = (transactionForm) form;
            try {
                transactionform.getLstPayment().clear();
                transactionform.setMemberaddress("");
                transactionform.setMembercontactno("");
                transactionform.setDrawamount("");
                session = request.getSession();
                String clear = (String) session.getAttribute("clear");
                if (clear == null || !clear.equalsIgnoreCase("1")) {
                    transactionform.setMessage("");
                } else {
                    session.setAttribute("clear", "0");
                }
                //transactionform.setMemberid(0);
                //transactionform.setMemberno(0);

                int memberno = transactionform.getMemberno();
                transactionform.setMemberno(memberno);

                Members objMembers = objMemebrsDAO.getMembersInfo(memberno, transactionform.getGroupid());

                transactionform.setMemberid(objMembers.getMemberid());
                transactionform.setSelectedmember(objMembers.getMembername());
                transactionform.setMemberaddress(objMembers.getMemberaddress());
                transactionform.setMembercontactno(objMembers.getContactno());

                Groups group = (Groups) hmGroups.get(transactionform.getGroupid() + "");

                transactionform.setGroup(group.getGroupname());

                SimpleDateFormat monthformat = new SimpleDateFormat("MMMM yyyy");
                SimpleDateFormat displaydate = new SimpleDateFormat("dd/MM/yyy");

                Date Actualstartdate = null;
                if (group.getActualstartdate() != null) {
                    Actualstartdate = group.getActualstartdate();
                } else {
                    List<Drawdetails> dtdrawdetails = DrawDetailsDAO.getDrawdetailsData(transactionform.getGroupid());
                    if (dtdrawdetails.size() > 0) {
                        Actualstartdate = dtdrawdetails.get(0).getDrawdate();
                    }
                }

                int paidamount = objPaymentDAO.getTotalAmount(objMembers.getMemberid());
                int drawamount = new DrawDetailsDAO().getSumOfDrawAmount(objMembers.getMemberid());
                transactionform.setTotalpaidamount(paidamount + "");

                transactionform.setDrawamount(drawamount + "");
                int total = (paidamount + drawamount);
                transactionform.setTotalamount(total + "");

                int count = 0;
                hmPayments = getPaymentDetails(transactionform.getMemberid());
                HashMap hmPrizes = getPrizeDetails(transactionform.getMemberid());

                transactionform.setStatus(objMembers.getStatus());
                transactionform.setSettlementcomment(objMembers.getRemarks());
                while (count < (group.getNoofinstallment())) {

                    transactionDispBean objbean = new transactionDispBean();

                    count++;
                    //1
                    objbean.setCount1(count + "");

                    if (Actualstartdate != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(Actualstartdate);
                        if (count != 1) {
                            calendar.add(Calendar.MONTH, count - 1);
                        }
                        Date date = calendar.getTime();
                        objbean.setMonth1(monthformat.format(date));
                    } else {
                        objbean.setMonth1("Month " + count);
                    }
                    objbean.setStatus1("Not Paid");
                    if (hmPayments.get(count + "") != null) {
                        Payment payment = (Payment) hmPayments.get(count + "");
                        group.getInstallmentamount();
                        String PaymentDetails = payment.getPaymentid() + " - " + displaydate.format(payment.getPaiddate()) + " - " + (int) group.getInstallmentamount() + " - " + objPaymentModeDAO.getPaymentMode(payment.getPaymentmode()) + "\n"
                                + payment.getRemarks();
                        objbean.setPaymentdetails1(PaymentDetails);
                        objbean.setPaymentid1(payment.getPaymentid());
                        objbean.setTerm1(count);
                        objbean.setStatus1("Paid");
                        String prizedetail = "";
                        if (hmPrizes.get(count + "") != null) {
                            Drawdetails drawdetails = (Drawdetails) hmPrizes.get(count + "");
                            prizedetail = displaydate.format(drawdetails.getDrawdate()) + "/ " + drawdetails.getAmount();
                            objbean.setDrawid1(drawdetails.getDrawdetailsid());
                        }
                        objbean.setPrizedetails1(prizedetail);
                    }
                    count++;
                    //2
                    objbean.setCount2(count + "");

                    if (Actualstartdate != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(Actualstartdate);
                        calendar.add(Calendar.MONTH, count - 1);
                        Date date = calendar.getTime();
                        objbean.setMonth2(monthformat.format(date));
                    } else {
                        objbean.setMonth2("Month " + count);
                    }
                    objbean.setStatus2("Not Paid");
                    if (hmPayments.get(count + "") != null) {
                        Payment payment = (Payment) hmPayments.get(count + "");

                        String PaymentDetails = payment.getPaymentid() + " - " + displaydate.format(payment.getPaiddate()) + " - " + (int) group.getInstallmentamount() + " - " + objPaymentModeDAO.getPaymentMode(payment.getPaymentmode()) + "\n"
                                + payment.getRemarks();
                        objbean.setPaymentdetails2(PaymentDetails);
                        objbean.setPaymentid2(payment.getPaymentid());
                        objbean.setTerm2(count);
                        objbean.setStatus2("Paid");
                        String prizedetail = "";
                        if (hmPrizes.get(count + "") != null) {
                            Drawdetails drawdetails = (Drawdetails) hmPrizes.get(count + "");
                            prizedetail = displaydate.format(drawdetails.getDrawdate()) + "/ " + drawdetails.getAmount();
                            objbean.setDrawid2(drawdetails.getDrawdetailsid());
                        }
                        objbean.setPrizedetails2(prizedetail);
                    }
                    count++;
                    //3
                    objbean.setCount3(count + "");

                    if (Actualstartdate != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(Actualstartdate);
                        calendar.add(Calendar.MONTH, count - 1);
                        Date date = calendar.getTime();
                        objbean.setMonth3(monthformat.format(date));
                    } else {
                        objbean.setMonth3("Month " + count);
                    }
                    objbean.setStatus3("Not Paid");
                    if (hmPayments.get(count + "") != null) {
                        Payment payment = (Payment) hmPayments.get(count + "");

                        String PaymentDetails = payment.getPaymentid() + " - " + displaydate.format(payment.getPaiddate()) + " - " + (int) group.getInstallmentamount() + " - " + objPaymentModeDAO.getPaymentMode(payment.getPaymentmode()) + "\n"
                                + payment.getRemarks();
                        objbean.setPaymentdetails3(PaymentDetails);
                        objbean.setPaymentid3(payment.getPaymentid());
                        objbean.setTerm3(count);
                        objbean.setStatus3("Paid");
                        String prizedetail = "";
                        if (hmPrizes.get(count + "") != null) {
                            Drawdetails drawdetails = (Drawdetails) hmPrizes.get(count + "");
                            prizedetail = displaydate.format(drawdetails.getDrawdate()) + "/ " + drawdetails.getAmount();
                            objbean.setDrawid3(drawdetails.getDrawdetailsid());
                        }
                        objbean.setPrizedetails3(prizedetail);
                    }
                    count++;
                    //4
                    objbean.setCount4(count + "");
                    if (Actualstartdate != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(Actualstartdate);
                        calendar.add(Calendar.MONTH, count - 1);
                        Date date = calendar.getTime();
                        objbean.setMonth4(monthformat.format(date));
                    } else {
                        objbean.setMonth4("Month " + count);
                    }
                    objbean.setStatus4("Not Paid");
                    if (hmPayments.get(count + "") != null) {
                        Payment payment = (Payment) hmPayments.get(count + "");

                        String PaymentDetails = payment.getPaymentid() + " - " + displaydate.format(payment.getPaiddate()) + " - " + (int) group.getInstallmentamount() + "-" + objPaymentModeDAO.getPaymentMode(payment.getPaymentmode()) + "\n"
                                + payment.getRemarks();
                        objbean.setPaymentdetails4(PaymentDetails);
                        objbean.setPaymentid4(payment.getPaymentid());
                        objbean.setTerm4(count);
                        objbean.setStatus4("Paid");
                        String prizedetail = "";
                        if (hmPrizes.get(count + "") != null) {
                            Drawdetails drawdetails = (Drawdetails) hmPrizes.get(count + "");
                            prizedetail = displaydate.format(drawdetails.getDrawdate()) + "/ " + drawdetails.getAmount();
                            objbean.setDrawid4(drawdetails.getDrawdetailsid());
                        }
                        objbean.setPrizedetails4(prizedetail);
                    }
                    count++;
                    //5
                    objbean.setCount5(count + "");
                    if (Actualstartdate != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(Actualstartdate);
                        calendar.add(Calendar.MONTH, count - 1);
                        Date date = calendar.getTime();
                        objbean.setMonth5(monthformat.format(date));
                    } else {
                        objbean.setMonth5("Month " + count);
                    }
                    objbean.setStatus5("Not Paid");
                    if (hmPayments.get(count + "") != null) {
                        Payment payment = (Payment) hmPayments.get(count + "");

                        String PaymentDetails = payment.getPaymentid() + " - " + displaydate.format(payment.getPaiddate()) + " - " + (int) group.getInstallmentamount() + " - " + objPaymentModeDAO.getPaymentMode(payment.getPaymentmode()) + "\n"
                                + payment.getRemarks();
                        objbean.setPaymentdetails5(PaymentDetails);
                        objbean.setPaymentid5(payment.getPaymentid());
                        objbean.setTerm5(count);
                        objbean.setStatus5("Paid");
                        String prizedetail = "";
                        if (hmPrizes.get(count + "") != null) {
                            Drawdetails drawdetails = (Drawdetails) hmPrizes.get(count + "");
                            prizedetail = displaydate.format(drawdetails.getDrawdate()) + "/ " + drawdetails.getAmount();
                            objbean.setDrawid5(drawdetails.getDrawdetailsid());
                        }
                        objbean.setPrizedetails5(prizedetail);
                    }

                    transactionform.getLstPayment().add(objbean);

                }
                return mapping.findForward("display");
            } catch (Exception e) {
                return mapping.findForward("display");
            }
        } else {
            return mapping.findForward("exp");
        }

    }

    public ActionForward setTerm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        HttpSession session = request.getSession();
        if (Constants.isSessionActive(request)) {
            transactionForm transactionform = (transactionForm) form;
            try {
                transactionform.getTerm();
                return mapping.findForward("display");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return mapping.findForward("display");
            }

        } else {
            return mapping.findForward("wxp");
        }

    }

    public ActionForward savePayment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        HttpSession session = request.getSession();
        if (Constants.isSessionActive(request)) {

            transactionForm transactionForm = (transactionForm) form;

            try {

                String date1 = transactionForm.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date testDate = sdf.parse(date1);
                // if the format of the string provided doesn't match the format we
                // declared in SimpleDateFormat() we will get an exception

                if (!sdf.format(testDate).equals(date1)) {
                    transactionForm.setMessage("The date that you provided is invalid.");
                    return mapping.findForward("display");
                }
                if (transactionForm.getMemberid() == 0) {
                    transactionForm.setMessage("Please select Member.");
                    return mapping.findForward("display");
                } else if (transactionForm.getPaymentmode().equals("")) {
                    transactionForm.setMessage("please select Payment mode.");
                    return mapping.findForward("display");
                }

                Payment payment = new Payment();

                payment.setPaidamount(Double.parseDouble(transactionForm.getAmount() + ""));
                payment.setPaiddate(testDate);
                payment.setMemberid(transactionForm.getMemberid());

                int paymentmodeid = 0;
                if (transactionForm.getPaymentmode().equalsIgnoreCase("cash")) {
                    paymentmodeid = 1;
                } else if (transactionForm.getPaymentmode().equalsIgnoreCase("cheque")) {
                    paymentmodeid = 2;
                }

                payment.setPaymentmode(paymentmodeid);
                payment.setRemarks(transactionForm.getRemarks());
                //get paid last term 
                //paid amount has to be divided by install amount
                int lastterm = objPaymentDetails.getLastTerm(transactionForm.getMemberid());

//last term==installmentterms, then all the installments are paid            
                Groups groups = (Groups) hmGroups.get(transactionForm.getGroupid() + "");
                int noofinstallment = groups.getNoofinstallment();

                if (lastterm == noofinstallment) {
                    transactionForm.setMessage("All installments are paid.");
                    return mapping.findForward("display");
                } else {
//get installment amount
                    double installmentAmount = groups.getInstallmentamount();

                    List<Paymentdetails> listPaymentdetails = new ArrayList<Paymentdetails>();

                    int direct = 2;
                    if (transactionForm.getAmount() == installmentAmount) {
                        Paymentdetails paymentdetails = new Paymentdetails();
                        //++lastterm;
                        paymentdetails.setTerm(transactionForm.getTerm());
                        listPaymentdetails.add(paymentdetails);
                        direct = 1;
                    } else if (transactionForm.getAmount() >= installmentAmount) {
                        if ((transactionForm.getAmount() % installmentAmount) != 0.0) {
                            transactionForm.setMessage("Kindly check the selected amount. Amount not meets installment pattern. Installment Amount : " + installmentAmount + "/-");
                            return mapping.findForward("display");
                        } else {
                            direct = 0;
                            int insertCount = (int) (transactionForm.getAmount() / installmentAmount);
                            for (int i = 0; i < insertCount; i++) {
                                Paymentdetails paymentdetails = new Paymentdetails();
                                ++lastterm;
                                paymentdetails.setTerm(lastterm);
                                listPaymentdetails.add(paymentdetails);
                            }
                        }
                    } else {
                        transactionForm.setMessage("Kindly check the entered amount. Amount not meets installment pattern. Installment Amount : " + installmentAmount + "/-");
                        return mapping.findForward("display");
                    }
                    boolean flag = false;
                    //update member complete=1
                    switch (direct) {
                        case 0:
                            if (noofinstallment == lastterm) {
                                flag = true;
                            }
                            break;
                        case 1:
                            if (transactionForm.getTerm() == noofinstallment) {
                                flag = true;
                            }
                            break;
                        default:
                            flag = false;
                            break;
                    }

                    int paymentid = objPaymentDAO.savePayment(payment, listPaymentdetails, flag, false);

                    String member = transactionForm.getSelectedmember();
                    int memberno = transactionForm.getMemberno();
                    int paidamount = objPaymentDAO.getTotalAmount(transactionForm.getMemberid());
                    new PrintBill().printreceipt(member.trim(), paidamount + "", memberno, transactionForm.getDate(), transactionForm.getAmount(), groups.getGroupname(), transactionForm.getPaymentmode(), paymentid, transactionForm.getRemarks());

                    SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
                    transactionForm.setDate(dat.format(new Date()));

                    transactionForm.setMessage("Payment entry is done successfully. Receipt No. : " + paymentid);

                    transactionForm.setAmount(500);
                    transactionForm.setPaymentmode("");
                    transactionForm.setRemarks("");
                    transactionForm.getLstPayment().clear();
                    session = request.getSession();
                    session.setAttribute("clear", "1");

                    fillPaymentDetails(mapping, form, request, response);

                }
                return mapping.findForward("display");
            } catch (ParseException e) {
                transactionForm.setMessage("The date you provided is in an invalid date format.");
                return mapping.findForward("display");
            } catch (Exception ex) {
                transactionForm.setMessage("Error while payment entry.");
                return mapping.findForward("display");
            } finally {
            }
        } else {
            return mapping.findForward("exp");
        }

    }

    public ActionForward editPayment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        transactionForm transactionForm = (transactionForm) form;
        if (Constants.isSessionActive(request)) {
            HttpSession session = request.getSession();
            boolean admin = (Boolean) session.getAttribute("admin");

            if (!admin) {
                transactionForm.setMessage("You are not authorized to do this action.");
                return mapping.findForward("display");
            }

            for (int i = 0; i < transactionForm.getLstPayment().size(); i++) {
                transactionDispBean object = transactionForm.getLstPayment().get(i);
                if (object.getTerm1() == transactionForm.getTerm()) {

                    List<Payment> lstpayment = new PaymentDAO().getPayment(object.getPaymentid1());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    transactionForm.setDate(format.format(lstpayment.get(0).getPaiddate()));
                    if (lstpayment.get(0).getPaymentmode() == 1) {
                        transactionForm.setPaymentmode("cash");
                    } else if (lstpayment.get(0).getPaymentmode() == 2) {
                        transactionForm.setPaymentmode("cheque");
                    }
                    transactionForm.setRemarks(lstpayment.get(0).getRemarks());
                    transactionForm.setAmount(lstpayment.get(0).getPaidamount().intValue());
                    transactionForm.setOldpayment(lstpayment.get(0).getPaidamount().intValue());
                    break;
                    //transactionForm.setMessage("Note : Amount can be changed only for last payment.");
                } else if (object.getTerm2() == transactionForm.getTerm()) {

                    List<Payment> lstpayment = new PaymentDAO().getPayment(object.getPaymentid2());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    transactionForm.setDate(format.format(lstpayment.get(0).getPaiddate()));
                    if (lstpayment.get(0).getPaymentmode() == 1) {
                        transactionForm.setPaymentmode("cash");
                    } else if (lstpayment.get(0).getPaymentmode() == 2) {
                        transactionForm.setPaymentmode("cheque");
                    }
                    transactionForm.setRemarks(lstpayment.get(0).getRemarks());
                    transactionForm.setAmount(lstpayment.get(0).getPaidamount().intValue());
                    transactionForm.setOldpayment(lstpayment.get(0).getPaidamount().intValue());
                    break;
                    //transactionForm.setMessage("Note : Amount can be changed only for last payment.");
                } else if (object.getTerm3() == transactionForm.getTerm()) {

                    List<Payment> lstpayment = new PaymentDAO().getPayment(object.getPaymentid3());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    transactionForm.setDate(format.format(lstpayment.get(0).getPaiddate()));
                    if (lstpayment.get(0).getPaymentmode() == 1) {
                        transactionForm.setPaymentmode("cash");
                    } else if (lstpayment.get(0).getPaymentmode() == 2) {
                        transactionForm.setPaymentmode("cheque");
                    }
                    transactionForm.setRemarks(lstpayment.get(0).getRemarks());
                    transactionForm.setAmount(lstpayment.get(0).getPaidamount().intValue());
                    transactionForm.setOldpayment(lstpayment.get(0).getPaidamount().intValue());
                    break;
                    //transactionForm.setMessage("Note : Amount can be changed only for last payment.");
                } else if (object.getTerm4() == transactionForm.getTerm()) {

                    List<Payment> lstpayment = new PaymentDAO().getPayment(object.getPaymentid4());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    transactionForm.setDate(format.format(lstpayment.get(0).getPaiddate()));
                    if (lstpayment.get(0).getPaymentmode() == 1) {
                        transactionForm.setPaymentmode("cash");
                    } else if (lstpayment.get(0).getPaymentmode() == 2) {
                        transactionForm.setPaymentmode("cheque");
                    }
                    transactionForm.setRemarks(lstpayment.get(0).getRemarks());
                    transactionForm.setAmount(lstpayment.get(0).getPaidamount().intValue());
                    transactionForm.setOldpayment(lstpayment.get(0).getPaidamount().intValue());
                    break;
                    //transactionForm.setMessage("Note : Amount can be changed only for last payment.");
                } else if (object.getTerm5() == transactionForm.getTerm()) {

                    List<Payment> lstpayment = new PaymentDAO().getPayment(object.getPaymentid5());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    transactionForm.setDate(format.format(lstpayment.get(0).getPaiddate()));
                    if (lstpayment.get(0).getPaymentmode() == 1) {
                        transactionForm.setPaymentmode("cash");
                    } else if (lstpayment.get(0).getPaymentmode() == 2) {
                        transactionForm.setPaymentmode("cheque");
                    }
                    transactionForm.setRemarks(lstpayment.get(0).getRemarks());
                    transactionForm.setAmount(lstpayment.get(0).getPaidamount().intValue());
                    transactionForm.setOldpayment(lstpayment.get(0).getPaidamount().intValue());
                    break;
                    //transactionForm.setMessage("Note : Amount can be changed only for last payment.");
                }
            }
            int lastterm = objPaymentDetails.getLastTerm(transactionForm.getMemberid());

            if (transactionForm.getTerm() == lastterm) {
                transactionForm.setUpdatepayment(1);
            } else {
                transactionForm.setUpdatepayment(0);
            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward updatePayment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;

            try {

                String date1 = transactionForm.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date testDate = null;

                testDate = sdf.parse(date1);
                // if the format of the string provided doesn't match the format we
                // declared in SimpleDateFormat() we will get an exception

                if (!sdf.format(testDate).equals(date1)) {
                    transactionForm.setMessage("The date that you provided is invalid.");
                    return mapping.findForward("display");
                }
                if (transactionForm.getMemberid() == 0) {
                    transactionForm.setMessage("Please select Member.");
                    return mapping.findForward("display");
                } else if (transactionForm.getPaymentmode().equals("")) {
                    transactionForm.setMessage("please select Payment mode.");
                    return mapping.findForward("display");
                }

                Payment payment = new Payment();
                payment.setPaidamount(Double.parseDouble(transactionForm.getAmount() + ""));

                payment.setPaiddate(testDate);

                payment.setMemberid(transactionForm.getMemberid());

                int paymentmodeid = 0;
                if (transactionForm.getPaymentmode().equalsIgnoreCase("cash")) {
                    paymentmodeid = 1;
                } else if (transactionForm.getPaymentmode().equalsIgnoreCase("cheque")) {
                    paymentmodeid = 2;
                }

                payment.setPaymentmode(paymentmodeid);

                payment.setRemarks(transactionForm.getRemarks());
                //get paid last term 
                //paid amount has to be divided by install amount
                int lastterm = objPaymentDetails.getLastTerm(transactionForm.getMemberid());

//last term==installmentterms, then all the installments are paid            
                Groups groups = (Groups) hmGroups.get(transactionForm.getGroupid() + "");
                int noofinstallment = groups.getNoofinstallment();

//            if (lastterm == noofinstallment && transactionForm.getDisable() == 0) {
//                transactionForm.setMessage("All installments are paid.");
//                return mapping.findForward("display");
//            } else {
//get installment amount
                Payment paymentobj = (Payment) hmPayments.get(transactionForm.getTerm() + "");
                double installmentAmount = groups.getInstallmentamount();
                List<Paymentdetails> listPaymentdetails = new ArrayList<Paymentdetails>();

                if ((transactionForm.getAmount() % installmentAmount) != 0.0) {
                    transactionForm.setMessage("Kindly check the selected amount. Amount not meets installment pattern. Installment Amount : " + installmentAmount + "/-");
                    return mapping.findForward("display");
                } else {
                    int insertCount = (int) (transactionForm.getAmount() / installmentAmount);
                    if (transactionForm.getUpdatepayment() == 1) {
                        int insertCountOLD = (int) (transactionForm.getOldpayment() / installmentAmount);

                        if (insertCount > insertCountOLD) {
                            if ((insertCount + lastterm) > noofinstallment) {
                                transactionForm.setMessage("Amount is exceeding no of installments of the Scheme.");
                                return mapping.findForward("display");
                            }
                            objPaymentDetails.insertPaymentDetails(paymentobj.getPaymentid(), insertCount - insertCountOLD, lastterm);
                            List<Paymentdetails> lstpd = objPaymentDetails.getPaymentDetailsData(paymentobj.getPaymentid());
                            for (int i = 0; i < lstpd.size(); i++) {
                                Paymentdetails paymentdetails = lstpd.get(i);
                                listPaymentdetails.add(paymentdetails);
                            }
                        } else if (insertCount < insertCountOLD) {
//delete one row of payment daetails
                            objPaymentDetails.deletePaymentDetails(paymentobj.getPaymentid(), (insertCountOLD - insertCount));

                            List<Paymentdetails> lstpd = objPaymentDetails.getPaymentDetailsData(paymentobj.getPaymentid());
                            for (int i = 0; i < lstpd.size(); i++) {
                                Paymentdetails paymentdetails = lstpd.get(i);
                                listPaymentdetails.add(paymentdetails);
                            }
                        } else if (insertCount == insertCountOLD) {

                            List<Paymentdetails> lstpd = objPaymentDetails.getPaymentDetailsData(paymentobj.getPaymentid());
                            for (int i = 0; i < lstpd.size(); i++) {
                                Paymentdetails paymentdetails = lstpd.get(i);
                                listPaymentdetails.add(paymentdetails);
                            }
                        }

                    } else {
                        payment.setPaidamount(Double.parseDouble(transactionForm.getOldpayment() + ""));
                        List<Paymentdetails> lstpd = objPaymentDetails.getPaymentDetailsData(paymentobj.getPaymentid());
                        for (int i = 0; i < lstpd.size(); i++) {
                            Paymentdetails paymentdetails = lstpd.get(i);
                            listPaymentdetails.add(paymentdetails);
                        }
                    }
                }

                boolean flag = false;
                lastterm = objPaymentDetails.getLastTerm(transactionForm.getMemberid());

                if (noofinstallment == lastterm) {
                    //update member complete=1

                    flag = true;
                }

                Payment obj = (Payment) hmPayments.get(transactionForm.getTerm() + "");
                payment.setPaymentid(obj.getPaymentid());
                int paymentid = objPaymentDAO.savePayment(payment, listPaymentdetails, flag, true);

                String member = transactionForm.getSelectedmember();
                int memberno = transactionForm.getMemberno();
                int paidamount = objPaymentDAO.getTotalAmount(transactionForm.getMemberid());
                new PrintBill().printreceipt(member.trim(), paidamount + "", memberno, transactionForm.getDate(), transactionForm.getAmount(), groups.getGroupname(), transactionForm.getPaymentmode(), paymentid, transactionForm.getRemarks());

                SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
                transactionForm.setDate(dat.format(new Date()));

                transactionForm.setMessage("Payment updated is done successfully. Receipt No. : " + paymentid);

                transactionForm.setAmount(500);
                transactionForm.setPaymentmode("");
                transactionForm.setRemarks("");
                transactionForm.getLstPayment().clear();
                HttpSession session = request.getSession();
                boolean admin = (Boolean) session.getAttribute("admin");

                session = request.getSession();
                session.setAttribute("clear", "1");

                fillPaymentDetails(mapping, form, request, response);
                //}
            } catch (ParseException e) {
                transactionForm.setMessage("The date you provided is in an invalid date format.");
            } catch (Exception ex) {
                transactionForm.setMessage("Error while payment update.");
            } finally {
            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward cancelPayment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;

            HttpSession session = request.getSession();
            boolean admin = (Boolean) session.getAttribute("admin");

            if (!admin) {
                transactionForm.setMessage("You are not authorized to do this action.");
                return mapping.findForward("display");
            }
            try {
                if (transactionForm.getTerm() != 0) {
                    boolean isDrawExist = new DrawDetailsDAO().isDrawExist(transactionForm.getMemberid(), transactionForm.getTerm());
                    if (!isDrawExist) {
                        for (int i = 0; i < transactionForm.getLstPayment().size(); i++) {
                            transactionDispBean paymentHistory = transactionForm.getLstPayment().get(i);

                            if (paymentHistory.getTerm1() == transactionForm.getTerm()) {

                                objPaymentDAO.cancelPayment(paymentHistory.getPaymentid1());
                                break;
                            } else if (paymentHistory.getTerm2() == transactionForm.getTerm()) {
                                objPaymentDAO.cancelPayment(paymentHistory.getPaymentid2());
                                break;
                            } else if (paymentHistory.getTerm3() == transactionForm.getTerm()) {
                                objPaymentDAO.cancelPayment(paymentHistory.getPaymentid3());
                                break;
                            } else if (paymentHistory.getTerm4() == transactionForm.getTerm()) {
                                objPaymentDAO.cancelPayment(paymentHistory.getPaymentid4());
                                break;
                            } else if (paymentHistory.getTerm5() == transactionForm.getTerm()) {
                                objPaymentDAO.cancelPayment(paymentHistory.getPaymentid5());
                                break;
                            }
                        }

                        transactionForm.setMessage("Payment Entry is deleted.");
                        transactionForm.setLstPayment(new ArrayList<transactionDispBean>());
                        transactionForm = new transactionForm();

                        session = request.getSession();
                        session.setAttribute("clear", "1");
                        fillPaymentDetails(mapping, form, request, response);
                    } else {
                        transactionForm.setMessage("Payement cannot be deleted.Draw entry found.");
                    }
                }
            } catch (Exception e) {
                transactionForm.setMessage("Error while deleting payment entry.");

            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward printReciept(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;

            String membername = transactionForm.getSelectedmember();
            int memberno = transactionForm.getMemberno();
            int paidamount = objPaymentDAO.getTotalAmount(transactionForm.getMemberid());
            Payment payment = (Payment) hmPayments.get(transactionForm.getTerm() + "");
            Groups group = (Groups) hmGroups.get(transactionForm.getGroupid() + "");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String paymentmode = payment.getPaymentmode() == 1 ? "Cash" : "Cheque/NEFT";

            new PrintBill().printreceipt(membername, paidamount + "", memberno, dateFormat.format(payment.getPaiddate()), payment.getPaidamount().intValue(), group.getGroupname(), paymentmode, payment.getPaymentid(), payment.getRemarks());

            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward savePrize(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;
            try {
                String date1 = transactionForm.getDrawdate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date testDate = null;
                testDate = sdf.parse(date1);
                // if the format of the string provided doesn't match the format we
                // declared in SimpleDateFormat() we will get an exception
                if (!sdf.format(testDate).equals(date1)) {
                    transactionForm.setMessage("The date that you provided is invalid.");
                    return mapping.findForward("display");
                }

                Drawdetails objsave = new Drawdetails();
                objsave.setTerm(transactionForm.getTerm());

                Calendar cal = Calendar.getInstance();
// Set time fields to zero
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
// Put it back in the Date object

                cal.set(Calendar.DATE, Integer.parseInt(transactionForm.getDrawdate().split("/")[0]));
                cal.set(Calendar.MONTH, Integer.parseInt(transactionForm.getDrawdate().split("/")[1]) - 1);
                cal.set(Calendar.YEAR, Integer.parseInt(transactionForm.getDrawdate().split("/")[2]));

                Date date = cal.getTime();
                objsave.setDrawdate(date);

                objsave.setMemberid(transactionForm.getMemberid());
                objsave.setAmount(transactionForm.getPrizeamount());
                objsave.setDrawtypeid(transactionForm.getDrawtypeid());
                DrawDetailsDAO.Save(objsave, true);

                transactionForm.setMessage("Prize added successfuly.");
                transactionForm.setDrawtypeid(0);
                transactionForm.setPrizeamount(0);
                SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
                transactionForm.setDrawdate(dat.format(new Date()));
                transactionForm.setLstPayment(new ArrayList<transactionDispBean>());
                transactionForm = new transactionForm();
                HttpSession session = request.getSession();
                session.setAttribute("clear", "1");
                fillPaymentDetails(mapping, form, request, response);
            } catch (ParseException e) {
                transactionForm.setMessage("The date you provided is in an invalid date format.");
            } catch (Exception e) {
                transactionForm.setMessage("Error while saving.");
            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward deletePrize(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        transactionForm drawForm = (transactionForm) form;
        if (Constants.isSessionActive(request)) {
            HttpSession session = request.getSession();
            boolean admin = (Boolean) session.getAttribute("admin");

            if (!admin) {
                drawForm.setMessage("You are not authorized to do this action.");
                return mapping.findForward("display");
            }
            try {
                if (drawForm.getTerm() != 0) {
                    for (int i = 0; i < drawForm.getLstPayment().size(); i++) {
                        transactionDispBean drawdetails = drawForm.getLstPayment().get(i);

                        if (drawdetails.getTerm1() == drawForm.getTerm()) {
                            //delete query
                            new DrawDetailsDAO().delete(drawdetails.getDrawid1());
                        } else if (drawdetails.getTerm2() == drawForm.getTerm()) {
                            //delete query
                            new DrawDetailsDAO().delete(drawdetails.getDrawid2());
                        } else if (drawdetails.getTerm3() == drawForm.getTerm()) {
                            //delete query
                            new DrawDetailsDAO().delete(drawdetails.getDrawid3());
                        } else if (drawdetails.getTerm4() == drawForm.getTerm()) {
                            //delete query
                            new DrawDetailsDAO().delete(drawdetails.getDrawid4());
                        } else if (drawdetails.getTerm5() == drawForm.getTerm()) {
                            //delete query
                            new DrawDetailsDAO().delete(drawdetails.getDrawid5());
                        }
                    }
                    drawForm.setMessage("Prize entry deleted.");
                    drawForm.setDrawtypeid(0);
                    //drawForm.setDrawtypes(new ArrayList());
                    drawForm.setAmount(0);
                    drawForm.setTerm(0);
                    drawForm.getLstPayment().clear();
                    SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
                    drawForm.setDrawdate(dat.format(new Date()));
                    session = request.getSession();
                    session.setAttribute("clear", "1");
                    fillPaymentDetails(mapping, form, request, response);
                } else {
                    drawForm.setMessage("");
                }

            } catch (Exception e) {
            }

            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward saveStartdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;
            try {
                String date1 = transactionForm.getActualstartdate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date testDate = null;
                testDate = sdf.parse(date1);
                // if the format of the string provided doesn't match the format we
                // declared in SimpleDateFormat() we will get an exception
                if (!sdf.format(testDate).equals(date1)) {
                    transactionForm.setMessage("The date that you have provided is invalid.");
                    return mapping.findForward("display");
                }

                Groups objsave = new Groups();

                Calendar cal = Calendar.getInstance();
// Set time fields to zero
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
// Put it back in the Date object

                cal.set(Calendar.DATE, Integer.parseInt(transactionForm.getActualstartdate().split("/")[0]));
                cal.set(Calendar.MONTH, Integer.parseInt(transactionForm.getActualstartdate().split("/")[1]) - 1);
                cal.set(Calendar.YEAR, Integer.parseInt(transactionForm.getActualstartdate().split("/")[2]));

                Date date = cal.getTime();

                objsave = new GroupsDAO().getGroupDetails(transactionForm.getGroupid());
                objsave.setActualstartdate(date);

                new GroupsDAO().saveGroup(objsave, true);

                transactionForm.setMessage("Actual start date updated successfuly.");

                SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
                transactionForm.setActualstartdate(dat.format(new Date()));
                HttpSession session = request.getSession();
                session.setAttribute("clear", "1");
                fillPaymentDetails(mapping, form, request, response);
            } catch (ParseException e) {
                transactionForm.setMessage("The date you provided is in an invalid date format.");
            } catch (NumberFormatException e) {
                transactionForm.setMessage("Error while updating");
            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }

    public ActionForward accountSettlement(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;
            try {
                String remarks = transactionForm.getSettlementcomment();
                objMemebrsDAO.updateMember(transactionForm.getMemberid(), remarks);
                transactionForm.setMessage(transactionForm.getSelectedmember() + " Scheme account has been settled.");
                HttpSession session = request.getSession();
                session.setAttribute("clear", "1");
                fillPaymentDetails(mapping, form, request, response);
            } catch (Exception e) {
                transactionForm.setMessage("Error while updating");
            }
            return mapping.findForward("display");
        } else {
            return mapping.findForward("exp");
        }
    }
    Font font = FontFactory.getFont(FontFactory.HELVETICA, 8);

    public ActionForward generatememberreport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        if (Constants.isSessionActive(request)) {
            transactionForm transactionForm = (transactionForm) form;
            try {
                Date utilDate = new Date();
                java.sql.Date date = new java.sql.Date(utilDate.getTime());
                Font bigFont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 12, Font.BOLD, BaseColor.BLACK);
                Font bigFont_Uderline = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 12, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
                Font boldfont = FontFactory.getFont(FontFactory.HELVETICA, "Windows-1254", 9, Font.BOLD);

                Document document = new Document();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PdfWriter.getInstance(document, baos);
                document.open();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Or whatever format fits best your needs.

                Paragraph para1 = new Paragraph("PALKE JEWELLERS", bigFont);
                para1.setAlignment(Element.ALIGN_CENTER);
                document.add(para1);

                para1 = new Paragraph("MEMBER ACCOUNT DETAILS", bigFont);
                para1.setAlignment(Element.ALIGN_CENTER);
                document.add(para1);

                para1 = new Paragraph(transactionForm.getSelectedmember(), boldfont);
                para1.setAlignment(Element.ALIGN_LEFT);
                document.add(para1);

                para1 = new Paragraph(transactionForm.getMemberaddress() + "\n" + transactionForm.getMembercontactno(), boldfont);
                para1.setAlignment(Element.ALIGN_LEFT);
                document.add(para1);
                Groups obj = (Groups) hmGroups.get(transactionForm.getGroupid() + "");
                if (obj != null) {
                    para1 = new Paragraph("Group : " + obj.getGroupname(), font);
                    para1.setAlignment(Element.ALIGN_LEFT);
                    document.add(para1);

                    para1 = new Paragraph("Paid Amount : " + transactionForm.getTotalpaidamount(), font);
                    para1.setAlignment(Element.ALIGN_LEFT);
                    document.add(para1);

                    para1 = new Paragraph("Prize Amount : " + transactionForm.getDrawamount(), font);
                    para1.setAlignment(Element.ALIGN_LEFT);
                    document.add(para1);

                    para1 = new Paragraph("Total Amount : " + transactionForm.getTotalamount(), boldfont);
                    para1.setAlignment(Element.ALIGN_LEFT);
                    document.add(para1);

                    para1 = new Paragraph("Status : " + transactionForm.getStatus(), boldfont);
                    para1.setAlignment(Element.ALIGN_RIGHT);
                    document.add(para1);

                    if (transactionForm.getStatus().equalsIgnoreCase("Settled")) {
                        para1 = new Paragraph(transactionForm.getSettlementcomment(), boldfont);
                        para1.setAlignment(Element.ALIGN_RIGHT);
                        document.add(para1);
                    }

                    String dateStr = sdf.format(date);
                    para1 = new Paragraph("DATED:" + dateStr, font);
                    para1.setAlignment(Element.ALIGN_RIGHT);
                    document.add(para1);

                    // add a couple of blank lines
                    document.add(Chunk.NEWLINE);

                    if (transactionForm.getLstPayment() != null && transactionForm.getLstPayment().size() > 0) {
                        PdfPTable table2 = new PdfPTable(7);
                        float[] columnWidths = {1.5f, 1.5f, 3f, 4f, 4f, 7f, 2f};

                        table2.setWidthPercentage(100);
                        table2.setWidths(columnWidths);

                        para1 = new Paragraph("Sl No.", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        PdfPCell cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        para1 = new Paragraph("Term", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        para1 = new Paragraph("Receipt No.", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        para1 = new Paragraph("Receipt Date", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        para1 = new Paragraph("Payment Mode", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        para1 = new Paragraph("Remarks", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        para1 = new Paragraph("Paid Amount", font);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        cell = new PdfPCell(para1);
                        table2.addCell(cell);

                        int x = 1;
                        double total = 0;
                        //Iterator it = hmPayments.entrySet().iterator();
                        //while (it.hasNext()) {
                        if (hmPayments.size() > 0) {
                            for (int i = 1; i <= obj.getNoofinstallment(); i++) {
                                //float f = columnWidths[i];
                                Payment f1 = (Payment) hmPayments.get(i + "");
                                //}
                                //Map.Entry pairs = (Map.Entry) it.next();
                                //Payment f1 = (Payment) pairs.getValue();
                                String term = i + "";

                                para1 = new Paragraph(Integer.toString(x), font);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);
                                x++;

                                para1 = new Paragraph(term, font);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);

                                para1 = new Paragraph(f1.getPaymentid() + "", font);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);

                                para1 = new Paragraph(sdf.format(f1.getPaiddate()), font);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);

                                para1 = new Paragraph(f1.getPaymentmode() == 1 ? "Cash" : "Cheque/NEFT", font);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);

                                para1 = new Paragraph(f1.getRemarks(), font);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);

                                //para1 = new Paragraph(f1.getPaidamount() + "", boldfont);
                                para1 = new Paragraph((int) obj.getInstallmentamount() + "", boldfont);
                                para1.setAlignment(Element.ALIGN_CENTER);
                                cell = new PdfPCell(para1);
                                table2.addCell(cell);
                                total = total + obj.getInstallmentamount();
                                if (hmPayments.size() == i) {
                                    break;
                                }
                            }

                            para1 = new Paragraph("Total", boldfont);
                            para1.setAlignment(Element.ALIGN_LEFT);
                            cell = new PdfPCell(para1);
                            cell.setColspan(6);
                            table2.addCell(cell);

                            //String numberStr = String.format("%.2f", total + "");
                            para1 = new Paragraph(total + "", boldfont);
                            para1.setAlignment(Element.ALIGN_CENTER);
                            cell = new PdfPCell(para1);
                            //cell.setColspan(7);
                            table2.addCell(cell);

                            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
                            document.add(table2);
                        } else {
                            para1 = new Paragraph("NO PAYMENTS FOUND", boldfont);
                            para1.setAlignment(Element.ALIGN_CENTER);
                            document.add(para1);
                        }

                    } else {
                        para1 = new Paragraph("NO RECORDS FOUND", boldfont);
                        para1.setAlignment(Element.ALIGN_CENTER);
                        document.add(para1);
                    }
                    document.add(Chunk.NEWLINE);

                    //document.close();
                    //fileInputStream = new FileInputStream(new File("C:\\reports\\PaymentReports.pdf"));
                    document.close();
                    ServletOutputStream outputStream = response.getOutputStream();
                    baos.writeTo(outputStream);
                    response.setHeader("Content-Disposition", "attachment; filename=\"PaymentStatusReport.pdf\"");
                    response.setContentType("application/pdf");
                    outputStream.flush();
                    outputStream.close();
                    return mapping.findForward("display");
                } else {
                    para1 = new Paragraph("NO RECORDS FOUND", boldfont);
                    para1.setAlignment(Element.ALIGN_CENTER);
                    document.add(para1);
                    document.close();
                    ServletOutputStream outputStream = response.getOutputStream();
                    baos.writeTo(outputStream);
                    response.setHeader("Content-Disposition", "attachment; filename=\"PaymentStatusReport.pdf\"");
                    response.setContentType("application/pdf");
                    outputStream.flush();
                    outputStream.close();
                    return mapping.findForward("display");
                }
            } catch (DocumentException i) {
                System.out.println(i);
                return mapping.findForward("fail");
            } catch (IOException i) {
                System.out.println(i);
                return mapping.findForward("fail");
            }
        } else {
            return mapping.findForward("exp");
        }
    }
}
