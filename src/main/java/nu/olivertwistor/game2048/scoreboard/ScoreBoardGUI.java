package nu.olivertwistor.game2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public final class ScoreBoardGUI extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();

    public ScoreBoardGUI(final ScoreBoard scoreBoard)
    {
        super(new GridLayout());

        final DescriptionLabel gameNumMovesLabel =
                new DescriptionLabel("Number of moves");
        final ValueLabel gameNumMovesValue = new ValueLabel(
                String.valueOf(scoreBoard.getGameNumMoves()));
        gameNumMovesLabel.setLabelFor(gameNumMovesValue);

        //todo remove when scoreboard fully works
        gameNumMovesValue.setText("not implemented");

        final DescriptionLabel gameLargestTileLabel =
                new DescriptionLabel("Largest tile");
        final ValueLabel gameLargestTileValue = new ValueLabel(
                String.valueOf(scoreBoard.getGameLargestTile()));
        gameLargestTileLabel.setLabelFor(gameLargestTileValue);

        //todo remove when scoreboard fully works
        gameLargestTileValue.setText("not implemented");

        final DescriptionLabel totalLowestNumMovesLabel =
                new DescriptionLabel("Number of moves");
        final ValueLabel totalLowestNumMovesValue = new ValueLabel(
                String.valueOf(scoreBoard.getTotalLowestNumMoves()));
        totalLowestNumMovesLabel.setLabelFor(totalLowestNumMovesValue);

        //todo remove when scoreboard fully works
        totalLowestNumMovesValue.setText("not implemented");

        final DescriptionLabel totalLargestTileLabel =
                new DescriptionLabel("Largest tile");
        final ValueLabel totalLargestTileValue = new ValueLabel(
                String.valueOf(scoreBoard.getTotalLargestTile()));
        totalLargestTileLabel.setLabelFor(totalLargestTileValue);

        //todo remove when scoreboard fully works
        totalLargestTileValue.setText("not implemented");

        final JPanel gameNumMovesPanel = new JPanel(new BorderLayout());
        gameNumMovesPanel.add(gameNumMovesLabel, BorderLayout.PAGE_START);
        gameNumMovesPanel.add(gameNumMovesValue, BorderLayout.CENTER);

        final JPanel gameLargestTilePanel = new JPanel(new BorderLayout());
        gameLargestTilePanel.add(gameLargestTileLabel, BorderLayout.PAGE_START);
        gameLargestTilePanel.add(gameLargestTileValue, BorderLayout.CENTER);

        final JPanel gamePanel = new JPanel(new GridLayout());
        gamePanel.setBorder(BorderFactory.createTitledBorder("This game"));
        gamePanel.add(gameNumMovesPanel);
        gamePanel.add(gameLargestTilePanel);

        final JPanel totalLowestNumMovesPanel = new JPanel(new BorderLayout());
        totalLowestNumMovesPanel.add(
                totalLowestNumMovesLabel, BorderLayout.PAGE_START);
        totalLowestNumMovesPanel.add(
                totalLowestNumMovesValue, BorderLayout.CENTER);

        final JPanel totalLargestTilePanel = new JPanel(new BorderLayout());
        totalLargestTilePanel.add(
                totalLargestTileLabel, BorderLayout.PAGE_START);
        totalLargestTilePanel.add(
                totalLargestTileValue, BorderLayout.CENTER);

        final JPanel totalPanel = new JPanel(new GridLayout());
        totalPanel.setBorder(BorderFactory.createTitledBorder("All time"));
        totalPanel.add(totalLowestNumMovesPanel);
        totalPanel.add(totalLargestTilePanel);

        this.add(gamePanel);
        this.add(totalPanel);
    }

    private static final class DescriptionLabel extends JLabel
    {
        DescriptionLabel(final String text)
        {
            super(text, SwingConstants.CENTER);

            final Map<TextAttribute, Object> labelFontAttributes =
                    new HashMap<>();
            labelFontAttributes.put(TextAttribute.FOREGROUND, Color.BLACK);
            labelFontAttributes.put(TextAttribute.SIZE, 12);
            this.setFont(this.getFont().deriveFont(labelFontAttributes));
        }
    }

    private static final class ValueLabel extends JLabel
    {
        ValueLabel(final String text)
        {
            super(text, SwingConstants.CENTER);

            final Map<TextAttribute, Object> valueFontAttributes =
                    new HashMap<>();
            valueFontAttributes.put(TextAttribute.FOREGROUND, Color.BLACK);
            //valueFontAttributes.put(TextAttribute.SIZE, 24);
            valueFontAttributes.put(TextAttribute.SIZE, 12); //todo remove when score fully works
            this.setFont(this.getFont().deriveFont(valueFontAttributes));
        }
    }
}
