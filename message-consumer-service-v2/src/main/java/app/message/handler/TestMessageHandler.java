package app.message.handler;

import app.message.api.TestMessage;
import core.framework.kafka.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class TestMessageHandler implements MessageHandler<TestMessage> {
    private final Logger logger = LoggerFactory.getLogger(TestMessageHandler.class);

    @Override
    public void handle(String key, TestMessage value) {
        logger.info("v2 received:" + value.key);
    }
}
