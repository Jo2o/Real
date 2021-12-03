package java.packt.Chapter04.P96_VarAndTryWithResources.src.modern.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        try (var writer = new PrintWriter(new File("welcome.txt"))) {
            writer.println("Welcome message");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
