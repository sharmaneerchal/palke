package com.myapp.struts.transactionreport;

import com.myapp.struts.beans.TransactionReportBean;
import com.myapp.struts.beans.YearsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;

public class TransactionReportForm
        extends ActionForm {

    private double credittotal1;
    private double debittotal1;
    private double balancetotal1;
    private double credittotal2;
    private double debittotal2;
    private double balancetotal2;
    private double credittotal3;
    private double debittotal3;
    private double balancetotal3;
    private double credittotal4;
    private double debittotal4;
    private double balancetotal4;
    private double credittotal;
    private double debittotal;
    private double balancetotal;
    private String type;
    private Date reportdate;
    private String year;
    private String message;
    private double carrybalance;
    private double netcarryBalance;
    private double grosscarryBalance;

    private String fromdate;
    private String todate;

    /*  46 */    private List<TransactionReportBean> lsttrgold = new ArrayList();
    /*  47 */    private List<TransactionReportBean> lsttrsilver = new ArrayList();
    /*  48 */    private List<TransactionReportBean> lsttrstone = new ArrayList();
    /*  49 */    private List<TransactionReportBean> lsttrdiamond = new ArrayList();

    /*  51 */    private List<TransactionReportBean> lstjewel = new ArrayList();

    /*  53 */    private List<TransactionReportBean> lstprint = new ArrayList();

    /*  55 */    private List<YearsBean> lstyears = new ArrayList();

    public TransactionReportForm(double credittotal1, double debittotal1, double balancetotal1, double credittotal2, double debittotal2, double balancetotal2, double credittotal3, double debittotal3, double balancetotal3, double credittotal4, double debittotal4, double balancetotal4, double credittotal, double debittotal, double balancetotal, String type, Date reportdate, String year, String message, double carrybalance, double netcarryBalance, double grosscarryBalance, String fromDate, String todate) {
        this.credittotal1 = credittotal1;
        this.debittotal1 = debittotal1;
        this.balancetotal1 = balancetotal1;
        this.credittotal2 = credittotal2;
        this.debittotal2 = debittotal2;
        this.balancetotal2 = balancetotal2;
        this.credittotal3 = credittotal3;
        this.debittotal3 = debittotal3;
        this.balancetotal3 = balancetotal3;
        this.credittotal4 = credittotal4;
        this.debittotal4 = debittotal4;
        this.balancetotal4 = balancetotal4;
        this.credittotal = credittotal;
        this.debittotal = debittotal;
        this.balancetotal = balancetotal;
        this.type = type;
        this.reportdate = reportdate;
        this.year = year;
        this.message = message;
        this.carrybalance = carrybalance;
        this.netcarryBalance = netcarryBalance;
        this.grosscarryBalance = grosscarryBalance;
        this.fromdate = fromDate;
        this.todate = todate;
    }

    public TransactionReportForm() {
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public double getCarrybalance() {
        /*  86 */ return this.carrybalance;
    }

    public double getNetcarryBalance() {
        /*  90 */ return this.netcarryBalance;
    }

    public void setNetcarryBalance(double netcarryBalance) {
        /*  94 */ this.netcarryBalance = netcarryBalance;
    }

    public double getGrosscarryBalance() {
        /*  98 */ return this.grosscarryBalance;
    }

    public void setGrosscarryBalance(double grosscarryBalance) {
        /* 102 */ this.grosscarryBalance = grosscarryBalance;
    }

    public void setCarrybalance(double carrybalance) {
        /* 106 */ this.carrybalance = carrybalance;
    }

    public List<TransactionReportBean> getLstjewel() {
        /* 110 */ return this.lstjewel;
    }

    public void setLstjewel(List<TransactionReportBean> lstjewel) {
        /* 114 */ this.lstjewel = lstjewel;
    }

    public List<YearsBean> getLstyears() {
        /* 118 */ return this.lstyears;
    }

    public void setLstyears(List<YearsBean> lstyears) {
        /* 122 */ this.lstyears = lstyears;
    }

    public String getYear() {
        /* 126 */ return this.year;
    }

    public void setYear(String year) {
        /* 130 */ this.year = year;
    }

    public List<TransactionReportBean> getLstprint() {
        /* 134 */ return this.lstprint;
    }

    public void setLstprint(List<TransactionReportBean> lstprint) {
        /* 138 */ this.lstprint = lstprint;
    }

    public double getCredittotal() {
        /* 142 */ return this.credittotal;
    }

    public void setCredittotal(double credittotal) {
        /* 146 */ this.credittotal = credittotal;
    }

    public double getDebittotal() {
        /* 150 */ return this.debittotal;
    }

    public void setDebittotal(double debittotal) {
        /* 154 */ this.debittotal = debittotal;
    }

    public double getBalancetotal() {
        /* 158 */ return this.balancetotal;
    }

    public void setBalancetotal(double balancetotal) {
        /* 162 */ this.balancetotal = balancetotal;
    }

    public String getType() {
        /* 166 */ return this.type;
    }

    public void setType(String type) {
        /* 170 */ this.type = type;
    }

    public String getMessage() {
        /* 174 */ return this.message;
    }

    public void setMessage(String message) {
        /* 178 */ this.message = message;
    }

    public List<TransactionReportBean> getLsttrgold() {
        /* 182 */ return this.lsttrgold;
    }

    public void setLsttrgold(List<TransactionReportBean> lsttrgold) {
        /* 186 */ this.lsttrgold = lsttrgold;
    }

    public List<TransactionReportBean> getLsttrsilver() {
        /* 190 */ return this.lsttrsilver;
    }

    public void setLsttrsilver(List<TransactionReportBean> lsttrsilver) {
        /* 194 */ this.lsttrsilver = lsttrsilver;
    }

    public List<TransactionReportBean> getLsttrstone() {
        /* 198 */ return this.lsttrstone;
    }

    public void setLsttrstone(List<TransactionReportBean> lsttrstone) {
        /* 202 */ this.lsttrstone = lsttrstone;
    }

    public List<TransactionReportBean> getLsttrdiamond() {
        /* 206 */ return this.lsttrdiamond;
    }

    public void setLsttrdiamond(List<TransactionReportBean> lsttrdiamond) {
        /* 210 */ this.lsttrdiamond = lsttrdiamond;
    }

    public double getCredittotal1() {
        /* 214 */ return this.credittotal1;
    }

    public void setCredittotal1(double credittotal1) {
        /* 218 */ this.credittotal1 = credittotal1;
    }

    public double getDebittotal1() {
        /* 222 */ return this.debittotal1;
    }

    public void setDebittotal1(double debittotal1) {
        /* 226 */ this.debittotal1 = debittotal1;
    }

    public double getBalancetotal1() {
        /* 230 */ return this.balancetotal1;
    }

    public void setBalancetotal1(double balancetotal1) {
        /* 234 */ this.balancetotal1 = balancetotal1;
    }

    public double getCredittotal2() {
        /* 238 */ return this.credittotal2;
    }

    public void setCredittotal2(double credittotal2) {
        /* 242 */ this.credittotal2 = credittotal2;
    }

    public double getDebittotal2() {
        /* 246 */ return this.debittotal2;
    }

    public void setDebittotal2(double debittotal2) {
        /* 250 */ this.debittotal2 = debittotal2;
    }

    public double getBalancetotal2() {
        /* 254 */ return this.balancetotal2;
    }

    public void setBalancetotal2(double balancetotal2) {
        /* 258 */ this.balancetotal2 = balancetotal2;
    }

    public double getCredittotal3() {
        /* 262 */ return this.credittotal3;
    }

    public void setCredittotal3(double credittotal3) {
        /* 266 */ this.credittotal3 = credittotal3;
    }

    public double getDebittotal3() {
        /* 270 */ return this.debittotal3;
    }

    public void setDebittotal3(double debittotal3) {
        /* 274 */ this.debittotal3 = debittotal3;
    }

    public double getBalancetotal3() {
        /* 278 */ return this.balancetotal3;
    }

    public void setBalancetotal3(double balancetotal3) {
        /* 282 */ this.balancetotal3 = balancetotal3;
    }

    public double getCredittotal4() {
        /* 286 */ return this.credittotal4;
    }

    public void setCredittotal4(double credittotal4) {
        /* 290 */ this.credittotal4 = credittotal4;
    }

    public double getDebittotal4() {
        /* 294 */ return this.debittotal4;
    }

    public void setDebittotal4(double debittotal4) {
        /* 298 */ this.debittotal4 = debittotal4;
    }

    public double getBalancetotal4() {
        /* 302 */ return this.balancetotal4;
    }

    public void setBalancetotal4(double balancetotal4) {
        /* 306 */ this.balancetotal4 = balancetotal4;
    }

    public Date getReportdate() {
        /* 310 */ return this.reportdate;
    }

    public void setReportdate(Date reportdate) {
        /* 314 */ this.reportdate = reportdate;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\transactionreport\TransactionReportForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
