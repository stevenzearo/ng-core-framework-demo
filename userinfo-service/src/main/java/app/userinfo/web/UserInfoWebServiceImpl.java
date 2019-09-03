package app.userinfo.web;

import app.userinfo.api.UserInfoWebService;
import app.userinfo.api.userinfo.CreateUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoResponse;
import app.userinfo.api.userinfo.UpdateUserInfoRequest;
import app.userinfo.api.userinfo.UserInfoView;
import app.userinfo.service.UserInfoService;
import core.framework.inject.Inject;

/**
 * @author steve
 */
public class UserInfoWebServiceImpl implements UserInfoWebService {
    @Inject
    UserInfoService userInfoService;

    @Override
    public UserInfoView create(CreateUserInfoRequest request) {
        return userInfoService.create(request);
    }

    public SearchUserInfoResponse searchUserInfoByNameFuzzily(SearchUserInfoRequest request) {
        return userInfoService.searchUserInfoByNameFuzzily(request);
    }

    @Override
    public UserInfoView getUserInfoById(Integer id) {
        return userInfoService.getUserInfoById(id);
    }

    @Override
    public UserInfoView updateUserInfo(Integer id, UpdateUserInfoRequest request) {
        return userInfoService.updateUserInfo(id, request);
    }

    @Override
    public UserInfoView deleteUserInfo(Integer id) {
        return userInfoService.deleteUserInfo(id);
    }
}
