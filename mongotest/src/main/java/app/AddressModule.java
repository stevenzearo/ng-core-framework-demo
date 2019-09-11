package app;

import app.mongotest.api.AddressWebService;
import app.mongotest.api.address.AddressWebView;
import app.mongotest.api.address.SearchAddressResponse;
import app.service.AddressService;
import app.web.AddressWebServiceImpl;
import core.framework.module.Module;

/**
 * @author steve
 */
public class AddressModule extends Module {
    @Override
    protected void initialize() {
        bind(AddressService.class);
        http().bean(AddressWebView.class);
        http().bean(SearchAddressResponse.class);
        api().service(AddressWebService.class, bind(AddressWebServiceImpl.class));
    }
}
