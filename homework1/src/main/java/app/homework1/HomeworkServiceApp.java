package app.homework1;

import app.homework1.domain.Cinema;
import app.homework1.domain.Brush;
import app.homework1.module.CinemaModule;
import app.homework1.module.PainterModule;
import app.homework1.service.CinemaService;
import app.homework1.service.Painter;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author steve
 */
public class HomeworkServiceApp extends App {

    @Override
    protected void initialize() {

        load(new SystemModule("sys.properties"));
        load(new CinemaModule());
        load(new PainterModule());

        onStartup(() -> {
            Painter painter = bean(Painter.class); // singleton bean
            painter.draw();
            CinemaService cinemaService = bean(CinemaService.class);
            Cinema cinemaById = cinemaService.getCinemaById(1);
            System.out.println(cinemaById);
        });
    }
}
