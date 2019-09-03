package app.mysqltest;

import app.mysqltest.domain.Movie;
import app.mysqltest.service.MovieService;
import core.framework.db.Database;
import core.framework.module.Module;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class MovieModule extends Module {

    @Override
    protected void initialize() {
        db().repository(Movie.class);
        bind(MovieService.class);
    }
}
