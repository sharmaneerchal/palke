package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1



/**
 * Positions generated by hbm2java
 */
public class Positions  implements java.io.Serializable {


     private Integer positionid;
     private String position;

    public Positions() {
    }

    public Positions(String position) {
       this.position = position;
    }
   
    public Integer getPositionid() {
        return this.positionid;
    }
    
    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }




}


