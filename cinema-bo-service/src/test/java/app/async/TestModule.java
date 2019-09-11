package app.async;

import app.cinema.CinemaBOApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author steve
 */
public class TestModule extends AbstractTestModule {
    static {
        System.setProperty("core.webPath", "C:\\Users\\steve\\IdeaProjects\\homework\\cinema-bo-service\\src\\main\\resources\\dist\\web");
    }

    @Override
    protected void initialize() {
        load(new CinemaBOApp());
        initDB().createSchema();
    }
}
