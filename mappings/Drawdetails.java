/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Drawdetails
/*    */   implements Serializable
/*    */ {
/*    */   private Integer drawdetailsid;
/*    */   private Members members;
/*    */   private double amount;
/*    */   private Integer term;
/*    */   private Date drawdate;
/*    */   private Drawtypes drawtypes;
/*    */   
/*    */   public Drawdetails() {}
/*    */   
/*    */   public Drawdetails(Integer drawdetailsid, Members members, double prizeamount, Integer term, Date drawdate, Drawtypes drawtypes)
/*    */   {
/* 22 */     this.drawdetailsid = drawdetailsid;
/* 23 */     this.members = members;
/* 24 */     this.amount = prizeamount;
/* 25 */     this.term = term;
/* 26 */     this.drawtypes = drawtypes;
/* 27 */     this.drawdate = drawdate;
/*    */   }
/*    */   
/*    */   public Drawtypes getDrawtypes() {
/* 31 */     return this.drawtypes;
/*    */   }
/*    */   
/*    */   public void setDrawtypes(Drawtypes drawtypes) {
/* 35 */     this.drawtypes = drawtypes;
/*    */   }
/*    */   
/*    */   public double getAmount() {
/* 39 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(double amount) {
/* 43 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public Date getDrawdate() {
/* 47 */     return this.drawdate;
/*    */   }
/*    */   
/*    */   public void setDrawdate(Date drawdate) {
/* 51 */     this.drawdate = drawdate;
/*    */   }
/*    */   
/*    */   public Integer getDrawdetailsid() {
/* 55 */     return this.drawdetailsid;
/*    */   }
/*    */   
/*    */   public void setDrawdetailsid(Integer drawdetailsid) {
/* 59 */     this.drawdetailsid = drawdetailsid;
/*    */   }
/*    */   
/*    */   public Members getMembers() {
/* 63 */     return this.members;
/*    */   }
/*    */   
/*    */   public void setMembers(Members members) {
/* 67 */     this.members = members;
/*    */   }
/*    */   
/*    */   public Integer getTerm() {
/* 71 */     return this.term;
/*    */   }
/*    */   
/*    */   public void setTerm(Integer term) {
/* 75 */     this.term = term;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Drawdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */