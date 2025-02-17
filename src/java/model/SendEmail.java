package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import util.Util;

/**
 * Class to handle sending confirmation emails for orders and password recovery.
 */
public class SendEmail {

    private final int LIMIT_MINUS = 10;
    private final String from = "baviapartment88@gmail.com";
    private final String password = "nong aqji krlu xvue";

    /**
     * Tạo mã xác nhận ngẫu nhiên.
     */
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    public LocalDateTime expireDateTime() {
        return LocalDateTime.now().plusMinutes(LIMIT_MINUS);
    }

    public boolean isExpired(LocalDateTime time) {
        return LocalDateTime.now().isAfter(time);
    }

    public boolean sendEmail(String to, String subject, String content) {
        // Kiểm tra xem địa chỉ email có tồn tại không trước khi gửi\

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Sử dụng 587 cho TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Kích hoạt TLS

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject, "UTF-8"); // Thiết lập chủ đề email

            // Tạo nội dung email
            msg.setContent(content, "text/html; charset=UTF-8");
            Transport.send(msg);
            System.out.println("Email đã được gửi thành công.");
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi gửi email:");
            e.printStackTrace(); // Hiển thị lỗi chi tiết
        }
        return false;
    }

    public void sendEmail(String to, String residentName, String username, String residentPassword) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Use 587 for TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            message.setSubject("Your New Resident Account Details", "UTF-8");

            String emailContent = "<p>Dear " + residentName + ",</p>"
                    + "<p>Your account has been created successfully.</p>"
                    + "<p>Username: " + username + "<br></p>"
                    + "<p>Password: " + residentPassword + "</p>"
                    + "<p>Please keep this information safe.</p>"
                    + "<p>Best Regards,<br>Your Community</p>";

            message.setContent(emailContent, "text/html; charset=UTF-8");

            Transport.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to: " + to);
            e.printStackTrace();
        }
    }
    
    public void sendEmailStaff(String to, String residentName, String username, String residentPassword) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Use 587 for TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            message.setSubject("Your New Staff Account Details", "UTF-8");

            String emailContent = "<p>Dear " + residentName + ",</p>"
                    + "<p>Your account has been created successfully.</p>"
                    + "<p>Username: " + username + "<br></p>"
                    + "<p>Password: " + residentPassword + "</p>"
                    + "<p>Please keep this information safe.</p>"
                    + "<p>Best Regards,<br>Your Community</p>";

            message.setContent(emailContent, "text/html; charset=UTF-8");

            Transport.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to: " + to);
            e.printStackTrace();
        }
    }
    

    /**
     * Kiểm tra xem địa chỉ email có tồn tại hay không.
     */
    public static void main(String[] args) {
        SendEmail emailSender = new SendEmail();
        String emailToSend = "example@gmail.com"; // Địa chỉ email cần gửi
        String subject = "Xác nhận đơn hàng"; // Chủ đề email
        String content = "<h1>Cảm ơn bạn đã đặt hàng!</h1>"; // Nội dung email
        Util u=new Util();

        emailSender.sendEmail("kophaithanhhui@gmail.com", "hui", "bla", u.generatePassword());
    }
}
