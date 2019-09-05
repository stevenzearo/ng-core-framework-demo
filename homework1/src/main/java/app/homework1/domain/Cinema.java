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
    public Integer id;

    @Column(name = "name")
    @NotNull
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "phone")
    public String phone;

    @Column(name = "zone_id")
    @NotNull
    public Integer zoneId;
}
