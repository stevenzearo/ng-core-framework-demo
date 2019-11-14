import core.framework.json.JSON;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author steve
 */
public class Test2 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime today = ZonedDateTime.of(now.toLocalDate(), LocalTime.of(0, 0), now.getZone());
//        System.out.println(JSON.toJSON(ZonedDateTime.now().plusMinutes(60)));

        System.out.println(JSON.toJSON(today));
//        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime shiftDate = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth() + 1, 0, 0, 0, 0, now.getZone());
        System.out.println(shiftDate.isEqual(today.plusDays(1)));
//        System.out.println(JSON.toJSON(shiftDate));
        System.out.println(Double.parseDouble("0.8d"));
        System.out.println(String.format("truck-%s-%03d", "regionName", 23));
//        Object
        System.out.println(1 / 0.3d);
    }
}
