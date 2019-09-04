package app.cinema.web.ajax;

import app.cinema.domain.CinemaView;
import app.cinema.service.CinemaBOService;
import core.framework.inject.Inject;
import core.framework.web.Request;
import core.framework.web.Response;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class CinemaAJAXController {
    @Inject
    CinemaBOService cinemaBOService;

    public Response searchCinemaListByNameFuzzilyAJAX(Request request) {
        String name = request.pathParam("name");
        List<CinemaWebView> cinemaViewList = cinemaBOService.searchCinemaListByName(name).stream().map(this::view).collect(Collectors.toList());
        return Response.bean(cinemaViewList);
    }

    public CinemaWebView view(CinemaView cinemaView) {
        CinemaWebView CinemaWebView = new CinemaWebView();
        CinemaWebView.id = cinemaView.id;
        CinemaWebView.cinemaName = cinemaView.cinemaName;
        CinemaWebView.address = cinemaView.address;
        CinemaWebView.phone = cinemaView.phone;
        CinemaWebView.zoneName = cinemaView.zoneName;
        CinemaWebView.cityName = cinemaView.cityName;
        return CinemaWebView;
    }
}
