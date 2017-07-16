/*    */ package com.myapp.struts.memoreport;
/*    */ 
/*    */ import com.myapp.struts.beans.MemoBalanceReportBean;
/*    */ import com.myapp.struts.beans.YearsBean;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MemoReportForm
/*    */   extends ActionForm
/*    */ {
/* 20 */   private List<MemoBalanceReportBean> lstMemos = new ArrayList();
/* 21 */   private List<YearsBean> lstyears = new ArrayList();
/*    */   private String year;
/*    */   private String message;
/*    */   
/*    */   public String getMessage() {
/* 26 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 30 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getYear() {
/* 34 */     return this.year;
/*    */   }
/*    */   
/*    */   public void setYear(String year) {
/* 38 */     this.year = year;
/*    */   }
/*    */   
/*    */   public List<YearsBean> getLstyears() {
/* 42 */     return this.lstyears;
/*    */   }
/*    */   
/*    */   public void setLstyears(List<YearsBean> lstyears) {
/* 46 */     this.lstyears = lstyears;
/*    */   }
/*    */   
/*    */   public List<MemoBalanceReportBean> getLstMemos() {
/* 50 */     return this.lstMemos;
/*    */   }
/*    */   
/*    */   public void setLstMemos(List<MemoBalanceReportBean> lstMemos) {
/* 54 */     this.lstMemos = lstMemos;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\memoreport\MemoReportForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */