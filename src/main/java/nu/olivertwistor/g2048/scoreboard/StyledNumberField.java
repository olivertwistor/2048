package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class StyledNumberField extends StyledLabel
{
    private static final Logger LOG = LogManager.getLogger();

    public StyledNumberField(final String text)
    {
        super(text);
    }
}
