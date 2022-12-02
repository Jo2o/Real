package advent22.maxcalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Top3ElvesCalories {
    private static final String INPUT_PATH = "src/main/java/advent22/maxcalories/in01.txt";

    public static void main(String[] args) {
        log.info("Default charset: {}", Charset.defaultCharset());

        List<Integer> maxes = new ArrayList<>();
        maxes.add(0);
        maxes.add(0);
        maxes.add(0);
        maxes.add(0);
        maxes.sort((x, y) -> -1 * Integer.compare(x, y));

        try (BufferedReader br = Files.newBufferedReader(Path.of(INPUT_PATH), StandardCharsets.UTF_8)) {
            String line;
            int currentSum = 0;
            while ((line = br.readLine()) != null) {
                if (StringUtils.isEmpty(line)) {
                    if (currentSum >= maxes.get(2)) {
                        maxes.set(3, currentSum);
                        maxes.sort(Comparator.reverseOrder());
                    }
                    currentSum = 0;
                } else {
                    currentSum += Integer.parseInt(line);
                }
            }
        } catch (IOException e) {
            log.error("", e);
        }
        log.info("{}", maxes.get(0) + maxes.get(1) + maxes.get(2));
    }
}
