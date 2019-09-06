package app.mongotest.api.address;

import core.framework.api.json.Property;

/**
 * @author steve
 */
public class ReplaceAddressRequest {
    @Property(name = "province_name")
    public String provinceName;

    @Property(name = "city_name")
    public String cityName;

    @Property(name = "zone_name")
    public String zoneName;
}
