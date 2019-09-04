package app.async;

import app.async.service.AsyncService;
import app.async.task.AsyncDelayTask;
import app.async.task.AsyncTask;
import core.framework.module.ExecutorConfig;
import core.framework.module.Module;

/**
 * @author steve
 */
public class AsyncModule extends Module {
    @Override
    protected void initialize() {
        ExecutorConfig executorConfig = executor();
        executorConfig.add("executor", 5);
        bind(AsyncTask.class, "asyncTask1", new AsyncTask());
        bind(AsyncTask.class, "asyncTask2", new AsyncTask());
        bind(AsyncDelayTask.class, "asyncDelayTask", new AsyncDelayTask());
        AsyncService asyncService = bind(new AsyncService());
        onStartup(() -> {
            context.logManager.begin("async");
            asyncService.executeTask();
            context.logManager.end("async");
        });
    }
}
