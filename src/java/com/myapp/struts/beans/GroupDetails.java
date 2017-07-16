 package com.myapp.struts.beans;
 
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
 
 
 
 
 
 
 
 
 
 public class GroupDetails
 {
   private int groupid;
   private int rowid;
   private String groupname;
   private int noofmembers;
   private int noofexistmembers;
   private int noofinstallments;
   private String startdate;
   private String enddate;
   private String status;
   private int installmentamount;
   private int bonousamount;
   private String drawdetails;
   private Date createddate;
   private int createdby;
   private List<DrawDetailsData> lstDrawDetails;
   
   public GroupDetails()
   {
/*  35 */     this.lstDrawDetails = new ArrayList();
   }
   
   public GroupDetails(int groupid, int rowid, String groupname, int noofmembers, int noofexistmembers, int noofinstallments, String startdate, String enddate, String status, int installmentamount, int bonousamount, String drawdetails, Date createddate, int createdby, List<DrawDetailsData> lstDrawDetails) {
/*  39 */     this.groupid = groupid;
/*  40 */     this.rowid = rowid;
/*  41 */     this.groupname = groupname;
/*  42 */     this.noofmembers = noofmembers;
/*  43 */     this.noofexistmembers = noofexistmembers;
/*  44 */     this.noofinstallments = noofinstallments;
/*  45 */     this.startdate = startdate;
/*  46 */     this.enddate = enddate;
/*  47 */     this.status = status;
/*  48 */     this.installmentamount = installmentamount;
/*  49 */     this.bonousamount = bonousamount;
/*  50 */     this.drawdetails = drawdetails;
/*  51 */     this.createddate = createddate;
/*  52 */     this.createdby = createdby;
/*  53 */     this.lstDrawDetails = lstDrawDetails;
   }
   
   public Date getCreateddate() {
/*  57 */     return this.createddate;
   }
   
   public void setCreateddate(Date createddate) {
/*  61 */     this.createddate = createddate;
   }
   
   public int getCreatedby() {
/*  65 */     return this.createdby;
   }
   
   public void setCreatedby(int createdby) {
/*  69 */     this.createdby = createdby;
   }
   
   public int getNoofexistmembers() {
/*  73 */     return this.noofexistmembers;
   }
   
   public void setNoofexistmembers(int noofexistmembers) {
/*  77 */     this.noofexistmembers = noofexistmembers;
   }
   
   public String getDrawdetails() {
/*  81 */     return this.drawdetails;
   }
   
   public void setDrawdetails(String drawdetails) {
/*  85 */     this.drawdetails = drawdetails;
   }
   
   public List<DrawDetailsData> getLstDrawDetails() {
/*  89 */     return this.lstDrawDetails;
   }
   
   public void setLstDrawDetails(List<DrawDetailsData> lstDrawDetails) {
/*  93 */     this.lstDrawDetails = lstDrawDetails;
   }
   
   public int getGroupid() {
/*  97 */     return this.groupid;
   }
   
   public void setGroupid(int groupid) {
/* 101 */     this.groupid = groupid;
   }
   
   public int getRowid() {
/* 105 */     return this.rowid;
   }
   
   public void setRowid(int rowid) {
/* 109 */     this.rowid = rowid;
   }
   
   public String getGroupname() {
/* 113 */     return this.groupname;
   }
   
   public void setGroupname(String groupname) {
/* 117 */     this.groupname = groupname;
   }
   
   public int getNoofmembers() {
/* 121 */     return this.noofmembers;
   }
   
   public void setNoofmembers(int noofmembers) {
/* 125 */     this.noofmembers = noofmembers;
   }
   
   public int getNoofinstallments() {
/* 129 */     return this.noofinstallments;
   }
   
   public void setNoofinstallments(int noofinstallments) {
/* 133 */     this.noofinstallments = noofinstallments;
   }
   
   public String getStartdate() {
/* 137 */     return this.startdate;
   }
   
   public void setStartdate(String startdate) {
/* 141 */     this.startdate = startdate;
   }
   
   public String getEnddate() {
/* 145 */     return this.enddate;
   }
   
   public void setEnddate(String enddate) {
/* 149 */     this.enddate = enddate;
   }
   
   public String getStatus() {
/* 153 */     return this.status;
   }
   
   public void setStatus(String status) {
/* 157 */     this.status = status;
   }
   
   public double getInstallmentamount() {
/* 161 */     return this.installmentamount;
   }
   
   public void setInstallmentamount(int installmentamount) {
/* 165 */     this.installmentamount = installmentamount;
   }
   
   public double getBonousamount() {
/* 169 */     return this.bonousamount;
   }
   
   public void setBonousamount(int bonousamount) {
/* 173 */     this.bonousamount = bonousamount;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\beans\GroupDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */