package com.myapp.struts.beans;

import java.util.Date;

public class JewelBean {

    private Integer ornamentstockid;
    private String ornamentstockno;
    private String description;
    private Integer itemid;
    private String memono;
    private Integer memoid;
    private Double grossweight;
    private Double goldweight;
    private Double stoneweight;
    private String stonetype;
    private Double netweight;
    private Double wastage;
    private Double totalglodused;
    private Date insertdate;
    private Double revgrossweight;
    private Double revnetweight;
    private Double revwastage;
    private Double revtotalglodused;
    private boolean sold;
    private boolean transfered;
    private Integer jewelentryid;
    private Date date;
    private String worker;
    private String billno;

    public JewelBean() {
    }

    public JewelBean(Integer ornamentstockid, String ornamentstockno, String description, Integer itemid, String memono, Integer memoid, Double grossweight, Double goldweight, Double stoneweight, String stonetype, Double netweight, Double wastage, Double totalglodused, Date insertdate, Double revgrossweight, Double revnetweight, Double revwastage, Double revtotalglodused, boolean sold, boolean transfered, Integer jewelentryid, Date date, String worker) {
        this.ornamentstockid = ornamentstockid;
        this.ornamentstockno = ornamentstockno;
        this.description = description;
        this.itemid = itemid;
        this.memono = memono;
        this.memoid = memoid;
        this.grossweight = grossweight;
        this.goldweight = goldweight;
        this.stoneweight = stoneweight;
        this.stonetype = stonetype;
        this.netweight = netweight;
        this.wastage = wastage;
        this.totalglodused = totalglodused;
        this.insertdate = insertdate;
        this.revgrossweight = revgrossweight;
        this.revnetweight = revnetweight;
        this.revwastage = revwastage;
        this.revtotalglodused = revtotalglodused;
        this.sold = sold;
        this.transfered = transfered;
        this.jewelentryid = jewelentryid;
        this.date = date;
        this.worker = worker;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public boolean isTransfered() {
        return transfered;
    }

    public void setTransfered(boolean transfered) {
        this.transfered = transfered;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Integer getOrnamentstockid() {
        /*  40 */ return this.ornamentstockid;
    }

    public void setOrnamentstockid(Integer ornamentstockid) {
        /*  44 */ this.ornamentstockid = ornamentstockid;
    }

    public String getOrnamentstockno() {
        /*  48 */ return this.ornamentstockno;
    }

    public void setOrnamentstockno(String ornamentstockno) {
        /*  52 */ this.ornamentstockno = ornamentstockno;
    }

    public String getDescription() {
        /*  56 */ return this.description;
    }

    public void setDescription(String description) {
        /*  60 */ this.description = description;
    }

    public Integer getItemid() {
        /*  64 */ return this.itemid;
    }

    public void setItemid(Integer itemid) {
        /*  68 */ this.itemid = itemid;
    }

    public String getMemono() {
        /*  72 */ return this.memono;
    }

    public void setMemono(String memono) {
        /*  76 */ this.memono = memono;
    }

    public Integer getMemoid() {
        /*  80 */ return this.memoid;
    }

    public void setMemoid(Integer memoid) {
        /*  84 */ this.memoid = memoid;
    }

    public Double getGrossweight() {
        /*  88 */ return this.grossweight;
    }

    public void setGrossweight(Double grossweight) {
        /*  92 */ this.grossweight = grossweight;
    }

    public Double getGoldweight() {
        /*  96 */ return this.goldweight;
    }

    public void setGoldweight(Double goldweight) {
        /* 100 */ this.goldweight = goldweight;
    }

    public Double getStoneweight() {
        /* 104 */ return this.stoneweight;
    }

    public void setStoneweight(Double stoneweight) {
        /* 108 */ this.stoneweight = stoneweight;
    }

    public String getStonetype() {
        return stonetype;
    }

    public void setStonetype(String stonetype) {
        this.stonetype = stonetype;
    }

    public Double getNetweight() {
        /* 128 */ return this.netweight;
    }

    public void setNetweight(Double netweight) {
        /* 132 */ this.netweight = netweight;
    }

    public Double getWastage() {
        /* 136 */ return this.wastage;
    }

    public void setWastage(Double wastage) {
        /* 140 */ this.wastage = wastage;
    }

    public Double getTotalglodused() {
        /* 144 */ return this.totalglodused;
    }

    public void setTotalglodused(Double totalglodused) {
        /* 148 */ this.totalglodused = totalglodused;
    }

    public Date getInsertdate() {
        /* 152 */ return this.insertdate;
    }

    public void setInsertdate(Date insertdate) {
        /* 156 */ this.insertdate = insertdate;
    }

    public Double getRevgrossweight() {
        /* 160 */ return this.revgrossweight;
    }

    public void setRevgrossweight(Double revgrossweight) {
        /* 164 */ this.revgrossweight = revgrossweight;
    }

    public Double getRevnetweight() {
        /* 168 */ return this.revnetweight;
    }

    public void setRevnetweight(Double revnetweight) {
        /* 172 */ this.revnetweight = revnetweight;
    }

    public Double getRevwastage() {
        /* 176 */ return this.revwastage;
    }

    public void setRevwastage(Double revwastage) {
        /* 180 */ this.revwastage = revwastage;
    }

    public Double getRevtotalglodused() {
        /* 184 */ return this.revtotalglodused;
    }

    public void setRevtotalglodused(Double revtotalglodused) {
        /* 188 */ this.revtotalglodused = revtotalglodused;
    }

    public boolean isSold() {
        /* 192 */ return this.sold;
    }

    public void setSold(boolean sold) {
        /* 196 */ this.sold = sold;
    }

    public Integer getJewelentryid() {
        /* 200 */ return this.jewelentryid;
    }

    public void setJewelentryid(Integer jewelentryid) {
        /* 204 */ this.jewelentryid = jewelentryid;
    }

    public Date getDate() {
        /* 208 */ return this.date;
    }

    public void setDate(Date date) {
        /* 212 */ this.date = date;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\JewelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
