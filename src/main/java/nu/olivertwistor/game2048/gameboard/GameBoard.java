package nu.olivertwistor.game2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameBoard
{
    private static final Logger LOG = LogManager.getLogger();

    static final int NUM_TILES_X = 4;
    static final int NUM_TILES_Y = 4;

    private final Tile[][] tiles;

    public GameBoard(final Tile[][] tiles)
    {
        this.tiles = tiles.clone();
    }

    public GameBoard()
    {
        this.tiles = new Tile[NUM_TILES_X][NUM_TILES_Y];

        for (int y = 0; y < NUM_TILES_Y; y++)
        {
            for (int x = 0; x < NUM_TILES_X; x++)
            {
                this.tiles[x][y] = new Tile(x, y);
            }
        }
    }

    public static GameBoard initialise()
    {
        final GameBoard gameBoard = new GameBoard();

        final Set<Tile> randomTiles = gameBoard.getRandomTiles(2);
        for (final Tile tile : randomTiles)
        {
            tile.setValue(Tile.LOWEST_VALUE);
        }

        return gameBoard;
    }

    public Tile getTile(final int x, final int y)
    {
        if (isWithinBounds(x, 0, NUM_TILES_X) &&
                isWithinBounds(y, 0, NUM_TILES_Y))
        {
            return this.tiles[x][y];
        }

        throw new IndexOutOfBoundsException(
                "Can't get a tile outside of game board.");
    }

    public Set<Tile> getRandomTiles(final int nTiles)
    {
        // Initialise a new randomiser for this invocation.
        final Random randomiser = new Random(System.currentTimeMillis());

        final Set<Tile> randomTiles = new HashSet<>();

        // Continue adding tiles until we get the desired quantity.
        while (randomTiles.size() < nTiles)
        {
            final int randomX = randomiser.nextInt(NUM_TILES_X);
            final int randomY = randomiser.nextInt(NUM_TILES_Y);

            final Tile randomTile = this.getTile(randomX, randomY);
            randomTiles.add(randomTile);
        }

        return randomTiles;
    }

    private static boolean isWithinBounds(final int value,
                                          final int lowerBound,
                                          final int upperBound)
    {
        return (value >= lowerBound) && (value < upperBound);
    }
}
