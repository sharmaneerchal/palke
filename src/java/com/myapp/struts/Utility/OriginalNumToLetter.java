/*    */ package com.myapp.struts.Utility;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class OriginalNumToLetter
/*    */ {
/*  7 */   private static final Logger log = Logger.getLogger(OriginalNumToLetter.class);
/*    */   
/*    */ 
/*    */   public String enterNumber(int num)
/*    */   {
/* 12 */     int q = 0;int r = 0;
/* 13 */     String ltr = "";
/* 14 */     String Str = "";
/* 15 */     ConstNumtoLetter n = new ConstNumtoLetter();
/*    */     
/*    */ 
/* 18 */     if (num <= 0) {
/* 19 */       System.out.println("Zero or Negative number not for conversion");
/*    */     }
/* 21 */     log.info("Zero or Negative number not for conversion");
/*    */     
/* 23 */     while (num > 0)
/*    */     {
/* 25 */       int len = n.numberCount(num);
/*    */       
/*    */ 
/* 28 */       switch (len) {
/*    */       case 8: 
/* 30 */         q = num / 10000000;
/* 31 */         r = num % 10000000;
/* 32 */         ltr = n.twonum(q);
/* 33 */         Str = Str + ltr + n.digit[4];
/* 34 */         num = r;
/* 35 */         break;
/*    */       
/*    */       case 6: 
/*    */       case 7: 
/* 39 */         q = num / 100000;
/* 40 */         r = num % 100000;
/* 41 */         ltr = n.twonum(q);
/* 42 */         Str = Str + ltr + n.digit[3];
/* 43 */         num = r;
/* 44 */         break;
/*    */       
/*    */ 
/*    */       case 4: 
/*    */       case 5: 
/* 49 */         q = num / 1000;
/* 50 */         r = num % 1000;
/* 51 */         ltr = n.twonum(q);
/* 52 */         Str = Str + ltr + n.digit[2];
/* 53 */         num = r;
/* 54 */         break;
/*    */       
/*    */ 
/*    */       case 3: 
/* 58 */         if (len == 3) {
/* 59 */           r = num;
/*    */         }
/* 61 */         ltr = n.threenum(r);
/* 62 */         Str = Str + ltr;
/* 63 */         num = 0;
/* 64 */         break;
/*    */       
/*    */ 
/*    */       case 2: 
/* 68 */         ltr = n.twonum(num);
/* 69 */         Str = Str + ltr;
/* 70 */         num = 0;
/* 71 */         break;
/*    */       
/*    */       case 1: 
/* 74 */         Str = Str + n.unitdo[num];
/* 75 */         num = 0;
/* 76 */         break;
/*    */       
/*    */       default: 
/* 79 */         num = 0;
/* 80 */         System.out.println("Exceeding Crore....No conversion");
/* 81 */         log.info("Exceeding Crore....No conversion");
/* 82 */         System.exit(1);
/*    */       }
/*    */       
/*    */       
/* 86 */       if (num == 0) {
/* 87 */         System.out.println(Str + " only");
/*    */       }
/* 89 */       log.info(Str + " only");
/*    */     }
/*    */     
/* 92 */     return "Rupees " + Str + " only";
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Utility\OriginalNumToLetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */