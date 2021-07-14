package nu.olivertwistor.game2048;

import nu.olivertwistor.game2048.gameboard.GameBoard;
import nu.olivertwistor.game2048.gameboard.GameBoardGUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GUI extends JFrame
{
    private static final Logger LOG = LogManager.getLogger();

    public GUI(final String title, final GameState gameState)
    {
        super(title);

        final GameBoard gameBoard = gameState.getGameBoard();
        final GameBoardGUI gameBoardGUI = new GameBoardGUI(gameBoard);

        final JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(gameBoardGUI, BorderLayout.CENTER);

        this.setContentPane(contentPane);
    }
}
