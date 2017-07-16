/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Paymentmodes
/*    */   implements Serializable
/*    */ {
/*    */   private Integer paymentmodeid;
/*    */   private String paymentmode;
/* 16 */   private Set<Payment> payments = new HashSet(0);
/*    */   
/*    */   public Paymentmodes() {}
/*    */   
/*    */   public Paymentmodes(String paymentmode, Set<Payment> payments)
/*    */   {
/* 22 */     this.paymentmode = paymentmode;
/* 23 */     this.payments = payments;
/*    */   }
/*    */   
/*    */   public Integer getPaymentmodeid() {
/* 27 */     return this.paymentmodeid;
/*    */   }
/*    */   
/*    */   public void setPaymentmodeid(Integer paymentmodeid) {
/* 31 */     this.paymentmodeid = paymentmodeid;
/*    */   }
/*    */   
/* 34 */   public String getPaymentmode() { return this.paymentmode; }
/*    */   
/*    */   public void setPaymentmode(String paymentmode)
/*    */   {
/* 38 */     this.paymentmode = paymentmode;
/*    */   }
/*    */   
/* 41 */   public Set<Payment> getPayments() { return this.payments; }
/*    */   
/*    */   public void setPayments(Set<Payment> payments)
/*    */   {
/* 45 */     this.payments = payments;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Paymentmodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */