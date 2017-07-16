/*    */ package com.myapp.struts.Logout;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
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
/*    */ public class LogoutAction
/*    */   extends DispatchAction
/*    */ {
/*    */   public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 24 */     HttpSession session = request.getSession(false);
/* 25 */     session.invalidate();
/* 26 */     return mapping.findForward("display");
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Logout\LogoutAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */