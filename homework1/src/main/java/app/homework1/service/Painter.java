package app.homework1.service;

import app.homework1.domain.Brush;
import core.framework.inject.Inject;
import core.framework.internal.log.marker.ErrorCodeMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class Painter {
    private final Logger logger = LoggerFactory.getLogger(Painter.class);

    @Inject
    Brush brush;

    public void draw() {
        logger.warn(new ErrorCodeMarker("DRAW_ERROR_CODE").getName() + " drawing picture...");
        brush.print();
    }
}
