package app.mongotest.api.address;

import core.framework.api.json.Property;
import core.framework.api.validate.Max;
import core.framework.api.validate.Min;

/**
 * @author steve
 */
public class SearchAddressRequest {
    @Property(name = "skip")
    @Min(0)
    public Integer skip;

    @Property(name = "limit")
    @Max(1000)
    public Integer limit;

    @Property(name = "province_name")
    public String provinceName;

    @Property(name = "city_name")
    public String cityName;

    @Property(name = "zone_name")
    public String zoneName;
}
