package com.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NotificationMail {
    Scanner sc = new Scanner(System.in);

    public void sendNotification() {

        // Set your email credentials and properties
        String username = "gudipellysaikiran9@gmail.com";
        String password = "uwcw frgr oxeo riyh";
        String toAddress = "ssai3585@gmail.com";
        String subject = "Admin Login Notification";
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        String messageBody = "Admin Logged in at : " + formattedDateTime;

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

            // Set the email subject and body
            message.setSubject(subject);
            message.setText(messageBody);

            // Send the email
            Transport.send(message);

            System.out.println("Login Notification Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
