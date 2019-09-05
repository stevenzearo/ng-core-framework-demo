package app;

import app.domain.Province;
import app.service.ProvinceService;
import core.framework.module.Module;
import core.framework.mongo.module.MongoConfig;

/**
 * @author steve
 */
public class ProvinceModule extends Module {
    @Override
    protected void initialize() {
        MongoConfig mongoConfig = config(MongoConfig.class);
        mongoConfig.collection(Province.class);
        bind(ProvinceService.class);
    }
}
