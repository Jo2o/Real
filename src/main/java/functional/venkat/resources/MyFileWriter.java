package functional.venkat.resources;

import lombok.SneakyThrows;

import java.io.FileWriter;

public class MyFileWriter {

    private final FileWriter fileWriter;

    @SneakyThrows
    public MyFileWriter(final String fileName) {
        fileWriter = new FileWriter(fileName);
    }

    @SneakyThrows
    public void writeStuff(final String message) {
        fileWriter.write(message);
    }

    @SneakyThrows
    public void finish() {
        fileWriter.close();
    }
}
