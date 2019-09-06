package app.mongotest.api;

import app.mongotest.api.address.AddressWebView;
import app.mongotest.api.address.CreateAddressRequest;
import app.mongotest.api.address.ReplaceAddressRequest;
import app.mongotest.api.address.SearchAddressRequest;
import app.mongotest.api.address.SearchAddressResponse;
import app.mongotest.api.address.UpdateAddressRequest;
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
public interface AddressWebService {
    @POST
    @Path("/address")
    @ResponseStatus(HTTPStatus.CREATED)
    void create(CreateAddressRequest request);

    @PUT
    @Path("/address/:id")
    void update(@PathParam("id") String id, UpdateAddressRequest request);

    @PUT
    @Path("/address/:id")
    void replace(@PathParam("id") String id, ReplaceAddressRequest request);

    @GET
    @Path("/address/:id")
    AddressWebView get(@PathParam("id") String id);

    @PUT
    @Path("/address")
    SearchAddressResponse search(SearchAddressRequest request);

    @DELETE
    @Path("/address/:id")
    void delete(@PathParam("id") String id);
}
