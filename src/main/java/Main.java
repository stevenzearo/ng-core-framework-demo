import app.HomeworkServiceApp;
import app.domain.Cinema;
import app.service.CinemaService;
import app.service.Painter;
import core.framework.db.DBEnumValue;
import core.framework.db.Query;

import java.util.Arrays;
import java.util.List;

/**
 * @author steve
 */

public class Main {
    public static void main(String[] args) {
        HomeworkServiceApp app = new HomeworkServiceApp();
        app.start();
        Painter painter = app.bean(Painter.class); // singleton bean
        painter.draw();
        CinemaService cinemaService = app.bean(CinemaService.class);
        Cinema cinemaById = cinemaService.getCinemaById(1);
        System.out.println(cinemaById);
    }
}
