package app.mysqltest.domain;

import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.DBEnumValue;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author steve
 */

@Table(name = "movies")
public class Movie {

    @PrimaryKey(autoIncrement = true)
    @NotNull
    @Column(name = "id")
    public Integer id;

    @NotNull
    @Column(name = "name")
    public String name;

    @Column(name = "country")
    public String country;

    @Column(name = "minutes")
    public Integer minutes;

    @Column(name = "language")
    public String language;

    @Column(name = "introduce")
    public String introduce;

    @Column(name = "online_time")
    public LocalDateTime onlineTime;

    @NotNull
    @Column(name = "status")
    public MovieStatus status;
}
