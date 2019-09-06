package app.mysqltest.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;

/**
 * @author steve
 */
public class CinemaView {
    @NotNull
    @Column(name = "id")
    public Integer id;

    @Column(name = "cinema_name")
    @NotNull
    public String cinemaName;

    @Column(name = "address")
    public String address;

    @Column(name = "phone")
    public String phone;

    @Column(name = "zone_name")
    public String zoneName;

    @Column(name = "city_name")
    public String cityName;
}
