/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Paymentdetails
/*    */   implements Serializable
/*    */ {
/*    */   private Integer paymentdetailsid;
/*    */   private Payment payment;
/*    */   private Integer term;
/*    */   
/*    */   public Paymentdetails() {}
/*    */   
/*    */   public Paymentdetails(Payment payment, Integer term)
/*    */   {
/* 21 */     this.payment = payment;
/* 22 */     this.term = term;
/*    */   }
/*    */   
/*    */   public Integer getPaymentdetailsid() {
/* 26 */     return this.paymentdetailsid;
/*    */   }
/*    */   
/*    */   public void setPaymentdetailsid(Integer paymentdetailsid) {
/* 30 */     this.paymentdetailsid = paymentdetailsid;
/*    */   }
/*    */   
/* 33 */   public Payment getPayment() { return this.payment; }
/*    */   
/*    */   public void setPayment(Payment payment)
/*    */   {
/* 37 */     this.payment = payment;
/*    */   }
/*    */   
/* 40 */   public Integer getTerm() { return this.term; }
/*    */   
/*    */   public void setTerm(Integer term)
/*    */   {
/* 44 */     this.term = term;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Paymentdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */