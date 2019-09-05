package app.service;

import app.domain.Province;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.mongo.module.MongoConfig;
import core.framework.web.exception.NotFoundException;

import java.util.Optional;
import java.util.UUID;

/**
 * @author steve
 */
public class ProvinceService {

    @Inject
    MongoCollection<Province> mongoCollection;

    public Province getProvinceById(String provinceId) {
        try {
            return mongoCollection.get(provinceId)
                .orElseThrow(() -> new NotFoundException("province not found, provinceId = " + provinceId));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addProvince() {
        Province province = new Province();
        province.id = "sss";
        province.name = "oho";
        try {
            mongoCollection.insert(province);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
