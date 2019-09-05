package app.mysqltest.service;

import app.mysqltest.domain.UserInfo;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author steve
 */
public class UserInfoService {
    @Inject
    private Repository<UserInfo> userInfoRepository;

    public Integer addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfoRepository.insert(userInfo);
        return userInfo.id;
    }

    public void updateUserInfo(UserInfo userInfo) {
        UserInfo userInfo2 = userInfoRepository.get(userInfo.id)
            .orElseThrow(() -> new NotFoundException("userInfo not found, userInfo = " + userInfo.id));

        userInfo2.name = "steve";
        userInfo2.password = "123456";
        userInfo2.phone = "13812341234";
        userInfo2.birthday = LocalDate.now();
        userInfoRepository.partialUpdate(userInfo);
    }

    public void deleteUserInfo(Integer userId) {
        userInfoRepository.delete(userId);
    }

    public UserInfo getUserInfoById(Integer userId) {
        return userInfoRepository.get(userId).orElseThrow(() -> new NotFoundException("userInfo not found, where userId = " + userId));
    }

    public List<UserInfo> getUserInfoListByName(String name) {
        return userInfoRepository.select("user_name LIKE ?", name);
    }

}
