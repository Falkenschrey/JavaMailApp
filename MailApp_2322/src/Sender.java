import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sender {

    private SMTP smtp = null;
    private Session session = null;

    public Sender() {
        this.smtp = new SMTP();
        this.session = this.smtp.getSMTPConnection();
    }

    public boolean send(Mail mail) throws Exception {
        Message message = new MimeMessage(this.session);
        message.setFrom(new InternetAddress(this.smtp.getFrom()));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(mail.getRecipient()));
        message.setSubject(mail.getSubject());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mail.getMessage(), "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        try {
            Transport.send(message);
        } catch (MessagingException ex){
            throw new Exception("ERROR: Message cannot be sent!");
        }
        return true;
    }
}
