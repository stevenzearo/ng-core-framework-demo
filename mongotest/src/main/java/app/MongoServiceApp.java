package app;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class MongoServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));

    }
}
