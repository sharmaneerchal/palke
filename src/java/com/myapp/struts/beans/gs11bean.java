/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author S.N.Sharma
 */
public class gs11bean implements Serializable {

    private Integer voucherid;
    private String voucherno;
    private Date voucherdate;
    private String amount;
    private Double weight;
    private String remarks;
    private String vouchertype;
    private String vouchercategory;
    private Date createddate;
    private Date updateddate;
    private Integer workersmemoid;
    private Integer workermemono;
    private String orderno;
    private Date date;
    //private Date createddate;
    private String employee;
    private Double goldweight;
    private Double silverweight;
    private Double stoneweight;
    private Double diamondweight;
    //private String remarks;

    public Integer getVoucherid() {
        return voucherid;
    }

    public void setVoucherid(Integer voucherid) {
        this.voucherid = voucherid;
    }

    public String getVoucherno() {
        return voucherno;
    }

    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno;
    }

    public Date getVoucherdate() {
        return voucherdate;
    }

    public void setVoucherdate(Date voucherdate) {
        this.voucherdate = voucherdate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getVouchertype() {
        return vouchertype;
    }

    public void setVouchertype(String vouchertype) {
        this.vouchertype = vouchertype;
    }

    public String getVouchercategory() {
        return vouchercategory;
    }

    public void setVouchercategory(String vouchercategory) {
        this.vouchercategory = vouchercategory;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    public Integer getWorkersmemoid() {
        return workersmemoid;
    }

    public void setWorkersmemoid(Integer workersmemoid) {
        this.workersmemoid = workersmemoid;
    }

    public Integer getWorkermemono() {
        return workermemono;
    }

    public void setWorkermemono(Integer workermemono) {
        this.workermemono = workermemono;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Double getGoldweight() {
        return goldweight;
    }

    public void setGoldweight(Double goldweight) {
        this.goldweight = goldweight;
    }

    public Double getSilverweight() {
        return silverweight;
    }

    public void setSilverweight(Double silverweight) {
        this.silverweight = silverweight;
    }

    public Double getStoneweight() {
        return stoneweight;
    }

    public void setStoneweight(Double stoneweight) {
        this.stoneweight = stoneweight;
    }

    public Double getDiamondweight() {
        return diamondweight;
    }

    public void setDiamondweight(Double diamondweight) {
        this.diamondweight = diamondweight;
    }

}
