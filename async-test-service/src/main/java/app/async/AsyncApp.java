package app.async;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class AsyncApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new AsyncModule());
    }
}
