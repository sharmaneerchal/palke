/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Drawtypes
/*    */   implements Serializable
/*    */ {
/*    */   private Integer drawtypeid;
/*    */   private String drawtypes;
/* 14 */   private Set<Groupdrawdetails> groupdrawdetailses = new HashSet(0);
/* 15 */   private Set<Drawdetails> drawdetails = new HashSet(0);
/*    */   
/*    */   public Drawtypes() {}
/*    */   
/*    */   public Set<Drawdetails> getDrawdetails()
/*    */   {
/* 21 */     return this.drawdetails;
/*    */   }
/*    */   
/*    */   public void setDrawdetails(Set<Drawdetails> drawdetails) {
/* 25 */     this.drawdetails = drawdetails;
/*    */   }
/*    */   
/*    */   public Drawtypes(String drawtypes) {
/* 29 */     this.drawtypes = drawtypes;
/*    */   }
/*    */   
/*    */   public Drawtypes(String drawtypes, Set<Groupdrawdetails> groupdrawdetailses) {
/* 33 */     this.drawtypes = drawtypes;
/* 34 */     this.groupdrawdetailses = groupdrawdetailses;
/*    */   }
/*    */   
/*    */   public Integer getDrawtypeid() {
/* 38 */     return this.drawtypeid;
/*    */   }
/*    */   
/*    */   public void setDrawtypeid(Integer drawtypeid) {
/* 42 */     this.drawtypeid = drawtypeid;
/*    */   }
/*    */   
/*    */   public String getDrawtypes() {
/* 46 */     return this.drawtypes;
/*    */   }
/*    */   
/*    */   public void setDrawtypes(String drawtypes) {
/* 50 */     this.drawtypes = drawtypes;
/*    */   }
/*    */   
/*    */   public Set<Groupdrawdetails> getGroupdrawdetailses() {
/* 54 */     return this.groupdrawdetailses;
/*    */   }
/*    */   
/*    */   public void setGroupdrawdetailses(Set<Groupdrawdetails> groupdrawdetailses) {
/* 58 */     this.groupdrawdetailses = groupdrawdetailses;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Drawtypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */