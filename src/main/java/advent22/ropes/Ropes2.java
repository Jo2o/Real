package advent22.ropes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Ropes2 {

  private static final String INPUT_PATH = "src/main/java/advent22/ropes/in.txt";

  public static void main(String[] args) throws IOException {
    Snake snake = Snake.builder()
        .head(new Head("H", new Position(0, 0)))
        .body(List.of(
            new Tail("1", new Position(0, 0)), // 0
            new Tail("2", new Position(0, 0)),
            new Tail("3", new Position(0, 0)),
            new Tail("4", new Position(0, 0)),
            new Tail("5", new Position(0, 0)),
            new Tail("6", new Position(0, 0)),
            new Tail("7", new Position(0, 0)),
            new Tail("8", new Position(0, 0)),
            new Tail("9", new Position(0, 0)))) // 8
        .build();

    try (Stream<String> lines = Files.lines(Paths.get(INPUT_PATH), StandardCharsets.UTF_8)) {
      lines.forEach(
          line -> {
            String direction = line.substring(0, 1);
            int stepCount = Integer.parseInt(line.substring(2));
            for (int i = 0; i < stepCount; i++) {
                snake.move(direction);
            }
          });
    }

    System.out.println("Tail's visited points: " + snake.getTail().getVisitedPoints().size());
  }

}
