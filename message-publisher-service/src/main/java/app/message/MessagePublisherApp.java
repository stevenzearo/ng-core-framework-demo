package app.message;

import app.message.api.TestMessage;
import core.framework.module.App;
import core.framework.module.KafkaConfig;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class MessagePublisherApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        KafkaConfig kafkaConfig = kafka();
        kafkaConfig.uri(requiredProperty("sys.kafka.URI"));
        kafkaConfig.groupId("group1");
        kafkaConfig.publish("topic1", TestMessage.class);
    }
}
