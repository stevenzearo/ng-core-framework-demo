package app.userinfo;

import core.framework.test.module.AbstractTestModule;

/**
 * @author steve
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new UserInfoApp());
        initDB().createSchema();
    }
}
