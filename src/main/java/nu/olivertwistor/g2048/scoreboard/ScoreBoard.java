package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public final class ScoreBoard extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();

    private JLabel gameHighestTileValueField;
    private JLabel allTimeHighestTileValueField;
    private JLabel numMovesField;

    public ScoreBoard()
    {
        super(new GridBagLayout());
        final GridBagConstraints constraints = new GridBagConstraints();

        final String numberFormat = "%5d";
        final Insets insets = new Insets(5, 5, 5, 5);

        final JLabel gameHeading = new StyledHeading("This game");
        final JLabel gameHighestTileValueLabel =
                new StyledLabel("Highest value");
        this.gameHighestTileValueField =
                new StyledNumberField(String.format(numberFormat, 0));
        final JLabel numMovesLabel = new StyledLabel("Number of moves");
        this.numMovesField =
                new StyledNumberField(String.format(numberFormat, 0));
        final JLabel allTimeHeading = new StyledHeading("All time");
        final JLabel allTimeHighestTileValueLabel =
                new StyledLabel("Highest value");
        this.allTimeHighestTileValueField =
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
    }
}
