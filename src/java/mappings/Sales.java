package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Sales generated by hbm2java
 */
public class Sales  implements java.io.Serializable {


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
       this.billno = billno;
       this.billdate = billdate;
       this.billamount = billamount;
       this.discounts = discounts;
       this.tax = tax;
       this.jewelcodes = jewelcodes;
       this.insertdate = insertdate;
       this.updatedate = updatedate;
    }
   
    public Integer getSalesid() {
        return this.salesid;
    }
    
    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }
    public String getBillno() {
        return this.billno;
    }
    
    public void setBillno(String billno) {
        this.billno = billno;
    }
    public String getBilldate() {
        return this.billdate;
    }
    
    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }
    public Double getBillamount() {
        return this.billamount;
    }
    
    public void setBillamount(Double billamount) {
        this.billamount = billamount;
    }
    public Double getDiscounts() {
        return this.discounts;
    }
    
    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }
    public Double getTax() {
        return this.tax;
    }
    
    public void setTax(Double tax) {
        this.tax = tax;
    }
    public String getJewelcodes() {
        return this.jewelcodes;
    }
    
    public void setJewelcodes(String jewelcodes) {
        this.jewelcodes = jewelcodes;
    }
    public Date getInsertdate() {
        return this.insertdate;
    }
    
    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }
    public Date getUpdatedate() {
        return this.updatedate;
    }
    
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }




}

