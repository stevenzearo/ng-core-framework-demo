package app.cinema.service;

import app.cinema.domain.CinemaView;
import core.framework.db.Database;
import core.framework.inject.Inject;
import core.framework.util.Strings;

import java.util.List;

/**
 * @author steve
 */
public class CinemaBOService {
    @Inject
    Database database;

    public List<CinemaView> searchCinemaListByName(String cinemaName) {
        String sql = "SELECT cinema.id, cinema.`name` cinema_name, address, phone, zone.`name` zone_name, city.`name` city_name"
            + " FROM cinemas LEFT JOIN zones ON cinemas.zone_id = zones.id"
            + " LEFT JOIN cities ON zones.city_id = cities.id WHERE cinema.`name` Like ?";
        return database.select(sql, CinemaView.class, Strings.format("%{}%", cinemaName));
    }
}
