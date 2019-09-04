package app.async.task;

import core.framework.async.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class AsyncTask implements Task {
    public String message = "";

    private final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Override
    public void execute() throws Exception {
        logger.warn("AsyncExecutor " + message);
    }
}
