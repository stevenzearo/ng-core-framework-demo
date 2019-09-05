package app.scheduler.job;

import app.scheduler.task.AsyncDelayTask;
import app.scheduler.task.AsyncTask;
import core.framework.async.Executor;
import core.framework.inject.Inject;
import core.framework.inject.Named;
import core.framework.scheduler.Job;

import java.time.Duration;

/**
 * @author steve
 */
public class SchedulerJob implements Job {
    @Inject
    @Named("executor")
    Executor executor;

    AsyncTask asyncTask1 = new AsyncTask();

    AsyncTask asyncTask2 = new AsyncTask();

    AsyncDelayTask asyncDelayTask = new AsyncDelayTask();

    @Override
    public void execute() throws Exception {
        executor.submit("async", asyncTask1);
        executor.submit("async", asyncTask2);
        executor.submit("async", asyncDelayTask, Duration.ofSeconds(20));
    }
}
