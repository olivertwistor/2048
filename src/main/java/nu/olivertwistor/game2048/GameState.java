package nu.olivertwistor.game2048;

import nu.olivertwistor.game2048.gameboard.GameBoard;
import nu.olivertwistor.game2048.scoreboard.HiScoresReader;
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

    public static GameState initialise()
    {
        final GameBoard gameBoard = GameBoard.initialise();

        ScoreBoard scoreBoard;
        try
        {
            final HiScoresReader hiScoresReader = new HiScoresReader(
                    System.getProperty("user.dir") +
                            File.separator + "hiscores.txt");
            scoreBoard = ScoreBoard.initialise(hiScoresReader);
        }
        catch (final IOException e)
        {
            scoreBoard = new ScoreBoard(0, 0, 0, 0);
            LOG.warn("Failed to read hiscore file. Using temporary scores " +
                    "instead.");
        }

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
