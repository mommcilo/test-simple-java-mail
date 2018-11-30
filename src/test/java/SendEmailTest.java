import org.junit.Test;

public class SendEmailTest {

    final String emailAddress1 = "test.tost@test.com";
    final String emailAddress2 = "test.töst@test.com";

    @Test
    public void defaultMailerWithoutSpecialCharacter(){
        MailSender mailSender = MailSender.defaultMailer();
        mailSender.sendEmail("test", "test", emailAddress1);
    }

    @Test
    public void defaultMailerWithSpecialCharacter(){
        MailSender mailSender = MailSender.defaultMailer();
        mailSender.sendEmail("test", "test", emailAddress2);
    }

    @Test
    public void rfcMailerWithoutSpecialCharacter(){
        MailSender mailSender = MailSender.rfcMailer();
        mailSender.sendEmail("test", "test", emailAddress1);
    }

    @Test
    public void rfcMailerWithSpecialCharacter(){
        MailSender mailSender = MailSender.rfcMailer();
        mailSender.sendEmail("test", "test", emailAddress2);
    }

    @Test
    public void clearMailerWithoutSpecialCharacter(){
        MailSender mailSender = MailSender.clearMailer();
        mailSender.sendEmail("test", "test", emailAddress1);
    }

    @Test
    public void clearMailerWithSpecialCharacter(){
        MailSender mailSender = MailSender.clearMailer();
        mailSender.sendEmail("test", "test", emailAddress2);
    }

}
