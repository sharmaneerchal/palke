/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.settlement;

import java.util.ArrayList;
import java.util.List;
import mappings.Employees;
import mappings.Items;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author S.N.Sharma
 */
public class MemoSettlementForm extends ActionForm {

    private List<Employees> worker = new ArrayList<Employees>();
    private List<Workersmemo> workersmemo = new ArrayList<Workersmemo>();
    private Employees employee = new Employees();
    private List<Items> items = new ArrayList<Items>();
    private int employeeid;

    private double goldIssued;
    private double silverIssued;
    private double goldReturned;
    private double balance;
    private Integer noofmemo;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Integer getNoofmemo() {
        return noofmemo;
    }

    public void setNoofmemo(Integer noofmemo) {
        this.noofmemo = noofmemo;
    }

    public double getGoldIssued() {
        return goldIssued;
    }

    public void setGoldIssued(double goldIssued) {
        this.goldIssued = goldIssued;
    }

    public double getSilverIssued() {
        return silverIssued;
    }

    public void setSilverIssued(double silverIssued) {
        this.silverIssued = silverIssued;
    }

    public double getGoldReturned() {
        return goldReturned;
    }

    public void setGoldReturned(double goldReturned) {
        this.goldReturned = goldReturned;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Workersmemo> getWorkersmemo() {
        return workersmemo;
    }

    public void setWorkersmemo(List<Workersmemo> workersmemo) {
        this.workersmemo = workersmemo;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public List<Employees> getWorker() {
        return worker;
    }

    public void setWorker(List<Employees> worker) {
        this.worker = worker;
    }

}
