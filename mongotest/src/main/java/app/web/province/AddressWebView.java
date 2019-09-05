package app.web.province;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import org.bson.types.ObjectId;

/**
 * @author steve
 */
public class AddressWebView {
    @NotNull
    @NotBlank
    @Property(name = "id")
    public String id;

    @Property(name = "province_id")
    public String provinceId;

    @Property(name = "province_name")
    public String provinceName;


    @Property(name = "city_id")
    public String cityId;

    @Property(name = "city_name")
    public String cityName;

    @Property(name = "zone_id")
    public ObjectId zoneId;

    @Property(name = "zone_name")
    public String zoneName;
}
