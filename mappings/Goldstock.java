 package mappings;
 
 import java.io.Serializable;
 import java.util.Date;
 
 
 
 public class Goldstock
   implements Serializable
 {
   private Integer goldstockid;
   private String goldstockno;
   private String type;
   private String vouchertype;
   private Date voucherdate;
   private Double weight;
   private Double price;
   private Integer refernceid;
   private Date createddate;
   private Date updateddate;
   private String remarks;
   private Integer refernceno;
   
   public Goldstock() {}
   
   public Goldstock(Integer goldstockid, String goldstockno, String type, String vouchertype, Date voucherdate, Double weight, Double price, Integer refernceid, Date createddate, Date updateddate, String remarks, Integer refernceno)
   {
/*  28 */     this.goldstockid = goldstockid;
/*  29 */     this.goldstockno = goldstockno;
/*  30 */     this.type = type;
/*  31 */     this.vouchertype = vouchertype;
/*  32 */     this.voucherdate = voucherdate;
/*  33 */     this.weight = weight;
/*  34 */     this.price = price;
/*  35 */     this.refernceid = refernceid;
/*  36 */     this.createddate = createddate;
/*  37 */     this.updateddate = updateddate;
/*  38 */     this.remarks = remarks;
/*  39 */     this.refernceno = refernceno;
   }
   
   public Integer getRefernceno() {
/*  43 */     return this.refernceno;
   }
   
   public void setRefernceno(Integer refernceno) {
/*  47 */     this.refernceno = refernceno;
   }
   
   public Integer getGoldstockid() {
/*  51 */     return this.goldstockid;
   }
   
   public void setGoldstockid(Integer goldstockid) {
/*  55 */     this.goldstockid = goldstockid;
   }
   
   public String getGoldstockno() {
/*  59 */     return this.goldstockno;
   }
   
   public void setGoldstockno(String goldstockno) {
/*  63 */     this.goldstockno = goldstockno;
   }
   
   public String getType() {
/*  67 */     return this.type;
   }
   
   public void setType(String type) {
/*  71 */     this.type = type;
   }
   
   public String getVouchertype() {
/*  75 */     return this.vouchertype;
   }
   
   public void setVouchertype(String vouchertype) {
/*  79 */     this.vouchertype = vouchertype;
   }
   
   public Date getVoucherdate() {
/*  83 */     return this.voucherdate;
   }
   
   public void setVoucherdate(Date voucherdate) {
/*  87 */     this.voucherdate = voucherdate;
   }
   
   public Double getWeight() {
/*  91 */     return this.weight;
   }
   
   public void setWeight(Double weight) {
/*  95 */     this.weight = weight;
   }
   
   public Double getPrice() {
/*  99 */     return this.price;
   }
   
   public void setPrice(Double price) {
/* 103 */     this.price = price;
   }
   
   public Integer getRefernceid() {
/* 107 */     return this.refernceid;
   }
   
   public void setRefernceid(Integer refernceid) {
/* 111 */     this.refernceid = refernceid;
   }
   
   public Date getCreateddate() {
/* 115 */     return this.createddate;
   }
   
   public void setCreateddate(Date createddate) {
/* 119 */     this.createddate = createddate;
   }
   
   public Date getUpdateddate() {
/* 123 */     return this.updateddate;
   }
   
   public void setUpdateddate(Date updateddate) {
/* 127 */     this.updateddate = updateddate;
   }
   
   public String getRemarks() {
/* 131 */     return this.remarks;
   }
   
   public void setRemarks(String remarks) {
/* 135 */     this.remarks = remarks;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Goldstock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */