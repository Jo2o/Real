package java.packt.Chapter04.P82_VarAndLackOfInformation.src.modern.challenge;

import java.io.File;

public final class Bins {

    private Bins() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static File fetchBinContent() {
        return new File(".");
    }
}
