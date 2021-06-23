package nu.olivertwistor.g2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public final class TileMovementPane extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();

    private JButton moveRightButton;
    private JButton moveUpButton;
    private JButton moveLeftButton;
    private JButton moveDownButton;

    public TileMovementPane()
    {
        final Dimension arrowButtonSize = new Dimension(50, 50);

        this.moveRightButton = new StyledArrowButton(SwingConstants.EAST);
        this.moveUpButton = new StyledArrowButton(SwingConstants.NORTH);
        this.moveLeftButton = new StyledArrowButton(SwingConstants.WEST);
        this.moveDownButton = new StyledArrowButton(SwingConstants.SOUTH);

        final JPanel upDownPane = new JPanel(new GridLayout(2, 1));
        upDownPane.add(moveUpButton);
        upDownPane.add(moveDownButton);

        this.add(moveLeftButton);
        this.add(upDownPane);
        this.add(moveRightButton);

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
    }
}
