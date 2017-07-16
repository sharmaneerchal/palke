/*    */ package com.myapp.struts.masters;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mappings.Employees;
/*    */ import mappings.Items;
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
/*    */ public class MasterDataForm
/*    */   extends ActionForm
/*    */ {
/* 20 */   private List<Employees> lstEmp = new ArrayList();
/* 21 */   private List<Items> lstItems = new ArrayList();
/*    */   private int employeeid;
/*    */   private int itemid;
/*    */   private String message;
/* 25 */   private Employees employee = new Employees();
/* 26 */   private Items item = new Items();
/*    */   
/*    */   public String getMessage() {
/* 29 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 33 */     this.message = message;
/*    */   }
/*    */   
/*    */   public Employees getEmployee() {
/* 37 */     return this.employee;
/*    */   }
/*    */   
/*    */   public void setEmployee(Employees employee) {
/* 41 */     this.employee = employee;
/*    */   }
/*    */   
/*    */   public Items getItem() {
/* 45 */     return this.item;
/*    */   }
/*    */   
/*    */   public void setItem(Items item) {
/* 49 */     this.item = item;
/*    */   }
/*    */   
/*    */   public int getEmployeeid() {
/* 53 */     return this.employeeid;
/*    */   }
/*    */   
/*    */   public void setEmployeeid(int employeeid) {
/* 57 */     this.employeeid = employeeid;
/*    */   }
/*    */   
/*    */   public int getItemid() {
/* 61 */     return this.itemid;
/*    */   }
/*    */   
/*    */   public void setItemid(int itemid) {
/* 65 */     this.itemid = itemid;
/*    */   }
/*    */   
/*    */   public List<Employees> getLstEmp() {
/* 69 */     return this.lstEmp;
/*    */   }
/*    */   
/*    */   public void setLstEmp(List<Employees> lstEmp) {
/* 73 */     this.lstEmp = lstEmp;
/*    */   }
/*    */   
/*    */   public List<Items> getLstItems() {
/* 77 */     return this.lstItems;
/*    */   }
/*    */   
/*    */   public void setLstItems(List<Items> lstItems) {
/* 81 */     this.lstItems = lstItems;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\masters\MasterDataForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */