package app.async;

import app.cinema.domain.CinemaSearchView;
import app.cinema.service.CinemaBOService;
import core.framework.inject.Inject;
import core.framework.test.Context;
import core.framework.test.IntegrationExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

/**
 * @author steve
 */

@ExtendWith(IntegrationExtension.class)
@Context(module = TestModule.class)
class CinemaBOTest {
    @Inject
    CinemaBOService cinemaBOService;

    @Test
    void test() {
        List<CinemaSearchView> sfc = cinemaBOService.searchCinemaListByName("%SFC%");
        sfc.forEach(System.out::println);
    }
}

