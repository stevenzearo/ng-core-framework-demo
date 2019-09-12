package app.service;

import app.MongoServiceApp;
import core.framework.mongo.module.MongoConfig;
import core.framework.test.module.AbstractTestModule;

/**
 * @author steve
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new MongoServiceApp());

    }
}
