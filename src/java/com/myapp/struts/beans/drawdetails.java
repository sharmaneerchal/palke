 package com.myapp.struts.beans;
 
 
 public class drawdetails
 {
   private int groupid;
   
   private String group;
   
   private int memberid;
   
   private String member;
   
   private int term;
   
   private int drawtypeid;
   
   private String drawtype;
   
   private boolean edited;
   
   private boolean added;
   private int rowid;
   private int drawdetailsid;
   private String drawdate;
   private int amount;
   
   public drawdetails() {}
   
   public drawdetails(int groupid, String group, int memberid, String member, int term, int drawtypeid, String drawtype, boolean edited, boolean added, int rowid, int drawdetailsid, String drawdate, int amount)
   {
/*  32 */     this.groupid = groupid;
/*  33 */     this.group = group;
/*  34 */     this.memberid = memberid;
/*  35 */     this.member = member;
/*  36 */     this.term = term;
/*  37 */     this.drawtypeid = drawtypeid;
/*  38 */     this.drawtype = drawtype;
/*  39 */     this.edited = edited;
/*  40 */     this.added = added;
/*  41 */     this.rowid = rowid;
/*  42 */     this.drawdetailsid = drawdetailsid;
/*  43 */     this.drawdate = drawdate;
/*  44 */     this.amount = amount;
   }
   
   public int getAmount() {
/*  48 */     return this.amount;
   }
   
   public void setAmount(int amount) {
/*  52 */     this.amount = amount;
   }
   
   public String getDrawdate() {
/*  56 */     return this.drawdate;
   }
   
   public void setDrawdate(String drawdate) {
/*  60 */     this.drawdate = drawdate;
   }
   
   public int getDrawdetailsid() {
/*  64 */     return this.drawdetailsid;
   }
   
   public void setDrawdetailsid(int drawdetailsid) {
/*  68 */     this.drawdetailsid = drawdetailsid;
   }
   
   public int getRowid() {
/*  72 */     return this.rowid;
   }
   
   public void setRowid(int rowid) {
/*  76 */     this.rowid = rowid;
   }
   
   public boolean isAdded() {
/*  80 */     return this.added;
   }
   
   public void setAdded(boolean added) {
/*  84 */     this.added = added;
   }
   
   public boolean isEdited() {
/*  88 */     return this.edited;
   }
   
   public void setEdited(boolean edited) {
/*  92 */     this.edited = edited;
   }
   
   public int getGroupid() {
/*  96 */     return this.groupid;
   }
   
   public void setGroupid(int groupid) {
/* 100 */     this.groupid = groupid;
   }
   
   public String getGroup() {
/* 104 */     return this.group;
   }
   
   public void setGroup(String group) {
/* 108 */     this.group = group;
   }
   
   public int getMemberid() {
/* 112 */     return this.memberid;
   }
   
   public void setMemberid(int memberid) {
/* 116 */     this.memberid = memberid;
   }
   
   public String getMember() {
/* 120 */     return this.member;
   }
   
   public void setMember(String member) {
/* 124 */     this.member = member;
   }
   
   public int getTerm() {
/* 128 */     return this.term;
   }
   
   public void setTerm(int term) {
/* 132 */     this.term = term;
   }
   
   public int getDrawtypeid() {
/* 136 */     return this.drawtypeid;
   }
   
   public void setDrawtypeid(int drawtypeid) {
/* 140 */     this.drawtypeid = drawtypeid;
   }
   
   public String getDrawtype() {
/* 144 */     return this.drawtype;
   }
   
   public void setDrawtype(String drawtype) {
/* 148 */     this.drawtype = drawtype;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\drawdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */