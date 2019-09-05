package app.message.service;

import app.message.api.TestMessage;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;

import java.util.UUID;

/**
 * @author steve
 */
public class MessagePublisherService {
    @Inject
    MessagePublisher<TestMessage> messagePublisher;

    public void publishMessage() {
        for (int i = 0; i < 10; i++) {
            TestMessage testMessage = new TestMessage();
            testMessage.key= String.valueOf(i);
            messagePublisher.publish(testMessage);
        }
    }
}
