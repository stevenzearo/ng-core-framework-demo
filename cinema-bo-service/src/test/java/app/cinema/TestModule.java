package app.cinema;

import core.framework.test.module.AbstractTestModule;

/**
 * @author steve
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new CinemaBOApp());
        initDB().createSchema();
    }
}
