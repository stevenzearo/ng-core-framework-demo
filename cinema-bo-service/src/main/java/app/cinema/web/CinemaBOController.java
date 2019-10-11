package app.cinema.web;

import core.framework.web.Request;
import core.framework.web.Response;

/**
 * @author steve
 */
public class CinemaBOController {
    public Response goIndex(Request request) {
        CinemaBOIndexPage indexPage = new CinemaBOIndexPage();
        indexPage.name = "gradle";
        return Response.html("/template/index.html", indexPage, "en_US");
    }
}