/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Utility;

import com.myapp.struts.beans.paymentstatus;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Habibullah
 */
public class PrintStatement implements Printable {
    
    private List<paymentstatus> lst;
    
    public List<paymentstatus> getLst() {
        return lst;
    }
    
    public void setLst(List<paymentstatus> lst) {
        this.lst = lst;
    }
    
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
            
            return NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        
        String mText = "";
        float amt = 0;
        for (int i = 0; i < lst.size(); i++) {
            paymentstatus dispBean = lst.get(i);
            String mTextTemp;
            amt = amt + dispBean.getPaidamount();
            String paidamt;
            if ((dispBean.getPaidamount() + "").length() < 4) {
                paidamt = dispBean.getPaidamount() + "  ";
            } else {
                paidamt = dispBean.getPaidamount() + "";
            }
            
            if (i == 0) {
                mTextTemp = "------------------------------------------------------------------------------------------------- ;"
                        + "No.                Date                 Amount          Member ; "
                        + "------------------------------------------------------------------------------------------------- ;"
                        + "" + dispBean.getPaymentid() + "                 " + dispBean.getPaiddate() + "      " + paidamt + "           " + dispBean.getGroup() + "-" + dispBean.getMembername().split("-")[0].trim() + ";";
            } else if (i == (lst.size() - 1)) {
                mTextTemp = dispBean.getPaymentid() + "                 " + dispBean.getPaiddate() + "      " + paidamt + "           " + dispBean.getGroup() + "-" + dispBean.getMembername().split("-")[0].trim() + ";"
                        + "-------------------------------------------------------------------------------------------------- ;";
            } else {
                mTextTemp = dispBean.getPaymentid() + "                 " + dispBean.getPaiddate() + "      " + paidamt + "           " + dispBean.getGroup() + "-" + dispBean.getMembername().split("-")[0].trim() + ";";
            }
            
            mText = mText + mTextTemp;
            
        }
        //Prepare the rendering
        String[] bill = mText.split(";");
        int y = 10;
        
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 12);
        
        graphics.setFont(f);
        graphics.drawString("PALKE JEWELLERS", 40, y);
        y = y + 15;
        graphics.setFont(f);

        y = y + 5;
        graphics.setFont(f);
        f = new Font(Font.SANS_SERIF, Font.PLAIN, 9);
        graphics.setFont(f);
        SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
        graphics.drawString("PAYMENTS STATUS        DATED : " + dat.format(new Date()), 40, y);
        y = y + 15;
        
        f = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        graphics.setFont(f);
        int i = 1;
        for (String bill1 : bill) {
            f = new Font(Font.SANS_SERIF, Font.BOLD, 10);
            graphics.setFont(f);
            graphics.drawString(bill1, 30, y);
            y = y + 15;
        }
        y = y + 2;
        graphics.setFont(f);
        f = new Font(Font.SANS_SERIF, Font.BOLD, 11);
        graphics.setFont(f);
        graphics.drawString("Total          " + amt, 100, y);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
    
    public void printreceipt(List<paymentstatus> lst) {
//        PrintingServices ps = new PrintingServices();
        //get the printer service by printer name
//        PrintService pss = ps.getCheckPrintService();

        this.lst = lst;
        
        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintService(pss);
//        job.setPrintable(this);
        PageFormat pageFormat = job.defaultPage();
        Paper paper = pageFormat.getPaper();
        paper.setSize(6 * 72, 6 * 72);
        paper.setImageableArea(
                0.0, 0.0,
                paper.getWidth(), paper.getHeight()
        );
        
        pageFormat.setOrientation(PageFormat.PORTRAIT);
        job.setPrintable(this, pageFormat);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        
    }

//    public static void main(String[] args) {
//        PrintBill hwp = new PrintBill();
//        try {
//            hwp.pp();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
