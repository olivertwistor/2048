package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("OverridableMethodCallDuringObjectConstruction")
class StyledLabel extends JLabel
{
    private static final Logger LOG = LogManager.getLogger();

    private static final int FONT_SIZE = 20;

    StyledLabel(final String text)
    {
        super(text);

        final Map<TextAttribute, Object> fontAttr = new HashMap<>();
        fontAttr.put(TextAttribute.SIZE, FONT_SIZE);
        final Font oldFont = this.getFont();
        final Font newFont = oldFont.deriveFont(fontAttr);

        this.setFont(newFont);

        LOG.trace("Created a new styled label.");
    }
}
