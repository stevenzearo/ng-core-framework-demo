package app.homework1.service;

import app.homework1.Homework1IntegrationExtension;
import app.homework1.domain.Cinema;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author steve
 */
class CinemaServiceTest extends Homework1IntegrationExtension {
    @Inject
    CinemaService service;

    @Inject
    Repository<Cinema> repository;

    private Cinema cinema;

    @BeforeEach
    void insert() {
        cinema = new Cinema();
        cinema.name = "NewYorkCinema";
        cinema.address = "0002 road 0001 street";
        cinema.phone = "70920010";
        cinema.zoneId = 1;
        OptionalLong insert = repository.insert(cinema);
        if (insert.isPresent())
            cinema.id = (int) insert.getAsLong();

    }

    @Test
    void getCinemaById() {
        assertThat(service.getCinemaById(1)).isEqualToComparingFieldByField(cinema);
    }

    @AfterEach
    void clean() {
        repository.delete(cinema.id);
    }
}