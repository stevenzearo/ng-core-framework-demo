package app.web;

import app.mongotest.api.AddressWebService;
import app.mongotest.api.address.AddressWebView;
import app.mongotest.api.address.CreateAddressRequest;
import app.mongotest.api.address.ReplaceAddressRequest;
import app.mongotest.api.address.SearchAddressRequest;
import app.mongotest.api.address.SearchAddressResponse;
import app.mongotest.api.address.UpdateAddressRequest;
import app.service.AddressService;
import core.framework.inject.Inject;

/**
 * @author steve
 */
public class AddressWebServiceImpl implements AddressWebService {
    @Inject
    AddressService addressService;

    @Override
    public void create(CreateAddressRequest request) {
        addressService.create(request);
    }

    @Override
    public void update(String id, UpdateAddressRequest request) {
        addressService.update(id, request);
    }

    @Override
    public void replace(String id, ReplaceAddressRequest request) {
        addressService.replace(id, request);
    }

    @Override
    public AddressWebView get(String id) {
        return addressService.get(id);
    }

    @Override
    public SearchAddressResponse search(SearchAddressRequest request) {
        return addressService.search(request);
    }

    @Override
    public void delete(String id) {
        addressService.delete(id);
    }
}
