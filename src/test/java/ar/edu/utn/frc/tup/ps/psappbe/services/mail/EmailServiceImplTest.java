package ar.edu.utn.frc.tup.ps.psappbe.services.mail;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.io.IOException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailServiceImplTest {

    @Autowired
    private Gmail gmail;

    @Autowired
    private EmailService emailService;

    @Test
    public void testMail() throws IOException {
        // Print the labels in the user's account.
        String user = "me";
        ListLabelsResponse listResponse = gmail.users().labels().list(user).execute();
        List<Label> labels = listResponse.getLabels();
        if (labels.isEmpty()) {
            System.out.println("No labels found.");
        } else {
            System.out.println("Labels:");
            for (Label label : labels) {
                System.out.printf("- %s\n", label.getName());
            }
        }
    }

    @Test
    public void testSendMail() throws IOException {
        // Print the labels in the user's account.
        emailService.sendSimpleEmail("hernanjesusmorais@hotmail.com",
                "ps.tecnicatura@gmail.com",
                "Test", "Text Body");
    }
}