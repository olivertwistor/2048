package nu.olivertwistor.game2048;

import nu.olivertwistor.game2048.gameboard.GameBoard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameState
{
    private static final Logger LOG = LogManager.getLogger();

    private final GameBoard gameBoard;

    public GameState(final GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;
    }

    public static GameState initialise()
    {
        final GameBoard gameBoard = GameBoard.initialise();
        return new GameState(gameBoard);
    }

    public GameBoard getGameBoard()
    {
        return this.gameBoard;
    }
}
