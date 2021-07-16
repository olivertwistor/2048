package nu.olivertwistor.game2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class HiScoresReaderWriter
{
    private static final Logger LOG = LogManager.getLogger();

    private static final String LOWEST_NUM_MOVES = "lowest.num.moves";
    private static final String LARGEST_TILE = "largest.tile";

    private final String filepath;
    private final Properties properties;

    public HiScoresReaderWriter(final String filepath)
    {
        this.filepath = filepath;
        this.properties = new Properties();

        try (final FileInputStream fileInputStream =
                     new FileInputStream(filepath))
        {
            this.properties.load(fileInputStream);
            LOG.info("Loaded hiscores file: {}", filepath);
        }
        catch (final FileNotFoundException e)
        {
            // If the file can't be found, let's create it.
            final File file = new File(filepath);
            final boolean createSuccess;
            try
            {
                createSuccess = file.createNewFile();

                if (createSuccess)
                {
                    LOG.info("Created new file: {}", file.getCanonicalPath());
                }
                else
                {
                    LOG.warn("Failed to create new file: {}", filepath);
                }
            }
            catch (IOException ioException)
            {
                LOG.error("Unable to create hiscores file.", e);
                return;
            }
        }
        catch (final IOException e)
        {
            LOG.error("Unable to read from hiscores file.", e);
        }
    }

    public int getLowestNumMoves()
    {
        return this.readInt(LOWEST_NUM_MOVES, 0);
    }

    public void setLowestNumMoves(final int lowestNumMoves) throws IOException
    {
        this.writeInt(LOWEST_NUM_MOVES, lowestNumMoves);
    }

    public int getLargestTile()
    {
        return this.readInt(LARGEST_TILE, 0);
    }

    public void setLargestTile(final int largestTile) throws IOException
    {
        this.writeInt(LARGEST_TILE, largestTile);
    }

    private int readInt(final String key, final int defaultValue)
    {
        final String raw = this.properties.getProperty(
                key, String.valueOf(defaultValue));
        LOG.debug("Read {} = {}", key, raw);

        return Integer.parseInt(raw);
    }

    private void writeInt(final String key, final int value) throws IOException
    {
        final String valueString = String.valueOf(value);
        this.properties.setProperty(key, valueString);

        try (final FileWriter fileWriter = new FileWriter(this.filepath))
        {
            this.properties.store(fileWriter, null);
            LOG.debug("Wrote {} = {}", key, value);
        }
    }
}
