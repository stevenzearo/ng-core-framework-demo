package app.cinema.service;

import app.cinema.domain.CinemaView;
import app.cinema.domain.UserInfo;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author steve
 */
public class CinemaBOService {
////    @Inject
////    Database database;
    @Inject
    Repository<UserInfo> infoRepository;

    @Inject
    Database database;
//
    public List<CinemaView> searchCinemaListByName(String cinemaName) {
        String sql = "SELECT cinemas.id, cinemas.name, address, phone, z.name zone_name, ct.name city_name " +
            "FROM cinemas LEFT JOIN zones z ON cinemas.zone_id = z.id\n" +
            "LEFT JOIN cities ct ON z.city_id = ct.id WHERE name Like '%SFC%'";
//        String sql = "select id from cinemas limit 0,1";
        return database.select(sql, CinemaView.class);
    }

    public void insert() {
        UserInfo user = new UserInfo();
        user.id = 1;
        user.name = "test";
        user.password = "test";
        user.phone = "11";
        infoRepository.insert(user);
    }

    public void get() {
//        Optional<UserInfo> userInfo = infoRepository.selectOne("name = ?","test");
//        System.out.println(userInfo.get());
        System.out.println(database.selectOne("select password FROM user_infos limit 0,1", String.class).get());
    }
}
