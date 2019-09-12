package app.cinema.service;

import app.cinema.CinemaIntegrationExtension;
import app.cinema.domain.CinemaSearchView;
import app.cinema.service.CinemaBOService;
import core.framework.inject.Inject;
import core.framework.test.Context;
import core.framework.test.IntegrationExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author steve
 */


class CinemaBOServiceTest extends CinemaIntegrationExtension {
    @Inject
    CinemaBOService cinemaBOService;

    @Test
    void test() {
        List<CinemaSearchView> sfc = cinemaBOService.searchCinemaListByName("%SFC%");
        assertThat(sfc).size().isGreaterThan(0);
    }
}

