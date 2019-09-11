package app.cinema.domain;

import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

/**
 * @author steve
 */
@Table(name = "cities")
public class City {
    @PrimaryKey
    @Column(name = "id")
    public Integer cityId;

    @Column(name = "name")
    public String name;
}
