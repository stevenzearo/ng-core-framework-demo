package app.mongotest.api.address;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

import java.util.List;

/**
 * @author steve
 */
public class SearchAddressResponse {
    @NotNull
    @Property(name = "total")
    public Long total = 0L;

    @Property(name = "address_list")
    public List<AddressWebView> addressList;
}
