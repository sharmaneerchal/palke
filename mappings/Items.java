/*    */ package mappings;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Items
/*    */   implements Serializable
/*    */ {
/*    */   private Integer itemid;
/*    */   private String item;
/*    */   private String itemcode;
/*    */   
/*    */   public String getItemcode()
/*    */   {
/* 14 */     return this.itemcode;
/*    */   }
/*    */   
/*    */   public void setItemcode(String itemcode) {
/* 18 */     this.itemcode = itemcode;
/*    */   }
/*    */   
/*    */   public Items() {}
/*    */   
/*    */   public Items(String item)
/*    */   {
/* 25 */     this.item = item;
/*    */   }
/*    */   
/*    */   public Integer getItemid() {
/* 29 */     return this.itemid;
/*    */   }
/*    */   
/*    */   public void setItemid(Integer itemid) {
/* 33 */     this.itemid = itemid;
/*    */   }
/*    */   
/*    */   public String getItem() {
/* 37 */     return this.item;
/*    */   }
/*    */   
/*    */   public void setItem(String item) {
/* 41 */     this.item = item;
/*    */   }
/*    */ }


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Items.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */