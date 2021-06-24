package nu.olivertwistor.g2048;

import nu.olivertwistor.g2048.gameboard.GameBoard;
import nu.olivertwistor.g2048.scoreboard.ScoreBoard;
import nu.olivertwistor.g2048.gameboard.TileMovementPane;
import nu.olivertwistor.g2048.gameboard.actions.MoveDownAction;
import nu.olivertwistor.g2048.gameboard.actions.MoveLeftAction;
import nu.olivertwistor.g2048.gameboard.actions.MoveRightAction;
import nu.olivertwistor.g2048.gameboard.actions.MoveUpAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;

import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ResourceBundle;

/**
 * The GUI class is the topmost class responsible for handling the GUI. It
 * creates a JFrame and all the components required for the GUI.
 *
 * @since //TODO correct version
 */
final class GUI extends JFrame
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final ResourceBundle i18n =
            ResourceBundle.getBundle("app"); //NON-NLS

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /**
     * Creates a new GUI object (a JFrame), with a title and a size. Sets the
     * close behaviour to exit the app. Creates and places all GUI components.
     *
     * @param title which title the GUI shows in its title bar
     *
     * @since //TODO correct version
     */
    GUI(@Nls final String title)
    {
        super(title);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        LOG.info("Created a GUI of size {}x{}.", WIDTH, HEIGHT);

        final Component scoreBoard = new ScoreBoard();
        final TileMovementPane tileMovementPane = new TileMovementPane();

        final Component enableAICheckBox =
                new JCheckBox(i18n.getString("gui.checkbox.ai-play"));

        final Container settingsPane = new JPanel(new BorderLayout());
        settingsPane.add(enableAICheckBox, BorderLayout.CENTER);

        final Container gameControlPane = new JPanel(new BorderLayout());
        gameControlPane.add(scoreBoard, BorderLayout.PAGE_START);
        gameControlPane.add(settingsPane, BorderLayout.CENTER);
        gameControlPane.add(tileMovementPane, BorderLayout.PAGE_END);

        final Component gameBoard = new GameBoard();

        final Container contentPane = new JPanel(new BorderLayout());
        contentPane.add(gameBoard, BorderLayout.CENTER);
        contentPane.add(gameControlPane, BorderLayout.LINE_END);

        this.setContentPane(contentPane);

        final Action moveRightAction = new MoveRightAction();
        final Action moveUpAction = new MoveUpAction();
        final Action moveLeftAction = new MoveLeftAction();
        final Action moveDownAction = new MoveDownAction();

        tileMovementPane.registerActions(
                moveRightAction,
                moveUpAction,
                moveLeftAction,
                moveDownAction);
    }

    /**
     * Creates an instance of {@link MainMenuBar} and sets it as the JMenuBar
     * of this GUI.
     *
     * @since //todo correct version
     */
    void attachMainMenuBar()
    {
        final JMenuBar menuBar = new MainMenuBar();
        this.setJMenuBar(menuBar);

        LOG.debug("Attached a menu bar.");
    }
}
