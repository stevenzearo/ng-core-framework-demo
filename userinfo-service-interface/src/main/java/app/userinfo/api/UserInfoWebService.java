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
import core.framework.api.web.service.QueryParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author steve
 */
public interface UserInfoWebService {

    @POST
    @Path("/user_info")
    @ResponseStatus(HTTPStatus.CREATED)
    UserInfoView create(CreateUserInfoRequest request);

    @PUT
    @Path("/user_info")
    @ResponseStatus(HTTPStatus.OK)
    public SearchUserInfoResponse searchUserInfoByNameFuzzily(SearchUserInfoRequest request);

    @GET
    @Path("/user_info/:id")
    UserInfoView getUserInfoById(@PathParam("id") Integer id);

    @PUT
    @Path("/user_info/:id")
    UserInfoView updateUserInfo(@PathParam("id") Integer id, UpdateUserInfoRequest request);

    @DELETE
    @Path("/user_info/:id")
     UserInfoView deleteUserInfo(@PathParam("id") Integer id);

}
