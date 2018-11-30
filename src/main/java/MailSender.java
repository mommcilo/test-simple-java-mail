import org.hazlewood.connor.bottema.emailaddress.EmailAddressCriteria;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import javax.mail.Message;

public class MailSender {

    private Mailer mailer;

    private final static String HOST = "localhost";
    private final static int PORT = 26;

    private final static String fromName = "test";
    private final static String fromAddress = "test@test.com";

    private MailSender(){

    }

    public static MailSender defaultMailer(){
        MailSender mailSender = new MailSender();
        mailSender.mailer = MailerBuilder.withSMTPServerHost(HOST)
                .withSMTPServerPort(PORT)
                .buildMailer();
        return mailSender;
    }

    public static MailSender rfcMailer(){
        MailSender mailSender = new MailSender();
        mailSender.mailer = MailerBuilder.withSMTPServerHost(HOST)
                .withSMTPServerPort(PORT)
                .withEmailAddressCriteria(EmailAddressCriteria.RFC_COMPLIANT)
                .buildMailer();
        return mailSender;
    }

    public static MailSender clearMailer(){
        MailSender mailSender = new MailSender();
        mailSender.mailer = MailerBuilder.withSMTPServerHost(HOST)
                .withSMTPServerPort(PORT)
                .clearEmailAddressCriteria()
                .buildMailer();
        return mailSender;
    }

    public void sendEmail(String subject, String text, String recipient){
        Email email = EmailBuilder.copying(createMail())
                .withRecipient("", recipient, Message.RecipientType.TO)
                .withSubject(subject)
                .withPlainText(text)
                .buildEmail();

        mailer.sendMail(email);
    }

    private Email createMail() {
        return EmailBuilder.startingBlank().from(fromName,
                fromAddress).buildEmail();
    }
}
