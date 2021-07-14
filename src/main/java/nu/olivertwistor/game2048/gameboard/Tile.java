package nu.olivertwistor.game2048.gameboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class Tile implements Serializable
{
    public static final int LOWEST_VALUE = 2;

    private static final Logger LOG = LogManager.getLogger();

    private final int x;
    private final int y;
    private int value;

    public Tile(final int x, final int y, final int value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public Tile(final int x, final int y)
    {
        this(x, y, 0);
    }

    public int getValue()
    {
        return this.value;
    }

    public void setValue(final int value)
    {
        this.value = value;
    }
}
