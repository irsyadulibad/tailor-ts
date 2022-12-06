package polije.ppl.tailor.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import polije.ppl.tailor.util.ConfigUtil;
import polije.ppl.tailor.util.EmailUtil;
import polije.ppl.tailor.util.PathUtil;

public class EmailService {
    public boolean sendVerificationEMail(String toEmail, String code) {
        final String fromEmail = ConfigUtil.get("mail.smtp.mail");
        final String password = ConfigUtil.get("mail.smtp.pass");

        Properties props = new Properties() {{
            put("mail.smtp.host", ConfigUtil.get("mail.smtp.host"));
            put("mail.smtp.port", ConfigUtil.get("mail.smtp.port"));
            put("mail.smtp.auth", ConfigUtil.get("mail.smtp.auth"));
            put("mail.smtp.starttls.enable", ConfigUtil.get("mail.smtp.tls"));
        }};

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(props, auth);
        return EmailUtil.sendEmail(session, toEmail, "Verification Code", getVerifyMailHtml(code));
    }

    private String getVerifyMailHtml(String code) {
        try {
            File html = new File(PathUtil.resourcePath("stub/verify-mail.html"));
            Document doc = Jsoup.parse(html, "UTF-8");

            doc.select("#code").first().text(code);
            return doc.toString();
        }catch(IOException e) { e.printStackTrace(); }

        return code;
    }
}
