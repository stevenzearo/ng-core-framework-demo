package app.web.province;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author steve
 */
public class CreateAddressRequest {
    @NotNull
    @NotBlank
    @Property(name = "province_name")
    public String provinceName;

    @NotNull
    @NotBlank
    @Property(name = "city_name")
    public String cityName;

    @NotNull
    @NotBlank
    @Property(name = "zone_name")
    public String zoneName;
}
