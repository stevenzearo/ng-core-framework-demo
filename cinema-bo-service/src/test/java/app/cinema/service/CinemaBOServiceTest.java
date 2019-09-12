package app.cinema.service;

import app.cinema.CinemaIntegrationExtension;
import core.framework.inject.Inject;
import org.junit.jupiter.api.Test;

/**
 * @author steve
 */
class CinemaBOServiceTest extends CinemaIntegrationExtension {
    @Inject
    CinemaBOService cinemaBOService;

    @Test
    void test() {
        cinemaBOService.searchCinemaListByName("%SFC%");
    }
}

