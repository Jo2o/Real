package j.javacodingproblems.mycodingtests.functionalpatterns;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import lombok.SneakyThrows;

public class ExecuteAround {

    @SneakyThrows
    public static void main(String[] args) {
        ExecuteAround.read(ExecuteAround::getFirst);
        ExecuteAround.read(ExecuteAround::sum);
    }
    
    private static double getFirst(Scanner scanner) {
        if (scanner.hasNext()) {
            return scanner.nextDouble();
        }
        return Double.NaN;
    }

    private static double sum(Scanner scanner) {
        double sum = 0.0d;
        while (scanner.hasNext()) {
            sum += scanner.nextDouble();
        }
        return sum;
    }
    
    public static double read(ScannerDoubleFunction scannerDoubleFunction) throws IOException {
        try (Scanner scanner = new Scanner(Path.of("doubles.txt"), StandardCharsets.UTF_8)) {
            return scannerDoubleFunction.readDouble(scanner);
        }
    }
    
    @FunctionalInterface
    interface ScannerDoubleFunction {
        double readDouble(Scanner scanner);
    }
}
