import lombok.AllArgsConstructor;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@AllArgsConstructor

public class Mail {

    private String route;
    private String recipient;

    public void sendEmail(){
        try {
            // Properties of the connection
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "Project2Maven");
            props.setProperty("mail.smtp.auth", "true");

            // Preparing the session
            Session session = Session.getDefaultInstance(props, null);

            // Preparing the text part of the email
            BodyPart text = new MimeBodyPart();
            text.setText("In the following email you are going to find the statistic information of " + route.split("-")[1]);

            // Building the part of attach a pdf file
            BodyPart attach = new MimeBodyPart();
            attach.setDataHandler(
                    new DataHandler(new FileDataSource(route.split("-")[0])));
            attach.setFileName("Statistic of " + route.split("-")[1] + ".pdf");

            //Grouping text and pdf file
            MimeMultipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(text);
            multiPart.addBodyPart(attach);

            //composing the mail and sending
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("carlos.prueba.bit@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(this.recipient));
            message.setSubject("Statistic report of " + route.split("-")[1]);
            message.setContent(multiPart);

            // The message is sent.
            Transport t = session.getTransport("smtp");
            t.connect("carlos.prueba.bit@gmail.com", "dllmdszowrcxilrr");
            t.sendMessage(message, message.getAllRecipients());

            // closing.
            t.close();
            System.out.println("The mail was sending successfully");

        }catch (Exception ex){
            System.out.println("An error occurred");
        }
    }
}
