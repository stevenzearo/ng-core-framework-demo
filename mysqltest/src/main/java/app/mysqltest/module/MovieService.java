package app.mysqltest.module;

import app.mysqltest.domain.Director;
import app.mysqltest.domain.DirectorMovie;
import app.mysqltest.domain.Movie;
import com.sun.source.tree.NewArrayTree;
import core.framework.db.Database;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.internal.db.DatabaseImpl;

import java.util.List;

/**
 * @author steve
 */
public class MovieService {

    @Inject
    Repository<Movie> movieRepository;

    @Inject
    Repository<DirectorMovie> directorRepository;

    public List<Movie> getMovieListByDirectorName() {
        Query<DirectorMovie> query = directorRepository.select();
        return null;
    }
}
