package app.homework1;

import app.homework1.domain.Cinema;
import app.homework1.service.CinemaService;
import core.framework.module.Module;

/**
 * @author steve
 */
public class CinemaModule extends Module {
    @Override
    protected void initialize() {
        db().repository(Cinema.class);
        bind(CinemaService.class);

    }
}
