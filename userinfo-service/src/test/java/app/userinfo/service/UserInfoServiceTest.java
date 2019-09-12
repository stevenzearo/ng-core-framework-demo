package app.userinfo.service;

import app.userinfo.TestModule;
import app.userinfo.api.userinfo.CreateUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoResponse;
import app.userinfo.api.userinfo.UpdateUserInfoRequest;
import core.framework.inject.Inject;
import core.framework.json.JSON;
import core.framework.test.Context;
import core.framework.test.IntegrationExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author steve
 */
@ExtendWith(IntegrationExtension.class)
@Context(module = TestModule.class)
class UserInfoServiceTest {
    @Inject
    UserInfoService service;

    private final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @BeforeEach
    void before() {
        CreateUserInfoRequest request = new CreateUserInfoRequest();
        request.name = "joseph";
        request.password = "1234";
        request.birthday = LocalDateTime.of(1997, 5, 8, 0, 0).toLocalDate();
        request.phone = "12312341234";
        service.create(request);
    }

    @Test
    void searchByNameFuzzily() {
        SearchUserInfoRequest request = new SearchUserInfoRequest();
        request.name = "s";
        SearchUserInfoResponse response = service.searchByNameFuzzily(request);
        response.userInfoViewList.forEach(x -> logger.warn(JSON.toJSON(x)));
    }

    @Test
    void get() {
        logger.warn(JSON.toJSON(service.get(1)));
    }

    @Test
    void update() {
        UpdateUserInfoRequest request = new UpdateUserInfoRequest();
        request.password = "1234";
        service.update(1, request);
        logger.warn(JSON.toJSON(service.get(1)));
    }

    @Test
    void delete() {
        service.delete(1);
    }

    @AfterEach
    void after() {
        service.delete(1);
    }
}