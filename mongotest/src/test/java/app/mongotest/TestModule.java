package app.mongotest;

import app.MongoServiceApp;
import core.framework.mongo.module.MongoConfig;
import core.framework.mongo.module.TestMongoConfig;
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
