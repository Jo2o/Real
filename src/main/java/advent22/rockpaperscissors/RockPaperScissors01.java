package advent22.rockpaperscissors;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * rock = A,X = 1
 * paper = B,Y = 2
 * scissors = C,Z = 3
 * loss = 0
 * draw = 3
 * win = 6
 */
@Slf4j
public class RockPaperScissors01 {

    private static final String INPUT_PATH = "src/main/java/advent22/rockpaperscissors/in01.txt";

    public static void main(String[] args) {

        AtomicInteger totalScore = new AtomicInteger();
        CircularBuffer circularBuffer = new CircularBuffer();

        try (Stream<String> lines = Files.lines(Paths.get(INPUT_PATH), StandardCharsets.UTF_8)) {
            lines.forEach(line ->
                totalScore.getAndAdd(
                    circularBuffer.getGameResult(
                        GameSymbol.getSymbol(line.substring(0, 1)),
                        GameSymbol.getSymbol(line.substring(2))
                    )));
        } catch (IOException e) {
            log.error("Error while processing input file", e);
        }

        log.info("My result: {}", totalScore);
    }
}
