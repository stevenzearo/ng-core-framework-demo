import core.framework.util.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class Test1 {
    public static void main(String[] args) {
        Set<Integer> trucks = Sets.newHashSetWithExpectedSize(100);
        List<Integer> integerList = trucks.stream().map(integer -> (int) Math.round(Math.random() * 1000)).collect(Collectors.toList());
        integerList.forEach(System.out::print);
    }
}
