package advent22.cpu;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Crt {

    private static final String INPUT_PATH = "src/main/java/advent22/cpu/in.txt";
    private static final List<Integer> IMPORTANT_CYCLES = List.of(20, 60, 100, 140, 180, 220);

    public static void main(String[] args) throws IOException {

        printRow();


        int signalStrength = 0;

//        try (BufferedReader br = Files.newBufferedReader(Path.of(INPUT_PATH), StandardCharsets.UTF_8)) {
//
//            int currentCycle = 1;
//            int currentX = 1;
//            int delta = 0;
//
//            String line;
//            while ((line = br.readLine()) != null) {
//
//                char ch = line.charAt(0);
//                if (ch == 'n') {
//                    signalStrength = addToSignalStrength(signalStrength, currentCycle, currentX);
//                    delta = 0;
//                    currentCycle++;
//                }
//                if (ch == 'a') {
//                    for(int i = 0; i < 2; i++) {
//                        signalStrength = addToSignalStrength(signalStrength, currentCycle, currentX);
//                        currentCycle++;
//                    }
//                    delta = parseInt(line.substring(5));
//                }
//
//                currentX += delta;
//            }
//        }

        log.info("Sum of signal strength during {} cycles: {}", IMPORTANT_CYCLES, signalStrength);
    }

    private static int addToSignalStrength(int strength, int cycle, int x) {
        if (IMPORTANT_CYCLES.contains(cycle)) {
            strength += cycle * x;
            log.info("Adding to signal: cycle={} * X={} => {}", cycle, x, cycle * x);
        }
        return strength;
    }

    private static void printRow() {
        for (int i = 0; i < 40; i++) {
            System.out.print("#");
        }
    }

}
