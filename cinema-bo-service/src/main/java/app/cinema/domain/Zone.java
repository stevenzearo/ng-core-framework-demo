package app.cinema.domain;

import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

/**
 * @author steve
 */
@Table(name = "zones")
public class Zone {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String zoneName;

    @Column(name = "city_id")
    public String cityId;
}
