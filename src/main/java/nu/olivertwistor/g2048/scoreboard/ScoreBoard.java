package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public final class ScoreBoard extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();

    public ScoreBoard()
    {
        super(new GridBagLayout());
        final GridBagConstraints constraints = new GridBagConstraints();

        final String numberFormat = "%5d";
        final Insets insets = new Insets(5, 5, 5, 5);

        final Component gameHeading = new StyledHeading("This game");
        final Component gameHighestTileValueLabel =
                new StyledLabel("Highest value");
        final Component gameHighestTileValueField =
                new StyledNumberField(String.format(numberFormat, 0));
        final Component numMovesLabel = new StyledLabel("Number of moves");
        final Component numMovesField =
                new StyledNumberField(String.format(numberFormat, 0));
        final Component allTimeHeading = new StyledHeading("All time");
        final Component allTimeHighestTileValueLabel =
                new StyledLabel("Highest value");
        final Component allTimeHighestTileValueField =
                new StyledNumberField(String.format(numberFormat, 0));

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
