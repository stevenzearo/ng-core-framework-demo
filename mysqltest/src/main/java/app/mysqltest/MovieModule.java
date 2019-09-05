package app.mysqltest;

import app.mysqltest.domain.Movie;
import app.mysqltest.service.MovieService;
import core.framework.module.Module;

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
