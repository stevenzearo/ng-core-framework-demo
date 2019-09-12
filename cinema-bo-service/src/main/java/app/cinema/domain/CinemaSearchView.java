package app.cinema.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.Table;

/**
 * @author steve
 */
public class CinemaSearchView {
    @NotNull
    @Column(name = "id")
    public Integer id;

    @NotNull
    @Column(name = "name")
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
