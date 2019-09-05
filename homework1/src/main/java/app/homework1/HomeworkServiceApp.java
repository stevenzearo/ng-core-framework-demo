package app.homework1;

import app.homework1.domain.Cinema;
import app.homework1.service.CinemaService;
import app.homework1.service.Painter;
import core.framework.json.JSON;
import core.framework.module.App;
import core.framework.module.SystemModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class HomeworkServiceApp extends App {
    private final Logger logger = LoggerFactory.getLogger(HomeworkServiceApp.class);
    @Override
    protected void initialize() {

        load(new SystemModule("sys.properties"));
        load(new CinemaModule());
        load(new PainterModule());

        onStartup(() -> {
            Painter painter = bean(Painter.class);
            painter.draw();
            CinemaService cinemaService = bean(CinemaService.class);
            Cinema cinemaById = cinemaService.getCinemaById(1);
            logger.warn(JSON.toJSON(cinemaById));
        });
    }
}
