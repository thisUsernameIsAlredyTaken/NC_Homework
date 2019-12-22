package com.example.homework.service;

import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

@Service
public class MailService {

    public boolean send(String email, String text) {
        return send(email, text, "");
    }

    public boolean send(String email, String text, String subject) {
        Properties properties = new Properties();

        try (InputStream is = new FileInputStream("./resources/email_config.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("properties = " + properties);
        if (!validateProperties(properties)) {
            return false;
        }

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getProperty("account.email"),
                        properties.getProperty("account.password"));
            }
        });

        Message message = prepareMessage(session, properties.getProperty("account.email"), email, text, subject);
        if (message != null) {
            try {
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean validateProperties(Properties properties) {
        String property = properties.getProperty("mail.smtp.auth");
        return properties.getProperty("mail.smtp.auth") != null &&
                properties.getProperty("mail.smtp.starttls.enable") != null &&
                properties.getProperty("mail.smtp.host") != null &&
                properties.getProperty("mail.smtp.port") != null &&
                properties.getProperty("account.email") != null &&
                properties.getProperty("account.password") != null;
    }

    private Message prepareMessage(Session session, String sender, String recipient, String text, String subject) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply@cccc.ru"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(text);
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
