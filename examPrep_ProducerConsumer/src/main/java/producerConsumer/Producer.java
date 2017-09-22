package producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanox
 */
public class Producer implements Runnable {

    ArrayBlockingQueue<Integer> numbersToProduce;
    ArrayBlockingQueue<Long> calculatedNumbers;

    public Producer(ArrayBlockingQueue<Integer> numbersToProduce, ArrayBlockingQueue<Long> calculatedNumbers) {
        this.numbersToProduce = numbersToProduce;
        this.calculatedNumbers = calculatedNumbers;
    }

    ;

     public long fib(Long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
        try {
            Long n = (long) numbersToProduce.take();
            calculatedNumbers.put(fib(n));
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
