package app.cinema.web.ajax;

import app.cinema.domain.CinemaSearchView;
import app.cinema.service.CinemaBOService;
import app.userinfo.api.UserInfoWebService;
import app.userinfo.api.userinfo.UserInfoView;
import core.framework.inject.Inject;
import core.framework.json.JSON;
import core.framework.log.ActionLogContext;
import core.framework.web.Request;
import core.framework.web.Response;

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

    public Response searchCinemaListByNameFuzzilyAJAX(Request request) {
        Map<String, String> map = request.queryParams();
        String name = map.get("name");
        ActionLogContext.put("searchName", name);
        List<CinemaWebView> cinemaViewList = cinemaBOService.searchCinemaListByName(name).stream().map(this::view).collect(Collectors.toList());
        return Response.text(JSON.toJSON(cinemaViewList));
    }

    public Response getUserInfo(Request request) {
        Map<String, String> map = request.queryParams();
        String idStr = map.get("id");
        Integer id = Integer.valueOf(idStr);
        UserInfoView userInfoView = userInfoWebService.get(id);
        ActionLogContext.put("getUserInfo", id);
        return Response.bean(userInfoView);
    }

    private CinemaWebView view(CinemaSearchView cinemaSearchView) {
        CinemaWebView cinemaWebView = new CinemaWebView();
        cinemaWebView.id = cinemaSearchView.id;
        cinemaWebView.cinemaName = cinemaSearchView.cinemaName;
        cinemaWebView.address = cinemaSearchView.address;
        cinemaWebView.phone = cinemaSearchView.phone;
        cinemaWebView.zoneName = cinemaSearchView.zoneName;
        cinemaWebView.cityName = cinemaSearchView.cityName;
        return cinemaWebView;
    }
}
