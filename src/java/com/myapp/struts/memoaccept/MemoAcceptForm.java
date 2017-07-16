package com.myapp.struts.memoaccept;

import com.myapp.struts.beans.JewelBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mappings.Items;
import mappings.Vouchers;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;

public class MemoAcceptForm
        extends ActionForm {

    /*  24 */ private List<Workersmemo> lstmemos = new ArrayList();
    /*  25 */    private List<JewelBean> lstentry = new ArrayList();
    /*  26 */    private List<Vouchers> lstvouchers = new ArrayList();
    /*  27 */    private List<Items> lstitems = new ArrayList();
    private int jewelid;
    private int ornamentid;

    private String action;
    private int index;
    private String memono;
    private Date memodate;
    private int memoid;
    private double memogweight;
    private double memosweight;
    private double memostweight;
    private double memodweight;
    private double memobalance;
    private String memoemp;
    private double usedWeight;
    private String returndate;
    private double returnweight;
    private String category;
    private String returnmsg;
    private String jeweldate;
    private double grossweight;
    private double goldweight;
    private double stonesweight;
    private String description;
    private String item;
    private int itemid;
    private String ornamentstockno;
    private double netweight;
    private double totalgoldused;
    private double wastage;
    private String jewelmsg;
    private String stonetype;

    public int getJewelid() {
        return jewelid;
    }

    public void setJewelid(int jewelid) {
        this.jewelid = jewelid;
    }

    public int getOrnamentid() {
        return ornamentid;
    }

    public void setOrnamentid(int ornamentid) {
        this.ornamentid = ornamentid;
    }

    public String getOrnamentstockno() {
        return ornamentstockno;
    }

    public void setOrnamentstockno(String ornamentstockno) {
        this.ornamentstockno = ornamentstockno;
    }

    public String getMemoemp() {
        return memoemp;
    }

    public void setMemoemp(String memoemp) {
        this.memoemp = memoemp;
    }

    public String getStonetype() {
        return stonetype;
    }

    public void setStonetype(String stonetype) {
        this.stonetype = stonetype;
    }

    public List<Vouchers> getLstvouchers() {
        /*  59 */ return this.lstvouchers;
    }

    public void setLstvouchers(List<Vouchers> lstvouchers) {
        /*  63 */ this.lstvouchers = lstvouchers;
    }

    public List<JewelBean> getLstentry() {
        /*  67 */ return this.lstentry;
    }

    public void setLstentry(List<JewelBean> lstentry) {
        /*  71 */ this.lstentry = lstentry;
    }

    public double getUsedWeight() {
        /*  75 */ return this.usedWeight;
    }

    public void setUsedWeight(double usedWeight) {
        /*  79 */ this.usedWeight = usedWeight;
    }

    public double getMemogweight() {
        /*  83 */ return this.memogweight;
    }

    public void setMemogweight(double memogweight) {
        /*  87 */ this.memogweight = memogweight;
    }

    public double getMemosweight() {
        /*  91 */ return this.memosweight;
    }

    public void setMemosweight(double memosweight) {
        /*  95 */ this.memosweight = memosweight;
    }

    public double getMemostweight() {
        /*  99 */ return this.memostweight;
    }

    public void setMemostweight(double memostweight) {
        /* 103 */ this.memostweight = memostweight;
    }

    public double getMemodweight() {
        /* 107 */ return this.memodweight;
    }

    public void setMemodweight(double memodweight) {
        /* 111 */ this.memodweight = memodweight;
    }

    public double getMemobalance() {
        /* 115 */ return this.memobalance;
    }

    public void setMemobalance(double memobalance) {
        /* 119 */ this.memobalance = memobalance;
    }

    public double getGoldweight() {
        /* 123 */ return this.goldweight;
    }

    public void setGoldweight(double goldweight) {
        /* 127 */ this.goldweight = goldweight;
    }

    public List<Workersmemo> getLstmemos() {
        /* 131 */ return this.lstmemos;
    }

    public void setLstmemos(List<Workersmemo> lstmemos) {
        /* 135 */ this.lstmemos = lstmemos;
    }

    public List<Items> getLstitems() {
        /* 139 */ return this.lstitems;
    }

    public void setLstitems(List<Items> lstitems) {
        /* 143 */ this.lstitems = lstitems;
    }

    public int getIndex() {
        /* 147 */ return this.index;
    }

    public void setIndex(int index) {
        /* 151 */ this.index = index;
    }

    public String getMemono() {
        /* 155 */ return this.memono;
    }

    public void setMemono(String memono) {
        /* 159 */ this.memono = memono;
    }

    public Date getMemodate() {
        /* 163 */ return this.memodate;
    }

    public void setMemodate(Date memodate) {
        /* 167 */ this.memodate = memodate;
    }

    public int getMemoid() {
        /* 171 */ return this.memoid;
    }

    public void setMemoid(int memoid) {
        /* 175 */ this.memoid = memoid;
    }

    public String getReturndate() {
        /* 179 */ return this.returndate;
    }

    public void setReturndate(String returndate) {
        /* 183 */ this.returndate = returndate;
    }

    public double getReturnweight() {
        /* 187 */ return this.returnweight;
    }

    public void setReturnweight(double returnweight) {
        /* 191 */ this.returnweight = returnweight;
    }

    public String getCategory() {
        /* 195 */ return this.category;
    }

    public void setCategory(String category) {
        /* 199 */ this.category = category;
    }

    public String getReturnmsg() {
        /* 203 */ return this.returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        /* 207 */ this.returnmsg = returnmsg;
    }

    public String getJeweldate() {
        /* 211 */ return this.jeweldate;
    }

    public void setJeweldate(String jeweldate) {
        /* 215 */ this.jeweldate = jeweldate;
    }

    public double getGrossweight() {
        /* 219 */ return this.grossweight;
    }

    public void setGrossweight(double grossweight) {
        /* 223 */ this.grossweight = grossweight;
    }

    public double getStonesweight() {
        /* 227 */ return this.stonesweight;
    }

    public void setStonesweight(double stonesweight) {
        /* 231 */ this.stonesweight = stonesweight;
    }

    public String getDescription() {
        /* 251 */ return this.description;
    }

    public void setDescription(String description) {
        /* 255 */ this.description = description;
    }

    public String getItem() {
        /* 259 */ return this.item;
    }

    public void setItem(String item) {
        /* 263 */ this.item = item;
    }

    public int getItemid() {
        /* 267 */ return this.itemid;
    }

    public void setItemid(int itemid) {
        /* 271 */ this.itemid = itemid;
    }

    public double getNetweight() {
        /* 275 */ return this.netweight;
    }

    public void setNetweight(double netweight) {
        /* 279 */ this.netweight = netweight;
    }

    public double getTotalgoldused() {
        /* 283 */ return this.totalgoldused;
    }

    public void setTotalgoldused(double totalgoldused) {
        /* 287 */ this.totalgoldused = totalgoldused;
    }

    public double getWastage() {
        /* 291 */ return this.wastage;
    }

    public void setWastage(double wastage) {
        /* 295 */ this.wastage = wastage;
    }

    public String getJewelmsg() {
        /* 299 */ return this.jewelmsg;
    }

    public void setJewelmsg(String jewelmsg) {
        /* 303 */ this.jewelmsg = jewelmsg;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\memoaccept\MemoAcceptForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
