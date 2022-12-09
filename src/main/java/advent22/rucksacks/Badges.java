package advent22.rucksacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Badges {

    private static final String INPUT_PATH = "src/main/java/advent22/rucksacks/in01.txt";
//    private static final String INPUT_PATH = "src/main/java/advent22/rucksacks/test.txt";

    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(INPUT_PATH), StandardCharsets.UTF_8)) {

            int total = 0;
            Map<Character, Integer> charsOccurrence = new HashMap<>();
            String line;
            int lineCounter = 0;
            while ((line = br.readLine()) != null) {
                lineCounter++;
                if (lineCounter % 3 == 1) {
                    for (char ch : line.toCharArray()) {
                        charsOccurrence.putIfAbsent(ch, 1);
                    }
                } else if (lineCounter % 3 == 2) {
                    for (char ch : line.toCharArray()) {
                        charsOccurrence.computeIfPresent(ch, (k, v) -> {
                            if (v == 1) {
                                return 2;
                            } else {
                                return v;
                            }});
                    }
                } else { // (lineCounter % 3 == 0)
                    for (char ch : line.toCharArray()) {
                        charsOccurrence.computeIfPresent(ch, (k, v) -> {
                            if (v == 2) {
                                return 3;
                            } else {
                                return v;
                            }});
                    }
                    total += charsOccurrence.entrySet().stream()
                        .filter(entry -> entry.getValue() == 3)
                        .map(entry -> MisplacedItems.getPriority(entry.getKey()))
                        .mapToInt(i -> i)
                        .sum();
                    charsOccurrence.clear();
                }
            }
            log.info("Total of badges is: {}", total);
        } catch (IOException e) {
            log.error("", e);
        }
    }

}
