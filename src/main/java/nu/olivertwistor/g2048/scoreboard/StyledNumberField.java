package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;

class StyledNumberField extends StyledLabel
{
    @NonNls
    private static final Logger LOG = LogManager.getLogger();

    StyledNumberField(final @Nls String text)
    {
        super(text);

        LOG.trace("Created a new styled number field.");
    }
}
