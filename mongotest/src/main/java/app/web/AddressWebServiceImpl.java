package app.web;

import app.service.AddressService;
import app.web.province.AddressWebView;
import app.web.province.CreateAddressRequest;
import app.web.province.DeleteAddressRequest;
import app.web.province.GetAddressRequest;
import app.web.province.SearchAddressRequest;
import app.web.province.SearchAddressResponse;
import core.framework.inject.Inject;

/**
 * @author steve
 */
public class AddressWebServiceImpl {
    @Inject
    AddressService addressService;

    public void create(CreateAddressRequest request) {
        addressService.create(request);
    }

    public AddressWebView get(GetAddressRequest request) {
        return addressService.get(request);
    }

    public SearchAddressResponse search(SearchAddressRequest request) {
        return addressService.search(request);
    }

    public void delete(DeleteAddressRequest request) {
        addressService.delete(request);
    }
}
