package random;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author steve
 */
public class RandomTest {
    private static final Random RANDOM = new SecureRandom();

    public static void main(String[] args) {

        int maxRestaurantNum = 7;
        for (int i = 0; i < 100; i++) {
            double rate = (double) (RANDOM.nextInt(maxRestaurantNum) + 1) / (double) maxRestaurantNum;

            System.out.println(rate);
        }

        List<Integer> originList = List.of(1, 2, 4, 5, 3);
        List<Integer> newList = new ArrayList<>(originList);
        newList.remove((Integer) 4);
        System.out.println(originList);
        System.out.println(newList);
        System.out.println(UUID.randomUUID().getMostSignificantBits());
    }
}
