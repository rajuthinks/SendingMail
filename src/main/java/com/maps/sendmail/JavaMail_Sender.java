package com.maps.sendmail;



import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class JavaMail_Sender {

    SimpleMailMessage email = new SimpleMailMessage();

    public JavaMailSenderImpl getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("From mail");
            mailSender.setPassword("PAssword");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        Session.getInstance(javaMailProperties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailSender.getUsername(), mailSender.getPassword());
            }
        }
        );

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    public void sendingMail(String recipientEmail, String subject, String msg) {
        email.setTo(recipientEmail);
        email.setSubject(subject);
        email.setText(msg);
        

        getMailSender().send(email);
    }
}