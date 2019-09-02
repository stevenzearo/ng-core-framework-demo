package app.mysqltest.service;

import app.mysqltest.domain.UserInfo;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.internal.db.QueryImpl;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * @author steve
 */
public class UserInfoService {
    @Inject
    private Repository<UserInfo> userInfoRepository;

    public boolean addUserInfo() {
        UserInfo userInfo = new UserInfo();
        OptionalLong insert = userInfoRepository.insert(userInfo);
        return insert.isEmpty();
    }

    public boolean updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        Optional<UserInfo> userInfo1 = userInfoRepository.get(userInfo.userId);
        try {
            UserInfo userInfo2 = userInfo1.orElseThrow(() -> new NotFoundException("userInfo not found, userInfo = " + userInfo.userId));
            userInfo2.userName = "";
            userInfo2.userPwd = "";
            userInfo2.userPhone = "";
            userInfo2.userBirthday = LocalDate.now();
            userInfoRepository.partialUpdate(userInfo);

        } catch (NotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean deleteUserInfo(Integer userId) {
        try {
            userInfoRepository.get(userId).orElseThrow(() -> new NotFoundException("userInfo not found, where userId = " + userId));
        } catch (NotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public UserInfo getUserInfoById(Integer userId) {
        return userInfoRepository.get(userId).orElseThrow(() -> new NotFoundException("userInfo not found, where userId = " + userId));
    }

    public List<UserInfo> getUserInfoListByName(String name) {
        return userInfoRepository.select("user_name LIKE ?", name);
    }

}
