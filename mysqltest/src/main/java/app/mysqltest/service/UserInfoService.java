package app.mysqltest.service;

import app.mysqltest.domain.UserInfo;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author steve
 */
public class UserInfoService {
    @Inject
    private Repository<UserInfo> repository;

    public Integer add() {
        UserInfo userInfo = new UserInfo();
        repository.insert(userInfo);
        return userInfo.id;
    }

    public void update(UserInfo userInfo) {
        UserInfo userInfo2 = repository.get(userInfo.id)
            .orElseThrow(() -> new NotFoundException(Strings.format("userInfo not found, id = {}", userInfo.id)));
        userInfo2.name = "steve";
        userInfo2.password = "123456";
        userInfo2.phone = "13812341234";
        userInfo2.birthday = LocalDate.now();
        repository.partialUpdate(userInfo);
    }

    public void delete(Integer userId) {
        repository.delete(userId);
    }

    public UserInfo get(Integer id) {
        return repository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("userInfo not found, id = {}", id)));
    }

    public List<UserInfo> searchByName(String name) {
        return repository.select("user_name LIKE ?", name);
    }
}
