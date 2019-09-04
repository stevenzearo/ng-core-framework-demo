package app.scheduler;

import app.scheduler.job.SchedulerJob;
import app.scheduler.task.AsyncDelayTask;
import app.scheduler.task.AsyncTask;
import core.framework.module.ExecutorConfig;
import core.framework.module.Module;
import core.framework.module.SchedulerConfig;

import java.time.Duration;

/**
 * @author steve
 */
public class SchedulerModule extends Module {
    @Override
    protected void initialize() {
        ExecutorConfig executorConfig = executor();
        executorConfig.add("executor", 5);

        bind(AsyncTask.class, "asyncTask1", new AsyncTask("asyncTask1"));
        bind(AsyncTask.class, "asyncTask2", new AsyncTask());
        bind(AsyncDelayTask.class, "asyncDelayTask", new AsyncDelayTask("asyncDelayTask"));

        SchedulerConfig schedulerConfig = schedule();
        schedulerConfig.fixedRate("scheduler", bind(SchedulerJob.class), Duration.ofSeconds(3));
    }
}
