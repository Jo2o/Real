package advent22.rockpaperscissors;

import static advent22.rockpaperscissors.GameResult.DRAW;
import static advent22.rockpaperscissors.GameResult.LOSS;
import static advent22.rockpaperscissors.GameResult.WIN;
import static advent22.rockpaperscissors.GameSymbol.PAPER;
import static advent22.rockpaperscissors.GameSymbol.ROCK;
import static advent22.rockpaperscissors.GameSymbol.SCISSORS;
import static java.lang.Math.E;
import static java.lang.Math.abs;

import java.util.List;

public class CircularBuffer {

    private static final List<GameSymbol> ELEMENTS = List.of(ROCK, PAPER, SCISSORS);
    private static final List<GameSymbol> LOSS_ELEMENTS = List.of(SCISSORS, ROCK, PAPER);
    private static final List<GameSymbol> WIN_ELEMENTS = List.of(PAPER, SCISSORS, ROCK);

    public int getGameResult(GameSymbol opponentSymbol, GameSymbol mySymbol) {
        int opponentIdx = ELEMENTS.indexOf(opponentSymbol);
        int myIdx = ELEMENTS.indexOf(mySymbol);

        GameResult gameResult;
        if (abs(opponentIdx - myIdx) <= 1) {
            if (myIdx > opponentIdx) {
                gameResult = WIN;
            } else if (myIdx == opponentIdx) {
                gameResult =DRAW;
            } else {
                gameResult =LOSS;
            }
        } else {
            if (myIdx > opponentIdx) {
                gameResult =LOSS;
            } else if (myIdx == opponentIdx) {
                gameResult =DRAW;
            } else {
                gameResult =WIN;
            }
        }

        return calculatePoints(gameResult, mySymbol);
    }

    public int getGameResult(GameSymbol opponentSymbol, GameResult gameResult) {
        return getGameResult(opponentSymbol, calculateMySymbol(opponentSymbol, gameResult));
    }

    private GameSymbol calculateMySymbol(GameSymbol opponentSymbol, GameResult gameResult) {
        if (DRAW == gameResult) {
            return opponentSymbol;
        } else if (WIN == gameResult) {
            return WIN_ELEMENTS.get(ELEMENTS.indexOf(opponentSymbol));
        } else { // LOSS
            return LOSS_ELEMENTS.get(ELEMENTS.indexOf(opponentSymbol));
        }
    }

    private int calculatePoints(GameResult gameResultScore, GameSymbol gameSymbol) {
        return gameResultScore.getScore() + gameSymbol.getScore();
    }

}
