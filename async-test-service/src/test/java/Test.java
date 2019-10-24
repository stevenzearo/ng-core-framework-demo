import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author steve
 */
public class Test {
    public static void main(String[] args) {
        Set<Integer> integers = Set.of(1, 2, 3, 4);
//        integers.stream().filter(x -> x >= 2).collect(Collectors.toList()).forEach(System.out::print);
        List<String> strings = List.of("hello", "world", "java");
        List<String> string2 = List.of("hello", "aaa", "bbb");
        System.out.println(strings.stream().anyMatch(string2::contains));
//        Timer timer = new Timer();
//        timer.schedule(new Scheduler((a) -> System.out.println("hello, world!"), 3L), 300);
    }

    @FunctionalInterface
    interface Task {
        void run(Object... args);
    }

    static class Scheduler extends TimerTask {
        private static final ReentrantLock lock = new ReentrantLock();
        private Long intervalSeconds;
        private Task task;

        Scheduler(Task task, Long intervalSeconds) {
            Scheduler.this.intervalSeconds = intervalSeconds;
            Scheduler.this.task = task;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(intervalSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                task.run();
                lock.unlock();
            }
        }
    }
}
