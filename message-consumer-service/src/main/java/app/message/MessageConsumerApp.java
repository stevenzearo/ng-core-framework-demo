package app.message;

import app.message.api.TestMessage;
import app.message.handler.TestMessageHandler;
import core.framework.module.App;
import core.framework.module.KafkaConfig;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class MessageConsumerApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        KafkaConfig kafkaConfig = kafka();
        kafkaConfig.uri(requiredProperty("sys.kafka.URI"));
        kafkaConfig.subscribe("topic1", TestMessage.class, bind(TestMessageHandler.class));
        load(new MessageConsumerModule());
    }
}
