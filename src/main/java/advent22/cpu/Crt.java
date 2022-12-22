package advent22.cpu;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Crt {

    private static final String INPUT_PATH = "src/main/java/advent22/cpu/in.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Path.of(INPUT_PATH), UTF_8)) {

            List<Integer> litPixels = new ArrayList<>();
            int currentCycle = 1;
            int currentX = 1;
            int delta = 0;

            String line;
            while ((line = br.readLine()) != null) {

                char ch = line.charAt(0);
                if (ch == 'n') {
                    if (isLit(currentCycle, currentX)) {
                        litPixels.add(currentCycle - 1);
                    }
                    delta = 0;
                    currentCycle++;
                }
                if (ch == 'a') {
                    for(int i = 0; i < 2; i++) {
                        if (isLit(currentCycle, currentX)) {
                            litPixels.add(currentCycle - 1);
                        }
                        currentCycle++;
                    }
                    delta = parseInt(line.substring(5));
                }

                currentX += delta;
            }

            log.info("{}", litPixels);
            printCrt(litPixels);
        }
    }

    private static boolean isLit(int cycle, int x) {
        cycle = cycleToPosition(cycle);   // convert cycle number to pixel position
        return cycle >= (x - 1) && cycle <= (x + 1);
    }

    private static void printCrt(List<Integer> litPixels) {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                if (litPixels.contains(counter)) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
                counter++;
            }
            System.out.println();
        }
    }

    private static int cycleToPosition(int cycle) {
        if (cycle <= 40) {
            return cycle - 1;
        }
        return (cycle % 40) - 1;
    }

}
