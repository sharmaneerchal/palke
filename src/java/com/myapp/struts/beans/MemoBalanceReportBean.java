/*    */ package com.myapp.struts.beans;

/*    */
import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;

/*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */
 /*    */ public class MemoBalanceReportBean implements Serializable/*    */ {

    /*    */ private int memono;
    /*    */    private Date memodate;
    /*    */    private double goldweight;
    /*    */    private double totalgrossweight;
    /*    */    private double totalnetweight;
    /*    */    private double netbalance;
    /*    */    private double grossbalance;
    /* 25 */    private List<BalanceDetails> lstDetails = new ArrayList();

    /*    */
 /*    */ public double getNetbalance() {
        /* 28 */ return this.netbalance;
        /*    */    }

    /*    */
 /*    */ public void setNetbalance(double netbalance) {
        /* 32 */ this.netbalance = netbalance;
        /*    */    }

    /*    */
 /*    */ public double getGrossbalance() {
        /* 36 */ return this.grossbalance;
        /*    */    }

    /*    */
 /*    */ public void setGrossbalance(double grossbalance) {
        /* 40 */ this.grossbalance = grossbalance;
        /*    */    }

    /*    */
 /*    */ public double getTotalgrossweight() {
        /* 44 */ return this.totalgrossweight;
        /*    */    }

    /*    */
 /*    */ public void setTotalgrossweight(double totalgrossweight) {
        /* 48 */ this.totalgrossweight = totalgrossweight;
        /*    */    }

    /*    */
 /*    */ public double getTotalnetweight() {
        /* 52 */ return this.totalnetweight;
        /*    */    }

    /*    */
 /*    */ public void setTotalnetweight(double totalnetweight) {
        /* 56 */ this.totalnetweight = totalnetweight;
        /*    */    }

    /*    */
 /*    */ public List<BalanceDetails> getLstDetails() {
        /* 60 */ return this.lstDetails;
        /*    */    }

    /*    */
 /*    */ public void setLstDetails(List<BalanceDetails> lstDetails) {
        /* 64 */ this.lstDetails = lstDetails;
        /*    */    }

    /*    */
 /*    */ public int getMemono() {
        /* 68 */ return this.memono;
        /*    */    }

    /*    */
 /*    */ public void setMemono(int memono) {
        /* 72 */ this.memono = memono;
        /*    */    }

    /*    */
 /*    */ public Date getMemodate() {
        /* 76 */ return this.memodate;
        /*    */    }

    /*    */
 /*    */ public void setMemodate(Date memodate) {
        /* 80 */ this.memodate = memodate;
        /*    */    }

    /*    */
 /*    */ public double getGoldweight() {
        /* 84 */ return this.goldweight;
        /*    */    }

    /*    */
 /*    */ public void setGoldweight(double goldweight) {
        /* 88 */ this.goldweight = goldweight;
        /*    */    }
    /*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\MemoBalanceReportBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
