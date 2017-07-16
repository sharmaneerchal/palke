package mappings;
// Generated 13 May, 2017 2:21:04 PM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;

/**
 * Ornamentstock generated by hbm2java
 */
public class Ornamentstock implements java.io.Serializable {

    private Integer ornamentstockid;
    private String ornamentstockno;
    private String description;
    private Integer itemid;
    private String memono;
    private Integer memoid;
    private Double grossweight;
    private Double goldweight;
    private Double stoneweight;
    private String stonetype;
    private Double netweight;
    private Double wastage;
    private Double totalglodused;
    private Date insertdate;
    private Double revgrossweight;
    private Double revnetweight;
    private Double revwastage;
    private Double revtotalglodused;
    private boolean sold;
    private boolean transfered;

    public Ornamentstock() {
    }

    public Ornamentstock(String ornamentstockno, String description, Integer itemid, String memono, Integer memoid, Double grossweight, Double goldweight, Double stoneweight, String stonetype, Double netweight, Double wastage, Double totalglodused, Date insertdate, Double revgrossweight, Double revnetweight, Double revwastage, Double revtotalglodused, boolean sold, boolean transfered) {
        this.ornamentstockno = ornamentstockno;
        this.description = description;
        this.itemid = itemid;
        this.memono = memono;
        this.memoid = memoid;
        this.grossweight = grossweight;
        this.goldweight = goldweight;
        this.stoneweight = stoneweight;
        this.stonetype = stonetype;
        this.netweight = netweight;
        this.wastage = wastage;
        this.totalglodused = totalglodused;
        this.insertdate = insertdate;
        this.revgrossweight = revgrossweight;
        this.revnetweight = revnetweight;
        this.revwastage = revwastage;
        this.revtotalglodused = revtotalglodused;
        this.sold = sold;
        this.transfered = transfered;
    }

    public Integer getOrnamentstockid() {
        return this.ornamentstockid;
    }

    public void setOrnamentstockid(Integer ornamentstockid) {
        this.ornamentstockid = ornamentstockid;
    }

    public String getOrnamentstockno() {
        return this.ornamentstockno;
    }

    public void setOrnamentstockno(String ornamentstockno) {
        this.ornamentstockno = ornamentstockno;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getItemid() {
        return this.itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getMemono() {
        return this.memono;
    }

    public void setMemono(String memono) {
        this.memono = memono;
    }

    public Integer getMemoid() {
        return this.memoid;
    }

    public void setMemoid(Integer memoid) {
        this.memoid = memoid;
    }

    public Double getGrossweight() {
        return this.grossweight;
    }

    public void setGrossweight(Double grossweight) {
        this.grossweight = grossweight;
    }

    public Double getGoldweight() {
        return this.goldweight;
    }

    public void setGoldweight(Double goldweight) {
        this.goldweight = goldweight;
    }

    public Double getStoneweight() {
        return this.stoneweight;
    }

    public void setStoneweight(Double stoneweight) {
        this.stoneweight = stoneweight;
    }

    public String getStonetype() {
        return this.stonetype;
    }

    public void setStonetype(String stonetype) {
        this.stonetype = stonetype;
    }

    public Double getNetweight() {
        return this.netweight;
    }

    public void setNetweight(Double netweight) {
        this.netweight = netweight;
    }

    public Double getWastage() {
        return this.wastage;
    }

    public void setWastage(Double wastage) {
        this.wastage = wastage;
    }

    public Double getTotalglodused() {
        return this.totalglodused;
    }

    public void setTotalglodused(Double totalglodused) {
        this.totalglodused = totalglodused;
    }

    public Date getInsertdate() {
        return this.insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Double getRevgrossweight() {
        return this.revgrossweight;
    }

    public void setRevgrossweight(Double revgrossweight) {
        this.revgrossweight = revgrossweight;
    }

    public Double getRevnetweight() {
        return this.revnetweight;
    }

    public void setRevnetweight(Double revnetweight) {
        this.revnetweight = revnetweight;
    }

    public Double getRevwastage() {
        return this.revwastage;
    }

    public void setRevwastage(Double revwastage) {
        this.revwastage = revwastage;
    }

    public Double getRevtotalglodused() {
        return this.revtotalglodused;
    }

    public void setRevtotalglodused(Double revtotalglodused) {
        this.revtotalglodused = revtotalglodused;
    }

    public boolean getSold() {
        return this.sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean getTransfered() {
        return this.transfered;
    }

    public void setTransfered(boolean transfered) {
        this.transfered = transfered;
    }

}
