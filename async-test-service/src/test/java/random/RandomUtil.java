package random;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author steve
 */
public class RandomUtil {
    private static final Random RANDOM = new SecureRandom();

    public static <T> List<T> randomT(List<T> list, Double rate) {
        List<T> result = new ArrayList<>();
        if (rate > 1d) return result;
        if (rate < 0d) return result;
        int randomIndexBound = (int) Math.round(list.size() * rate - 0.5d); // using rate to get dataset num
        return randomT(list, randomIndexBound, result);
    }


    private static <T> List<T> randomT(List<T> list, Integer randomIndexBound, List<T> result) {
        T o = list.get(RANDOM.nextInt(randomIndexBound));
        list.remove(o);
        result.add(o);
        if (randomIndexBound > 1)
            return randomT(list, randomIndexBound - 1, result);
        else return result;
    }

    public static Double randomGaussian(Double mean, Double min, Double max) {
        double val = RANDOM.nextGaussian() + mean;
        while (val > min || val < max) {
            val = RANDOM.nextGaussian();
        }
        return val;
    }
}
