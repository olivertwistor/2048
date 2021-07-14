package nu.olivertwistor.game2048.gameboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColourPickerTest
{
    @Test
    public void getRandomColour_1000times_gives_1000Colours()
    {
        final ColourPicker colourPicker = new ColourPicker();

        for (int i = 0; i < 1000; i++)
        {
            colourPicker.getRandomColor();
        }

        Assertions.assertEquals(1000, colourPicker.getNumberOfUsedColours());
    }
}
