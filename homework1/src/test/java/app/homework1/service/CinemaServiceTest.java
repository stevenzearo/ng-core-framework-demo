package app.homework1.service;

import app.homework1.TestModule;
import app.homework1.domain.Cinema;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.test.Context;
import core.framework.test.IntegrationExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.OptionalLong;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author steve
 */
@ExtendWith(IntegrationExtension.class)
@Context(module = TestModule.class)
class CinemaServiceTest {
    @Inject
    CinemaService service;

    @Inject
    Repository<Cinema> repository;

    Cinema cinema;

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
}