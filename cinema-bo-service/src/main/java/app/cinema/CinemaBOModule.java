package app.cinema;

import app.cinema.domain.CinemaView;
import app.cinema.service.CinemaBOService;
import app.cinema.web.CinemaBOController;
import app.cinema.web.CinemaBOIndexPage;
import app.cinema.web.ajax.CinemaAJAXController;
import app.cinema.web.ajax.CinemaWebView;
import app.userinfo.api.UserInfoWebService;
import core.framework.module.Module;

import java.util.List;

import static core.framework.http.HTTPMethod.GET;

/**
 * @author steve
 */
public class CinemaBOModule extends Module {
    @Override
    protected void initialize() {
        db().view(CinemaView.class);
        List<String> messages = List.of("messages/main.properties", "messages/main_en.properties", "messages/main_en_US.properties");
        bind(CinemaBOService.class);
        api().client(UserInfoWebService.class, requiredProperty("app.user.serviceURL"));
        CinemaBOController cinemaBOController = bind(CinemaBOController.class);

        site().message(messages, "en_US");
        site().template("/template/index.html", CinemaBOIndexPage.class);

        http().route(GET, "/", cinemaBOController::goIndex);
        http().route(GET, "/index.html", cinemaBOController::goIndex);

        http().bean(CinemaWebView.class);
        CinemaAJAXController cinemaAJAXController = bind(CinemaAJAXController.class);
        http().route(GET, "/ajax/cinema", cinemaAJAXController::searchCinemaListByNameFuzzilyAJAX);
        http().route(GET, "/ajax/cinema/user", cinemaAJAXController::getUserInfo);
    }
}
