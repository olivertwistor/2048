package nu.olivertwistor.g2048.gameboard.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public final class MoveUpAction extends AbstractAction
{
    private static final Logger LOG = LogManager.getLogger();

    public MoveUpAction()
    {
        super("Up");
        this.putValue(SHORT_DESCRIPTION, "Move up");
        this.putValue(LONG_DESCRIPTION,
                "Move the tiles to the top of the game board");

    }

    @Override
    public void actionPerformed(final ActionEvent e)
    {
        LOG.debug("Move up action performed.");
    }
}
