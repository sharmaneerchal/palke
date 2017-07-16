package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Goldstock generated by hbm2java
 */
public class Goldstock  implements java.io.Serializable {


     private Integer goldstockid;
     private String goldstockno;
     private String type;
     private String vouchertype;
     private Date voucherdate;
     private Double weight;
     private Double price;
     private Integer refernceid;
     private Integer refernceno;
     private Date createddate;
     private Date updateddate;
     private String remarks;

    public Goldstock() {
    }

    public Goldstock(String goldstockno, String type, String vouchertype, Date voucherdate, Double weight, Double price, Integer refernceid, Integer refernceno, Date createddate, Date updateddate, String remarks) {
       this.goldstockno = goldstockno;
       this.type = type;
       this.vouchertype = vouchertype;
       this.voucherdate = voucherdate;
       this.weight = weight;
       this.price = price;
       this.refernceid = refernceid;
       this.refernceno = refernceno;
       this.createddate = createddate;
       this.updateddate = updateddate;
       this.remarks = remarks;
    }
   
    public Integer getGoldstockid() {
        return this.goldstockid;
    }
    
    public void setGoldstockid(Integer goldstockid) {
        this.goldstockid = goldstockid;
    }
    public String getGoldstockno() {
        return this.goldstockno;
    }
    
    public void setGoldstockno(String goldstockno) {
        this.goldstockno = goldstockno;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getVouchertype() {
        return this.vouchertype;
    }
    
    public void setVouchertype(String vouchertype) {
        this.vouchertype = vouchertype;
    }
    public Date getVoucherdate() {
        return this.voucherdate;
    }
    
    public void setVoucherdate(Date voucherdate) {
        this.voucherdate = voucherdate;
    }
    public Double getWeight() {
        return this.weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getRefernceid() {
        return this.refernceid;
    }
    
    public void setRefernceid(Integer refernceid) {
        this.refernceid = refernceid;
    }
    public Integer getRefernceno() {
        return this.refernceno;
    }
    
    public void setRefernceno(Integer refernceno) {
        this.refernceno = refernceno;
    }
    public Date getCreateddate() {
        return this.createddate;
    }
    
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }
    public Date getUpdateddate() {
        return this.updateddate;
    }
    
    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




}

