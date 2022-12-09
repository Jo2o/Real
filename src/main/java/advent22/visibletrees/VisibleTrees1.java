package advent22.visibletrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VisibleTrees1 {
    private static final String INPUT_PATH = "src/main/java/advent22/visibletrees/in.txt";

    public static void main(String[] args) throws IOException {
        List<Integer> forestDimensions = forestRowsColumns(INPUT_PATH);
        int rowCount = forestDimensions.get(0);
        int colCount = forestDimensions.get(1);
        int[][] forest = new int[rowCount][colCount];
        forest = readForest(INPUT_PATH, forest);

        int perimeterTrees = countPerimeterTrees(forest);
        log.info("Perimeter tree count: {}", perimeterTrees);

        int visibleTreesCounter = 0;
        for (int row = 1; row < rowCount - 1; row++) {
            for(int col = 1; col < colCount - 1; col++) {
                if (isVisible(row, col, forest)) {
                    visibleTreesCounter++;
                }
            }
        }

        log.info("Visible tree count: {}", perimeterTrees + visibleTreesCounter);
    }

    private static boolean isVisible(int row, int col, int[][] forest) {
        if (isVisibleFromNorth(row, col, forest)) {
            return true;
        }
        if (isVisibleFromSouth(row, col, forest)) {
            return true;
        }
        if (isVisibleFromEast(row, col, forest)) {
            return true;
        }
        if (isVisibleFromWest(row, col, forest)) {
            return true;
        }
        return false;
    }

    private static boolean isVisibleFromNorth(int row, int col, int[][] forest) {
        int current = row;
        while (current != 0) {
            current--;
            if (forest[current][col] >= forest[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleFromSouth(int row, int col, int[][] forest) {
        int current = row;
        while (current != getForestRowCount(forest) - 1) {
            current++;
            if (forest[current][col] >= forest[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleFromEast(int row, int col, int[][] forest) {
        int current = col;
        while (current != getForestColCount(forest) - 1) {
            current++;
            if (forest[row][current] >= forest[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleFromWest(int row, int col, int[][] forest) {
        int current = col;
        while (current != 0) {
            current--;
            if (forest[row][current] >= forest[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static int countPerimeterTrees(int[][] forest) {
        return 2 * (forest[0].length) + 2 * (forest.length - 2);
    }

    private static int[][] readForest(String filePath, int[][] forest) throws IOException {
        int rows = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                for(int i = 0; i < line.length(); i++) {
                    forest[rows][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                }
                rows++;
            }
        }
        return forest;
    }

    private static List<Integer> forestRowsColumns(String filePath) throws IOException {
        int rows = 0;
        int cols = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (rows == 0) {
                    cols = line.length();
                }
                rows++;
            }
        }
        return List.of(rows, cols);
    }

    private static int getForestRowCount(int[][] forest) {
        return forest.length;
    }

    private static int getForestColCount(int[][] forest) {
        return forest[0].length;
    }

}
