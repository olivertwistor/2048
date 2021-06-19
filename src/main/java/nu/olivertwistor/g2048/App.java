package nu.olivertwistor.g2048;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;

public final class App
{
    private static final Logger LOG = LogManager.getLogger();

    public static void main(final String[] args)
            throws InterruptedException, InvocationTargetException
    {
        SwingUtilities.invokeAndWait(App::createAndShowGUI);

        LOG.info("Started the app.");
    }

    private static void createAndShowGUI()
    {
        final GUI gui = new GUI("2048");
        gui.attachMainMenuBar();
        gui.setVisible(true);
    }
}
