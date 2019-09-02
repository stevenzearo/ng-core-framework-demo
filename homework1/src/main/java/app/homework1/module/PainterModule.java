package app.homework1.module;

import app.homework1.domain.Brush;
import app.homework1.service.Painter;
import core.framework.module.Module;

/**
 * @author steve
 */
public class PainterModule extends Module {
    @Override
    protected void initialize() {
        bind(Brush.class);
        bind(Painter.class);
    }
}
