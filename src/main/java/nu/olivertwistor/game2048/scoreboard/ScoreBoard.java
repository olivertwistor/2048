package nu.olivertwistor.game2048.scoreboard;

import nu.olivertwistor.game2048.gameboard.Tile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ScoreBoard
{
    private static final Logger LOG = LogManager.getLogger();

    private int gameNumMoves;
    private int gameLargestTile;
    private int totalLowestNumMoves;
    private int totalLargestTile;
    private final HiScoresReaderWriter hiScoresReaderWriter;

    public ScoreBoard(final int gameNumMoves,
                      final int gameLargestTile,
                      final HiScoresReaderWriter hiScoresReaderWriter)
    {
        this.gameNumMoves = gameNumMoves;
        this.gameLargestTile = gameLargestTile;
        this.totalLowestNumMoves = hiScoresReaderWriter.getLowestNumMoves();
        this.totalLargestTile = hiScoresReaderWriter.getLargestTile();
        this.hiScoresReaderWriter = hiScoresReaderWriter;
    }

    public static ScoreBoard initialise(
            final HiScoresReaderWriter hiScoresReaderWriter)
    {
        final ScoreBoard scoreBoard = new ScoreBoard(
                0, Tile.LOWEST_VALUE, hiScoresReaderWriter);

        return scoreBoard;
    }

    public void storeHiScores() throws IOException
    {
        this.hiScoresReaderWriter.setLowestNumMoves(this.gameNumMoves);
        this.hiScoresReaderWriter.setLargestTile(this.gameLargestTile);
    }

    public int getGameNumMoves()
    {
        return this.gameNumMoves;
    }

    public void setGameNumMoves(final int gameNumMoves)
    {
        this.gameNumMoves = gameNumMoves;
    }

    public void incrementGameNumMoves()
    {
        this.gameNumMoves++;
    }

    public int getGameLargestTile()
    {
        return this.gameLargestTile;
    }

    public void setGameLargestTile(final int gameLargestTile)
    {
        this.gameLargestTile = gameLargestTile;
    }

    public int getTotalLowestNumMoves()
    {
        return this.totalLowestNumMoves;
    }

    public void setTotalLowestNumMoves(final int totalLowestNumMoves)
    {
        this.totalLowestNumMoves = totalLowestNumMoves;
    }

    public int getTotalLargestTile()
    {
        return this.totalLargestTile;
    }

    public void setTotalLargestTile(final int totalLargestTile)
    {
        this.totalLargestTile = totalLargestTile;
    }
}
