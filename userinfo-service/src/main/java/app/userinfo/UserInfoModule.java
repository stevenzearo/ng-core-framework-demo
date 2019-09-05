package app.userinfo;

import app.userinfo.api.UserInfoWebService;
import app.userinfo.api.userinfo.CreateUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoResponse;
import app.userinfo.api.userinfo.UpdateUserInfoRequest;
import app.userinfo.api.userinfo.UserInfoView;
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
        http().bean(CreateUserInfoRequest.class);
        http().bean(UpdateUserInfoRequest.class);
        http().bean(SearchUserInfoRequest.class);
        http().bean(SearchUserInfoResponse.class);
        http().bean(UserInfoView.class);
        bind(UserInfoService.class);
        api().service(UserInfoWebService.class, bind(UserInfoWebServiceImpl.class));
    }
}
