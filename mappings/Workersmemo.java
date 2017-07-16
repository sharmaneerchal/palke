package mappings;

import java.io.Serializable;
import java.util.Date;

public class Workersmemo
        implements Serializable {

    private Integer workersmemoid;
    private Integer workermemono;
    private String orderno;
    private Date date;
    private Date createddate;
    private String employee;
    private Double goldweight;
    private Double silverweight;
    private Double stoneweight;
    private Double diamondweight;
    private String remarks;
    private String jewel;
    private Date readydate;
    private Double netweight;
    private String size;

    public Workersmemo() {
    }

    public Workersmemo(Integer workersmemoid, Integer workermemono, String orderno, Date date, Date createddate, String employee, Double goldweight, Double silverweight, Double stoneweight, Double diamondweight, String remarks, String jewel, Date readydate, Double netweight, String size) {
        this.workersmemoid = workersmemoid;
        this.workermemono = workermemono;
        this.orderno = orderno;
        this.date = date;
        this.createddate = createddate;
        this.employee = employee;
        this.goldweight = goldweight;
        this.silverweight = silverweight;
        this.stoneweight = stoneweight;
        this.diamondweight = diamondweight;
        this.remarks = remarks;
        this.jewel = jewel;
        this.readydate = readydate;
        this.netweight = netweight;
        this.size = size;
    }

    public String getJewel() {
        return jewel;
    }

    public void setJewel(String jewel) {
        this.jewel = jewel;
    }

    public Date getReadydate() {
        return readydate;
    }

    public void setReadydate(Date readydate) {
        this.readydate = readydate;
    }

    public Double getNetweight() {
        return netweight;
    }

    public void setNetweight(Double netweight) {
        this.netweight = netweight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getWorkersmemoid() {
        /*  42 */ return this.workersmemoid;
    }

    public void setWorkersmemoid(Integer workersmemoid) {
        /*  46 */ this.workersmemoid = workersmemoid;
    }

    /*  49 */ public Integer getWorkermemono() {
        return this.workermemono;
    }

    public void setWorkermemono(Integer workermemono) {
        /*  53 */ this.workermemono = workermemono;
    }

    /*  56 */ public String getOrderno() {
        return this.orderno;
    }

    public void setOrderno(String orderno) {
        /*  60 */ this.orderno = orderno;
    }

    /*  63 */ public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        /*  67 */ this.date = date;
    }

    /*  70 */ public Date getCreateddate() {
        return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        /*  74 */ this.createddate = createddate;
    }

    /*  77 */ public String getEmployee() {
        return this.employee;
    }

    public void setEmployee(String employee) {
        /*  81 */ this.employee = employee;
    }

    /*  84 */ public Double getGoldweight() {
        return this.goldweight;
    }

    public void setGoldweight(Double goldweight) {
        /*  88 */ this.goldweight = goldweight;
    }

    /*  91 */ public Double getSilverweight() {
        return this.silverweight;
    }

    public void setSilverweight(Double silverweight) {
        /*  95 */ this.silverweight = silverweight;
    }

    /*  98 */ public Double getStoneweight() {
        return this.stoneweight;
    }

    public void setStoneweight(Double stoneweight) {
        /* 102 */ this.stoneweight = stoneweight;
    }

    /* 105 */ public Double getDiamondweight() {
        return this.diamondweight;
    }

    public void setDiamondweight(Double diamondweight) {
        /* 109 */ this.diamondweight = diamondweight;
    }

    /* 112 */ public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        /* 116 */ this.remarks = remarks;
    }

    public static void main(String[] args) {
        String firstname1 = "BC8";
        firstname1 = firstname1.replaceAll("[A-Z]", "");
        System.out.println(firstname1);
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\mappings\Workersmemo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
