import app.HomeworkServiceApp;
import app.service.Painter;
import core.framework.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author steve
 */
public class Main {
    public static void main(String[] args) {
        HomeworkServiceApp app = new HomeworkServiceApp();
        app.start();
        Painter painter = app.bean(Painter.class);
        painter.draw();
        List<String> strings = Arrays.asList("abc", "hello");
    }
}
