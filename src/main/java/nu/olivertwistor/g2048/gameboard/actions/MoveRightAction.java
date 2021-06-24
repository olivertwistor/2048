package nu.olivertwistor.g2048.gameboard.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public final class MoveRightAction extends AbstractAction
{
    private static final Logger LOG = LogManager.getLogger();

    public MoveRightAction()
    {
        super("Right");
        this.putValue(SHORT_DESCRIPTION, "Move right");
        this.putValue(LONG_DESCRIPTION,
                "Move the tiles to the right side of the game board");

    }

    @Override
    public void actionPerformed(final ActionEvent e)
    {
        LOG.debug("Move right action performed.");
    }
}
