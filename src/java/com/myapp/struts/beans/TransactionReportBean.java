package com.myapp.struts.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionReportBean implements Serializable{

    private String date;
    private double credit;
    private double debit;
    private double balance;
    /*  21 */    private List<DetailsBean> lstcredit = new ArrayList();
    /*  22 */    private List<DetailsBean> lstdebit = new ArrayList();

    /*  24 */    private List<DetailsBean> lstreceipt = new ArrayList();
    /*  25 */    private List<DetailsBean> lstsales = new ArrayList();
    private double netweightbalance;
    private double grossweightbalance;

    public TransactionReportBean() {
    }

    public TransactionReportBean(String date, double credit, double debit, double balance, double netweightbalance, double grossweightbalance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
        this.netweightbalance = netweightbalance;
        this.grossweightbalance = grossweightbalance;
    }

    public double getNetweightbalance() {
        /*  42 */ return this.netweightbalance;
    }

    public void setNetweightbalance(double netweightbalance) {
        /*  46 */ this.netweightbalance = netweightbalance;
    }

    public double getGrossweightbalance() {
        /*  50 */ return this.grossweightbalance;
    }

    public void setGrossweightbalance(double grossweightbalance) {
        /*  54 */ this.grossweightbalance = grossweightbalance;
    }

    public List<DetailsBean> getLstreceipt() {
        /*  58 */ return this.lstreceipt;
    }

    public void setLstreceipt(List<DetailsBean> lstreceipt) {
        /*  62 */ this.lstreceipt = lstreceipt;
    }

    public List<DetailsBean> getLstsales() {
        /*  66 */ return this.lstsales;
    }

    public void setLstsales(List<DetailsBean> lstsales) {
        /*  70 */ this.lstsales = lstsales;
    }

    public double getBalance() {
        /*  74 */ return this.balance;
    }

    public void setBalance(double balance) {
        /*  78 */ this.balance = balance;
    }

    public List<DetailsBean> getLstcredit() {
        /*  82 */ return this.lstcredit;
    }

    public void setLstcredit(List<DetailsBean> lstcredit) {
        /*  86 */ this.lstcredit = lstcredit;
    }

    public List<DetailsBean> getLstdebit() {
        /*  90 */ return this.lstdebit;
    }

    public void setLstdebit(List<DetailsBean> lstdebit) {
        /*  94 */ this.lstdebit = lstdebit;
    }

    public String getDate() {
        /*  98 */ return this.date;
    }

    public void setDate(String date) {
        /* 102 */ this.date = date;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\TransactionReportBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
