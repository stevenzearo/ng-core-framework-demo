package app.message;

import app.message.service.MessagePublisherService;
import core.framework.module.Module;

/**
 * @author steve
 */
public class MessagePublisherModule extends Module {
    @Override
    protected void initialize() {
        MessagePublisherService messagePublisherService = bind(MessagePublisherService.class);
        onStartup(messagePublisherService::publishMessage);
    }
}
