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
/*    */ public class Positions
/*    */   implements Serializable
/*    */ {
/*    */   private Integer positionid;
/*    */   private String position;
/* 16 */   private Set<Groupdrawpositions> groupdrawpositionses = new HashSet(0);
/*    */   
/*    */   public Positions() {}
/*    */   
/*    */   public Positions(String position, Set<Groupdrawpositions> groupdrawpositionses)
/*    */   {
/* 22 */     this.position = position;
/* 23 */     this.groupdrawpositionses = groupdrawpositionses;
/*    */   }
/*    */   
/*    */   public Integer getPositionid() {
/* 27 */     return this.positionid;
/*    */   }
/*    */   
/*    */   public void setPositionid(Integer positionid) {
/* 31 */     this.positionid = positionid;
/*    */   }
/*    */   
/* 34 */   public String getPosition() { return this.position; }
/*    */   
/*    */   public void setPosition(String position)
/*    */   {
/* 38 */     this.position = position;
/*    */   }
/*    */   
/* 41 */   public Set<Groupdrawpositions> getGroupdrawpositionses() { return this.groupdrawpositionses; }
/*    */   
/*    */   public void setGroupdrawpositionses(Set<Groupdrawpositions> groupdrawpositionses)
/*    */   {
/* 45 */     this.groupdrawpositionses = groupdrawpositionses;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Positions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */