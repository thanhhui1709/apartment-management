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
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Class to handle sending confirmation emails for orders and password recovery.
 */
public class SendEmail {

    private final int LIMIT_MINUS = 10;
    private final String from = "playunknowquangoc@gmail.com";
    private final String password = "ooah bdsl oxjb cxat";

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
        // Kiểm tra xem địa chỉ email có tồn tại không trước khi gửi
        if (!checkEmailExists(to)) {
            System.out.println("Địa chỉ email không tồn tại: " + to);
            return false;
        }

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

    /**
     * Kiểm tra xem địa chỉ email có tồn tại hay không.
     */
    public boolean checkEmailExists(String email) {
        String domain = email.substring(email.indexOf("@") + 1);
        try (Socket socket = new Socket("smtp." + domain, 25); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Đọc phản hồi từ máy chủ
            readServerResponse(in);

            // Gửi lệnh HELO
            out.println("HELO localhost");
            readServerResponse(in);

            // Gửi lệnh MAIL FROM
            out.println("MAIL FROM:<test@" + domain + ">");
            readServerResponse(in);

            // Gửi lệnh RCPT TO
            out.println("RCPT TO:<" + email + ">");
            String response = readServerResponse(in);

            // Kiểm tra phản hồi
            return response.startsWith("250"); // Nếu phản hồi bắt đầu bằng "250", email tồn tại

        } catch (IOException e) {
            System.out.println("Lỗi khi kiểm tra email: " + e.getMessage());
            return false; 
        }
    }

    private String readServerResponse(BufferedReader in) throws IOException {
        String response = in.readLine();
        System.out.println("Server: " + response);
        return response;
    }

    public static void main(String[] args) {
        SendEmail emailSender = new SendEmail();
        String emailToSend = "example@gmail.com"; // Địa chỉ email cần gửi
        String subject = "Xác nhận đơn hàng"; // Chủ đề email
        String content = "<h1>Cảm ơn bạn đã đặt hàng!</h1>"; // Nội dung email

        // Gửi email
        if(emailSender.sendEmail(emailToSend, subject, content)){
            System.out.println("Yes");
        } else System.out.println("NO");
    }
}
