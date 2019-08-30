package app.service;

import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class Painter {

    private final Logger logger = LoggerFactory.getLogger(Painter.class);

    @Inject
    private Brush brush;

    public void draw() {
        logger.warn("drawing picture...");
        brush.print();
    }
}
