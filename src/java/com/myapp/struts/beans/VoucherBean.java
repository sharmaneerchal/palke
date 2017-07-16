 package com.myapp.struts.beans;
 
 
 public class VoucherBean
 {
   private int voucherid;
   
   private int stockid;
   
   private String vouchertype;
   
   private String voucherno;
   
   private String voucherdate;
   
   private double weight;
   
   private String amount;
   
   private String remarks;
   private String category;
   private double oldweight;
   
   public double getOldweight()
   {
/*  26 */     return this.oldweight;
   }
   
   public void setOldweight(double oldweight) {
/*  30 */     this.oldweight = oldweight;
   }
   
   public String getAmount() {
/*  34 */     return this.amount;
   }
   
   public void setAmount(String amount) {
/*  38 */     this.amount = amount;
   }
   
   public int getStockid() {
/*  42 */     return this.stockid;
   }
   
   public void setStockid(int stockid) {
/*  46 */     this.stockid = stockid;
   }
   
   public String getCategory() {
/*  50 */     return this.category;
   }
   
   public void setCategory(String category) {
/*  54 */     this.category = category;
   }
   
   public int getVoucherid() {
/*  58 */     return this.voucherid;
   }
   
   public void setVoucherid(int voucherid) {
/*  62 */     this.voucherid = voucherid;
   }
   
   public String getVouchertype() {
/*  66 */     return this.vouchertype;
   }
   
   public void setVouchertype(String vouchertype) {
/*  70 */     this.vouchertype = vouchertype;
   }
   
   public String getVoucherno() {
/*  74 */     return this.voucherno;
   }
   
   public void setVoucherno(String voucherno) {
/*  78 */     this.voucherno = voucherno;
   }
   
   public String getVoucherdate() {
/*  82 */     return this.voucherdate;
   }
   
   public void setVoucherdate(String voucherdate) {
/*  86 */     this.voucherdate = voucherdate;
   }
   
   public double getWeight() {
/*  90 */     return this.weight;
   }
   
   public void setWeight(double weight) {
/*  94 */     this.weight = weight;
   }
   
   public String getRemarks() {
/*  98 */     return this.remarks;
   }
   
   public void setRemarks(String remarks) {
/* 102 */     this.remarks = remarks;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\VoucherBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */