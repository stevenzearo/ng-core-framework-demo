import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author steve
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);
        integers.stream().filter(x -> x >= 2).forEach(System.out::print);
        Timer timer = new Timer();
        timer.schedule(new Scheduler(() -> System.out.println("hello, world!"), 3L), 300);
    }

    @FunctionalInterface
    interface Task {
        void run();
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
