package app.scheduler.job;

import app.scheduler.task.AsyncDelayTask;
import app.scheduler.task.AsyncTask;
import core.framework.async.Executor;
import core.framework.inject.Inject;
import core.framework.inject.Named;
import core.framework.scheduler.Job;

/**
 * @author steve
 */
public class SchedulerJob implements Job {
    @Inject
    @Named("executor")
    Executor executor;

    @Inject
    @Named("asyncTask1")
    AsyncTask asyncTask1;

    @Inject
    @Named("asyncTask2")
    AsyncTask asyncTask2;

    @Inject
    @Named("asyncDelayTask")
    AsyncDelayTask asyncDelayTask;

    @Override
    public void execute() throws Exception {
        executor.submit("async", () -> {
            asyncTask1.execute();
            asyncTask2.execute();
            asyncDelayTask.execute();
        });
    }
}
