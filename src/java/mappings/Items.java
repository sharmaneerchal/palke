package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1



/**
 * Items generated by hbm2java
 */
public class Items  implements java.io.Serializable {


     private Integer itemid;
     private String item;
     private String itemcode;

    public Items() {
    }

    public Items(String item, String itemcode) {
       this.item = item;
       this.itemcode = itemcode;
    }
   
    public Integer getItemid() {
        return this.itemid;
    }
    
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
    public String getItem() {
        return this.item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }
    public String getItemcode() {
        return this.itemcode;
    }
    
    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }




}

