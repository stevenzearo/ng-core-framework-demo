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
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    public Integer id;

    @NotNull
    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "phone")
    public String phone;

    @NotNull
    @Column(name = "zone_id")
    public Integer zoneId;
}
