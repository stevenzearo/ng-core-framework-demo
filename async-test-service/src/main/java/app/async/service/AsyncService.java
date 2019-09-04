package app.async.service;

import app.async.task.AsyncDelayTask;
import app.async.task.AsyncTask;
import core.framework.async.Executor;
import core.framework.inject.Inject;
import core.framework.inject.Named;

/**
 * @author steve
 */
public class AsyncService {
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

    public void executeTask() throws Exception {

        System.out.println("hello, world!");
        executor.submit("async", () -> {
            try {
                asyncTask1.execute();
                asyncTask1.execute();
                asyncDelayTask.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("hello, world!");
    }
}
