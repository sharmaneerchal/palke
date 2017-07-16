 package com.myapp.struts.transaction;
 
 import com.myapp.struts.beans.transactionDispBean;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
 import mappings.Members;
 import org.apache.struts.action.ActionForm;
 
 
 
 
 
 
 
 
 
 public class transactionForm
   extends ActionForm
 {
   private int groupid;
   private List groups;
   private String group;
   private String selectedmember;
/*  26 */   private List<transactionDispBean> lstPayment = new ArrayList();
   private String memberaddress;
   private String membercontactno;
   private int memberid;
   private int memberno;
   private String date;
   private String helpdate;
   private int amount;
   private List amountlst;
   private String paymentmode;
   private String remarks;
   private int term;
   private String message;
   private int drawtypeid;
   private List drawtypes;
   private String drawdate;
   private double prizeamount;
   private int oldpayment;
   private int updatepayment;
   private String totalpaidamount;
   private String drawamount;
   private String status;
   private String totalamount;
   private String actualstartdate;
   private String settlementcomment;
/*  51 */   private List<Members> lstMembers = new ArrayList();
   
   public String getHelpdate() {
/*  54 */     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
/*  55 */     this.helpdate = sdf.format(new Date());
/*  56 */     return this.helpdate;
   }
   
   public void setHelpdate(String helpdate) {
/*  60 */     this.helpdate = helpdate;
   }
   
   public String getGroup() {
/*  64 */     return this.group;
   }
   
   public void setGroup(String group) {
/*  68 */     this.group = group;
   }
   
   public List<Members> getLstMembers() {
/*  72 */     return this.lstMembers;
   }
   
   public void setLstMembers(List<Members> lstMembers) {
/*  76 */     this.lstMembers = lstMembers;
   }
   
   public String getSettlementcomment() {
/*  80 */     return this.settlementcomment;
   }
   
   public void setSettlementcomment(String settlementcomment) {
/*  84 */     this.settlementcomment = settlementcomment;
   }
   
   public String getActualstartdate() {
/*  88 */     return this.actualstartdate;
   }
   
   public void setActualstartdate(String actualstartdate) {
/*  92 */     this.actualstartdate = actualstartdate;
   }
   
   public String getTotalpaidamount() {
/*  96 */     return this.totalpaidamount;
   }
   
   public void setTotalpaidamount(String totalpaidamount) {
/* 100 */     this.totalpaidamount = totalpaidamount;
   }
   
   public String getDrawamount() {
/* 104 */     return this.drawamount;
   }
   
   public void setDrawamount(String drawamount) {
/* 108 */     this.drawamount = drawamount;
   }
   
   public String getTotalamount() {
/* 112 */     return this.totalamount;
   }
   
   public void setTotalamount(String totalamount) {
/* 116 */     this.totalamount = totalamount;
   }
   
   public String getStatus() {
/* 120 */     return this.status;
   }
   
   public void setStatus(String status) {
/* 124 */     this.status = status;
   }
   
   public int getUpdatepayment() {
/* 128 */     return this.updatepayment;
   }
   
   public void setUpdatepayment(int updatepayment) {
/* 132 */     this.updatepayment = updatepayment;
   }
   
   public int getOldpayment() {
/* 136 */     return this.oldpayment;
   }
   
   public void setOldpayment(int oldpayment) {
/* 140 */     this.oldpayment = oldpayment;
   }
   
   public int getDrawtypeid() {
/* 144 */     return this.drawtypeid;
   }
   
   public void setDrawtypeid(int drawtypeid) {
/* 148 */     this.drawtypeid = drawtypeid;
   }
   
   public List getDrawtypes() {
/* 152 */     return this.drawtypes;
   }
   
   public void setDrawtypes(List drawtypes) {
/* 156 */     this.drawtypes = drawtypes;
   }
   
   public String getDrawdate() {
/* 160 */     return this.drawdate;
   }
   
   public void setDrawdate(String drawdate) {
/* 164 */     this.drawdate = drawdate;
   }
   
   public double getPrizeamount() {
/* 168 */     return this.prizeamount;
   }
   
   public void setPrizeamount(double prizeamount) {
/* 172 */     this.prizeamount = prizeamount;
   }
   
   public String getMessage() {
/* 176 */     return this.message;
   }
   
   public void setMessage(String message) {
/* 180 */     this.message = message;
   }
   
   public int getTerm() {
/* 184 */     return this.term;
   }
   
   public void setTerm(int term) {
/* 188 */     this.term = term;
   }
   
   public String getDate() {
/* 192 */     return this.date;
   }
   
   public void setDate(String date) {
/* 196 */     this.date = date;
   }
   
   public int getAmount() {
/* 200 */     return this.amount;
   }
   
   public void setAmount(int amount) {
/* 204 */     this.amount = amount;
   }
   
   public List getAmountlst() {
/* 208 */     return this.amountlst;
   }
   
   public void setAmountlst(List amountlst) {
/* 212 */     this.amountlst = amountlst;
   }
   
   public String getPaymentmode() {
/* 216 */     return this.paymentmode;
   }
   
   public void setPaymentmode(String paymentmode) {
/* 220 */     this.paymentmode = paymentmode;
   }
   
   public String getRemarks() {
/* 224 */     return this.remarks;
   }
   
   public void setRemarks(String remarks) {
/* 228 */     this.remarks = remarks;
   }
   
   public int getMemberno() {
/* 232 */     return this.memberno;
   }
   
   public void setMemberno(int memberno) {
/* 236 */     this.memberno = memberno;
   }
   
   public int getMemberid() {
/* 240 */     return this.memberid;
   }
   
   public void setMemberid(int memberid) {
/* 244 */     this.memberid = memberid;
   }
   
   public String getMemberaddress() {
/* 248 */     return this.memberaddress;
   }
   
   public void setMemberaddress(String memberaddress) {
/* 252 */     this.memberaddress = memberaddress;
   }
   
   public String getMembercontactno() {
/* 256 */     return this.membercontactno;
   }
   
   public void setMembercontactno(String membercontactno) {
/* 260 */     this.membercontactno = membercontactno;
   }
   
   public List<transactionDispBean> getLstPayment() {
/* 264 */     return this.lstPayment;
   }
   
   public void setLstPayment(List<transactionDispBean> lstPayment) {
/* 268 */     this.lstPayment = lstPayment;
   }
   
   public String getSelectedmember() {
/* 272 */     return this.selectedmember;
   }
   
   public void setSelectedmember(String selectedmember) {
/* 276 */     this.selectedmember = selectedmember;
   }
   
   public int getGroupid() {
/* 280 */     return this.groupid;
   }
   
   public void setGroupid(int groupid) {
/* 284 */     this.groupid = groupid;
   }
   
   public List getGroups() {
/* 288 */     return this.groups;
   }
   
   public void setGroups(List groups) {
/* 292 */     this.groups = groups;
   }
 }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\transaction\transactionForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */