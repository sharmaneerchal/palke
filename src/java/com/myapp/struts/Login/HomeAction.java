/*    */ package com.myapp.struts.Login;
/*    */ 
/*    */ import com.myapp.struts.Utility.Constants;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.apache.struts.actions.DispatchAction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HomeAction
/*    */   extends DispatchAction
/*    */ {
/*    */   public ActionForward displayHome(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 25 */     if (Constants.isSessionActive(request)) {
/* 26 */       return mapping.findForward("display");
/*    */     }
/* 28 */     return mapping.findForward("exp");
/*    */   }
/*    */   
/*    */ 
/*    */   public ActionForward displayAppHome(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 34 */     if (Constants.isSessionActive(request)) {
/* 35 */       return mapping.findForward("home");
/*    */     }
/* 37 */     return mapping.findForward("exp");
/*    */   }
/*    */   
/*    */ 
/*    */   public ActionForward displayOrderHome(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 43 */     if (Constants.isSessionActive(request)) {
/* 44 */       return mapping.findForward("orderhome");
/*    */     }
/* 46 */     return mapping.findForward("exp");
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Login\HomeAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */