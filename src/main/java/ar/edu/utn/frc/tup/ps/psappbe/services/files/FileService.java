package ar.edu.utn.frc.tup.ps.psappbe.services.files;

import com.google.api.services.drive.model.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FileService {

    String createFolder(String folderName, List<String> parents) throws IOException;

    File uploadToFolder(String fileName, String fileType, String realFolderId) throws IOException;

    List<String> moveFileToFolder(String fileId, String folderId) throws IOException;

    ByteArrayOutputStream downloadFile(String realFileId) throws IOException;

    ByteArrayOutputStream exportPdf(String realFileId) throws IOException;

    List<File> searchFile(String query, Optional<String> spaces) throws IOException;

    String getPsFolderId() throws IOException;

    String getProjectsFolderId() throws IOException;

}
