/*    */ package com.myapp.struts.beans;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class itemdetails
/*    */ {
/*    */   private int sino;
/*    */   
/*    */ 
/*    */   private String description;
/*    */   
/*    */   private String weight;
/*    */   
/*    */   private String price;
/*    */   
/*    */   private String remarks;
/*    */   
/*    */ 
/*    */   public itemdetails()
/*    */   {
/* 21 */     this.sino = 1;
/* 22 */     this.description = "";
/* 23 */     this.weight = "";
/* 24 */     this.price = "";
/* 25 */     this.remarks = "";
/*    */   }
/*    */   
/*    */   public itemdetails(int sino, String description, String weight, String price, String remarks) {
/* 29 */     this.sino = sino;
/* 30 */     this.description = description;
/* 31 */     this.weight = weight;
/* 32 */     this.price = price;
/* 33 */     this.remarks = remarks;
/*    */   }
/*    */   
/*    */   public int getSino() {
/* 37 */     return this.sino;
/*    */   }
/*    */   
/*    */   public void setSino(int sino) {
/* 41 */     this.sino = sino;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 45 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 49 */     this.description = description;
/*    */   }
/*    */   
/*    */   public String getWeight() {
/* 53 */     return this.weight;
/*    */   }
/*    */   
/*    */   public void setWeight(String weight) {
/* 57 */     this.weight = weight;
/*    */   }
/*    */   
/*    */   public String getPrice() {
/* 61 */     return this.price;
/*    */   }
/*    */   
/*    */   public void setPrice(String price) {
/* 65 */     this.price = price;
/*    */   }
/*    */   
/*    */   public String getRemarks() {
/* 69 */     return this.remarks;
/*    */   }
/*    */   
/*    */   public void setRemarks(String remarks) {
/* 73 */     this.remarks = remarks;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\itemdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */