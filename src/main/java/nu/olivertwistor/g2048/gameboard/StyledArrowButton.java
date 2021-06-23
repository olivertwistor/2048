package nu.olivertwistor.g2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Dimension;

public class StyledArrowButton extends BasicArrowButton
{
    private static final Logger LOG = LogManager.getLogger();

    private static final Dimension SIZE = new Dimension(50, 50);

    public StyledArrowButton(final int direction)
    {
        super(direction);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return SIZE;
    }
}
