package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1



/**
 * Groupdrawpositions generated by hbm2java
 */
public class Groupdrawpositions  implements java.io.Serializable {


     private Integer groupdrawpositionsid;
     private Integer positionid;
     private Double amount;
     private Integer groupdrawdetailsid;

    public Groupdrawpositions() {
    }

    public Groupdrawpositions(Integer positionid, Double amount, Integer groupdrawdetailsid) {
       this.positionid = positionid;
       this.amount = amount;
       this.groupdrawdetailsid = groupdrawdetailsid;
    }
   
    public Integer getGroupdrawpositionsid() {
        return this.groupdrawpositionsid;
    }
    
    public void setGroupdrawpositionsid(Integer groupdrawpositionsid) {
        this.groupdrawpositionsid = groupdrawpositionsid;
    }
    public Integer getPositionid() {
        return this.positionid;
    }
    
    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Integer getGroupdrawdetailsid() {
        return this.groupdrawdetailsid;
    }
    
    public void setGroupdrawdetailsid(Integer groupdrawdetailsid) {
        this.groupdrawdetailsid = groupdrawdetailsid;
    }




}


