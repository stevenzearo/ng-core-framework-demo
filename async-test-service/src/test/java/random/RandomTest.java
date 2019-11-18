package random;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class RandomTest {
    private static final Random RANDOM = new SecureRandom();

    public static void main(String[] args) {
        List<String> a = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j","aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj");

        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            strings.addAll(RandomUtil.randomT(a, 0.4));
            System.out.println(strings.size());
        }
        System.out.println(strings.size());
        strings.forEach(System.out::println);
    }
}
