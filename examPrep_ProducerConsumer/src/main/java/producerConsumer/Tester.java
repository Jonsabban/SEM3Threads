package producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sanox
 */
public class Tester {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(11);
        numbers.add(4);
        numbers.add(5);
        numbers.add(8);
        numbers.add(12);
        numbers.add(21);
        numbers.add(22);
        numbers.add(34);
        numbers.add(35);
        numbers.add(36);
        numbers.add(37);
        numbers.add(42);
        ArrayBlockingQueue<Long> calculatedNumbers = new ArrayBlockingQueue(11);

        ExecutorService es = Executors.newFixedThreadPool(5);
        //Create and start four producers (P1-P4 in the exercise-figure)
        es.execute(new Producer(numbers, calculatedNumbers));
        es.execute(new Producer(numbers, calculatedNumbers));
        es.execute(new Producer(numbers, calculatedNumbers));
        es.execute(new Producer(numbers, calculatedNumbers));

        Consumer consumer = new Consumer(calculatedNumbers);
        es.execute(consumer);

        es.awaitTermination(10, TimeUnit.SECONDS);
        es.shutdown();
        System.out.println(consumer.getTotal());
    }
    
    
    
}
