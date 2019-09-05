package app;

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
        bind(AddressWebServiceImpl.class);
    }
}
