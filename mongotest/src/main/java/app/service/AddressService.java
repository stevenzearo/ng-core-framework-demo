package app.service;

import app.domain.Address;
import app.domain.City;
import app.domain.Province;
import app.domain.Zone;
import app.web.province.AddressWebView;
import app.web.province.CreateAddressRequest;
import app.web.province.DeleteAddressRequest;
import app.web.province.GetAddressRequest;
import app.web.province.SearchAddressRequest;
import app.web.province.SearchAddressResponse;
import com.mongodb.client.model.Filters;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.mongo.Query;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.UUID;

/**
 * @author steve
 */
public class AddressService {
    @Inject
    MongoCollection<Address> mongoCollection;

    public void create(CreateAddressRequest request) {
        Address address = new Address();
        address.id = UUID.randomUUID().toString();
        address.province = new Province();
        address.province.id = UUID.randomUUID().toString();
        address.province.name = request.provinceName;
        address.province.city = new City();
        address.province.city.id = UUID.randomUUID().toString();
        address.province.city.name = request.cityName;
        address.province.city.zone = new Zone();
        address.province.city.zone.id = new ObjectId();
        address.province.city.zone.name = request.zoneName;
        mongoCollection.insert(address);
    }

    public AddressWebView get(GetAddressRequest request) {
        Address address = mongoCollection.get(request.id)
            .orElseThrow(() -> new NotFoundException(Strings.format("address not found, id = {}", request.id)));
        return view(address);
    }

    public SearchAddressResponse search(SearchAddressRequest request) {
        Query query = new Query();
        query.limit = request.limit;
        query.skip = request.skip;
        if (Strings.isBlank(request.zoneName)) {
            query.filter = Filters.regex("province.city.zone.name", request.cityName);
        } else if (Strings.isBlank(request.cityName)) {
            query.filter = Filters.regex("province.city.name", request.cityName);
        } else if (Strings.isBlank(request.provinceName)) {
            query.filter = Filters.regex("province.name", request.cityName);
        }
        SearchAddressResponse response = new SearchAddressResponse();
        response.total = mongoCollection.count(query.filter);
        response.addressList = mongoCollection.find(query);
        return response;
    }

    public void delete(DeleteAddressRequest request) {
        Bson id = Filters.eq("id", request.id);
        mongoCollection.delete(id);
    }

    private AddressWebView view(Address address) {
        AddressWebView webView = new AddressWebView();
        webView.id = address.id;
        webView.provinceId = address.province.id;
        webView.provinceName = address.province.name;
        webView.cityId = address.province.city.id;
        webView.cityName = address.province.city.name;
        webView.zoneId = address.province.city.zone.id;
        webView.zoneName = address.province.city.zone.name;
        return webView;
    }
}
