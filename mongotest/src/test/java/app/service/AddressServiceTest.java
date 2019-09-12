package app.service;

import app.mongotest.api.address.AddressWebView;
import app.mongotest.api.address.CreateAddressRequest;
import app.mongotest.api.address.ReplaceAddressRequest;
import app.mongotest.api.address.SearchAddressRequest;
import app.mongotest.api.address.SearchAddressResponse;
import app.mongotest.api.address.UpdateAddressRequest;
import core.framework.inject.Inject;
import core.framework.json.JSON;
import core.framework.test.Context;
import core.framework.test.IntegrationExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
@ExtendWith(IntegrationExtension.class)
@Context(module = TestModule.class)
class AddressServiceTest {
    private final Logger logger = LoggerFactory.getLogger(AddressServiceTest.class);

    @Inject
    AddressService service;

    @Test
    void create() {
        CreateAddressRequest request = new CreateAddressRequest();
        request.provinceName = "oho";
        request.cityName = "rsa";
        request.zoneName = "zeera";
        service.create(request);
    }

    @Test
    void get() {
        AddressWebView addressWebView = service.get("86a827cc-73f8-46a0-97c8-3f2da9a532df");
        logger.warn(JSON.toJSON(addressWebView));
    }

    @Test
    void search() {
        SearchAddressRequest searchAddressRequest = new SearchAddressRequest();
        searchAddressRequest.provinceName = "oho";
        searchAddressRequest.cityName = "rsa";
        searchAddressRequest.zoneName = "zeera";
        searchAddressRequest.limit = 5;
        searchAddressRequest.skip = 0;
        SearchAddressResponse search = service.search(searchAddressRequest);
        search.addressList.forEach(x -> logger.warn(JSON.toJSON(x)));
    }

    @Test
    void delete() {
        service.delete("86a827cc-73f8-46a0-97c8-3f2da9a532df");
    }

    @Test
    void update() {
        UpdateAddressRequest request = new UpdateAddressRequest();
        request.cityName = "newYork";
        request.provinceName = "bbb";
        request.zoneName = "sss";
        service.update("927ce102-c10c-4e27-8e8c-d810b251d3d1", request);
        AddressWebView addressWebView = service.get("927ce102-c10c-4e27-8e8c-d810b251d3d1");
        logger.warn(JSON.toJSON(addressWebView));
    }

    @Test
    void replace() {
        ReplaceAddressRequest request = new ReplaceAddressRequest();
        request.cityName = "hello";
        request.provinceName = "world";
        request.zoneName = "steve";
        service.replace("927ce102-c10c-4e27-8e8c-d810b251d3d1", request);
        AddressWebView addressWebView = service.get("927ce102-c10c-4e27-8e8c-d810b251d3d1");
        logger.warn(JSON.toJSON(addressWebView));
    }
}