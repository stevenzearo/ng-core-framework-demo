package app.userinfo.service;

import app.userinfo.api.userinfo.CreateUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoResponse;
import app.userinfo.api.userinfo.UpdateUserInfoRequest;
import app.userinfo.api.userinfo.UserInfoView;
import app.userinfo.domain.UserInfo;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;

import java.util.stream.Collectors;

/**
 * @author steve
 */
public class UserInfoService {
    @Inject
    Repository<UserInfo> repository;

    public UserInfoView create(CreateUserInfoRequest request) {
        return null;
    }

    public SearchUserInfoResponse searchUserInfoByNameFuzzily(SearchUserInfoRequest request) {

        SearchUserInfoResponse response = new SearchUserInfoResponse();
        Query<UserInfo> query = repository.select();
        query.skip(request.skip);
        query.limit(request.limit);
        if (!Strings.isBlank(request.name)) {
            query.where("`name` LIKE ?", Strings.format("%{}%", request.name));
        }
        response.userInfoViewList = query.fetch().stream().map(this::view).collect(Collectors.toList());
        response.total = query.count();
        return response;
    }

    public UserInfoView getUserInfoById(Integer id) {
        return view(repository.get(id).orElseThrow(() -> new NotFoundException("userInfo not found, id = " + id)));
    }

    public UserInfoView updateUserInfo(Integer id, UpdateUserInfoRequest request) {
        UserInfo userInfo = repository.get(id).orElseThrow(() -> new NotFoundException("userInfo not found, id = " + id));
        userInfo.name = request.name;
        userInfo.password = request.password;
        userInfo.birthday = request.birthday;
        userInfo.img = request.img;
        return view(userInfo);
    }

    public UserInfoView deleteUserInfo(Integer id) {
        UserInfo userInfo = repository.get(id).orElseThrow(() -> new NotFoundException("userInfo not found, id = " + id));
        repository.delete(id);
        return view(userInfo);
    }

    private UserInfoView view(UserInfo userInfo) {
        UserInfoView userInfoView = new UserInfoView();
        userInfoView.id = userInfo.id;
        userInfoView.name = userInfo.name;
        userInfoView.password = userInfo.password;
        userInfoView.birthday = userInfo.birthday;
        userInfoView.img = userInfo.img;
        return userInfoView;
    }
}
