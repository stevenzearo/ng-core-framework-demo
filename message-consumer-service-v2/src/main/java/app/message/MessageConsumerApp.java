package app.message;

import app.message.api.TestMessage;
import app.message.handler.TestMessageHandler;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class MessageConsumerApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        kafka().uri(requiredProperty("sys.kafka.uri"));
        kafka().groupId("group1");
        kafka().subscribe("topic1", TestMessage.class, bind(TestMessageHandler.class));
    }
}
