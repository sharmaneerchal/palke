 package com.myapp.struts.beans;
 
 import java.util.Date;
 
 
 
 
 
 
 
 
 
 public class MemberDetails
 {
   private int memberid;
   private int groupid;
   private String group;
   private String membername;
   private String memberaddress;
   private String contactno;
   private String email;
   private String joinDate;
   private int memberno;
   private Date date;
   private boolean edited;
   
   public MemberDetails()
   {
/*  29 */     this.edited = false;
   }
   
   public MemberDetails(int groupid, String group, String membername, String memberaddress, String contactno, String email, int memberid, String joinDate, int memberno, Date date, boolean edited) {
/*  33 */     this.groupid = groupid;
/*  34 */     this.group = group;
/*  35 */     this.membername = membername;
/*  36 */     this.memberaddress = memberaddress;
/*  37 */     this.contactno = contactno;
/*  38 */     this.email = email;
/*  39 */     this.memberid = memberid;
/*  40 */     this.joinDate = joinDate;
/*  41 */     this.memberno = memberno;
/*  42 */     this.date = date;
/*  43 */     this.edited = edited;
   }
   
   public boolean isEdited() {
/*  47 */     return this.edited;
   }
   
   public void setEdited(boolean edited) {
/*  51 */     this.edited = edited;
   }
   
   public String getJoinDate() {
/*  55 */     return this.joinDate;
   }
   
   public void setJoinDate(String joinDate) {
/*  59 */     this.joinDate = joinDate;
   }
   
   public Date getDate() {
/*  63 */     return this.date;
   }
   
   public void setDate(Date date) {
/*  67 */     this.date = date;
   }
   
   public int getMemberno() {
/*  71 */     return this.memberno;
   }
   
   public void setMemberno(int memberno) {
/*  75 */     this.memberno = memberno;
   }
   
   public int getMemberid() {
/*  79 */     return this.memberid;
   }
   
   public void setMemberid(int memberid) {
/*  83 */     this.memberid = memberid;
   }
   
   public int getGroupid() {
/*  87 */     return this.groupid;
   }
   
   public void setGroupid(int groupid) {
/*  91 */     this.groupid = groupid;
   }
   
   public String getGroup() {
/*  95 */     return this.group;
   }
   
   public void setGroup(String group) {
/*  99 */     this.group = group;
   }
   
   public String getMembername() {
/* 103 */     return this.membername;
   }
   
   public void setMembername(String membername) {
/* 107 */     this.membername = membername;
   }
   
   public String getMemberaddress() {
/* 111 */     return this.memberaddress;
   }
   
   public void setMemberaddress(String memberaddress) {
/* 115 */     this.memberaddress = memberaddress;
   }
   
   public String getContactno() {
/* 119 */     return this.contactno;
   }
   
   public void setContactno(String contactno) {
/* 123 */     this.contactno = contactno;
   }
   
   public String getEmail() {
/* 127 */     return this.email;
   }
   
   public void setEmail(String email) {
/* 131 */     this.email = email;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\MemberDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */