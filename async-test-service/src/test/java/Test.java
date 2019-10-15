import javax.swing.table.TableStringConverter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author steve
 */
public class Test {
    abstract static class Scheduler extends TimerTask{
        private Long intervalSeconds;
        private static final ReentrantLock lock = new ReentrantLock();

        Scheduler(Long intervalSeconds) {
            Scheduler.this.intervalSeconds = intervalSeconds;
        }

        abstract public void scheduling();

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(intervalSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                scheduling();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);
        integers.stream().filter(x -> x >= 2).forEach(System.out::print);
        Timer timer = new Timer();
        timer.schedule(new Scheduler(3L) {
            @Override
            public void scheduling() {
                System.out.println("hello, world");
            }
        }, 300);
    }
}
