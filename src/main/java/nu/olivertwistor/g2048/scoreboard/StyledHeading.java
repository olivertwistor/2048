package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.StyleConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class StyledHeading extends StyledLabel
{
    private static final Logger LOG = LogManager.getLogger();

    public StyledHeading(final String text)
    {
        super(text);

        final Font oldFont = super.getFont();
        final Map<TextAttribute, Object> fontAttr = new HashMap<>();
        fontAttr.put(TextAttribute.SIZE, 20);
        fontAttr.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        fontAttr.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        final Font newFont = oldFont.deriveFont(fontAttr);

        this.setFont(newFont);
    }
}
