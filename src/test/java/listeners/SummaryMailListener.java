package listeners;

import org.testng.IExecutionListener;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class SummaryMailListener implements IExecutionListener {

    // SMTP bilgileri - isterseniz env değişkenden alın
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";
    private static final String USER = "bekos1test@gmail.com";
    private static final String PASS = "cqfy ttnq yyph tfan"; // uygulama şifresi
    private static final String FROM = "bekos1test@gmail.com";
    private static final String TO   = "bekos1test@gmail.com";

    @Override
    public void onExecutionStart() {
        // İstersen başlarken log mesajı at
        System.out.println(">>> Test yürütmesi başladı");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println(">>> Test yürütmesi bitti, mail gönderiliyor...");
        try {
            sendSummaryMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendSummaryMail() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASS);
            }
        });

        // Mesaj oluştur
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject("🧪 Test Özeti ve Rapor");

        // Multipart içerik
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText("Merhaba,\n\nTest yürütmesi tamamlandı. Ekteki raporu inceleyebilirsiniz.\n\nİyi çalışmalar!.\n\n Enis ALBAYRAK");

        // Rapor dosyasını attachment olarak ekle
        // Allure: target/allure-report/index.html dizini; Cucumber: target/cucumber-reports/cucumber.html
        File report = new File("target/allure-report/index.html");
        if (!report.exists()) {
            // Allure raporu yoksa Cucumber raporunu deneyelim
            report = new File("target/cucumber-reports/cucumber.html");
        }
        MimeBodyPart attachment = new MimeBodyPart();
        FileDataSource ds = new FileDataSource(report);
        attachment.setDataHandler(new DataHandler(ds));
        attachment.setFileName(report.getName());

        Multipart mp = new MimeMultipart();
        mp.addBodyPart(textPart);
        mp.addBodyPart(attachment);

        msg.setContent(mp);

        // Gönder
        Transport.send(msg);
        System.out.println(">>> Özet mail gönderildi: " + report.getAbsolutePath());
    }
}
