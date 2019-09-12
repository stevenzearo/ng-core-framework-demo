package app.mongotest.service;

import app.mongotest.MongoTestIntegrationExtension;
import app.mongotest.api.address.AddressWebView;
import app.mongotest.api.address.CreateAddressRequest;
import app.mongotest.api.address.ReplaceAddressRequest;
import app.mongotest.api.address.SearchAddressRequest;
import app.mongotest.api.address.SearchAddressResponse;
import app.mongotest.api.address.UpdateAddressRequest;
import app.service.AddressService;
import core.framework.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author steve
 */
class AddressServiceTest extends MongoTestIntegrationExtension {
    @Inject
    AddressService service;

    String addressId;

    @BeforeEach
    void create() {
        CreateAddressRequest request = new CreateAddressRequest();
        request.provinceName = "oho";
        request.cityName = "rsa";
        request.zoneName = "zeera";
        addressId = service.create(request);
    }

    @Test
    void get() {
        AddressWebView addressWebView = service.get(addressId);
        assertThat(addressWebView.provinceName).isEqualTo("oho");
        assertThat(addressWebView.cityName).isEqualTo("rsa");
        assertThat(addressWebView.zoneName).isEqualTo("zeera");
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
        assertThat(search.addressList).size().isEqualByComparingTo(1);
    }

    @Test
    void update() {
        UpdateAddressRequest request = new UpdateAddressRequest();
        request.cityName = "newYork";
        request.provinceName = "bbb";
        request.zoneName = "sss";
        service.update(addressId, request);
        AddressWebView addressWebView = service.get(addressId);
        assertThat(addressWebView.provinceName).isEqualTo(request.provinceName);
        assertThat(addressWebView.cityName).isEqualTo(request.cityName);
        assertThat(addressWebView.zoneName).isEqualTo(request.zoneName);
    }

    @Test
    void replace() {
        ReplaceAddressRequest request = new ReplaceAddressRequest();
        request.cityName = "hello";
        request.provinceName = "world";
        request.zoneName = "steve";
        service.replace(addressId, request);
        AddressWebView addressWebView = service.get(addressId);
        assertThat(addressWebView.cityName).isEqualTo(request.cityName);
        assertThat(addressWebView.provinceName).isEqualTo(request.provinceName);
        assertThat(addressWebView.zoneName).isEqualTo(request.zoneName);

    }

    @AfterEach
    void delete() {
        service.delete(addressId);
    }
}