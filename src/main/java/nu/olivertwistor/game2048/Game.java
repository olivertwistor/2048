package nu.olivertwistor.game2048;

import nu.olivertwistor.game2048.scoreboard.HiScoresReaderWriter;
import nu.olivertwistor.game2048.scoreboard.ScoreBoard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game
{
    private static final Logger LOG = LogManager.getLogger();

    private final Deque<GameState> gameHistory;
    private final HiScoresReaderWriter hiScoresReaderWriter;

    public Game(final HiScoresReaderWriter hiScoresReaderWriter)
    {
        this.gameHistory = new LinkedList<>();
        this.gameHistory.add(GameState.initialise(hiScoresReaderWriter));
        this.hiScoresReaderWriter = hiScoresReaderWriter;
    }

    public GameState getLatestGameState()
    {
        return this.gameHistory.getLast();
    }

    public void saveToHiScore() throws IOException
    {
        final GameState latestGameState = this.getLatestGameState();
        final ScoreBoard scoreBoard = latestGameState.getScoreBoard();
        scoreBoard.storeHiScores();
    }
}
