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
public class MisplacedItems {

    private static final String INPUT_PATH = "src/main/java/advent22/rucksacks/in01.txt";

    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(INPUT_PATH), StandardCharsets.UTF_8)) {

            Map<Integer, Integer> totalMisplacedItemPriorities = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {

                Map<Integer, Integer> charsOccurrence = new HashMap<>();
                int lineLength = line.length();

                String firstHalf = line.substring(0, lineLength/2);
                for (char ch : firstHalf.toCharArray()) {
                    charsOccurrence.putIfAbsent((int) ch, 1);
                }

                String secondHalf = line.substring(lineLength/2);
                for (char ch : secondHalf.toCharArray()) {
                    charsOccurrence.computeIfPresent((int) ch, (key, val) -> ++val);
                }

                charsOccurrence.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> totalMisplacedItemPriorities
                        .compute(
                            entry.getKey(),
                            (key, val) -> (val == null)
                                ? getPriority(key)
                                : val + getPriority(key)));

            }
            log.info("Total of misplaced items is: {}",
                totalMisplacedItemPriorities.values()
                    .stream()
                    .reduce(0, Integer::sum));

        } catch (IOException e) {
            log.error("", e);
        }
    }

    public static int getPriority(int ch) {
        if (ch >= 97 && ch <= 122) {
            return ch - 96;
        }
        return ch - 38;
    }
}
