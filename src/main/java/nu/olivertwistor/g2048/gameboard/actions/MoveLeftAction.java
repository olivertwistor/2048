package nu.olivertwistor.g2048.gameboard.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

@SuppressWarnings("ALL")
public final class MoveLeftAction extends AbstractAction
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final ResourceBundle I18N =
            ResourceBundle.getBundle("gameboard"); //NON-NLS

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
