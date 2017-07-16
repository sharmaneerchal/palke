 package com.myapp.struts.beans;
 
 
 public class paymentstatus
 {
   private int paymentid;
   
   private int groupid;
   
   private int memberid;
   
   private String group;
   
   private String membername;
   
   private String memberinfo;
   
   private int paidamount;
   
   private String paiddate;
   
   private String paymentmode;
   
   private String remarks;
   
   private int paymentmodeid;
   
   public int getPaymentmodeid()
   {
/*  30 */     return this.paymentmodeid;
   }
   
   public void setPaymentmodeid(int paymentmodeid) {
/*  34 */     this.paymentmodeid = paymentmodeid;
   }
   
   public int getPaymentid() {
/*  38 */     return this.paymentid;
   }
   
   public void setPaymentid(int paymentid) {
/*  42 */     this.paymentid = paymentid;
   }
   
   public int getGroupid() {
/*  46 */     return this.groupid;
   }
   
   public void setGroupid(int groupid) {
/*  50 */     this.groupid = groupid;
   }
   
   public int getMemberid() {
/*  54 */     return this.memberid;
   }
   
   public void setMemberid(int memberid) {
/*  58 */     this.memberid = memberid;
   }
   
   public String getGroup() {
/*  62 */     return this.group;
   }
   
   public void setGroup(String group) {
/*  66 */     this.group = group;
   }
   
   public String getMembername() {
/*  70 */     return this.membername;
   }
   
   public void setMembername(String membername) {
/*  74 */     this.membername = membername;
   }
   
   public String getMemberinfo() {
/*  78 */     return this.memberinfo;
   }
   
   public void setMemberinfo(String memberinfo) {
/*  82 */     this.memberinfo = memberinfo;
   }
   
   public int getPaidamount() {
/*  86 */     return this.paidamount;
   }
   
   public void setPaidamount(int paidamount) {
/*  90 */     this.paidamount = paidamount;
   }
   
   public String getPaiddate() {
/*  94 */     return this.paiddate;
   }
   
   public void setPaiddate(String paiddate) {
/*  98 */     this.paiddate = paiddate;
   }
   
   public String getPaymentmode() {
/* 102 */     return this.paymentmode;
   }
   
   public void setPaymentmode(String paymentmode) {
/* 106 */     this.paymentmode = paymentmode;
   }
   
   public String getRemarks() {
/* 110 */     return this.remarks;
   }
   
   public void setRemarks(String remarks) {
/* 114 */     this.remarks = remarks;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\paymentstatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */