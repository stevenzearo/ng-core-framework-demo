package app.cinema.web.ajax;

import core.framework.api.json.Property;

/**
 * @author steve
 */
public class CinemaWebView {
    @Property(name = "id")
    public Integer id;

    @Property(name = "cinema_name")
    public String cinemaName;

    @Property(name = "address")
    public String address;

    @Property(name = "phone")
    public String phone;

    @Property(name = "zone_name")
    public String zoneName;

    @Property(name = "city_name")
    public String cityName;
}
