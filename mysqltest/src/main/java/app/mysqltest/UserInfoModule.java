package app.mysqltest;

import app.mysqltest.domain.UserInfo;
import app.mysqltest.service.UserInfoService;
import core.framework.module.Module;

/**
 * @author steve
 */
public class UserInfoModule extends Module {
    @Override
    protected void initialize() {
        db().repository(UserInfo.class);
        bind(UserInfoService.class);
    }
}
