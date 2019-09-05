package app.mysqltest.service;

import app.mysqltest.domain.Movie;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;

import java.util.List;

/**
 * @author steve
 */
public class MovieService {
    @Inject
    Repository<Movie> movieRepository;

    public List<Movie> getMovieListByName(String movieName) {
        Query<Movie> movieQuery = movieRepository.select();
        movieQuery.where("`name` LIKE ?", movieName);
        return movieQuery.fetch();
    }
}
