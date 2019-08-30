package app;

import app.service.Brush;
import app.service.Painter;
import core.framework.module.App;

/**
 * @author steve
 */
public class HomeworkServiceApp extends App {

    @Override
    protected void initialize() {
        Brush brush = bind(Brush.class);
        Painter painter = bind(Painter.class);
    }
}
