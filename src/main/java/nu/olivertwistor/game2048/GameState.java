package nu.olivertwistor.game2048;

import nu.olivertwistor.game2048.gameboard.GameBoard;
import nu.olivertwistor.game2048.scoreboard.HiScoresReaderWriter;
import nu.olivertwistor.game2048.scoreboard.ScoreBoard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class GameState
{
    private static final Logger LOG = LogManager.getLogger();

    private final GameBoard gameBoard;
    private final ScoreBoard scoreBoard;

    public GameState(final GameBoard gameBoard, final ScoreBoard scoreBoard)
    {
        this.gameBoard = gameBoard;
        this.scoreBoard = scoreBoard;
    }

    public static GameState initialise(
            final HiScoresReaderWriter hiScoresReaderWriter)
    {
        final GameBoard gameBoard = GameBoard.initialise();
        final ScoreBoard scoreBoard =
                ScoreBoard.initialise(hiScoresReaderWriter);

        return new GameState(gameBoard, scoreBoard);
    }

    public GameBoard getGameBoard()
    {
        return this.gameBoard;
    }

    public ScoreBoard getScoreBoard()
    {
        return this.scoreBoard;
    }
}
