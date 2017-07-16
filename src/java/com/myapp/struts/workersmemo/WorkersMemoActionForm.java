package com.myapp.struts.workersmemo;

import com.myapp.struts.beans.WorkersMemoBean;
import java.util.ArrayList;
import java.util.List;
import mappings.Employees;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;

public class WorkersMemoActionForm
        extends ActionForm {

    private int workersmemoid;
    private String workermemono;
    private String orderno;
    private String date;
    private String employee;
    private int employeeid;
    private double goldweight;
    private double silverweight;
    private double stoneweight;
    private double diamondweight;
    private String remarks;
    private int index;
    private String transtype;
    private String message;
    private String createddate;
    private String jewel;
    private String readydate;
    private double netweight;
    private String size;
    private List<WorkersMemoBean> lstWorkersMemo = new ArrayList();
    private List<Workersmemo> lstWorkersMemos = new ArrayList();
    private List<Employees> lstEmp = new ArrayList();

    private String printworker;
    private String printaddress;
    private String printmemoid;
    private String printdate;
    private String printOrderno;
    private String printjewel;
    private String printsize;
    private String printreadydate;
    private double printnetweight;
    private double printstoneweight;
    private double printgoldweight;
    private boolean print;

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public String getPrintdate() {
        return printdate;
    }

    public void setPrintdate(String printdate) {
        this.printdate = printdate;
    }

    public String getPrintworker() {
        return printworker;
    }

    public void setPrintworker(String printworker) {
        this.printworker = printworker;
    }

    public String getPrintaddress() {
        return printaddress;
    }

    public void setPrintaddress(String printaddress) {
        this.printaddress = printaddress;
    }

    public String getPrintmemoid() {
        return printmemoid;
    }

    public void setPrintmemoid(String printmemoid) {
        this.printmemoid = printmemoid;
    }

    public String getPrintOrderno() {
        return printOrderno;
    }

    public void setPrintOrderno(String printOrderno) {
        this.printOrderno = printOrderno;
    }

    public String getPrintjewel() {
        return printjewel;
    }

    public void setPrintjewel(String printjewel) {
        this.printjewel = printjewel;
    }

    public String getPrintsize() {
        return printsize;
    }

    public void setPrintsize(String printsize) {
        this.printsize = printsize;
    }

    public String getPrintreadydate() {
        return printreadydate;
    }

    public void setPrintreadydate(String printreadydate) {
        this.printreadydate = printreadydate;
    }

    public double getPrintnetweight() {
        return printnetweight;
    }

    public void setPrintnetweight(double printnetweight) {
        this.printnetweight = printnetweight;
    }

    public double getPrintstoneweight() {
        return printstoneweight;
    }

    public void setPrintstoneweight(double printstoneweight) {
        this.printstoneweight = printstoneweight;
    }

    public double getPrintgoldweight() {
        return printgoldweight;
    }

    public void setPrintgoldweight(double printgoldweight) {
        this.printgoldweight = printgoldweight;
    }

    public String getJewel() {
        return jewel;
    }

    public void setJewel(String jewel) {
        this.jewel = jewel;
    }

    public String getReadydate() {
        return readydate;
    }

    public void setReadydate(String readydate) {
        this.readydate = readydate;
    }

    public double getNetweight() {
        return netweight;
    }

    public void setNetweight(double netweight) {
        this.netweight = netweight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreateddate() {
        /*  41 */ return this.createddate;
    }

    public void setCreateddate(String createddate) {
        /*  45 */ this.createddate = createddate;
    }

    public int getEmployeeid() {
        /*  49 */ return this.employeeid;
    }

    public void setEmployeeid(int employeeid) {
        /*  53 */ this.employeeid = employeeid;
    }

    public List<Employees> getLstEmp() {
        /*  57 */ return this.lstEmp;
    }

    public void setLstEmp(List<Employees> lstEmp) {
        /*  61 */ this.lstEmp = lstEmp;
    }

    public String getOrderno() {
        /*  65 */ return this.orderno;
    }

    public void setOrderno(String orderno) {
        /*  69 */ this.orderno = orderno;
    }

    public double getGoldweight() {
        /*  73 */ return this.goldweight;
    }

    public void setGoldweight(double goldweight) {
        /*  77 */ this.goldweight = goldweight;
    }

    public double getSilverweight() {
        /*  81 */ return this.silverweight;
    }

    public void setSilverweight(double silverweight) {
        /*  85 */ this.silverweight = silverweight;
    }

    public double getStoneweight() {
        /*  89 */ return this.stoneweight;
    }

    public void setStoneweight(double stoneweight) {
        /*  93 */ this.stoneweight = stoneweight;
    }

    public double getDiamondweight() {
        /*  97 */ return this.diamondweight;
    }

    public void setDiamondweight(double diamondweight) {
        /* 101 */ this.diamondweight = diamondweight;
    }

    public List<Workersmemo> getLstWorkersMemos() {
        /* 105 */ return this.lstWorkersMemos;
    }

    public void setLstWorkersMemos(List<Workersmemo> lstWorkersMemos) {
        /* 109 */ this.lstWorkersMemos = lstWorkersMemos;
    }

    public String getTranstype() {
        /* 113 */ return this.transtype;
    }

    public String getMessage() {
        /* 117 */ return this.message;
    }

    public void setMessage(String message) {
        /* 121 */ this.message = message;
    }

    public void setTranstype(String transtype) {
        /* 125 */ this.transtype = transtype;
    }

    public String getWorkermemono() {
        /* 129 */ return this.workermemono;
    }

    public void setWorkermemono(String workermemono) {
        /* 133 */ this.workermemono = workermemono;
    }

    public String getDate() {
        /* 137 */ return this.date;
    }

    public void setDate(String date) {
        /* 141 */ this.date = date;
    }

    public String getEmployee() {
        /* 145 */ return this.employee;
    }

    public void setEmployee(String employee) {
        /* 149 */ this.employee = employee;
    }

    public String getRemarks() {
        /* 153 */ return this.remarks;
    }

    public void setRemarks(String remarks) {
        /* 157 */ this.remarks = remarks;
    }

    public List<WorkersMemoBean> getLstWorkersMemo() {
        /* 161 */ return this.lstWorkersMemo;
    }

    public void setLstWorkersMemo(List<WorkersMemoBean> lstWorkersMemo) {
        /* 165 */ this.lstWorkersMemo = lstWorkersMemo;
    }

    public int getIndex() {
        /* 169 */ return this.index;
    }

    public void setIndex(int index) {
        /* 173 */ this.index = index;
    }

    public int getWorkersmemoid() {
        /* 177 */ return this.workersmemoid;
    }

    public void setWorkersmemoid(int workersmemoid) {
        /* 181 */ this.workersmemoid = workersmemoid;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\workersmemo\WorkersMemoActionForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
