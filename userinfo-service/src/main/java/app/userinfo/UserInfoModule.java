package app.userinfo;

import app.userinfo.api.UserInfoWebService;
import app.userinfo.domain.UserInfo;
import app.userinfo.service.UserInfoService;
import app.userinfo.web.UserInfoWebServiceImpl;
import core.framework.module.Module;

/**
 * @author steve
 */
public class UserInfoModule extends Module {
    @Override
    protected void initialize() {
        db().repository(UserInfo.class);
        bind(UserInfoService.class);
        api().service(UserInfoWebService.class, bind(UserInfoWebServiceImpl.class));
    }
}
