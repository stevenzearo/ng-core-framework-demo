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
    @Column(name = "movie_id")
    public Integer movieId;

    @NotNull
    @Column(name = "movie_name")
    public String movieName;

    @Column(name = "movie_country")
    public String movieCountry;

    @Column(name = "movie_minutes")
    public Integer movieMinutes;

    @Column(name = "movie_language")
    public String movieLanguage;

    @Column(name = "introduce")
    public String introduce;

    @Column(name = "online_time")
    public LocalDateTime onlineTime;

    @NotNull
    @Column(name = "movie_status")
    public MovieStatus movieStatus;

    @Override
    public String toString() {
        return "Movie{" +
            "movieId=" + movieId +
            ", movieName='" + movieName + '\'' +
            ", movieCountry='" + movieCountry + '\'' +
            ", movieMinutes=" + movieMinutes +
            ", movieLanguage='" + movieLanguage + '\'' +
            ", introduce='" + introduce + '\'' +
            ", onlineTime=" + onlineTime +
            ", movieStatus=" + movieStatus +
            '}';
    }
}
