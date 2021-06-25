package nu.olivertwistor.g2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Container;
import java.awt.GridLayout;

/**
 * JPanel holding the buttons used by the player to move the game board.
 *
 * @since //todo correct version
 */
public final class TileMovementPane extends JPanel
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final long serialVersionUID = 1L;

    private final JButton moveRightButton;
    private final JButton moveUpButton;
    private final JButton moveLeftButton;
    private final JButton moveDownButton;

    /**
     * Creates the tile movement pane, and lays out all its components.
     *
     * @since //todo correct version
     */
    public TileMovementPane()
    {
        this.moveRightButton = new StyledArrowButton(SwingConstants.EAST);
        this.moveUpButton = new StyledArrowButton(SwingConstants.NORTH);
        this.moveLeftButton = new StyledArrowButton(SwingConstants.WEST);
        this.moveDownButton = new StyledArrowButton(SwingConstants.SOUTH);

        final Container upDownPane = new JPanel(new GridLayout(2, 1));
        upDownPane.add(this.moveUpButton);
        upDownPane.add(this.moveDownButton);

        this.add(this.moveLeftButton);
        this.add(upDownPane);
        this.add(this.moveRightButton);

        LOG.debug("Created the tile movement pane.");
    }

    /**
     * Add the specified actions to this movement pane's buttons.
     *
     * @param moveRightAction the action that should be added to the move right
     *                        button
     * @param moveUpAction    the action that should be added to the move up
     *                        button
     * @param moveLeftAction  the action that should be added to the move left
     *                        button
     * @param moveDownAction  the action that should be added to the move down
     *                        button
     *
     * @since //todo correct version
     */
    public void registerActions(final Action moveRightAction,
                                final Action moveUpAction,
                                final Action moveLeftAction,
                                final Action moveDownAction)
    {
        this.moveRightButton.setAction(moveRightAction);
        this.moveUpButton.setAction(moveUpAction);
        this.moveLeftButton.setAction(moveLeftAction);
        this.moveDownButton.setAction(moveDownAction);

        LOG.trace("Registered move actions to the movement buttons.");
    }

    @SuppressWarnings("PublicMethodWithoutLogging")
    @Override
    public String toString()
    {
        return "TileMovementPane{" +
                "moveRightButton=" + this.moveRightButton +
                ", moveUpButton=" + this.moveUpButton +
                ", moveLeftButton=" + this.moveLeftButton +
                ", moveDownButton=" + this.moveDownButton +
                '}';
    }
}
