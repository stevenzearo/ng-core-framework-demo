package app;

import app.service.AddressService;
import app.web.AddressWebServiceImpl;
import app.web.province.CreateAddressRequest;
import app.web.province.SearchAddressRequest;
import core.framework.module.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class AddressModule extends Module {
    private final Logger logger = LoggerFactory.getLogger(AddressModule.class);

    @Override
    protected void initialize() {
        bind(AddressService.class);
        AddressWebServiceImpl webService = bind(AddressWebServiceImpl.class);
        onStartup(() -> {
            CreateAddressRequest createAddressRequest = new CreateAddressRequest();
            createAddressRequest.provinceName = "fujian";
            createAddressRequest.cityName = "xiamen";
            createAddressRequest.zoneName = "jimei";
//            webService.create(createAddressRequest);
//            logger.warn("create successfully");
            SearchAddressRequest searchAddressRequest = new SearchAddressRequest();
            searchAddressRequest.cityName = "xiamen";
            webService.search(searchAddressRequest);
        });
    }
}
