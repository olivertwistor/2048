package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;

/**
 * JPanel holding player scores both for the active game and for all time.
 *
 * @since //todo correct version
 */
public final class ScoreBoard extends JPanel
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final long serialVersionUID = 1L;

    private static final ResourceBundle I18N =
            ResourceBundle.getBundle("scoreboard"); //NON-NLS

    /**
     * Creates the score board, and lays out all its components.
     *
     * @since //todo correct version
     */
    public ScoreBoard()
    {
        super(new GridBagLayout());
        final GridBagConstraints constraints = new GridBagConstraints();

        @NonNls
        final String numberFormat = "%5d";

        final Insets insets = new Insets(5, 5, 5, 5);

        final Component gameHeading = new StyledHeading(
                I18N.getString("game.label.heading"));
        final Component gameHighestTileValueLabel = new StyledLabel(
                I18N.getString("game.label.highest-tile-value"));
        final Component gameHighestTileValueField = new StyledLabel(
                String.format(numberFormat, 0));
        final Component numMovesLabel = new StyledLabel(
                I18N.getString("label.num-moves"));
        final Component numMovesField = new StyledLabel(
                String.format(numberFormat, 0));
        final Component allTimeHeading = new StyledHeading(
                I18N.getString("all-time.label.heading"));
        final Component allTimeHighestTileValueLabel = new StyledLabel(
                I18N.getString("all-time.label.highest-tile-value"));
        final Component allTimeHighestTileValueField = new StyledLabel(
                String.format(numberFormat, 0));

        // Lay out headings.
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = insets;
        this.add(gameHeading, constraints);
        constraints.gridy = 3;
        this.add(allTimeHeading, constraints);

        // Lay out labels.
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(gameHighestTileValueLabel, constraints);
        constraints.gridy = 2;
        this.add(numMovesLabel, constraints);
        constraints.gridy = 4;
        this.add(allTimeHighestTileValueLabel, constraints);

        // Lay out fields.
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(gameHighestTileValueField, constraints);
        constraints.gridy = 2;
        this.add(numMovesField, constraints);
        constraints.gridy = 4;
        this.add(allTimeHighestTileValueField, constraints);

        LOG.trace("Created a score board.");
    }
}
