package app.async;

import app.async.service.AsyncService;
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
        AsyncService asyncService = bind(new AsyncService());
        onStartup(() -> {
            context.logManager.begin("async");
            asyncService.executeTask();
            context.logManager.end("async");
        });
    }
}
