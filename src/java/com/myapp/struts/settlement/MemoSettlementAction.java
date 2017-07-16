/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.settlement;

import com.myapp.struts.Utility.Constants;
import com.myapp.struts.dao.EmployeesDAO;
import com.myapp.struts.dao.ItemsDAO;
import com.myapp.struts.dao.OrnamentStockDAO;
import com.myapp.struts.dao.WorkersMemoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Employees;
import mappings.Workersmemo;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author S.N.Sharma
 */
public class MemoSettlementAction extends DispatchAction {

    Logger logger;

    public MemoSettlementAction() {
        this.logger = Logger.getLogger(MemoSettlementAction.class.getName());
    }

    public ActionForward loadMemoSettlementPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        if (Constants.isSessionActive(request)) {

            try {
                MemoSettlementForm memoForm = (MemoSettlementForm) form;
                memoForm.setBalance(0);
                memoForm.setEmployee(new Employees());
                memoForm.setEmployeeid(0);
                memoForm.setGoldIssued(0);
                memoForm.setGoldReturned(0);
                memoForm.setNoofmemo(0);
                memoForm.setSilverIssued(0);
                memoForm.setWorker(new ArrayList<Employees>());//
                memoForm.setWorkersmemo(new ArrayList<Workersmemo>());

                memoForm.setWorker(new EmployeesDAO().getEmployees());
                memoForm.setItems(new ItemsDAO().getItems());
            } catch (Exception ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return mapping.findForward("display");
    }

    public ActionForward onSelectEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        if (Constants.isSessionActive(request)) {
            MemoSettlementForm memoForm = (MemoSettlementForm) form;
            try {
                for (Employees employee : memoForm.getWorker()) {
                    if (employee.getEmployeeid() == memoForm.getEmployeeid()) {
                        memoForm.setEmployee(employee);
                        break;
                    }
                }
                List<Workersmemo> listMemo = new WorkersMemoDAO().getWorkMemoByWorker(memoForm.getEmployee().getName());
                memoForm.setWorkersmemo(listMemo);

                double goldIssued = 0;
                double silverIssued = 0;
                double goldReturned;
                double balance;

                StringBuilder memoNo = new StringBuilder();

                for (Workersmemo workersmemo : listMemo) {

                    goldIssued = workersmemo.getGoldweight() != null ? goldIssued + workersmemo.getGoldweight() : 0;

                    silverIssued = workersmemo.getSilverweight() != null ? silverIssued + workersmemo.getSilverweight() : 0;

                    memoNo.append(workersmemo.getWorkersmemoid());
                    memoNo.append(",");
                }
                memoNo.append("0");
                goldReturned = new OrnamentStockDAO().getGoldReturned(memoNo.toString());

                memoForm.setGoldIssued(goldIssued);
                memoForm.setGoldReturned(goldReturned);
                memoForm.setSilverIssued(silverIssued);

                balance = goldIssued - goldReturned;

                memoForm.setBalance(balance);
                memoForm.setNoofmemo(listMemo.size());

            } catch (Exception e) {
            }

        }
        return mapping.findForward("display");
    }
}
