package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("OverridableMethodCallDuringObjectConstruction")
class StyledLabel extends JLabel
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final int FONT_SIZE = 20;

    StyledLabel(final @Nls String text)
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
