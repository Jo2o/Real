package advent22.walkieprotocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WalkieProtocol2 {

    private static final String INPUT_PATH = "src/main/java/advent22/walkieprotocol/in.txt";
    private static final int BUFFER_SIZE = 14;

    public static void main(String[] args) throws IOException {

        String line = readLine(INPUT_PATH);
        char[] chars = line.toCharArray();

        LinkedList<Character> buffer = new LinkedList<>();
        int totalCounter = 0;

        for (int i = 0; i < BUFFER_SIZE; i++) {
            totalCounter++;
            buffer.add(chars[i]);
        }

        if (!hasDuplicates(buffer)) {
            log.info("Result: {}", totalCounter);
            return;
        }

        for (int i = BUFFER_SIZE; i < line.length(); i++) {
            totalCounter++;
            buffer.removeFirst();
            buffer.add(chars[i]);
            if (!hasDuplicates(buffer)) {
                log.info("Result: {}", totalCounter);
                return;
            }
        }
    }

    private static boolean hasDuplicates(LinkedList<Character> buffer) {
        return new HashSet<>(buffer).size() < BUFFER_SIZE;
    }

    private static String readLine(String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8)) {
            return br.readLine();
        }
    }

}
