package app.cinema.web;

import core.framework.web.Request;
import core.framework.web.Response;
import core.framework.web.Session;

/**
 * @author steve
 */
public class CinemaBOController {

    public Response goIndex(Request request) {
        CinemaBOIndexPage indexPage = new CinemaBOIndexPage();
        indexPage.name = "gradle";
//        Session session = request.session();
//        session.set("welcome", indexPage.welcomeMessage());
        return Response.html("/template/index.html", indexPage, "en_US");
    }

}
