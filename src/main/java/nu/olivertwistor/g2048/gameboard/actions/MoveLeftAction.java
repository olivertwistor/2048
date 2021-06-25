package nu.olivertwistor.g2048.gameboard.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

/**
 * This action is triggered when the user wants to move the gameboard to the
 * left. It tells all the tiles to move to the left.
 *
 * @since //todo correct version
 */
@SuppressWarnings("ClassOnlyUsedInOnePackage")
public final class MoveLeftAction extends AbstractAction
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle I18N =
            ResourceBundle.getBundle("gameboard"); //NON-NLS

    /**
     * Creates the move left action. Sets the name, short description and long
     * description.
     *
     * @since //todo correct version
     */
    public MoveLeftAction()
    {
        super(I18N.getString("actions.move-left.name"));
        this.putValue(SHORT_DESCRIPTION, I18N.getString(
                "actions.move-left.short-description"));
        this.putValue(LONG_DESCRIPTION, I18N.getString(
                "actions.move-left.long-description"));
    }

    @Override
    public void actionPerformed(final ActionEvent e)
    {
        LOG.debug("Move left action performed.");
    }
}
