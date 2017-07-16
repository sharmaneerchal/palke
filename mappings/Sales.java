package mappings;

import java.io.Serializable;
import java.util.Date;

public class Sales
        implements Serializable {

    private Integer salesid;
    private String billno;
    private String billdate;
    private Double billamount;
    private Double discounts;
    private Double tax;
    private String jewelcodes;
    private Date insertdate;
    private Date updatedate;

    public Sales() {
    }

    public Sales(String billno, String billdate, Double billamount, Double discounts, Double tax, String jewelcodes, Date insertdate, Date updatedate) {
        /*  25 */ this.billno = billno;
        /*  26 */ this.billdate = billdate;
        /*  27 */ this.billamount = billamount;
        /*  28 */ this.discounts = discounts;
        /*  29 */ this.tax = tax;
        /*  30 */ this.jewelcodes = jewelcodes;
        /*  31 */ this.insertdate = insertdate;
        /*  32 */ this.updatedate = updatedate;
    }

    public Integer getSalesid() {
        /*  36 */ return this.salesid;
    }

    public void setSalesid(Integer salesid) {
        /*  40 */ this.salesid = salesid;
    }

    public String getBillno() {
        /*  44 */ return this.billno;
    }

    public void setBillno(String billno) {
        /*  48 */ this.billno = billno;
    }

    public String getBilldate() {
        /*  52 */ return this.billdate;
    }

    public void setBilldate(String billdate) {
        /*  56 */ this.billdate = billdate;
    }

    public Double getBillamount() {
        /*  60 */ return this.billamount;
    }

    public void setBillamount(Double billamount) {
        /*  64 */ this.billamount = billamount;
    }

    public Double getDiscounts() {
        /*  68 */ return this.discounts;
    }

    public void setDiscounts(Double discounts) {
        /*  72 */ this.discounts = discounts;
    }

    public Double getTax() {
        /*  76 */ return this.tax;
    }

    public void setTax(Double tax) {
        /*  80 */ this.tax = tax;
    }

    public String getJewelcodes() {
        /*  84 */ return this.jewelcodes;
    }

    public void setJewelcodes(String jewelcodes) {
        /*  88 */ this.jewelcodes = jewelcodes;
    }

    public Date getInsertdate() {
        /*  92 */ return this.insertdate;
    }

    public void setInsertdate(Date insertdate) {
        /*  96 */ this.insertdate = insertdate;
    }

    public Date getUpdatedate() {
        /* 100 */ return this.updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        /* 104 */ this.updatedate = updatedate;
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Sales.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
