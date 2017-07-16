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
/*    */ public class Groupdrawdetails
/*    */   implements Serializable
/*    */ {
/*    */   private Integer groupdrawdetailsid;
/*    */   private Groups groups;
/*    */   private Drawtypes drawtypes;
/* 17 */   private Set groupdrawpositionses = new HashSet(0);
/*    */   
/*    */   public Groupdrawdetails() {}
/*    */   
/*    */   public Groupdrawdetails(Groups groups, Drawtypes drawtypes, Set groupdrawpositionses)
/*    */   {
/* 23 */     this.groups = groups;
/* 24 */     this.drawtypes = drawtypes;
/* 25 */     this.groupdrawpositionses = groupdrawpositionses;
/*    */   }
/*    */   
/*    */   public Integer getGroupdrawdetailsid() {
/* 29 */     return this.groupdrawdetailsid;
/*    */   }
/*    */   
/*    */   public void setGroupdrawdetailsid(Integer groupdrawdetailsid) {
/* 33 */     this.groupdrawdetailsid = groupdrawdetailsid;
/*    */   }
/*    */   
/* 36 */   public Groups getGroups() { return this.groups; }
/*    */   
/*    */   public void setGroups(Groups groups)
/*    */   {
/* 40 */     this.groups = groups;
/*    */   }
/*    */   
/* 43 */   public Drawtypes getDrawtypes() { return this.drawtypes; }
/*    */   
/*    */   public void setDrawtypes(Drawtypes drawtypes)
/*    */   {
/* 47 */     this.drawtypes = drawtypes;
/*    */   }
/*    */   
/* 50 */   public Set getGroupdrawpositionses() { return this.groupdrawpositionses; }
/*    */   
/*    */   public void setGroupdrawpositionses(Set groupdrawpositionses)
/*    */   {
/* 54 */     this.groupdrawpositionses = groupdrawpositionses;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Groupdrawdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */