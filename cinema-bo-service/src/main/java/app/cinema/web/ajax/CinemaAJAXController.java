package app.cinema.web.ajax;

import app.cinema.domain.CinemaView;
import app.cinema.service.CinemaBOService;
import app.userinfo.api.UserInfoWebService;
import app.userinfo.api.userinfo.UserInfoView;
import core.framework.inject.Inject;
import core.framework.json.JSON;
import core.framework.web.Request;
import core.framework.web.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class CinemaAJAXController {
    @Inject
    CinemaBOService cinemaBOService;

    @Inject
    UserInfoWebService userInfoWebService;

    private final Logger logger = LoggerFactory.getLogger(CinemaAJAXController.class);

    public Response searchCinemaListByNameFuzzilyAJAX(Request request) {
        Map<String, String> map = request.queryParams();
        String name = map.get("name");
        List<CinemaWebView> cinemaViewList = cinemaBOService.searchCinemaListByName(name).stream().map(this::view).collect(Collectors.toList());
        return Response.text(JSON.toJSON(cinemaViewList));
    }

    public Response getUserInfo(Request request) {
        Map<String, String> map = request.queryParams();
        String idStr = map.get("id");
        Integer id = Integer.valueOf(idStr);
        UserInfoView userInfoView = userInfoWebService.get(id);
        logger.warn(JSON.toJSON(userInfoView));
        return Response.bean(userInfoView);
    }

    private CinemaWebView view(CinemaView cinemaView) {
        CinemaWebView cinemaWebView = new CinemaWebView();
        cinemaWebView.id = cinemaView.id;
        cinemaWebView.cinemaName = cinemaView.cinemaName;
        cinemaWebView.address = cinemaView.address;
        cinemaWebView.phone = cinemaView.phone;
        cinemaWebView.zoneName = cinemaView.zoneName;
        cinemaWebView.cityName = cinemaView.cityName;
        return cinemaWebView;
    }
}
