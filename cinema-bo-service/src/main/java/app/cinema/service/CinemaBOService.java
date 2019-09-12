package app.cinema.service;

import app.cinema.domain.CinemaSearchView;
import core.framework.db.Database;
import core.framework.inject.Inject;

import java.util.List;

/**
 * @author steve
 */
public class CinemaBOService {
    @Inject
    Database database;

    public List<CinemaSearchView> searchCinemaListByName(String cinemaName) {
        String sql = "SELECT cinemas.id, cinemas.name, address, phone, z.name zone_name, ct.name city_name "
            + "FROM cinemas LEFT JOIN zones z ON cinemas.zone_id = z.id\n"
            + "LEFT JOIN cities ct ON z.city_id = ct.id WHERE name Like '%SFC%'";
        return database.select(sql, CinemaSearchView.class);
    }
}
