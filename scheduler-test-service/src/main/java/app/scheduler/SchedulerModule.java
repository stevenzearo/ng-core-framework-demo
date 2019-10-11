package app.scheduler;

import app.scheduler.job.SchedulerJob;
import app.scheduler.task.AsyncDelayTask;
import app.scheduler.task.AsyncTask;
import app.scheduler.trigger.TestTrigger;
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
        SchedulerJob schedulerJob = bind(SchedulerJob.class);
        schedulerConfig.fixedRate("scheduler", schedulerJob, Duration.ofSeconds(3));

        TestTrigger testTrigger = new TestTrigger();
        schedulerConfig.trigger("trigger", schedulerJob, testTrigger);
    }
}
