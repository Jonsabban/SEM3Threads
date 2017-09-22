package producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanox
 */
public class Consumer implements Runnable {

    private ArrayBlockingQueue<Long> numbersProduced;
    private Long total;

    public Consumer(ArrayBlockingQueue<Long> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {

            long num;
            try {
                num = numbersProduced.take();
                // total += num;
                System.out.println(num);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public Long getTotal() {
        return total;
    }

}
