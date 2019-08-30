package app.domain;

import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

/**
 * @author steve
 */

@Table(name = "cinema")
public class Cinema {
    @PrimaryKey
    @Column(name = "cinema_id")
    public Integer cinemaId;
    @Column(name = "cinema_name")
    public String cinemaName;
    @Column(name = "cinema_address")
    public String cinemaAddress;
    @Column(name = "cinema_phone")
    public String cinemaPhone;
    @Column(name = "cinema_zone_id")
    public Integer cinemaZoneId;

    @Override
    public String toString() {
        return "Cinema{" +
            "cinemaId=" + cinemaId +
            ", cinemaName='" + cinemaName + '\'' +
            ", cinemaAddress='" + cinemaAddress + '\'' +
            ", cinemaPhone='" + cinemaPhone + '\'' +
            ", cinemaZoneId=" + cinemaZoneId +
            '}';
    }
}
