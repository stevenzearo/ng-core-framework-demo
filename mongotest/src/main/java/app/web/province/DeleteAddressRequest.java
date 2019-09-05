package app.web.province;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author steve
 */
public class DeleteAddressRequest {
    @NotNull
    @NotBlank
    @Property(name = "id")
    public String id;
}
