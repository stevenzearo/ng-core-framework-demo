import core.framework.json.JSON;

import java.time.ZonedDateTime;

/**
 * @author steve
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(JSON.toJSON(ZonedDateTime.now()));
        System.out.println(JSON.toJSON(ZonedDateTime.now().plusMinutes(60)));
    }
}
