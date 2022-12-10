package ar.edu.utn.frc.tup.ps.psappbe.services.files;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class FileServiceImpl implements FileService {

    private final Drive service;

    @Value("${app.files.root.id}")
    private String rootFolderId;

    @Value("${app.files.root.name}")
    private String rootFolderName;

    @Value("${app.files.projects.id}")
    private String projectsFolderId;

    @Value("${app.files.projects.name}")
    private String projectsFolderName;

    @Override
    public String createFolder(String folderName, List<String> parents) throws IOException {
        // File's metadata.
        File fileMetadata = new File();
        fileMetadata.setParents(parents);
        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");
        try {
            File file = service.files().create(fileMetadata)
                    .setFields("id")
                    .execute();
            System.out.println("Folder ID: " + file.getId());
            return file.getId();
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to create folder: " + e.getDetails());
            throw e;
        }
    }

    @Override
    public File uploadToFolder(String fileName, String fileType, String realFolderId) throws IOException {
        // File's metadata.
        File fileMetadata = new File();
        fileMetadata.setName(fileName);
        fileMetadata.setParents(Arrays.asList(realFolderId));
        java.io.File filePath = new java.io.File(fileName);
        FileContent mediaContent = new FileContent(fileType, filePath);
        try {
            File file = service.files().create(fileMetadata, mediaContent)
                    .setFields("id, parents")
                    .execute();
            System.out.println("File ID: " + file.getId());
            return file;
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to upload file: " + e.getDetails());
            throw e;
        }
    }

    @Override
    public List<String> moveFileToFolder(String fileId, String folderId) throws IOException {
        // Retrieve the existing parents to remove
        File file = service.files().get(fileId)
                .setFields("parents")
                .execute();
        StringBuilder previousParents = new StringBuilder();
        for (String parent : file.getParents()) {
            previousParents.append(parent);
            previousParents.append(',');
        }
        try {
            // Move the file to the new folder
            file = service.files().update(fileId, null)
                    .setAddParents(folderId)
                    .setRemoveParents(previousParents.toString())
                    .setFields("id, parents")
                    .execute();

            return file.getParents();
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to move file: " + e.getDetails());
            throw e;
        }
    }

    @Override
    public ByteArrayOutputStream downloadFile(String realFileId) throws IOException {
        try {
            OutputStream outputStream = new ByteArrayOutputStream();
            service.files().get(realFileId)
                    .executeMediaAndDownloadTo(outputStream);
            return (ByteArrayOutputStream) outputStream;
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to move file: " + e.getDetails());
            throw e;
        }
    }

    @Override
    public ByteArrayOutputStream exportPdf(String realFileId) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        try {
            service.files().export(realFileId, "application/pdf")
                    .executeMediaAndDownloadTo(outputStream);
            return (ByteArrayOutputStream) outputStream;
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to export file: " + e.getDetails());
            throw e;
        }
    }

    @Override
    public List<File> searchFile(String query, Optional<String> spaces) throws IOException {
        List<File> files = new ArrayList<File>();
        String pageToken = null;
        do {
            FileList result = service.files().list()
                    .setQ(query)
                    .setSpaces(spaces.orElse("drive"))
                    .setFields("nextPageToken, items(id, title)")
                    .setPageToken(pageToken)
                    .execute();
            files.addAll(result.getFiles());
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        return files;
    }

    @Override
    public String getPsFolderId() throws IOException {
        return this.rootFolderId;
    }

    @Override
    public String getProjectsFolderId() throws IOException {
        return this.projectsFolderId;
    }

}
