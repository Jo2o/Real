package java.packt.Chapter09.P198_DefaultMethods.src.modern.challenge;

import java.util.Arrays;

public interface Polygon {

    public double area();

    default double perimeter(double... segments) {

        return Arrays.stream(segments)
                .sum();
    }
}
