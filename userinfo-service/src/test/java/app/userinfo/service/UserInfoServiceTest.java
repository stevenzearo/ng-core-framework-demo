package app.userinfo.service;

import app.userinfo.UserInfoIntegrationExtension;
import app.userinfo.api.userinfo.CreateUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoResponse;
import app.userinfo.api.userinfo.UpdateUserInfoRequest;
import app.userinfo.api.userinfo.UserInfoView;
import core.framework.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author steve
 */

class UserInfoServiceTest extends UserInfoIntegrationExtension {
    @Inject
    UserInfoService service;

    private int userInfoId = 0;

    @BeforeEach
    void before() {
        CreateUserInfoRequest request = new CreateUserInfoRequest();
        request.name = "joseph";
        request.password = "1234";
        request.birthday = LocalDateTime.of(1997, 5, 8, 0, 0).toLocalDate();
        request.phone = "12312341234";
        UserInfoView userInfoView = service.create(request);
        userInfoId = userInfoView.id;

    }

    @Test
    void searchByNameFuzzily() {
        SearchUserInfoRequest request = new SearchUserInfoRequest();
        request.name = "s";
        SearchUserInfoResponse response = service.searchByNameFuzzily(request);
        assertThat(response.userInfoViewList).size().isGreaterThan(0);
    }

    @Test
    void get() {
        UserInfoView userInfoView = service.get(userInfoId);
        assertThat(userInfoView.name).isEqualTo("joseph");
        assertThat(userInfoView.password).isEqualTo("1234");
        assertThat(userInfoView.birthday).isEqualTo(LocalDateTime.of(1997, 5, 8, 0, 0).toLocalDate());
        assertThat(userInfoView.phone).isEqualTo("12312341234");
    }

    @Test
    void update() {
        UpdateUserInfoRequest request = new UpdateUserInfoRequest();
        request.password = "1234";
        service.update(userInfoId, request);
        UserInfoView userInfoView = service.get(userInfoId);
        assertThat(userInfoView.password).isEqualTo(request.password);
    }

    @AfterEach
    void after() {
        service.delete(userInfoId);
    }
}