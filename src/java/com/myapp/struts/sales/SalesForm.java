package com.myapp.struts.sales;

import com.myapp.struts.beans.JewelBean;
import java.util.ArrayList;
import java.util.List;
import mappings.Items;
import mappings.Sales;
import org.apache.struts.action.ActionForm;

public class SalesForm
        extends ActionForm {

    private List<Items> lstItems = new ArrayList();
    private List<JewelBean> lstornaments = new ArrayList();
    private List<JewelBean> lstoradded = new ArrayList();
    private List<Sales> lstbills = new ArrayList();
    private String billno;
    private String billdate;
    private double billamount;
    private double discount;
    private int Itemid;
    private String item;
    private int jewelcode;
    private String message;
    private int salesid;
    private Double revgrossweight;
    private Double revnetweight;
    private Double revwastage;
    private String stonetype;
    private int index;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Double getRevgrossweight() {
        return revgrossweight;
    }

    public void setRevgrossweight(Double revgrossweight) {
        this.revgrossweight = revgrossweight;
    }

    public Double getRevnetweight() {
        return revnetweight;
    }

    public void setRevnetweight(Double revnetweight) {
        this.revnetweight = revnetweight;
    }

    public Double getRevwastage() {
        return revwastage;
    }

    public void setRevwastage(Double revwastage) {
        this.revwastage = revwastage;
    }

    public String getStonetype() {
        return stonetype;
    }

    public void setStonetype(String stonetype) {
        this.stonetype = stonetype;
    }

    public List<Sales> getLstbills() {
        /*  37 */ return this.lstbills;
    }

    public void setLstbills(List<Sales> lstbills) {
        /*  41 */ this.lstbills = lstbills;
    }

    public int getSalesid() {
        /*  45 */ return this.salesid;
    }

    public void setSalesid(int salesid) {
        /*  49 */ this.salesid = salesid;
    }

    public String getMessage() {
        /*  53 */ return this.message;
    }

    public void setMessage(String message) {
        /*  57 */ this.message = message;
    }

    public String getItem() {
        /*  61 */ return this.item;
    }

    public void setItem(String item) {
        /*  65 */ this.item = item;
    }

    public int getJewelcode() {
        /*  69 */ return this.jewelcode;
    }

    public void setJewelcode(int jewelcode) {
        /*  73 */ this.jewelcode = jewelcode;
    }

    public int getItemid() {
        /*  77 */ return this.Itemid;
    }

    public void setItemid(int Itemid) {
        /*  81 */ this.Itemid = Itemid;
    }

    public List<JewelBean> getLstoradded() {
        /*  85 */ return this.lstoradded;
    }

    public void setLstoradded(List<JewelBean> lstoradded) {
        /*  89 */ this.lstoradded = lstoradded;
    }

    public String getBillno() {
        /*  93 */ return this.billno;
    }

    public void setBillno(String billno) {
        /*  97 */ this.billno = billno;
    }

    public String getBilldate() {
        /* 101 */ return this.billdate;
    }

    public void setBilldate(String billdate) {
        /* 105 */ this.billdate = billdate;
    }

    public double getBillamount() {
        /* 109 */ return this.billamount;
    }

    public void setBillamount(double billamount) {
        /* 113 */ this.billamount = billamount;
    }

    public double getDiscount() {
        /* 117 */ return this.discount;
    }

    public void setDiscount(double discount) {
        /* 121 */ this.discount = discount;
    }

    public List<Items> getLstItems() {
        /* 125 */ return this.lstItems;
    }

    public void setLstItems(List<Items> lstItems) {
        /* 129 */ this.lstItems = lstItems;
    }

    public List<JewelBean> getLstornaments() {
        /* 133 */ return this.lstornaments;
    }

    public void setLstornaments(List<JewelBean> lstornaments) {
        /* 137 */ this.lstornaments = lstornaments;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\sales\SalesForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
