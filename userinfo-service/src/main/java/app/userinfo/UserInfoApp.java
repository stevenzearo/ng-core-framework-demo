package app.userinfo;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class UserInfoApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new UserInfoModule());
    }
}
