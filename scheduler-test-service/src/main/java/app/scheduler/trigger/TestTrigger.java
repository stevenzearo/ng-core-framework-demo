package app.scheduler.trigger;

import core.framework.scheduler.Trigger;
import core.framework.util.Randoms;

import java.time.ZonedDateTime;

/**
 * @author steve
 */
public class TestTrigger implements Trigger {
    @Override
    public ZonedDateTime next(ZonedDateTime previous) {
        return previous.plusSeconds(Randoms.nextInt(7, 13));
    }
}
