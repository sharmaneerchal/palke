/*    */ package com.myapp.struts.beans;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrawDetailsData
/*    */ {
/*    */   private String drawtype;
/*    */   
/*    */   private int drawtypeid;
/*    */   
/*    */   private String position;
/*    */   
/*    */   private double amount;
/*    */   
/*    */   private int positionid;
/*    */   
/*    */   private int groupdrawdetailsid;
/*    */   
/*    */   private int groupdrawpositionsid;
/*    */   
/*    */ 
/*    */   public DrawDetailsData() {}
/*    */   
/*    */ 
/*    */   public DrawDetailsData(String drawtype, int drawtypeid, String position, double amount, int positionid, int groupdrawdetailsid, int groupdrawpositionsid)
/*    */   {
/* 27 */     this.drawtype = drawtype;
/* 28 */     this.drawtypeid = drawtypeid;
/* 29 */     this.position = position;
/* 30 */     this.amount = amount;
/* 31 */     this.positionid = positionid;
/* 32 */     this.groupdrawdetailsid = groupdrawdetailsid;
/* 33 */     this.groupdrawpositionsid = groupdrawpositionsid;
/*    */   }
/*    */   
/*    */   public int getGroupdrawpositionsid() {
/* 37 */     return this.groupdrawpositionsid;
/*    */   }
/*    */   
/*    */   public void setGroupdrawpositionsid(int groupdrawpositionsid) {
/* 41 */     this.groupdrawpositionsid = groupdrawpositionsid;
/*    */   }
/*    */   
/*    */   public int getGroupdrawdetailsid() {
/* 45 */     return this.groupdrawdetailsid;
/*    */   }
/*    */   
/*    */   public void setGroupdrawdetailsid(int groupdrawdetailsid) {
/* 49 */     this.groupdrawdetailsid = groupdrawdetailsid;
/*    */   }
/*    */   
/*    */   public int getPositionid() {
/* 53 */     return this.positionid;
/*    */   }
/*    */   
/*    */   public void setPositionid(int positionid) {
/* 57 */     this.positionid = positionid;
/*    */   }
/*    */   
/*    */   public int getDrawtypeid() {
/* 61 */     return this.drawtypeid;
/*    */   }
/*    */   
/*    */   public void setDrawtypeid(int drawtypeid) {
/* 65 */     this.drawtypeid = drawtypeid;
/*    */   }
/*    */   
/*    */   public String getDrawtype() {
/* 69 */     return this.drawtype;
/*    */   }
/*    */   
/*    */   public void setDrawtype(String drawtype) {
/* 73 */     this.drawtype = drawtype;
/*    */   }
/*    */   
/*    */   public String getPosition() {
/* 77 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(String position) {
/* 81 */     this.position = position;
/*    */   }
/*    */   
/*    */   public double getAmount() {
/* 85 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(double amount) {
/* 89 */     this.amount = amount;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\DrawDetailsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */