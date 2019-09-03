package app.mysqltest.service;

import app.mysqltest.domain.CinemaView;
import core.framework.db.Database;
import core.framework.inject.Inject;

import java.util.List;

/**
 * @author steve
 */
public class CinemaService {
    @Inject
    private Database database;

    public List<CinemaView> getCinemaByName(String cinemaName) {
        String sql = "SELECT cinema.id, cinema.`name` cinema_name, address, phone, zone.`name` zone_name, city.`name` city_name"
            + " FROM cinemas LEFT JOIN zones ON cinemas.zone_id = zones.id"
            + " LEFT JOIN cities ON zones.city_id = cities.id WHERE cinema.`name` Like ?";
        return database.select(sql, CinemaView.class, cinemaName);
    }
}
