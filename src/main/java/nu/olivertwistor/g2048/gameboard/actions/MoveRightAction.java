package nu.olivertwistor.g2048.gameboard.actions;

import nu.olivertwistor.g2048.GUI;
import nu.olivertwistor.g2048.gameboard.GameBoard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public final class MoveRightAction extends AbstractAction
{
    private static final Logger LOG = LogManager.getLogger();

    private final GameBoard gameBoard;

    public MoveRightAction(final GameBoard gameBoard)
    {
        super("Right");
        this.putValue(SHORT_DESCRIPTION, "Move right");
        this.putValue(LONG_DESCRIPTION,
                "Move the tiles to the right side of the game board");

        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        LOG.debug("Move right action performed.");
    }
}
