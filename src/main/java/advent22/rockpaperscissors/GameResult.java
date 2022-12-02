package advent22.rockpaperscissors;

import lombok.Getter;

@Getter
public enum GameResult {
    WIN(6),
    DRAW(3),
    LOSS(0);

    private final int score;

    GameResult(int score) {
        this.score = score;
    }

    public static GameResult getResult(String letter) {
        if ("X".equals(letter)) {
            return LOSS;
        }
        if ("Y".equals(letter)) {
            return DRAW;
        }
        return WIN;
    }
}
