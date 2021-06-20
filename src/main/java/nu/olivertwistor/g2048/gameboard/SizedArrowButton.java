package nu.olivertwistor.g2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Color;
import java.awt.Dimension;

public class SizedArrowButton extends BasicArrowButton
{
    private static final Logger LOG = LogManager.getLogger();

    private final Dimension size;

    public SizedArrowButton(final int direction, final Color background, final Color shadow, final Color darkShadow, Color highlight, final Dimension size)
    {
        super(direction, background, shadow, darkShadow, highlight);
        this.size = size;
    }

    public SizedArrowButton(final int direction, final Dimension size)
    {
        super(direction);
        this.size = size;
    }

    @Override
    public Dimension getPreferredSize()
    {
        return this.size;
    }
}
