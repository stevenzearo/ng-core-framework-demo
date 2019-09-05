package app.homework1.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author steve
 */
public class Brush {
    private final Logger logger = LoggerFactory.getLogger(Brush.class);
    public void print() {
        logger.warn("hello, world!");
    }
}
