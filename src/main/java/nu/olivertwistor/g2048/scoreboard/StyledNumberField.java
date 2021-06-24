package nu.olivertwistor.g2048.scoreboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class StyledNumberField extends StyledLabel
{
    private static final Logger LOG = LogManager.getLogger();

    StyledNumberField(final String text)
    {
        super(text);

        LOG.trace("Created a new styled number field.");
    }
}
