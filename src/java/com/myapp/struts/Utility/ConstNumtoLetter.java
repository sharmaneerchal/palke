/*    */ package com.myapp.struts.Utility;
/*    */ 
/*    */ public class ConstNumtoLetter {
/*  4 */   String[] unitdo = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
/*    */   
/*    */ 
/*    */ 
/*  8 */   String[] tens = { "", "Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };
/*    */   
/* 10 */   String[] digit = { "", " Hundred", " Thousand", " Lakh", " Crore" };
/*    */   
/*    */   int r;
/*    */   
/*    */ 
/*    */   int numberCount(int num)
/*    */   {
/* 17 */     int cnt = 0;
/*    */     
/* 19 */     while (num > 0)
/*    */     {
/* 21 */       this.r = (num % 10);
/* 22 */       cnt++;
/* 23 */       num /= 10;
/*    */     }
/*    */     
/* 26 */     return cnt;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   String twonum(int numq)
/*    */   {
/* 35 */     String ltr = "";
/*    */     
/* 37 */     int nq = numq / 10;
/* 38 */     int numr = numq % 10;
/*    */     
/* 40 */     if (numq > 19)
/*    */     {
/* 42 */       ltr = ltr + this.tens[nq] + this.unitdo[numr];
/*    */     }
/*    */     else
/*    */     {
/* 46 */       ltr = ltr + this.unitdo[numq];
/*    */     }
/*    */     
/* 49 */     return ltr;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   String threenum(int numq)
/*    */   {
/* 57 */     String ltr = "";
/*    */     
/* 59 */     int nq = numq / 100;
/* 60 */     int numr = numq % 100;
/*    */     
/* 62 */     if (numr == 0)
/*    */     {
/* 64 */       ltr = ltr + this.unitdo[nq] + this.digit[1];
/*    */     }
/*    */     else
/*    */     {
/* 68 */       ltr = ltr + this.unitdo[nq] + this.digit[1] + " and" + twonum(numr);
/*    */     }
/* 70 */     return ltr;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Utility\ConstNumtoLetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */