package listeners;

import org.testng.IExecutionListener;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class SummaryMailListener implements IExecutionListener {

    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";
    private static final String USER = "bekos1test@gmail.com";
    private static final String PASS = "cqfy ttnq yyph tfan";
    private static final String FROM = "bekos1test@gmail.com";
    private static final String TO   = "bekos1test@gmail.com";

    @Override
    public void onExecutionStart() {
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
        // Cucumber HTML raporunun yolu
        File reportFile = new File("target/cucumber-reports/cucumber.html");
        if (!reportFile.exists()) {
            throw new Exception("Cucumber raporu bulunamadı: " + reportFile.getAbsolutePath());
        }

        // SMTP ayarları
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

        // E-posta mesajı
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject("🧪 Test Özeti ve Cucumber Raporu");

        // Mail içeriği
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(
                "Merhaba,\n\n" +
                        "Test yürütmesi tamamlandı. Ekte Cucumber test raporunu bulabilirsiniz.\n\n" +
                        "İyi çalışmalar!\nEnis ALBAYRAK"
        );

        // Raporu ekle
        MimeBodyPart attachment = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(reportFile);
        attachment.setDataHandler(new DataHandler(fds));
        attachment.setFileName("cucumber.html");

        // Mesajı birleştir
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(textPart);
        mp.addBodyPart(attachment);
        msg.setContent(mp);

        // Gönder
        Transport.send(msg);
        System.out.println(">>> Cucumber raporu başarıyla gönderildi.");
    }
}
