package mappings;
// Generated 9 Jul, 2017 4:43:28 PM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;

/**
 * Payment generated by hbm2java
 */
public class Payment implements java.io.Serializable {

    private Integer paymentid;
    private Integer memberid;
    private Double paidamount;
    private Date paiddate;
    private Integer paymentmode;
    private String attachments;
    private String remarks;
    private boolean canceled;

    public Payment() {
    }

    public Payment(Integer memberid, Double paidamount, Date paiddate, Integer paymentmode, String attachments, String remarks, boolean canceled) {
        this.memberid = memberid;
        this.paidamount = paidamount;
        this.paiddate = paiddate;
        this.paymentmode = paymentmode;
        this.attachments = attachments;
        this.remarks = remarks;
        this.canceled = canceled;
    }

    public Integer getPaymentid() {
        return this.paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Integer getMemberid() {
        return this.memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Double getPaidamount() {
        return this.paidamount;
    }

    public void setPaidamount(Double paidamount) {
        this.paidamount = paidamount;
    }

    public Date getPaiddate() {
        return this.paiddate;
    }

    public void setPaiddate(Date paiddate) {
        this.paiddate = paiddate;
    }

    public Integer getPaymentmode() {
        return this.paymentmode;
    }

    public void setPaymentmode(Integer paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getAttachments() {
        return this.attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

}
