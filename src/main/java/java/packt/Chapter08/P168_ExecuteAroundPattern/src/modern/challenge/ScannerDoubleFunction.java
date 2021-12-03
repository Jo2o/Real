package java.packt.Chapter08.P168_ExecuteAroundPattern.src.modern.challenge;

import java.io.IOException;
import java.util.Scanner;

@FunctionalInterface
public interface ScannerDoubleFunction {
    
    double readDouble(Scanner scanner) throws IOException;
}
