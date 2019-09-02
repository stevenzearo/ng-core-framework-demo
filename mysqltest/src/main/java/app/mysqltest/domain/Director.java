package app.mysqltest.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

/**
 * @author steve
 */

@Table(name = "directors")
public class Director {

    @NotNull
    @PrimaryKey(autoIncrement = true)
    @Column(name = "director_id")
    public Integer directorId;

    @NotNull
    @Column(name = "director_name")
    public String directorName;

    @Override
    public String toString() {
        return "Director{" +
            "directorId=" + directorId +
            ", directorName='" + directorName + '\'' +
            '}';
    }
}
