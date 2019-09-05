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

    @Override
    public SearchUserInfoResponse searchByNameFuzzily(SearchUserInfoRequest request) {
        return userInfoService.searchByNameFuzzily(request);
    }

    @Override
    public UserInfoView get(Integer id) {
        return userInfoService.get(id);
    }

    @Override
    public void update(Integer id, UpdateUserInfoRequest request) {
        userInfoService.update(id, request);
    }

    @Override
    public void delete(Integer id) {
        userInfoService.delete(id);
    }
}
