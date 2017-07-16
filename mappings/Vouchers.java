package mappings;

import java.io.Serializable;
import java.util.Date;

public class Vouchers
        implements Serializable {

    private Integer voucherid;
    private String voucherno;
    private Date voucherdate;
    private String amount;
    private Double weight;
    private String remarks;
    private String vouchertype;
    private String vouchercategory;
    private Date createddate;
    private Date updateddate;

    public Vouchers() {
    }

    public Vouchers(String voucherno, Date voucherdate, String voucheramount, Double paidamount, Double balance, Double weight, String remarks, String vouchertype, String vouchercategory, Date createddate, Date updateddate) {
        /*  26 */ this.voucherno = voucherno;
        /*  27 */ this.voucherdate = voucherdate;
        /*  28 */ this.amount = voucheramount;
        /*  29 */ this.weight = weight;
        /*  30 */ this.remarks = remarks;
        /*  31 */ this.vouchertype = vouchertype;
        /*  32 */ this.vouchercategory = vouchercategory;
        /*  33 */ this.createddate = createddate;
        /*  34 */ this.updateddate = updateddate;
    }

    public Integer getVoucherid() {
        /*  38 */ return this.voucherid;
    }

    public void setVoucherid(Integer voucherid) {
        /*  42 */ this.voucherid = voucherid;
    }

    public String getVoucherno() {
        /*  46 */ return this.voucherno;
    }

    public void setVoucherno(String voucherno) {
        /*  50 */ this.voucherno = voucherno;
    }

    public Date getVoucherdate() {
        /*  54 */ return this.voucherdate;
    }

    public void setVoucherdate(Date voucherdate) {
        /*  58 */ this.voucherdate = voucherdate;
    }

    public String getAmount() {
        /*  62 */ return this.amount;
    }

    public void setAmount(String amount) {
        /*  66 */ this.amount = amount;
    }

    public Double getWeight() {
        /*  70 */ return this.weight;
    }

    public void setWeight(Double weight) {
        /*  74 */ this.weight = weight;
    }

    public String getRemarks() {
        /*  78 */ return this.remarks;
    }

    public void setRemarks(String remarks) {
        /*  82 */ this.remarks = remarks;
    }

    public String getVouchertype() {
        /*  86 */ return this.vouchertype;
    }

    public void setVouchertype(String vouchertype) {
        /*  90 */ this.vouchertype = vouchertype;
    }

    public String getVouchercategory() {
        /*  94 */ return this.vouchercategory;
    }

    public void setVouchercategory(String vouchercategory) {
        /*  98 */ this.vouchercategory = vouchercategory;
    }

    public Date getCreateddate() {
        /* 102 */ return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        /* 106 */ this.createddate = createddate;
    }

    public Date getUpdateddate() {
        /* 110 */ return this.updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        /* 114 */ this.updateddate = updateddate;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Vouchers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
