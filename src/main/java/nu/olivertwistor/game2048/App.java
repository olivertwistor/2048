package nu.olivertwistor.game2048;

import nu.olivertwistor.game2048.scoreboard.HiScoresReaderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class App
{
    private static final Logger LOG = LogManager.getLogger();

    public static void main(final String[] args)
            throws InterruptedException, InvocationTargetException
    {
        SwingUtilities.invokeAndWait(App::createAndShowGUI);
    }

    private static void createAndShowGUI()
    {
        final HiScoresReaderWriter hiScoresReaderWriter =
                new HiScoresReaderWriter("./hiscores.txt");
        final Game game = new Game(hiScoresReaderWriter);

        final GUI gui = new GUI("2048", game);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);

        //testing
        try
        {
            game.saveToHiScore();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
