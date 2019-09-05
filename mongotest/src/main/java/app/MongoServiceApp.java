package app;

import app.domain.Address;
import core.framework.module.App;
import core.framework.module.SystemModule;
import core.framework.mongo.module.MongoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class MongoServiceApp extends App {
    private final Logger logger = LoggerFactory.getLogger(MongoServiceApp.class);

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
