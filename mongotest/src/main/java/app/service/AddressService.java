package app.service;

import app.domain.Address;
import app.domain.City;
import app.domain.Province;
import app.domain.Zone;
import app.mongotest.api.address.AddressWebView;
import app.mongotest.api.address.CreateAddressRequest;
import app.mongotest.api.address.ReplaceAddressRequest;
import app.mongotest.api.address.SearchAddressRequest;
import app.mongotest.api.address.SearchAddressResponse;
import app.mongotest.api.address.UpdateAddressRequest;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.mongo.Query;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class AddressService {
    @Inject
    MongoCollection<Address> mongoCollection;

    private final Logger logger = LoggerFactory.getLogger(AddressService.class);

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

    public AddressWebView get(String id) {
        Address address = mongoCollection.get(id)
            .orElseThrow(() -> new NotFoundException(Strings.format("address not found, id = {}", id)));
        return view(address);
    }

    public SearchAddressResponse search(SearchAddressRequest request) {
        Query query = new Query();
        query.limit = request.limit;
        query.skip = request.skip;
        if (!Strings.isBlank(request.zoneName)) {
            query.filter = Filters.regex("province.city.zone.name", request.zoneName);
        } else if (!Strings.isBlank(request.cityName)) {
            query.filter = Filters.regex("province.city.name", request.cityName);
        } else if (!Strings.isBlank(request.provinceName)) {
            query.filter = Filters.regex("province.name", request.provinceName);
        }
        SearchAddressResponse response = new SearchAddressResponse();
        response.total = mongoCollection.count(query.filter);
        response.addressList = mongoCollection.find(query).stream().map(this::view).collect(Collectors.toList());
        return response;
    }

    public void delete(String id) {
        mongoCollection.delete(id);
    }

    private AddressWebView view(Address address) {
        AddressWebView webView = new AddressWebView();
        webView.id = address.id;
        webView.provinceId = address.province.id;
        webView.provinceName = address.province.name;
        webView.cityId = address.province.city.id;
        webView.cityName = address.province.city.name;
        webView.zoneId = address.province.city.zone.id.toHexString();
        webView.zoneName = address.province.city.zone.name;
        return webView;
    }

    public void update(String id, UpdateAddressRequest request) {
        Address address = mongoCollection.get(id).orElseThrow(() -> new NotFoundException(Strings.format("address not found, id = ", id), "ADDRESS_NOT_FOUND"));
        Bson provinceNameFilter = Filters.eq("province.name", address.province.name);
        Bson cityNameFilter = Filters.eq("province.city.name", address.province.city.name);
        Bson zoneNameFilter = Filters.eq("province.city.zone.name", address.province.city.zone.name);
        Bson combineFilter = Filters.and(provinceNameFilter, cityNameFilter, zoneNameFilter);
        Bson provinceNameSet = Updates.set("province.name", request.provinceName);
        Bson cityNameSet = Updates.set("province.city.name", request.cityName);
        Bson zoneNameSet = Updates.set("province.city.zone.name", request.zoneName);
        Bson combineUpdate = Updates.combine(provinceNameSet, cityNameSet, zoneNameSet);
        mongoCollection.update(combineFilter, combineUpdate);
    }

    public void replace(String id, ReplaceAddressRequest request) {
        Address address = new Address();
        address.province = new Province();
        address.province.city = new City();
        address.province.city.zone = new Zone();
        address.id = id;
        address.province.id = UUID.randomUUID().toString();
        address.province.name = request.provinceName;
        address.province.city.id = UUID.randomUUID().toString();
        address.province.city.name = request.cityName;
        address.province.city.zone.name = request.zoneName;
        address.province.city.zone.id = new ObjectId();
        mongoCollection.replace(address);
    }
}
