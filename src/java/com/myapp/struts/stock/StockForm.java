package com.myapp.struts.stock;

import com.myapp.struts.beans.JewelBean;
import java.util.ArrayList;
import java.util.List;
import mappings.Goldstock;
import mappings.Items;
import org.apache.struts.action.ActionForm;

public class StockForm extends ActionForm {

    private double goldweight;
    private String stonetype;
    private List<Goldstock> lstgold = new ArrayList();
    private List<JewelBean> lstorgold = new ArrayList();
    private List<Items> lstItems = new ArrayList();
    private String item;
    private int itemid;
    private int index;
    private Double revgrossweight;
    private Double revnetweight;
    private Double revwastage;
    private Double revtotalglodused;
    private String msg;
    private double grosstotal;
    private double nettotal;
    private double revgrosstotal;
    private double revnettotal;

    public StockForm() {
    }

    public StockForm(double goldweight, String stonetype, String item, int itemid, int index, Double revgrossweight, Double revnetweight, Double revwastage, Double revtotalglodused, String msg, double grosstotal, double nettotal, double revgrosstotal, double revnettotal) {
        this.goldweight = goldweight;
        this.stonetype = stonetype;
        this.item = item;
        this.itemid = itemid;
        this.index = index;
        this.revgrossweight = revgrossweight;
        this.revnetweight = revnetweight;
        this.revwastage = revwastage;
        this.revtotalglodused = revtotalglodused;
        this.msg = msg;
        this.grosstotal = grosstotal;
        this.nettotal = nettotal;
        this.revgrosstotal = revgrosstotal;
        this.revnettotal = revnettotal;
    }

    public double getGrosstotal() {
        return grosstotal;
    }

    public void setGrosstotal(double grosstotal) {
        this.grosstotal = grosstotal;
    }

    public double getNettotal() {
        return nettotal;
    }

    public void setNettotal(double nettotal) {
        this.nettotal = nettotal;
    }

    public double getRevgrosstotal() {
        return revgrosstotal;
    }

    public void setRevgrosstotal(double revgrosstotal) {
        this.revgrosstotal = revgrosstotal;
    }

    public double getRevnettotal() {
        return revnettotal;
    }

    public void setRevnettotal(double revnettotal) {
        this.revnettotal = revnettotal;
    }

    public String getStonetype() {
        return stonetype;
    }

    public void setStonetype(String stonetype) {
        this.stonetype = stonetype;
    }

    public Double getRevtotalglodused() {
        /*  43 */ return this.revtotalglodused;
    }

    public void setRevtotalglodused(Double revtotalglodused) {
        /*  47 */ this.revtotalglodused = revtotalglodused;
    }

    public int getIndex() {
        /*  51 */ return this.index;
    }

    public void setIndex(int index) {
        /*  55 */ this.index = index;
    }

    public Double getRevgrossweight() {
        /*  59 */ return this.revgrossweight;
    }

    public void setRevgrossweight(Double revgrossweight) {
        /*  63 */ this.revgrossweight = revgrossweight;
    }

    public Double getRevnetweight() {
        /*  67 */ return this.revnetweight;
    }

    public void setRevnetweight(Double revnetweight) {
        /*  71 */ this.revnetweight = revnetweight;
    }

    public Double getRevwastage() {
        /*  75 */ return this.revwastage;
    }

    public void setRevwastage(Double revwastage) {
        /*  79 */ this.revwastage = revwastage;
    }

    public String getMsg() {
        /*  83 */ return this.msg;
    }

    public void setMsg(String msg) {
        /*  87 */ this.msg = msg;
    }

    public String getItem() {
        /*  91 */ return this.item;
    }

    public void setItem(String item) {
        /*  95 */ this.item = item;
    }

    public int getItemid() {
        /*  99 */ return this.itemid;
    }

    public void setItemid(int itemid) {
        /* 103 */ this.itemid = itemid;
    }

    public List<Items> getLstItems() {
        /* 107 */ return this.lstItems;
    }

    public void setLstItems(List<Items> lstItems) {
        /* 111 */ this.lstItems = lstItems;
    }

    public List<JewelBean> getLstorgold() {
        /* 115 */ return this.lstorgold;
    }

    public void setLstorgold(List<JewelBean> lstorgold) {
        /* 119 */ this.lstorgold = lstorgold;
    }

    public List<Goldstock> getLstgold() {
        /* 131 */ return this.lstgold;
    }

    public void setLstgold(List<Goldstock> lstgold) {
        /* 135 */ this.lstgold = lstgold;
    }

    public double getGoldweight() {
        /* 163 */ return this.goldweight;
    }

    public void setGoldweight(double goldweight) {
        /* 167 */ this.goldweight = goldweight;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\stock\StockForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
