package app.message.api;

import core.framework.api.json.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class TestMessage {
    @Property(name = "message")
    public String message;

    public void sendMessage(String message) {
        Logger logger = LoggerFactory.getLogger(TestMessage.class);
        logger.warn(message);
    }

}
