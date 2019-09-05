package app.mysqltest.service;

import app.mysqltest.domain.CinemaView;
import core.framework.db.Database;
import core.framework.inject.Inject;
import core.framework.util.Strings;

import java.util.List;

/**
 * @author steve
 */
public class CinemaService {
    @Inject
    Database database;

    public List<CinemaView> searchCinemaListByNameFuzzily(String cinemaName) {
        String sql = "SELECT cinemas.id, cinemas.`name` cinema_name, address, phone, zones.`name` zone_name, cities.`name` city_name"
            + " FROM cinemas LEFT JOIN zones ON cinemas.zone_id = zones.id"
            + " LEFT JOIN cities ON zones.city_id = cities.id WHERE cinemas.`name` Like ?";
        return database.select(sql, CinemaView.class, Strings.format("%{}%", cinemaName));
    }
}
