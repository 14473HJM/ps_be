package ar.edu.utn.frc.tup.ps.psappbe.services.mail;

import ar.edu.utn.frc.tup.ps.psappbe.services.files.FileService;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import javax.servlet.UnavailableException;
import java.io.IOException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailServiceImplTest {

    @Autowired
    private Gmail gmail;

    @Autowired
    private Drive drive;

    @Autowired
    private EmailService emailService;

    @Autowired
    private FileService fileService;

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
    public void testDrive() throws IOException {
        // Print the labels in the user's account.
        FileList result = drive.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }
    }

    @Test
    public void testSendMail() throws UnavailableException {
        // Print the labels in the user's account.
        emailService.sendSimpleEmail("hernanjesusmorais@hotmail.com",
                "ps.tecnicatura@gmail.com",
                "Test", "Text Body");
    }

    @Test
    public void testDriver() throws UnavailableException, IOException {
        // Print the labels in the user's account.
        //fileService.createFolder("Test");
        String id = fileService.getPsFolderId();
        System.out.println(id);
    }
}