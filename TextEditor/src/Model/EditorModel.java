package Model;

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EditorModel {
    private String fileName;
    private String fileAddress;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String openFile(String fileAddress, String fileName) throws IOException {
        this.fileAddress = fileAddress;
        this.fileName = fileName;

        try (BufferedReader br = new BufferedReader(new FileReader(fileAddress))) {
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new IOException("Error opening file: " + e.getMessage());
        }
    }

    public void saveFile(String fileAddress, String content) throws IOException {
        this.fileAddress = fileAddress;

        try (FileWriter fw = new FileWriter(fileAddress)) {
            fw.write(content);
        } catch (IOException e) {
            throw new IOException("Error saving file: " + e.getMessage());
        }
    }

    public List<String> getAllFilesInDirectory(String directory) throws IOException {
        List<String> fileList;
        try (Stream<Path> paths = Files.walk(Paths.get(directory), FileVisitOption.FOLLOW_LINKS)) {
            fileList = paths
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }
        return fileList;
    }
}
