package advent22.rockpaperscissors;

import lombok.Getter;

@Getter
public enum GameSymbol {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int score;

    GameSymbol(int score) {
        this.score = score;
    }

    public static GameSymbol getSymbol(String letter) {
        if ("A".equals(letter) || "X".equals(letter)) {
            return ROCK;
        }
        if ("B".equals(letter) || "Y".equals(letter)) {
            return PAPER;
        }
        return SCISSORS;
    }
}
