/*    */ package com.myapp.struts.Login;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.struts.action.ActionErrors;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.apache.struts.action.ActionMessage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginForm
/*    */   extends ActionForm
/*    */ {
/*    */   private String userName;
/*    */   private String password;
/*    */   private String message;
/*    */   private boolean admin;
/*    */   
/*    */   public LoginForm() {}
/*    */   
/*    */   public LoginForm(String userName, String password, String message, boolean admin)
/*    */   {
/* 28 */     this.userName = userName;
/* 29 */     this.password = password;
/* 30 */     this.message = message;
/* 31 */     this.admin = admin;
/*    */   }
/*    */   
/*    */   public boolean isAdmin() {
/* 35 */     return this.admin;
/*    */   }
/*    */   
/*    */   public void setAdmin(boolean admin) {
/* 39 */     this.admin = admin;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 43 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 47 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 51 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 55 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getUserName() {
/* 59 */     return this.userName;
/*    */   }
/*    */   
/*    */   public void setUserName(String userName) {
/* 63 */     this.userName = userName;
/*    */   }
/*    */   
/*    */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
/* 67 */     ActionErrors errors = new ActionErrors();
/* 68 */     if ((this.userName == null) || (this.userName.length() < 1)) {
/* 69 */       errors.add("userName", new ActionMessage("error.userName.required"));
/*    */     }
/* 71 */     if ((this.password == null) || (this.password.length() < 1)) {
/* 72 */       errors.add("password", new ActionMessage("error.password.required"));
/*    */     }
/* 74 */     return errors;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Login\LoginForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */