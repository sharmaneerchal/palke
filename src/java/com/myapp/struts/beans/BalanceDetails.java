/*    */ package com.myapp.struts.beans;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BalanceDetails
/*    */ {
/*    */   private Date jewelDate;
/*    */   private int jewelentryid;
/*    */   private String item;
/*    */   private double grossweight;
/*    */   private double netweight;
/*    */   private double goldused;
/*    */   
/*    */   public String getItem()
/*    */   {
/* 24 */     return this.item;
/*    */   }
/*    */   
/*    */   public void setItem(String item) {
/* 28 */     this.item = item;
/*    */   }
/*    */   
/*    */   public Date getJewelDate() {
/* 32 */     return this.jewelDate;
/*    */   }
/*    */   
/*    */   public void setJewelDate(Date jewelDate) {
/* 36 */     this.jewelDate = jewelDate;
/*    */   }
/*    */   
/*    */   public int getJewelentryid() {
/* 40 */     return this.jewelentryid;
/*    */   }
/*    */   
/*    */   public void setJewelentryid(int jewelentryid) {
/* 44 */     this.jewelentryid = jewelentryid;
/*    */   }
/*    */   
/*    */   public double getGrossweight() {
/* 48 */     return this.grossweight;
/*    */   }
/*    */   
/*    */   public void setGrossweight(double grossweight) {
/* 52 */     this.grossweight = grossweight;
/*    */   }
/*    */   
/*    */   public double getNetweight() {
/* 56 */     return this.netweight;
/*    */   }
/*    */   
/*    */   public void setNetweight(double netweight) {
/* 60 */     this.netweight = netweight;
/*    */   }
/*    */   
/*    */   public double getGoldused() {
/* 64 */     return this.goldused;
/*    */   }
/*    */   
/*    */   public void setGoldused(double goldused) {
/* 68 */     this.goldused = goldused;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\BalanceDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */