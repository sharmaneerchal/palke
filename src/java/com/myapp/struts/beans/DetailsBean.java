/*    */ package com.myapp.struts.beans;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DetailsBean
/*    */ {
/*    */   private String desc;
/*    */   
/*    */ 
/*    */   private double weight;
/*    */   
/*    */ 
/*    */   private String memono;
/*    */   
/*    */   private double netweight;
/*    */   
/*    */   private double grossweight;
/*    */   
/*    */ 
/*    */   public double getNetweight()
/*    */   {
/* 22 */     return this.netweight;
/*    */   }
/*    */   
/*    */   public void setNetweight(double netweight) {
/* 26 */     this.netweight = netweight;
/*    */   }
/*    */   
/*    */   public double getGrossweight() {
/* 30 */     return this.grossweight;
/*    */   }
/*    */   
/*    */   public void setGrossweight(double grossweight) {
/* 34 */     this.grossweight = grossweight;
/*    */   }
/*    */   
/*    */   public String getMemono() {
/* 38 */     return this.memono;
/*    */   }
/*    */   
/*    */   public void setMemono(String memono) {
/* 42 */     this.memono = memono;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/* 46 */     return this.desc;
/*    */   }
/*    */   
/*    */   public void setDesc(String desc) {
/* 50 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public double getWeight() {
/* 54 */     return this.weight;
/*    */   }
/*    */   
/*    */   public void setWeight(double weight) {
/* 58 */     this.weight = weight;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\DetailsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */