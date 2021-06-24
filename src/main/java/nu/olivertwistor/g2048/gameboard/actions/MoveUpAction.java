package nu.olivertwistor.g2048.gameboard.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

@SuppressWarnings("ClassOnlyUsedInOnePackage")
public final class MoveUpAction extends AbstractAction
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final ResourceBundle i18n =
            ResourceBundle.getBundle("gameboard"); //NON-NLS

    public MoveUpAction()
    {
        super(i18n.getString("actions.move-up.name"));
        this.putValue(SHORT_DESCRIPTION, i18n.getString(
                "actions.move-up.short-description"));
        this.putValue(LONG_DESCRIPTION, i18n.getString(
                "actions.move-up.long-description"));
    }

    @Override
    public void actionPerformed(final ActionEvent e)
    {
        LOG.debug("Move up action performed.");
    }
}
