package app;

import app.domain.Cinema;
import app.service.Brush;
import app.service.CinemaService;
import app.service.Painter;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class HomeworkServiceApp extends App {

    @Override
    protected void initialize() {
        http().httpsPort(8443);
        load(new SystemModule("sys.properties"));
        db().repository(Cinema.class);
        CinemaService cinemaService = bind(CinemaService.class);
        Brush brush = bind(Brush.class);
        Painter painter = bind(Painter.class);
    }
}
