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
/*    */ public class Groupdrawpositions
/*    */   implements Serializable
/*    */ {
/*    */   private Integer groupdrawpositionsid;
/*    */   private Groupdrawdetails groupdrawdetails;
/*    */   private Positions positions;
/*    */   private Double amount;
/* 18 */   private Set drawdetailses = new HashSet(0);
/*    */   
/*    */   public Groupdrawpositions() {}
/*    */   
/*    */   public Groupdrawpositions(Groupdrawdetails groupdrawdetails, Positions positions, Double amount, Set drawdetailses)
/*    */   {
/* 24 */     this.groupdrawdetails = groupdrawdetails;
/* 25 */     this.positions = positions;
/* 26 */     this.amount = amount;
/* 27 */     this.drawdetailses = drawdetailses;
/*    */   }
/*    */   
/*    */   public Integer getGroupdrawpositionsid() {
/* 31 */     return this.groupdrawpositionsid;
/*    */   }
/*    */   
/*    */   public void setGroupdrawpositionsid(Integer groupdrawpositionsid) {
/* 35 */     this.groupdrawpositionsid = groupdrawpositionsid;
/*    */   }
/*    */   
/* 38 */   public Groupdrawdetails getGroupdrawdetails() { return this.groupdrawdetails; }
/*    */   
/*    */   public void setGroupdrawdetails(Groupdrawdetails groupdrawdetails)
/*    */   {
/* 42 */     this.groupdrawdetails = groupdrawdetails;
/*    */   }
/*    */   
/* 45 */   public Positions getPositions() { return this.positions; }
/*    */   
/*    */   public void setPositions(Positions positions)
/*    */   {
/* 49 */     this.positions = positions;
/*    */   }
/*    */   
/* 52 */   public Double getAmount() { return this.amount; }
/*    */   
/*    */   public void setAmount(Double amount)
/*    */   {
/* 56 */     this.amount = amount;
/*    */   }
/*    */   
/* 59 */   public Set getDrawdetailses() { return this.drawdetailses; }
/*    */   
/*    */   public void setDrawdetailses(Set drawdetailses)
/*    */   {
/* 63 */     this.drawdetailses = drawdetailses;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Groupdrawpositions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */