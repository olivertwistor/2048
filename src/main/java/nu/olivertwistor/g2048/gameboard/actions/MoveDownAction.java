package nu.olivertwistor.g2048.gameboard.actions;

import nu.olivertwistor.g2048.GUI;
import nu.olivertwistor.g2048.gameboard.GameBoard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

public final class MoveDownAction extends AbstractAction
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final ResourceBundle i18n =
            ResourceBundle.getBundle("gameboard"); //NON-NLS

    public MoveDownAction(final GameBoard gameBoard)
    {
        super(i18n.getString("actions.move-down.name"));
        this.putValue(SHORT_DESCRIPTION, i18n.getString(
                "actions.move-down.short-description"));
        this.putValue(LONG_DESCRIPTION, i18n.getString(
                "actions.move-down.long-description"));

        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        LOG.debug("Move down action performed.");
    }
}
