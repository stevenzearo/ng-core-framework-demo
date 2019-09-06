package app.mongotest.api.address;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author steve
 */
public class SearchAddressResponse {
    @Property(name = "total")
    public Long total = 0L;

    @Property(name = "address_list")
    public List<AddressWebView> addressList;
}
