package com.myapp.struts.vouchers;

import com.myapp.struts.beans.VoucherBean;
import java.util.ArrayList;
import java.util.List;
import mappings.Vouchers;
import org.apache.struts.action.ActionForm;

public class VouchersForm
        extends ActionForm {

    private int voucherid;
    private String vouchertype;
    private String category;
    private String pvoucherno;
    private String pvoucherdate;
    private double pweight;
    private double poldweight;
    private String pamount;
    private String premarks;
    private String ptranstype;
    private String rvoucherno;
    private String rvoucherdate;
    private double rweight;
    private double roldweight;
    private String ramount;
    private String rremarks;
    private String rtranstype;
    private String transtype;
    private int index;
    private String message;
    private List<VoucherBean> lstVouchers = new ArrayList();
    private List<Vouchers> lstVoucherslst = new ArrayList();
    private Integer slno;
    private String printdate;
    private String printname;
    private String description;
    private String purity;
    private double netweight;
    private String voucherno;
    private String printamount;

    public String getPrintamount() {
        return printamount;
    }

    public void setPrintamount(String printamount) {
        this.printamount = printamount;
    }

    public Integer getSlno() {
        return slno;
    }

    public void setSlno(Integer slno) {
        this.slno = slno;
    }

    public String getPrintdate() {
        return printdate;
    }

    public void setPrintdate(String printdate) {
        this.printdate = printdate;
    }

    public String getPrintname() {
        return printname;
    }

    public void setPrintname(String printname) {
        this.printname = printname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    public double getNetweight() {
        return netweight;
    }

    public void setNetweight(double netweight) {
        this.netweight = netweight;
    }

    public String getVoucherno() {
        return voucherno;
    }

    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno;
    }

    public String getTranstype() {
        /*  48 */ return this.transtype;
    }

    public void setTranstype(String transtype) {
        /*  52 */ this.transtype = transtype;
    }

    public int getVoucherid() {
        /*  56 */ return this.voucherid;
    }

    public void setVoucherid(int voucherid) {
        /*  60 */ this.voucherid = voucherid;
    }

    public String getVouchertype() {
        /*  64 */ return this.vouchertype;
    }

    public void setVouchertype(String vouchertype) {
        /*  68 */ this.vouchertype = vouchertype;
    }

    public String getCategory() {
        /*  72 */ return this.category;
    }

    public void setCategory(String category) {
        /*  76 */ this.category = category;
    }

    public String getPvoucherno() {
        /*  80 */ return this.pvoucherno;
    }

    public void setPvoucherno(String pvoucherno) {
        /*  84 */ this.pvoucherno = pvoucherno;
    }

    public String getPvoucherdate() {
        /*  88 */ return this.pvoucherdate;
    }

    public void setPvoucherdate(String pvoucherdate) {
        /*  92 */ this.pvoucherdate = pvoucherdate;
    }

    public double getPweight() {
        /*  96 */ return this.pweight;
    }

    public void setPweight(double pweight) {
        /* 100 */ this.pweight = pweight;
    }

    public String getPamount() {
        /* 104 */ return this.pamount;
    }

    public void setPamount(String pamount) {
        /* 108 */ this.pamount = pamount;
    }

    public String getPremarks() {
        /* 112 */ return this.premarks;
    }

    public void setPremarks(String premarks) {
        /* 116 */ this.premarks = premarks;
    }

    public String getPtranstype() {
        /* 120 */ return this.ptranstype;
    }

    public void setPtranstype(String ptranstype) {
        /* 124 */ this.ptranstype = ptranstype;
    }

    public String getRvoucherno() {
        /* 128 */ return this.rvoucherno;
    }

    public void setRvoucherno(String rvoucherno) {
        /* 132 */ this.rvoucherno = rvoucherno;
    }

    public String getRvoucherdate() {
        /* 136 */ return this.rvoucherdate;
    }

    public void setRvoucherdate(String rvoucherdate) {
        /* 140 */ this.rvoucherdate = rvoucherdate;
    }

    public double getRweight() {
        /* 144 */ return this.rweight;
    }

    public void setRweight(double rweight) {
        /* 148 */ this.rweight = rweight;
    }

    public double getPoldweight() {
        /* 152 */ return this.poldweight;
    }

    public void setPoldweight(double poldweight) {
        /* 156 */ this.poldweight = poldweight;
    }

    public double getRoldweight() {
        /* 160 */ return this.roldweight;
    }

    public void setRoldweight(double roldweight) {
        /* 164 */ this.roldweight = roldweight;
    }

    public String getRamount() {
        /* 168 */ return this.ramount;
    }

    public void setRamount(String ramount) {
        /* 172 */ this.ramount = ramount;
    }

    public String getRremarks() {
        /* 176 */ return this.rremarks;
    }

    public void setRremarks(String rremarks) {
        /* 180 */ this.rremarks = rremarks;
    }

    public String getRtranstype() {
        /* 184 */ return this.rtranstype;
    }

    public void setRtranstype(String rtranstype) {
        /* 188 */ this.rtranstype = rtranstype;
    }

    public int getIndex() {
        /* 192 */ return this.index;
    }

    public void setIndex(int index) {
        /* 196 */ this.index = index;
    }

    public String getMessage() {
        /* 200 */ return this.message;
    }

    public void setMessage(String message) {
        /* 204 */ this.message = message;
    }

    public List<VoucherBean> getLstVouchers() {
        /* 208 */ return this.lstVouchers;
    }

    public void setLstVouchers(List<VoucherBean> lstVouchers) {
        /* 212 */ this.lstVouchers = lstVouchers;
    }

    public List<Vouchers> getLstVoucherslst() {
        /* 216 */ return this.lstVoucherslst;
    }

    public void setLstVoucherslst(List<Vouchers> lstVoucherslst) {
        /* 220 */ this.lstVoucherslst = lstVoucherslst;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\vouchers\VouchersForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
