package nu.olivertwistor.game2048.scoreboard;

import nu.olivertwistor.game2048.gameboard.Tile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ScoreBoard
{
    private static final Logger LOG = LogManager.getLogger();

    private int gameNumMoves;
    private int gameLargestTile;
    private int totalLowestNumMoves;
    private int totalLargestTile;

    public ScoreBoard(final int gameNumMoves,
                      final int gameLargestTile,
                      final int totalLowestNumMoves,
                      final int totalLargestTile)
    {
        this.gameNumMoves = gameNumMoves;
        this.gameLargestTile = gameLargestTile;
        this.totalLowestNumMoves = totalLowestNumMoves;
        this.totalLargestTile = totalLargestTile;
    }

    public static ScoreBoard initialise(final HiScoresReader hiScoresReader)
    {
        final int lowestNumMoves = hiScoresReader.getLowestNumMoves();
        final int largestTile = hiScoresReader.getLargestTile();

        final ScoreBoard scoreBoard = new ScoreBoard(
                0, Tile.LOWEST_VALUE, lowestNumMoves, largestTile);

        return scoreBoard;
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
