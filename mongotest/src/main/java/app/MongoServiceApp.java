package app;

import app.domain.Province;
import app.service.ProvinceService;
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
        load(new ProvinceModule());
        onStartup(() -> {
            ProvinceService provinceService = bean(ProvinceService.class);
//            provinceService.addProvince();
            Province sss = provinceService.getProvinceById("sss");
            System.out.println(sss);
        });
    }
}
