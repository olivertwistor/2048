package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

final class StyledHeading extends StyledLabel
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final int FONT_SIZE = 20;

    StyledHeading(final @Nls String text)
    {
        super(text);

        final Map<TextAttribute, Object> fontAttr = new HashMap<>();
        fontAttr.put(TextAttribute.SIZE, FONT_SIZE);
        fontAttr.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        fontAttr.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        final Font oldFont = this.getFont();
        final Font newFont = oldFont.deriveFont(fontAttr);

        this.setFont(newFont);

        LOG.trace("Created a styled heading.");
    }
}
