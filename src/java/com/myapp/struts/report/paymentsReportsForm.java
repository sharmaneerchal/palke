/*    */ package com.myapp.struts.report;

/*    */
 /*    */ import com.myapp.struts.beans.paymentstatus;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.apache.struts.action.ActionForm;

/*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */ public class paymentsReportsForm
        /*    */ extends ActionForm /*    */ {

    /*    */ private int groupid;
    /*    */    private List groups;
    /*    */    private String fromDate;
    /*    */    private String toDate;
    /*    */    private int fromno;
    /*    */    private int tono;
    /*    */    private int totalamount;
    /* 28 */    private List<paymentstatus> lstpaymentstatus = new ArrayList();

    /*    */
 /*    */ public paymentsReportsForm() {
        /* 31 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        /* 32 */ this.fromDate = sdf.format(new Date());
        /* 33 */ this.toDate = sdf.format(new Date());
        /*    */    }

    /*    */
 /*    */ public int getFromno() {
        /* 37 */ return this.fromno;
        /*    */    }

    /*    */
 /*    */ public void setFromno(int fromno) {
        /* 41 */ this.fromno = fromno;
        /*    */    }

    /*    */
 /*    */ public int getTono() {
        /* 45 */ return this.tono;
        /*    */    }

    /*    */
 /*    */ public void setTono(int tono) {
        /* 49 */ this.tono = tono;
        /*    */    }

    /*    */
 /*    */ public int getTotalamount() {
        /* 53 */ return this.totalamount;
        /*    */    }

    /*    */
 /*    */ public void setTotalamount(int totalamount) {
        /* 57 */ this.totalamount = totalamount;
        /*    */    }

    /*    */
 /*    */ public List<paymentstatus> getLstpaymentstatus() {
        /* 61 */ return this.lstpaymentstatus;
        /*    */    }

    /*    */
 /*    */ public void setLstpaymentstatus(List<paymentstatus> lstpaymentstatus) {
        /* 65 */ this.lstpaymentstatus = lstpaymentstatus;
        /*    */    }

    /*    */
 /*    */ public String getFromDate() {
        /* 69 */ return this.fromDate;
        /*    */    }

    /*    */
 /*    */ public void setFromDate(String fromDate) {
        /* 73 */ this.fromDate = fromDate;
        /*    */    }

    /*    */
 /*    */ public String getToDate() {
        /* 77 */ return this.toDate;
        /*    */    }

    /*    */
 /*    */ public void setToDate(String toDate) {
        /* 81 */ this.toDate = toDate;
        /*    */    }

    /*    */
 /*    */ public int getGroupid() {
        /* 85 */ return this.groupid;
        /*    */    }

    /*    */
 /*    */ public void setGroupid(int groupid) {
        /* 89 */ this.groupid = groupid;
        /*    */    }

    /*    */
 /*    */ public List getGroups() {
        /* 93 */ return this.groups;
        /*    */    }

    /*    */
 /*    */ public void setGroups(List groups) {
        /* 97 */ this.groups = groups;
        /*    */    }
    /*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\report\paymentsReportsForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
