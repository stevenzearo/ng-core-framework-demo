package app.homework1.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

/**
 * @author steve
 */

@Table(name = "cinemas")
public class Cinema {
    @PrimaryKey
    @NotNull
    @Column(name = "id")
    public Integer cinemaId;

    @Column(name = "name")
    @NotNull
    public String cinemaName;

    @Column(name = "address")
    public String cinemaAddress;

    @Column(name = "phone")
    public String cinemaPhone;

    @Column(name = "zone_id")
    @NotNull
    public Integer cinemaZoneId;

}
