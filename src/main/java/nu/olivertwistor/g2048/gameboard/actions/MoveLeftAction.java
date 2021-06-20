package nu.olivertwistor.g2048.gameboard.actions;

import nu.olivertwistor.g2048.GUI;
import nu.olivertwistor.g2048.gameboard.GameBoard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public final class MoveLeftAction extends AbstractAction
{
    private static final Logger LOG = LogManager.getLogger();

    private final GameBoard gameBoard;

    public MoveLeftAction(final GameBoard gameBoard)
    {
        super("Left");
        this.putValue(SHORT_DESCRIPTION, "Move left");
        this.putValue(LONG_DESCRIPTION,
                "Move the tiles to the left side of the game board");

        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        LOG.debug("Move left action performed.");
    }
}
