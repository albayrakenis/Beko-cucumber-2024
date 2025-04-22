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

    private static Set<Pattern> patterns = Collections.synchronizedSet(new HashSet<Pattern>());
    private static final String EMAIL_HOST = "smtp.gmail.com";
    private static final String EMAIL_PORT = "587";
    private static final String EMAIL_USERNAME = "bekos1test@gmail.com"; // Consider storing this in environment variables
    private static final String EMAIL_PASSWORD = "cqfy ttnq yyph tfan"; // Consider storing this in environment variables or using OAuth2 for security
    private static final String EMAIL_FROM = "bekos1test@gmail.com";
    private static final String EMAIL_TO = "bekos1test@gmail.com";

    private boolean includeTest(String testsToInclude, String currentTestName) {
        boolean result = false;

        // Initialize patterns only if they are not initialized
        if (patterns.isEmpty()) {
            String[] testPatterns = testsToInclude.split(",");
            for (String testPattern : testPatterns) {
                patterns.add(Pattern.compile(testPattern.trim(), Pattern.CASE_INSENSITIVE));
            }
        }

        // Check if the test name matches any of the patterns
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
            return methods; // Return all methods if no filter is provided
        } else {
            // Include or exclude tests based on the test name pattern
            if (includeTest(testNames, context.getName())) {
                return methods;
            } else {
                return Collections.emptyList(); // Exclude all methods if no match
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
        // Optional: Add any logic needed when a test starts.
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional: Add any logic needed after all tests finish.
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: Add any logic needed when TestNG starts.
    }

    private void sendMail(String subject, String body) {
        // Setting up SMTP properties
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", EMAIL_HOST);
        properties.setProperty("mail.smtp.port", EMAIL_PORT);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Session setup with email authentication
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            // Create email message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_TO));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);
            System.out.println("Mail sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
