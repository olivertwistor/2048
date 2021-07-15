package nu.olivertwistor.game2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ColourPicker
{
    private static final Logger LOG = LogManager.getLogger();

    private final Map<Integer, Color> tileValueColours;
    private final Set<Color> usedColours;
    private final Random randomiser;

    public ColourPicker()
    {
        this.tileValueColours = new HashMap<>();
        this.usedColours = new HashSet<>();
        this.randomiser = new Random(System.currentTimeMillis());

        // Add white as the colour of tiles without a value (value: 0).
        this.tileValueColours.put(0, Color.WHITE);
        this.usedColours.add(Color.WHITE);
    }

    public Color getRandomColor()
    {
        final int brightener = 150;
        final int leftTo255 = 255 - brightener;

        while (true)
        {
            final int red = brightener + this.randomiser.nextInt(leftTo255);
            final int green = brightener + this.randomiser.nextInt(leftTo255);
            final int blue = brightener + this.randomiser.nextInt(leftTo255);

            final Color randomColor = new Color(red, green, blue);
            if (this.usedColours.add(randomColor))
            {
                LOG.debug("Added {} to the colour picker.", randomColor);
                return randomColor;
            }
        }
    }

    public Color getAppropriateTileColour(final int value)
    {
        if (!this.tileValueColours.containsKey(value))
        {
            this.tileValueColours.put(value, this.getRandomColor());
        }

        return this.tileValueColours.get(value);
    }

    int getNumberOfUsedColours()
    {
        return this.usedColours.size();
    }
}
