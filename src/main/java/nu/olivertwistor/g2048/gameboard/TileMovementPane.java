package nu.olivertwistor.g2048.gameboard;

import nu.olivertwistor.g2048.GUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

public final class TileMovementPane extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();

    public TileMovementPane()
    {
        final JButton moveRightButton = new JButton("Right");
        final JButton moveUpButton = new JButton("Up");
        final JButton moveLeftButton = new JButton("Left");
        final JButton moveDownButton = new JButton("Down");

        final JPanel upDownPane = new JPanel(new GridLayout(2, 1));
        upDownPane.add(moveUpButton);
        upDownPane.add(moveDownButton);

        this.add(moveLeftButton);
        this.add(upDownPane);
        this.add(moveRightButton);

        LOG.debug("Created the tile movement pane.");
    }
}
