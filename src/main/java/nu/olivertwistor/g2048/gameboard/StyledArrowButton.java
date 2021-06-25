package nu.olivertwistor.g2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Dimension;

/**
 * This is a {@link BasicArrowButton} with the only change, it's preferred size.
 *
 * @since //todo correct version
 */
class StyledArrowButton extends BasicArrowButton
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final long serialVersionUID = 1L;

    private static final Dimension SIZE = new Dimension(50, 50);

    /**
     * Creates a {@link BasicArrowButton}.
     *
     * @param direction in which direction the arrow should point
     *
     * @since //todo correct version
     */
    StyledArrowButton(final int direction)
    {
        super(direction);

        LOG.trace("Created a styled arrow button.");
    }

    @Override
    public Dimension getPreferredSize()
    {
        return SIZE;
    }
}
