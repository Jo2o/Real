package functional.venkat.resources;

import lombok.SneakyThrows;

import java.io.FileWriter;

public class MyFileWriterLambda {

    private MyFileWriterLambda() {
    }

    @SneakyThrows
    public static void writeStuff(final String fileName, UseInstance<FileWriter> block) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            block.accept(fileWriter);
        }
    }

}
