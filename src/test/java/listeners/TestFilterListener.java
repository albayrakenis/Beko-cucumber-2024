package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.regex.Pattern;

public class TestFilterListener implements IMethodInterceptor, ITestListener {

    private static Set<Pattern> patterns;

    private boolean includeTest(String testsToInclude, String currentTestName) {
        boolean result = false;

        if (patterns == null) {
            patterns = new HashSet<>();
            String[] testPatterns = testsToInclude.split(",");
            for (String testPattern : testPatterns) {
                patterns.add(Pattern.compile(testPattern, Pattern.CASE_INSENSITIVE));
            }
        }
        for (Pattern pattern : patterns) {
            if (pattern.matcher(currentTestName).find()) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        String testNames = System.getProperty("testname");
        if (testNames == null || testNames.trim().isEmpty()) {
            return methods;
        } else {
            if (includeTest(testNames, context.getName())) {
                return methods;
            } else {
                return new ArrayList<IMethodInstance>();
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        sendMail("Test Passed: " + result.getName(), "Test passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        sendMail("Test Failed: " + result.getName(), "Test failed. Please check logs for details.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        sendMail("Test Skipped: " + result.getName(), "Test was skipped.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Test başladığında yapılacak bir şey var mı?
    }

    @Override
    public void onFinish(ITestContext context) {
        // TestNG süreci bittiğinde yapılacak bir şey var mı?
    }

    @Override
    public void onStart(ITestContext context) {
        // TestNG başlatıldığında yapılacak bir şey var mı?
    }

    private void sendMail(String subject, String body) {
        String to = "bekos1test@gmail.com"; // Alıcı adresi
        String from = "bekos1test@gmail.com"; // Gönderen adresi
        String host = "smtp.gmail.com"; // SMTP sunucu adresi
        String username = "bekos1test@gmail.com"; // Kullanıcı adı
        String password = "cqfy ttnq yyph tfan"; // Parola

        // SMTP server ayarları
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Session oluşturma
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // E-posta mesajını oluşturma
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            // Maili gönderme
            Transport.send(message);
            System.out.println("Mail gönderildi!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
