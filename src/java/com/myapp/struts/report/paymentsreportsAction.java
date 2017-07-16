package com.myapp.struts.report;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.myapp.struts.Utility.Constants;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.PrintStatement;
import com.myapp.struts.beans.paymentstatus;
import com.myapp.struts.dao.GroupsDAO;
import com.myapp.struts.dao.MembersDAO;
import com.myapp.struts.dao.PaymentDAO;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappings.Groups;
import mappings.Members;
import mappings.Payment;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class paymentsreportsAction
        extends DispatchAction {

    /*  59 */ private HashMap hmGroups = new HashMap();
    /*  61 */ Font font = FontFactory.getFont("Helvetica", 8.0F);

    public ActionForward displayGroups(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
        /*  65 */ if (Constants.isSessionActive(request)) {
            /*  66 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;
            try {
                /*  68 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                /*  69 */ paymentsReportsForm.setFromDate(sdf.format(new java.util.Date()));
                /*  70 */ paymentsReportsForm.setToDate(sdf.format(new java.util.Date()));
                /*  71 */ paymentsReportsForm.getLstpaymentstatus().clear();
                /*  72 */ paymentsReportsForm.setTotalamount(0);

                /*  74 */ paymentsReportsForm.setGroupid(0);

                /*  76 */ List<DropDownFill> dropDowListDT = new ArrayList();

                /*  78 */ this.hmGroups = new GroupsDAO().getGroups();
                /*  79 */ List<Groups> lstGroups = (List) this.hmGroups.get("Group");
                /*  80 */ for (int i = 0; i < lstGroups.size(); i++) {
                    /*  81 */ Groups groups = (Groups) lstGroups.get(i);
                    /*  82 */ dropDowListDT.add(new DropDownFill(groups.getGroupid(), groups.getGroupname()));
                }
                /*  84 */ paymentsReportsForm.setGroups(dropDowListDT);

                /*  86 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /*  88 */ return mapping.findForward("fail");
            }
        }
        /*  91 */ return mapping.findForward("exp");
    }

    public ActionForward searchPayments(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /*  97 */ if (Constants.isSessionActive(request)) {
            /*  98 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;
            try {
                /* 100 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                /* 101 */ java.util.Date testDate1 = sdf.parse(paymentsReportsForm.getFromDate());
                /* 102 */ java.util.Date testDate2 = sdf.parse(paymentsReportsForm.getToDate());

                /* 104 */ SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
                /* 105 */ String fromdate = fr.format(testDate1);
                /* 106 */ String todate = fr.format(testDate2);

                /* 108 */ List<Payment> lstPayments = new PaymentDAO().getPaymentStatus(paymentsReportsForm.getGroupid(), fromdate, todate, paymentsReportsForm.getFromno(), paymentsReportsForm.getTono());

                /* 110 */ paymentsReportsForm.getLstpaymentstatus().clear();
                /* 111 */ paymentsReportsForm.setTotalamount(0);
                /* 112 */ for (int i = 0; i < lstPayments.size(); i++) {
                    /* 113 */ Payment payment = (Payment) lstPayments.get(i);
                    /* 114 */ paymentstatus ps = new paymentstatus();
                    /* 115 */ Members members = new MembersDAO().getmemberdetails(payment.getPaymentid());


                    /* 118 */ if (paymentsReportsForm.getGroupid() != 0) {
                        /* 119 */ Groups group = (Groups) this.hmGroups.get(paymentsReportsForm.getGroupid() + "");
                        /* 120 */ ps.setGroup(group.getGroupname());
                    } else {
                        /* 122 */ Groups mem = new GroupsDAO().getgroupdetails(payment.getPaymentid());
                        /* 123 */ Groups group = (Groups) this.hmGroups.get(mem.getGroupid() + "");
                        /* 124 */ ps.setGroup(group.getGroupname());
                    }
                    /* 126 */ ps.setPaymentid(payment.getPaymentid());
                    /* 127 */ ps.setMemberid(payment.getMemberid());
                    /* 128 */ ps.setMembername(members.getMemberno() + "-" + members.getMembername());
                    /* 129 */ ps.setMemberinfo(members.getMemberaddress() + "\n" + members.getContactno());
                    /* 130 */ ps.setPaidamount(payment.getPaidamount().intValue());
                    /* 131 */ ps.setPaiddate(sdf.format(payment.getPaiddate()));
                    /* 132 */ ps.setPaymentmodeid(payment.getPaymentmode());
                    /* 133 */ ps.setRemarks(payment.getRemarks());
                    /* 134 */ if (payment.getPaymentmode() == 1) {
                        /* 135 */ ps.setPaymentmode("Cash");
                    } else {
                        /* 137 */ ps.setPaymentmode("Cheque");
                    }
                    /* 139 */ paymentsReportsForm.setTotalamount(paymentsReportsForm.getTotalamount() + payment.getPaidamount().intValue());
                    /* 140 */ paymentsReportsForm.getLstpaymentstatus().add(ps);
                }
                /* 142 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /* 144 */ return mapping.findForward("fail");
            }
        }
        /* 147 */ return mapping.findForward("exp");
    }

    public ActionForward clearsearch(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 153 */ if (Constants.isSessionActive(request)) {
            /* 154 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;
            try {
                /* 156 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                /* 157 */ paymentsReportsForm.setFromDate(sdf.format(new java.util.Date()));
                /* 158 */ paymentsReportsForm.setToDate(sdf.format(new java.util.Date()));
                /* 159 */ paymentsReportsForm.setLstpaymentstatus(new ArrayList());
                /* 160 */ paymentsReportsForm.setTotalamount(0);

                /* 162 */ return mapping.findForward("display");
            } catch (Exception ex) {
                /* 164 */ return mapping.findForward("fail");
            }
        }
        /* 167 */ return mapping.findForward("exp");
    }

    public ActionForward generatepdf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 173 */ if (Constants.isSessionActive(request)) {
            /* 174 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;
            try {
                /* 176 */ java.util.Date utilDate = new java.util.Date();
                /* 177 */ java.sql.Date date = new java.sql.Date(utilDate.getTime());
                /* 178 */ Font bigFont = FontFactory.getFont("Helvetica", "Windows-1254", 12.0F, 1, BaseColor.BLACK);
                /* 179 */ Font bigFont_Uderline = FontFactory.getFont("Helvetica", "Windows-1254", 12.0F, 5, BaseColor.BLACK);
                /* 180 */ Font boldfont = FontFactory.getFont("Helvetica", "Windows-1254", 9.0F, 1);

                /* 182 */ Document document = new Document();
                /* 183 */ ByteArrayOutputStream baos = new ByteArrayOutputStream();
                /* 184 */ PdfWriter.getInstance(document, baos);
                /* 185 */ document.open();

                /* 187 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                /* 189 */ Paragraph para1 = new Paragraph("PALKE JEWELLERS", bigFont);
                /* 190 */ para1.setAlignment(1);
                /* 191 */ document.add(para1);

                /* 193 */ para1 = new Paragraph("PAYMENTS STATUS REPORT", bigFont);
                /* 194 */ para1.setAlignment(1);
                /* 195 */ document.add(para1);

                /* 197 */ String dateStr = sdf.format(date);
                /* 198 */ para1 = new Paragraph("DATED:" + dateStr, boldfont);
                /* 199 */ para1.setAlignment(2);
                /* 200 */ document.add(para1);


                /* 203 */ document.add(Chunk.NEWLINE);

                /* 205 */ if ((paymentsReportsForm.getLstpaymentstatus() != null) && (paymentsReportsForm.getLstpaymentstatus().size() > 0)) {
                    /* 206 */ PdfPTable table2 = new PdfPTable(8);
                    /* 207 */ float[] columnWidths = {1.5F, 4.0F, 3.0F, 4.0F, 5.0F, 7.0F, 2.0F, 3.0F};

                    /* 209 */ table2.setWidthPercentage(100.0F);
                    /* 210 */ table2.setWidths(columnWidths);

                    /* 212 */ para1 = new Paragraph("Sl No.", this.font);
                    /* 213 */ para1.setAlignment(1);
                    /* 214 */ PdfPCell cell = new PdfPCell(para1);
                    /* 215 */ table2.addCell(cell);

                    /* 217 */ para1 = new Paragraph("Receipt No.", this.font);
                    /* 218 */ para1.setAlignment(1);
                    /* 219 */ cell = new PdfPCell(para1);
                    /* 220 */ table2.addCell(cell);

                    /* 222 */ para1 = new Paragraph("Receipt Date", this.font);
                    /* 223 */ para1.setAlignment(1);
                    /* 224 */ cell = new PdfPCell(para1);
                    /* 225 */ table2.addCell(cell);

                    /* 227 */ para1 = new Paragraph("Payment Mode", this.font);
                    /* 228 */ para1.setAlignment(1);
                    /* 229 */ cell = new PdfPCell(para1);
                    /* 230 */ table2.addCell(cell);

                    /* 232 */ para1 = new Paragraph("Remarks", this.font);
                    /* 233 */ para1.setAlignment(1);
                    /* 234 */ cell = new PdfPCell(para1);
                    /* 235 */ table2.addCell(cell);

                    /* 237 */ para1 = new Paragraph("Member Details", this.font);
                    /* 238 */ para1.setAlignment(1);
                    /* 239 */ cell = new PdfPCell(para1);
                    /* 240 */ table2.addCell(cell);

                    /* 242 */ para1 = new Paragraph("Group", this.font);
                    /* 243 */ para1.setAlignment(1);
                    /* 244 */ cell = new PdfPCell(para1);
                    /* 245 */ table2.addCell(cell);

                    /* 247 */ para1 = new Paragraph("Paid Amount", this.font);
                    /* 248 */ para1.setAlignment(1);
                    /* 249 */ cell = new PdfPCell(para1);
                    /* 250 */ table2.addCell(cell);

                    /* 252 */ int x = 1;
                    /* 253 */ int total = 0;
                    /* 254 */ for (paymentstatus f1 : paymentsReportsForm.getLstpaymentstatus()) {
                        /* 255 */ para1 = new Paragraph(Integer.toString(x), this.font);
                        /* 256 */ para1.setAlignment(1);
                        /* 257 */ cell = new PdfPCell(para1);
                        /* 258 */ table2.addCell(cell);
                        /* 259 */ x++;

                        /* 261 */ para1 = new Paragraph(f1.getPaymentid() + "", this.font);
                        /* 262 */ para1.setAlignment(1);
                        /* 263 */ cell = new PdfPCell(para1);
                        /* 264 */ table2.addCell(cell);

                        /* 266 */ para1 = new Paragraph(f1.getPaiddate(), this.font);
                        /* 267 */ para1.setAlignment(1);
                        /* 268 */ cell = new PdfPCell(para1);
                        /* 269 */ table2.addCell(cell);

                        /* 271 */ para1 = new Paragraph(f1.getPaymentmode(), this.font);
                        /* 272 */ para1.setAlignment(1);
                        /* 273 */ cell = new PdfPCell(para1);
                        /* 274 */ table2.addCell(cell);

                        /* 276 */ para1 = new Paragraph(f1.getRemarks(), this.font);
                        /* 277 */ para1.setAlignment(1);
                        /* 278 */ cell = new PdfPCell(para1);
                        /* 279 */ table2.addCell(cell);

                        /* 281 */ String memberdetails = f1.getMembername() + "\n" + f1.getMemberinfo();
                        /* 282 */ para1 = new Paragraph(memberdetails, this.font);
                        /* 283 */ para1.setAlignment(1);
                        /* 284 */ cell = new PdfPCell(para1);
                        /* 285 */ table2.addCell(cell);

                        /* 287 */ para1 = new Paragraph(f1.getGroup(), this.font);
                        /* 288 */ para1.setAlignment(1);
                        /* 289 */ cell = new PdfPCell(para1);
                        /* 290 */ table2.addCell(cell);

                        /* 292 */ para1 = new Paragraph(f1.getPaidamount() + "", boldfont);
                        /* 293 */ para1.setAlignment(1);
                        /* 294 */ cell = new PdfPCell(para1);
                        /* 295 */ table2.addCell(cell);
                        /* 296 */ total += f1.getPaidamount();
                    }

                    /* 299 */ para1 = new Paragraph("Total", boldfont);
                    /* 300 */ para1.setAlignment(0);
                    /* 301 */ cell = new PdfPCell(para1);
                    /* 302 */ cell.setColspan(7);
                    /* 303 */ table2.addCell(cell);


                    /* 306 */ para1 = new Paragraph(total + "", boldfont);
                    /* 307 */ para1.setAlignment(1);
                    /* 308 */ cell = new PdfPCell(para1);

                    /* 310 */ table2.addCell(cell);

                    /* 312 */ table2.setHorizontalAlignment(0);
                    /* 313 */ document.add(table2);
                } else {
                    /* 315 */ para1 = new Paragraph("NO RECORDS FOUND", boldfont);
                    /* 316 */ para1.setAlignment(1);
                    /* 317 */ document.add(para1);
                }
                /* 319 */ document.add(Chunk.NEWLINE);

                /* 323 */ document.close();
                /* 324 */ ServletOutputStream outputStream = response.getOutputStream();
                /* 325 */ baos.writeTo(outputStream);
                /* 326 */ response.setHeader("Content-Disposition", "attachment; filename=\"PaymentStatusReport.pdf\"");
                /* 327 */ response.setContentType("application/pdf");
                /* 328 */ outputStream.flush();
                /* 329 */ outputStream.close();
                /* 330 */ return mapping.findForward("display");
            } catch (DocumentException i) {
                /* 332 */ System.out.println(i);
                /* 333 */ return mapping.findForward("fail");
            } catch (IOException i) {
                /* 335 */ System.out.println(i);
                /* 336 */ return mapping.findForward("fail");
            }
        }
        /* 339 */ return mapping.findForward("exp");
    }

    public ActionForward generatexls(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 345 */ if (Constants.isSessionActive(request)) {
            /* 346 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;
            try {
                /* 348 */ if (paymentsReportsForm.getLstpaymentstatus() != null) {
                    /* 350 */ ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    /* 352 */ HSSFWorkbook wb = new HSSFWorkbook();

                    /* 354 */ HSSFSheet sheet = wb.createSheet("Payment Status Report");

                    /* 362 */ HSSFCellStyle headerCellStyle = wb.createCellStyle();
                    /* 363 */ HSSFFont boldFont = wb.createFont();
                    /* 364 */ boldFont.setBoldweight((short) 700);
                    /* 365 */ headerCellStyle.setFont(boldFont);

                    /* 367 */ HSSFRow row = sheet.createRow(0);

                    /* 369 */ HSSFCell cell = row.createCell(0);
                    /* 370 */ cell.setCellStyle(headerCellStyle);
                    /* 371 */ cell.setCellValue(new HSSFRichTextString("SI No."));

                    /* 373 */ cell = row.createCell(1);
                    /* 374 */ cell.setCellStyle(headerCellStyle);
                    /* 375 */ cell.setCellValue(new HSSFRichTextString("Receipt No."));

                    /* 377 */ cell = row.createCell(2);
                    /* 378 */ cell.setCellStyle(headerCellStyle);
                    /* 379 */ cell.setCellValue(new HSSFRichTextString("Receipt Date"));

                    /* 381 */ cell = row.createCell(3);
                    /* 382 */ cell.setCellStyle(headerCellStyle);
                    /* 383 */ cell.setCellValue(new HSSFRichTextString("Payment Mode"));

                    /* 385 */ cell = row.createCell(4);
                    /* 386 */ cell.setCellStyle(headerCellStyle);
                    /* 387 */ cell.setCellValue(new HSSFRichTextString("Remarks"));

                    /* 389 */ cell = row.createCell(5);
                    /* 390 */ cell.setCellStyle(headerCellStyle);
                    /* 391 */ cell.setCellValue(new HSSFRichTextString("Member Details"));

                    /* 393 */ cell = row.createCell(6);
                    /* 394 */ cell.setCellStyle(headerCellStyle);
                    /* 395 */ cell.setCellValue(new HSSFRichTextString("Group"));

                    /* 397 */ cell = row.createCell(7);
                    /* 398 */ cell.setCellStyle(headerCellStyle);
                    /* 399 */ cell.setCellValue(new HSSFRichTextString("Paid Amount"));

                    /* 401 */ int i = 1;
                    /* 402 */ int total = 0;
                    /* 403 */ for (paymentstatus userData : paymentsReportsForm.getLstpaymentstatus()) {
                        /* 404 */ row = sheet.createRow(i);

                        /* 406 */ cell = row.createCell(0);
                        /* 407 */ HSSFRichTextString cellvalue = new HSSFRichTextString(i + "");
                        /* 408 */ cell.setCellValue(cellvalue);

                        /* 410 */ cell = row.createCell(1);
                        /* 411 */ cellvalue = new HSSFRichTextString(userData.getPaymentid() + "");
                        /* 412 */ cell.setCellValue(cellvalue);

                        /* 414 */ cell = row.createCell(2);
                        /* 415 */ cellvalue = new HSSFRichTextString(userData.getPaiddate());
                        /* 416 */ cell.setCellValue(cellvalue);

                        /* 418 */ cell = row.createCell(3);
                        /* 419 */ cellvalue = new HSSFRichTextString(userData.getPaymentmode());
                        /* 420 */ cell.setCellValue(cellvalue);

                        /* 422 */ cell = row.createCell(4);
                        /* 423 */ cellvalue = new HSSFRichTextString(userData.getRemarks());
                        /* 424 */ cell.setCellValue(cellvalue);

                        /* 426 */ String dateStr = userData.getMembername() + "\n" + userData.getMemberinfo();
                        /* 427 */ cell = row.createCell(5);
                        /* 428 */ cellvalue = new HSSFRichTextString(dateStr);
                        /* 429 */ cell.setCellValue(cellvalue);

                        /* 431 */ dateStr = userData.getGroup();
                        /* 432 */ cell = row.createCell(6);
                        /* 433 */ cellvalue = new HSSFRichTextString(dateStr);
                        /* 434 */ cell.setCellValue(cellvalue);

                        /* 436 */ dateStr = userData.getPaidamount() + "";
                        /* 437 */ boldFont.setBoldweight((short) 700);
                        /* 438 */ headerCellStyle.setFont(boldFont);
                        /* 439 */ cell = row.createCell(7);
                        /* 440 */ cellvalue = new HSSFRichTextString(dateStr);
                        /* 441 */ cell.setCellValue(cellvalue);

                        /* 443 */ total += userData.getPaidamount();
                        /* 444 */ i++;
                    }
                    /* 446 */ boldFont.setBoldweight((short) 700);
                    /* 447 */ row = sheet.createRow(paymentsReportsForm.getLstpaymentstatus().size() + 1);
                    /* 448 */ cell = row.createCell(0);
                    /* 449 */ HSSFRichTextString cellvalue = new HSSFRichTextString("Total");
                    /* 450 */ cell.setCellStyle(headerCellStyle);
                    /* 451 */ cell.setCellValue(cellvalue);

                    /* 453 */ cell = row.createCell(7);
                    /* 454 */ cell.setCellStyle(headerCellStyle);
                    /* 455 */ cellvalue = new HSSFRichTextString(total + "");
                    /* 456 */ cell.setCellValue(cellvalue);

                    /* 461 */ response.setHeader("Content-Disposition", "attachment; filename=\"PaymentStatusReport.xls\"");
                    /* 462 */ response.setContentType("application/xls");

                    /* 464 */ ServletOutputStream out = response.getOutputStream();
                    /* 465 */ wb.write(out);
                    /* 466 */ out.flush();
                    /* 467 */ out.close();
                    /* 468 */ return mapping.findForward("display");
                }

                /* 471 */ return mapping.findForward("display");
            } catch (FileNotFoundException ex) {
                /* 474 */ return mapping.findForward("fail");
            }
        }
        /* 477 */ return mapping.findForward("exp");
    }

    public ActionForward generateministatement(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 483 */ if (Constants.isSessionActive(request)) {
            /* 484 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;

            /* 486 */ new PrintStatement().printreceipt(paymentsReportsForm.getLstpaymentstatus());

            /* 488 */ return mapping.findForward("display");
        }
        /* 490 */ return mapping.findForward("exp");
    }

    public ActionForward generateminireport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws SQLException, Exception {
        /* 496 */ if (Constants.isSessionActive(request)) {
            /* 497 */ paymentsReportsForm paymentsReportsForm = (paymentsReportsForm) form;
            try {
                /* 499 */ java.util.Date utilDate = new java.util.Date();
                /* 500 */ java.sql.Date date = new java.sql.Date(utilDate.getTime());
                /* 501 */ Font bigFont = FontFactory.getFont("Helvetica", "Windows-1254", 12.0F, 1, BaseColor.BLACK);
                /* 502 */ Font bigFont_Uderline = FontFactory.getFont("Helvetica", "Windows-1254", 12.0F, 5, BaseColor.BLACK);
                /* 503 */ Font boldfont = FontFactory.getFont("Helvetica", "Windows-1254", 9.0F, 1);

                /* 505 */ Document document = new Document();
                /* 506 */ ByteArrayOutputStream baos = new ByteArrayOutputStream();
                /* 507 */ PdfWriter.getInstance(document, baos);
                /* 508 */ document.open();

                /* 510 */ SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                /* 512 */ Paragraph para1 = new Paragraph("PALKE JEWELLERS", bigFont);
                /* 513 */ para1.setAlignment(1);
                /* 514 */ document.add(para1);

                /* 516 */ para1 = new Paragraph("PAYMENTS STATUS REPORT", bigFont);
                /* 517 */ para1.setAlignment(1);
                /* 518 */ document.add(para1);

                /* 520 */ String dateStr = sdf.format(date);
                /* 521 */ para1 = new Paragraph("DATED:" + dateStr, boldfont);
                /* 522 */ para1.setAlignment(2);
                /* 523 */ document.add(para1);


                /* 526 */ document.add(Chunk.NEWLINE);

                /* 528 */ if ((paymentsReportsForm.getLstpaymentstatus() != null) && (paymentsReportsForm.getLstpaymentstatus().size() > 0)) {
                    /* 529 */ PdfPTable table2 = new PdfPTable(5);
                    /* 530 */ float[] columnWidths = {2.0F, 2.0F, 2.0F, 2.0F, 2.0F};

                    /* 532 */ table2.setWidthPercentage(100.0F);
                    /* 533 */ table2.setWidths(columnWidths);

                    /* 539 */ para1 = new Paragraph("Receipt No.", this.font);
                    /* 540 */ para1.setAlignment(1);
                    /* 541 */ PdfPCell cell = new PdfPCell(para1);
                    /* 542 */ table2.addCell(cell);

                    /* 544 */ para1 = new Paragraph("Date", this.font);
                    /* 545 */ para1.setAlignment(1);
                    /* 546 */ cell = new PdfPCell(para1);
                    /* 547 */ table2.addCell(cell);

                    /* 558 */ para1 = new Paragraph("Amount", this.font);
                    /* 559 */ para1.setAlignment(1);
                    /* 560 */ cell = new PdfPCell(para1);
                    /* 561 */ table2.addCell(cell);

                    /* 563 */ para1 = new Paragraph("Member Details", this.font);
                    /* 564 */ para1.setAlignment(1);
                    /* 565 */ cell = new PdfPCell(para1);
                    /* 566 */ table2.addCell(cell);

                    /* 572 */ int x = 1;
                    /* 573 */ int total = 0;
                    /* 574 */ for (paymentstatus f1 : paymentsReportsForm.getLstpaymentstatus()) {

                        /* 580 */ x++;

                        /* 582 */ para1 = new Paragraph(f1.getPaymentid() + "", this.font);
                        /* 583 */ para1.setAlignment(1);
                        /* 584 */ cell = new PdfPCell(para1);
                        /* 585 */ table2.addCell(cell);

                        /* 587 */ para1 = new Paragraph(f1.getPaiddate(), this.font);
                        /* 588 */ para1.setAlignment(1);
                        /* 589 */ cell = new PdfPCell(para1);
                        /* 590 */ table2.addCell(cell);

                        /* 600 */ para1 = new Paragraph(f1.getPaidamount() + "", boldfont);
                        /* 601 */ para1.setAlignment(1);
                        /* 602 */ cell = new PdfPCell(para1);
                        /* 603 */ table2.addCell(cell);

                        /* 605 */ String memberdetails = f1.getMembername();
                        /* 606 */ para1 = new Paragraph(f1.getMemberinfo().split("-")[0].trim() + "-" + f1.getGroup(), this.font);
                        /* 607 */ para1.setAlignment(1);
                        /* 608 */ cell = new PdfPCell(para1);
                        /* 609 */ table2.addCell(cell);

                        /* 615 */ total += f1.getPaidamount();
                    }

                    /* 618 */ para1 = new Paragraph("Total", boldfont);
                    /* 619 */ para1.setAlignment(0);
                    /* 620 */ cell = new PdfPCell(para1);
                    /* 621 */ cell.setColspan(4);
                    /* 622 */ table2.addCell(cell);


                    /* 625 */ para1 = new Paragraph(total + "", boldfont);
                    /* 626 */ para1.setAlignment(1);
                    /* 627 */ cell = new PdfPCell(para1);

                    /* 629 */ table2.addCell(cell);

                    /* 631 */ table2.setHorizontalAlignment(0);
                    /* 632 */ document.add(table2);
                } else {
                    /* 634 */ para1 = new Paragraph("NO RECORDS FOUND", boldfont);
                    /* 635 */ para1.setAlignment(1);
                    /* 636 */ document.add(para1);
                }
                /* 638 */ document.add(Chunk.NEWLINE);

                /* 642 */ document.close();
                /* 643 */ ServletOutputStream outputStream = response.getOutputStream();
                /* 644 */ baos.writeTo(outputStream);
                /* 645 */ response.setHeader("Content-Disposition", "attachment; filename=\"MiniStatusReport.pdf\"");
                /* 646 */ response.setContentType("application/pdf");
                /* 647 */ outputStream.flush();
                /* 648 */ outputStream.close();
                /* 649 */ return mapping.findForward("display");
            } catch (DocumentException i) {
                /* 651 */ System.out.println(i);
                /* 652 */ return mapping.findForward("fail");
            } catch (IOException i) {
                /* 654 */ System.out.println(i);
                /* 655 */ return mapping.findForward("fail");
            }
        }
        /* 658 */ return mapping.findForward("exp");
    }
}


/* Location:              I:\palke.war!\WEB-INF\classes\com\myapp\struts\report\paymentsreportsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
