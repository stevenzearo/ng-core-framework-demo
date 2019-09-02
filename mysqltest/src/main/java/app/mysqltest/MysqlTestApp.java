package app.mysqltest;

import app.mysqltest.domain.UserInfo;
import app.mysqltest.module.UserInfoModule;
import app.mysqltest.service.UserInfoService;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class MysqlTestApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new UserInfoModule());
        onStartup(() -> {
            UserInfoService userInfoService = bean(UserInfoService.class);
//            System.out.println(userInfoService.getUserInfoById(1));
            userInfoService.getUserInfoListByName("%s%").forEach(System.out::println);
        });
    }
}
