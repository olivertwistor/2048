package nu.olivertwistor.game2048;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class Game
{
    private static final Logger LOG = LogManager.getLogger();

    private LinkedList<GameState> gameHistory;

    public Game()
    {
        this.gameHistory = new LinkedList<>();
        this.gameHistory.add(GameState.initialise());
    }
}
