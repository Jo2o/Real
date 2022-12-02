package advent22.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileLineByLineReader {

    private String relativeFilePath;
    private String absoluteFilePath;

    public FileLineByLineReader(String relativeFilePath) {
        this.relativeFilePath = relativeFilePath;
        this.absoluteFilePath = Paths.get(relativeFilePath).toAbsolutePath().toString();
    }

    public void read() {
        try (BufferedReader br = Files.newBufferedReader(Path.of(relativeFilePath), StandardCharsets.UTF_16)) {
            String line;
            while ((line = br.readLine()) != null) {
                log.info("{}", line);
            }
        } catch (IOException e) {
            log.error("", e);
        }
    }


}
