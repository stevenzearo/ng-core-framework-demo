package app.cinema;

import app.cinema.domain.CinemaView;
import core.framework.module.App;
import core.framework.module.SystemModule;
import core.framework.web.site.WebDirectory;

/**
 * @author steve
 */
public class CinemaBOApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new CinemaBOModule());
    }
}
