package app.homework1;

import app.homework1.HomeworkServiceApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author steve
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new HomeworkServiceApp());
        initDB().createSchema();
    }
}
