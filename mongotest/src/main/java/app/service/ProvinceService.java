package app.service;

import app.domain.Province;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.web.exception.NotFoundException;

/**
 * @author steve
 */
public class ProvinceService {
    @Inject
    MongoCollection<Province> mongoCollection;

    public Province getProvinceById(String provinceId) {
        return mongoCollection.get(provinceId)
            .orElseThrow(() -> new NotFoundException("province not found, provinceId = " + provinceId));
    }

    public void addProvince() {
        Province province = new Province();
        province.id = "sss";
        province.name = "oho";
        mongoCollection.insert(province);
    }

}
