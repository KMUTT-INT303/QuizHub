/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Top
 */
public class MailSet {

    private final String username = "int303.quizhub@gmail.com";
    private final String password = "atmquiz303";
    private String subjectline = null;
    private String toName = null;
    private String messageTosend = null;
    private String toMailAddress = null;

    public MailSet(String subjectline) {
        this.subjectline = subjectline;
    }
    
    
    public void setMail(String dear, String message, String emailAddress){   
        this.toName = dear;
        this.messageTosend = message;
        this.toMailAddress = emailAddress;
    }
    
    
    public boolean sendMail() {
        if (getMessageTosend() != null && getToName() != null && getToMailAddress() != null) {
            
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("QuizHub"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(getToMailAddress())
                );
                message.setSubject("QuizHub - " + subjectline);
                message.setText(
                        "Dear " + getToName() + ","
                        + "\n\n "
                        + getMessageTosend()
                        + "\n\n Regard, \n QuizHub.com"
                );

                Transport.send(message);
                System.out.println("Send Complete!");
                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Something Wrong!");
        return false;
    }

    
    public String getToName() {
        return toName;
    }


    public String getMessageTosend() {
        return messageTosend;
    }


    public String getToMailAddress() {
        return toMailAddress;
    }

    @Override
    public String toString() {
        return "MailSet{" + "toName=" + toName + ", messageTosend=" + messageTosend + ", toMailAddress=" + toMailAddress + '}';
    }
    
    

}
