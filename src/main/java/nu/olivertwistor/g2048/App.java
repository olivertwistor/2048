package nu.olivertwistor.g2048;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NonNls;

import javax.swing.SwingUtilities;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

/**
 * The starting point for this application. Creates a GUI and shows it.
 *
 * @since //todo correct version
 */
final class App
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    private static final ResourceBundle i18n =
            ResourceBundle.getBundle("app"); //NON-NLS

    /**
     *
     * @param args
     * @throws InterruptedException
     * @throws InvocationTargetException
     */
    public static void main(final String[] args)
            throws InterruptedException, InvocationTargetException
    {
        SwingUtilities.invokeAndWait(App::createAndShowGUI);

        LOG.info("Started the app.");
    }

    private static void createAndShowGUI()
    {
        final GUI gui = new GUI(i18n.getString("gui.title"));
        gui.attachMainMenuBar();
        gui.setVisible(true);
    }
}
