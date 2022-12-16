package advent22.ropes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ropes1 {

  private static final String INPUT_PATH = "src/main/java/advent22/ropes/in.txt";

  public static void main(String[] args) throws IOException {
    Head head = new Head("H", new Position(0, 0));
    Tail tail = new Tail("T", new Position(0, 0));

    try (Stream<String> lines = Files.lines(Paths.get(INPUT_PATH), StandardCharsets.UTF_8)) {
      lines.forEach(
          line -> {
            String direction = line.substring(0, 1);
            int stepCount = Integer.parseInt(line.substring(2));
            for (int i = 0; i < stepCount; i++) {
              head.move(direction);
              tail.move(head);
            }
          });
    }

    System.out.println("Tail's visited points: " + tail.getVisitedPoints().size());
  }

}
