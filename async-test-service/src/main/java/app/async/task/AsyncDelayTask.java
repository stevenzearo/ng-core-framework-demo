package app.async.task;

import core.framework.async.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class AsyncDelayTask implements Task {
    public String message = "";

    private final Logger logger = LoggerFactory.getLogger(AsyncDelayTask.class);

    @Override
    public void execute() throws Exception {
        logger.warn("delay async task " + message);
    }
}
