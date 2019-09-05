package app.mysqltest;

import app.mysqltest.domain.CinemaView;
import app.mysqltest.service.CinemaService;
import core.framework.module.App;
import core.framework.module.SystemModule;

import java.util.List;

/**
 * @author steve
 */
public class MysqlTestApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new MovieModule());
        load(new CinemaModule());
        load(new UserInfoModule());
        onStartup(() -> {
            CinemaService cinemaService = bean(CinemaService.class);
            List<CinemaView> cinemaViewList = cinemaService.searchCinemaListByNameFuzzily("SFC");
            cinemaViewList.forEach(System.out::println);
        });
    }
}
