package app.message;

import app.message.api.TestMessage;
import app.message.handler.TestMessageHandler;
import core.framework.module.Module;

/**
 * @author steve
 */
public class MessageConsumerModule extends Module {
    @Override
    protected void initialize() {
        /*TestMessageHandler messageHandler = bean(TestMessageHandler.class);
        TestMessage testMessage = new TestMessage();
        messageHandler.handle("message1", testMessage);*/
    }
}
