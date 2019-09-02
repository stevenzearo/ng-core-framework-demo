package app.mysqltest.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;

import java.util.List;

/**
 * @author steve
 */
public class DirectorMovie {

    @Column(name = "director_id")
    public Integer DirectorId;

    public Director director;

    public List<Movie> movieList;

}
