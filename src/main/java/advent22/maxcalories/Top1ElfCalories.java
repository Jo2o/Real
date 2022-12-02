package advent22.maxcalories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Top1ElfCalories {
    private static final String INPUT_PATH = "src/main/java/advent22/maxcalories/in01.txt";

    public static void main(String[] args) {

        logCurrentDirectory();

        AtomicInteger maxCalories = new AtomicInteger();
        AtomicInteger currentCalories = new AtomicInteger();

        try (Stream<String> lines = Files.lines(Paths.get(INPUT_PATH), StandardCharsets.UTF_8)) {
            lines.forEach(
                line -> {
                    if (StringUtils.isEmpty(line)) {
                        if (currentCalories.get() > maxCalories.get()) {
                            maxCalories.set(currentCalories.get());
                        }
                        currentCalories.set(0);
                    } else {
                        currentCalories.set(currentCalories.get() + Integer.parseInt(line));
                    }
                });
            } catch (IOException e) {
                log.error("Error while processing input file", e);
            }

        log.info("MaxCalories: {}", maxCalories.get());
    }

    private static void logCurrentDirectory() {
        String currentDirectory = System.getProperty("user.dir");
        log.info("Current directory using 'user.dir' system property is: {}", currentDirectory);
        log.info("Current directory using 'Paths' is: {}", getCurrentPath());
    }

    private static String getCurrentPath() {
        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath().toString();
    }
}
