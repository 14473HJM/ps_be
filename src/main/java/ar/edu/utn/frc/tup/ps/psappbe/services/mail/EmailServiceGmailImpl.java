package ar.edu.utn.frc.tup.ps.psappbe.services.mail;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.apache.commons.codec.binary.Base64;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;



import java.util.Properties;

@RequiredArgsConstructor
@Component
public class EmailServiceGmailImpl implements EmailService {

    private final Gmail gmail;

    @Override
    public void sendSimpleEmail(String toEmailAddress,
                                String fromEmailAddress,
                                String subject,
                                String bodyText) {
        try {
            String user = "me";
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage email = new MimeMessage(session);
            email.setFrom(new InternetAddress(fromEmailAddress));
            email.addRecipient(javax.mail.Message.RecipientType.TO,
                    new InternetAddress(toEmailAddress));
            email.setSubject(subject);
            email.setText(bodyText);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            email.writeTo(buffer);
            byte[] bytes = buffer.toByteArray();
            String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
            Message message = new Message();
            message.setRaw(encodedEmail);
            message = gmail.users().messages().send(user, message).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
