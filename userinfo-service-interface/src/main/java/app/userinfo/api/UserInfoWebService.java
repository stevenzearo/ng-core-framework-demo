package app.userinfo.api;

import app.userinfo.api.userinfo.CreateUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoRequest;
import app.userinfo.api.userinfo.SearchUserInfoResponse;
import app.userinfo.api.userinfo.UpdateUserInfoRequest;
import app.userinfo.api.userinfo.UserInfoView;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author steve
 */
public interface UserInfoWebService {
    @POST
    @Path("/user")
    @ResponseStatus(HTTPStatus.CREATED)
    UserInfoView create(CreateUserInfoRequest request);

    @PUT
    @Path("/user")
    SearchUserInfoResponse searchByNameFuzzily(SearchUserInfoRequest request);

    @GET
    @Path("/user/:id")
    UserInfoView get(@PathParam("id") Integer id);

    @PUT
    @Path("/user/:id")
    void update(@PathParam("id") Integer id, UpdateUserInfoRequest request);

    @DELETE
    @Path("/user/:id")
     void delete(@PathParam("id") Integer id);

}
