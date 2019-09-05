package app.async.service;

import app.async.task.AsyncDelayTask;
import app.async.task.AsyncTask;
import core.framework.async.Executor;
import core.framework.inject.Inject;
import core.framework.inject.Named;

import java.time.Duration;

/**
 * @author steve
 */
public class AsyncService {
    @Inject
    @Named("executor")
    Executor executor;

    AsyncTask asyncTask1 = new AsyncTask();

    AsyncTask asyncTask2 = new AsyncTask();

    AsyncDelayTask asyncDelayTask = new AsyncDelayTask();

    public void executeTask() throws Exception {
        executor.submit("async", asyncTask1);
        executor.submit("async", asyncTask2);
        executor.submit("async", asyncDelayTask, Duration.ofSeconds(5));
    }
}
