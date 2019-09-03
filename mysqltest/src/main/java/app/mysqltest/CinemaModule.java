package app.mysqltest;

import app.mysqltest.domain.CinemaView;
import app.mysqltest.service.CinemaService;
import core.framework.module.Module;

/**
 * @author steve
 */
public class CinemaModule extends Module {
    @Override
    protected void initialize() {
        db().view(CinemaView.class);
        bind(CinemaService.class);
    }
}
