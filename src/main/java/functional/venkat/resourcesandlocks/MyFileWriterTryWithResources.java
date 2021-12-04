package functional.venkat.resourcesandlocks;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;

@Slf4j
public class MyFileWriterTryWithResources implements AutoCloseable {

    private final FileWriter fileWriter;

    @SneakyThrows
    public MyFileWriterTryWithResources(final String fileName) {
        fileWriter = new FileWriter(fileName);
    }

    @SneakyThrows
    public void writeStuff(final String message) {
        fileWriter.write(message);
    }

    @Override
    @SneakyThrows
    public void close() {
        log.info("AutoCloseable auto closing resource...");
        fileWriter.close();
    }
}
