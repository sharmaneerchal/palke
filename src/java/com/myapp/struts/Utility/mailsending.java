/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Utility;

import com.myapp.struts.dao.BackupDAO;
import com.sun.mail.smtp.SMTPAddressFailedException;
import com.sun.mail.smtp.SMTPAddressSucceededException;
import com.sun.mail.smtp.SMTPSendFailedException;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import mappings.Backup;

/**
 *
 * @author ptechadmin
 */
public class mailsending {

    public void Backupdbtosql() throws IOException, InterruptedException {
        try {
            SimpleDateFormat dat = new SimpleDateFormat("ddMMyyyy");
            String date = dat.format(new Date());
            //Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pshypalke jewellery -r D:/Backupfiles/backup" + date + ".sql");
            Runtime.getRuntime().exec("C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pshypalke jewellery -r D:/Backupfiles/backup" + date + ".sql");

            //C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pjavaapp asmmotors -r C:/backup.sql
        } catch (IOException e) {
        }
    }

    public String sendMail(String ContactEmailAddress, String subject, String message) {

        String password = "developer1234";
        String from = "shy.developers@gmail.com";
        String cc = "";
        String to = ContactEmailAddress;

        String mailhost = "smtp.mail.gmail.com";
        String user = "shy.developers@gmail.com";

        String retMsg = " ";

        boolean auth = true;
        boolean ssl = false;
        Properties props = System.getProperties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.port", "587");
//        if (mailhost != null) {
//            props.put("mail.smtp.host", mailhost);
//        }
//        if (auth) {
//            props.put("mail.smtp.auth", "true");
//        }

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get a Session object
        javax.mail.Session session = javax.mail.Session.getInstance(props, null);
        // Construct the message
        javax.mail.Message msg = new MimeMessage(session);
        try {
            // Set message details
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

            StringTokenizer strcc = new StringTokenizer(cc, ",");

            while (strcc.hasMoreTokens()) {
                String temp = strcc.nextToken();
                msg.setRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress(temp));
            }

            String[] temp = null;

            temp = message.split(",");

            Multipart multipart = new MimeMultipart("related");

            for (int i = 0; i < temp.length; i++) {
//            htmlPart.setContent("<html><body>" + message + "<br><img src=\"http://www.e.com/images/Ec-TM.jpg\"/><br/>" + "</body></html>", "text/html");
                BodyPart htmlPart = new MimeBodyPart();

                htmlPart.setContent("<html><body><font color=red>" + temp[i] + "<br/>" + "</font></body></html>", "text/html");

                multipart.addBodyPart(htmlPart);
            }

            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(multipart);

            // Send the thing off
            SMTPTransport t = (SMTPTransport) session.getTransport(ssl ? "smtps" : "smtp");
            try {
                if (auth) {
                    t.connect(mailhost, user, password);
                } else {
                    t.connect();
                }
                t.sendMessage(msg, msg.getAllRecipients());
            } finally {
                t.close();
            }
            retMsg = "Mail was sent successfully.";
        } catch (Exception e) {
            if (e instanceof SendFailedException) {
                MessagingException sfe = (MessagingException) e;
                if (sfe instanceof SMTPSendFailedException) {
                    SMTPSendFailedException ssfe = (SMTPSendFailedException) sfe;
                    retMsg = "Smtp_Send_Failed:";
                }
                Exception ne;
                while ((ne = sfe.getNextException()) != null && ne instanceof MessagingException) {
                    sfe = (MessagingException) ne;
                    if (sfe instanceof SMTPAddressFailedException) {
                        SMTPAddressFailedException ssfe = (SMTPAddressFailedException) sfe;
                        retMsg = "Address failed:";
                        retMsg = retMsg + "  Address: " + ssfe.getAddress();
                        retMsg = retMsg + "  Command: " + ssfe.getCommand();
                        retMsg = retMsg + "  Return Code: " + ssfe.getReturnCode();
                        retMsg = retMsg + "  Response: " + ssfe.getMessage();
                    } else if (sfe instanceof SMTPAddressSucceededException) {
                        retMsg = retMsg + "Address succeeded:";
                        SMTPAddressSucceededException ssfe = (SMTPAddressSucceededException) sfe;
                    }
                }
            } else {
                retMsg = retMsg + "Got Exception : " + e;
            }
        }
        return retMsg;
    }

    //
    public String sendMailWithAttachment(String ContactEmailAddress, String subject, String filePath, String message) {

        final String username = "shy.developers@gmail.com";
        final String password = "developer1234";
        String cc = "";
        String to = ContactEmailAddress;

        String mailhost = "smtp.gmail.com";
        String user = "shy.developers@gmail.com";

        String retMsg = " ";

        boolean auth = true;
        boolean ssl = false;

        // Get a Session object
        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Construct the message
        javax.mail.Message msg = new MimeMessage(session);
        try {
            // Set message details
            msg.setFrom(new InternetAddress(username));
            msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

            StringTokenizer strcc = new StringTokenizer(cc, ",");

            while (strcc.hasMoreTokens()) {
                String temp = strcc.nextToken();
                msg.setRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress(temp));
            }

            Multipart multipart = new MimeMultipart("related");
//            
            BodyPart htmlPart = new MimeBodyPart();

            htmlPart.setContent("<html><body><font color=red>" + message + "<br/>" + "</font></body></html>", "text/html");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            String filename = filePath;//change accordingly
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);

            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(messageBodyPart);

            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(multipart);

            // Send the thing off
//            Transport t = (SMTPTransport) session.getTransport(ssl ? "smtps" : "smtp");
//            try {
//                if (auth) {
//                    t.connect(mailhost, user, password);
//                } else {
//                    t.connect();
//                }
//                t.sendMessage(msg, msg.getAllRecipients());
//            } finally {
//                t.close();
//            }
            Transport.send(msg);
            retMsg = "Mail was sent successfully.";
            ///insert 
            new BackupDAO().saveItem(new Backup(new Date(), filename));
        } catch (Exception e) {
            if (e instanceof SendFailedException) {
                MessagingException sfe = (MessagingException) e;
                if (sfe instanceof SMTPSendFailedException) {
                    SMTPSendFailedException ssfe = (SMTPSendFailedException) sfe;
                    retMsg = "Smtp_Send_Failed:";
                }
                Exception ne;
                while ((ne = sfe.getNextException()) != null && ne instanceof MessagingException) {
                    sfe = (MessagingException) ne;
                    if (sfe instanceof SMTPAddressFailedException) {
                        SMTPAddressFailedException ssfe = (SMTPAddressFailedException) sfe;
                        retMsg = "Address failed:";
                        retMsg = retMsg + "  Address: " + ssfe.getAddress();
                        retMsg = retMsg + "  Command: " + ssfe.getCommand();
                        retMsg = retMsg + "  Return Code: " + ssfe.getReturnCode();
                        retMsg = retMsg + "  Response: " + ssfe.getMessage();
                    } else if (sfe instanceof SMTPAddressSucceededException) {
                        retMsg = retMsg + "Address succeeded:";
                        SMTPAddressSucceededException ssfe = (SMTPAddressSucceededException) sfe;
                    }
                }
            } else {
                retMsg = retMsg + "Got Exception : " + e;
            }
        }
        return retMsg;
    }

    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "shy.developers@gmail.com";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "shy.developers@gmail.com";//change accordingly
        final String username = "shy.developers@gmail.com";//change accordingly
        final String password = "developer1234";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", "465");

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Now set the actual message
            message.setText("Hello, this is sample for to check send "
                    + "email using JavaMailAPI ");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
