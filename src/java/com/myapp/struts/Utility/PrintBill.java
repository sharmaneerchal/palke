package com.myapp.struts.Utility;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintBill
        implements Printable {

    private String memberName;
    private String totalamount;
    private int memberid;
    private String Date;
    private int amount;
    private String paymentMode;
    private String groupName;
    private String paymentid;
    private String remarks;

    public String getRemarks() {
        /*  34 */ return this.remarks;
    }

    public void setRemarks(String remarks) {
        /*  38 */ this.remarks = remarks;
    }

    public String getPaymentid() {
        /*  42 */ return this.paymentid;
    }

    public void setPaymentid(String paymentid) {
        /*  46 */ this.paymentid = paymentid;
    }

    public String getGroupName() {
        /*  50 */ return this.groupName;
    }

    public void setGroupName(String groupName) {
        /*  54 */ this.groupName = groupName;
    }

    public String getPaymentMode() {
        /*  58 */ return this.paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        /*  62 */ this.paymentMode = paymentMode;
    }

    public String getMemberName() {
        /*  66 */ return this.memberName;
    }

    public void setMemberName(String memberName) {
        /*  70 */ this.memberName = memberName;
    }

    public String getTotalamount() {
        /*  74 */ return this.totalamount;
    }

    public void setTotalamount(String totalamount) {
        /*  78 */ this.totalamount = totalamount;
    }

    public int getMemberid() {
        /*  82 */ return this.memberid;
    }

    public void setMemberid(int memberid) {
        /*  86 */ this.memberid = memberid;
    }

    public String getDate() {
        /*  90 */ return this.Date;
    }

    public void setDate(String Date) {
        /*  94 */ this.Date = Date;
    }

    public int getAmount() {
        /*  98 */ return this.amount;
    }

    public void setAmount(int amount) {
        /* 102 */ this.amount = amount;
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        /* 106 */ if (pageIndex > 0) {
            /* 108 */ return 1;
        }

        /* 111 */ Graphics2D g2d = (Graphics2D) graphics;
        /* 112 */ g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        /* 114 */ String mText = "";

        /* 116 */ if (this.paymentMode.equalsIgnoreCase("cheque/NEFT")) {
            /* 118 */ mText = "--------------------------------------------------------------------------- ;     Received with thanks from ;Mr/Mrs " + this.memberName + " ;" + "a sum of " + new OriginalNumToLetter().enterNumber(this.amount) + ";" + "by " + this.paymentMode + "(" + this.remarks + ") ;" + "towards the Gift Scheme instalment of ;" + "Member No " + this.memberid + " of Group " + this.groupName + " ;" + "                                                   For Palke Jewellers;" + "Rs. " + this.amount + "/-                                                       ;" + "                                             ...................................;" + "                                                            Partner   ;" + "                                                                           ;" + "Total amount received : " + this.totalamount + "                                   ;";

        } else {

            /* 132 */ mText = "---------------------------------------------------------------------------- ;     Received with thanks from ;Mr/Mrs " + this.memberName + " ;" + "a sum of " + new OriginalNumToLetter().enterNumber(this.amount) + ";" + "by " + this.paymentMode + " towards the Gift Scheme instalment of ;" + "Member No " + this.memberid + " of Group " + this.groupName + " ;" + "                                            For Palke Jewellers;" + "Rs. " + this.amount + "/-                                                       ;" + "                                      ...................................;" + "                                                      Partner          ;" + "                                                                           ;" + "Total amount received : " + this.totalamount + "                                   ;";
        }

        /* 146 */ String[] bill = mText.split(";");
        /* 147 */ int y = 20;

        /* 149 */ Font f = new Font("SansSerif", 1, 12);

        /* 151 */ graphics.setFont(f);
        /* 152 */ graphics.drawString("Receipt", 140, y);
        /* 153 */ y += 15;
        /* 154 */ graphics.setFont(f);

        /* 156 */ f = new Font("Serif", 1, 12);

        /* 158 */ graphics.setFont(f);
        /* 159 */ graphics.drawString("Receipt No. : " + this.paymentid + "                         Date: " + this.Date, 30, y);
        /* 160 */ y += 25;

        /* 167 */ f = new Font("SansSerif", 1, 11);

        /* 169 */ graphics.setFont(f);
        /* 170 */ graphics.drawString("PALKE JEWELLERS", 120, y);
        /* 171 */ y += 20;
        /* 172 */ graphics.setFont(f);
        /* 173 */ f = new Font("SansSerif", 0, 10);
        /* 174 */ graphics.setFont(f);
        /* 175 */ graphics.drawString("G. H. S. Road, Mangalore.", 120, y);
        /* 176 */ y += 15;

        /* 178 */ if (this.paymentMode.equalsIgnoreCase("cheque/NEFT")) {
            /* 179 */ f = new Font("SansSerif", 0, 11);
            /* 180 */ graphics.setFont(f);
            /* 181 */ int i = 1;
            /* 182 */ for (String bill1 : bill) {
                /* 183 */ if ((i == 7) || (i == 9) || (i == 13)) {
                    /* 184 */ f = new Font("SansSerif", 1, 11);
                    /* 185 */ graphics.setFont(f);
                    /* 186 */ graphics.drawString(bill1, 40, y);
                    /* 187 */ y += 15;
                } else {
                    /* 189 */ f = new Font("SansSerif", 0, 11);
                    /* 190 */ graphics.setFont(f);
                    /* 191 */ graphics.drawString(bill1, 40, y);
                    /* 192 */ y += 15;
                }

                /* 195 */ i++;
            }
        } else {
            /* 199 */ f = new Font("SansSerif", 0, 11);
            /* 200 */ graphics.setFont(f);
            /* 201 */ int i = 1;
            /* 202 */ for (String bill1 : bill) {
                /* 203 */ if ((i == 6) || (i == 8) || (i == 12)) {
                    /* 204 */ f = new Font("SansSerif", 1, 11);
                    /* 205 */ graphics.setFont(f);
                    /* 206 */ graphics.drawString(bill1, 40, y);
                    /* 207 */ y += 15;
                } else {
                    /* 209 */ f = new Font("SansSerif", 0, 11);
                    /* 210 */ graphics.setFont(f);
                    /* 211 */ graphics.drawString(bill1, 40, y);
                    /* 212 */ y += 15;
                }

                /* 215 */ i++;
            }
        }

        /* 221 */ return 0;
    }

    public void printreceipt(String memberName, String totalamount, int memberid, String dateP, int amount, String GroupName, String PaymentMode, int paymentid, String remarks)
            throws PrinterException {
        /* 229 */ this.Date = dateP;
        /* 230 */ this.amount = amount;
        /* 231 */ this.memberName = memberName;
        /* 232 */ this.totalamount = totalamount;
        /* 233 */ this.memberid = memberid;
        /* 234 */ this.groupName = GroupName;
        /* 235 */ this.paymentMode = PaymentMode;
        /* 236 */ this.paymentid = (paymentid + "");
        /* 237 */ this.remarks = remarks;

        /* 239 */ PrinterJob job = PrinterJob.getPrinterJob();

        /* 242 */ PageFormat pageFormat = job.defaultPage();
        /* 243 */ Paper paper = pageFormat.getPaper();
        /* 244 */ paper.setSize(432.0D, 432.0D);
        /* 245 */ paper.setImageableArea(0.0D, 0.0D, paper.getWidth(), paper.getHeight());

        /* 250 */ pageFormat.setOrientation(1);
        /* 251 */ job.setPrintable(this, pageFormat);
        /* 252 */ if (job.printDialog()) {
            try {
                /* 254 */ job.print();
            } catch (PrinterException ex) {
                /* 256 */ ex.printStackTrace();
            }
        }
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\Utility\PrintBill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
