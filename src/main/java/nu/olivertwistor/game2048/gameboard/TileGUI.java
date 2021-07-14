package nu.olivertwistor.game2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public final class TileGUI extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();
    private static final ColourPicker COLOUR_PICKER = new ColourPicker();

    private final JLabel valueLabel;
    private int fontSize;

    public TileGUI(final Tile tile)
    {
        super(new BorderLayout());

        this.valueLabel = new JLabel("", SwingConstants.CENTER);
        this.fontSize = 50;

        final Color bgColour = COLOUR_PICKER.getAppropriateTileColour(
                tile.getValue());
        this.setBackground(bgColour);

        final Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);

        this.setOpaque(true);

        final int tileValue = tile.getValue();
        if (tileValue != 0)
        {
            // Make a good font for the text label.
            final Map<TextAttribute, Object> fontAttributes = new HashMap<>();
            fontAttributes.put(TextAttribute.FOREGROUND, Color.BLACK);
            fontAttributes.put(TextAttribute.SIZE, this.fontSize);
            final Font font = this.getFont().deriveFont(fontAttributes);

            this.valueLabel.setText(String.valueOf(tileValue));
            this.valueLabel.setFont(font);
            this.add(this.valueLabel, BorderLayout.CENTER);
        }
    }
}
