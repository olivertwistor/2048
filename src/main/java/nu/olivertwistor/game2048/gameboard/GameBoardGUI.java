package nu.olivertwistor.game2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class GameBoardGUI extends JPanel
{
    private static final Logger LOG = LogManager.getLogger();

    public GameBoardGUI(final GameBoard gameBoard)
    {
        super(new GridLayout(GameBoard.NUM_TILES_X, GameBoard.NUM_TILES_Y));

        for (int column = 0; column < GameBoard.NUM_TILES_X; column++)
        {
            for (int row = 0; row < GameBoard.NUM_TILES_Y; row++)
            {
                final Tile tile = gameBoard.getTile(row, column);
                final TileGUI tileGUI = new TileGUI(tile);

                this.add(tileGUI);
            }
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(400, 400);
    }
}
