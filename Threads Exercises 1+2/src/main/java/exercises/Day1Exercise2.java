package exercises;

/**
 *
 * @author Sanox
 */
public class Day1Exercise2 {

    private int n = 0;
    
    public synchronized int next() {
        n++;
        n++;
        return n;
    }

    public static void main(String[] args) {
        Day1Exercise2 next = new Day1Exercise2();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                next.next();
                System.out.println("t1: " + next.n);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                next.next();
                System.out.println("t2: " + next.n);
            }
        });
        
        t1.start();
        t2.start();
        
        
        
        //A) When calling next on 2 different threads 10.000 times, I start losing updates regulary
        //B) It happens around 50% of the time.
        //D) Syncronising the method ensures the value of next wont be updated by mutliple threads at the same time,therefore my solution will never loose an update no matter how many calls are made.
    }

}
