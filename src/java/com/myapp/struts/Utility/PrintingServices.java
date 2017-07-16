/*    */ package com.myapp.struts.Utility;
/*    */ 
/*    */ import javax.print.PrintService;
/*    */ import javax.print.PrintServiceLookup;
/*    */ import javax.print.attribute.HashPrintRequestAttributeSet;
/*    */ import javax.print.attribute.PrintRequestAttributeSet;
/*    */ import javax.print.attribute.standard.Copies;
/*    */ import javax.print.attribute.standard.Sides;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrintingServices
/*    */ {
/*    */   public PrintService getCheckPrintService()
/*    */   {
/* 26 */     PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
/*    */     
/*    */ 
/* 29 */     attr_set.add(new Copies(1));
/* 30 */     attr_set.add(Sides.ONE_SIDED);
/* 31 */     PrintService service = PrintServiceLookup.lookupDefaultPrintService();
/*    */     
/*    */ 
/* 34 */     return service;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Utility\PrintingServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */