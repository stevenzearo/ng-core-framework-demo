package app.message.handler;

import app.message.api.TestMessage;
import core.framework.kafka.MessageHandler;

/**
 * @author steve
 */
public class TestMessageHandler implements MessageHandler<TestMessage> {
    @Override
    public void handle(String key, TestMessage value) {
        value.sendMessage(key + ": hello, world!");
    }
}
