package app;

import app.domain.Address;
import core.framework.module.App;
import core.framework.module.SystemModule;
import core.framework.mongo.module.MongoConfig;

/**
 * @author steve
 */
public class MongoServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        String uri = requiredProperty("sys.mongo.uri");
        MongoConfig config = config(MongoConfig.class);
        config.uri(uri);
        config.collection(Address.class);
        load(new AddressModule());
    }
}