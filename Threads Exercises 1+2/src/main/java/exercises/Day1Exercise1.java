package exercises;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanox
 */
public class Day1Exercise1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1e4; i++) {
                System.out.println("t1: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5; j++) {
                System.out.println("t2: " + j);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Day1Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            int i = 10;
            Long time = System.currentTimeMillis();
            Long end = time + 80000;
            while (System.currentTimeMillis() < end) {

                System.out.println(i);
                i++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Day1Exercise1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        //t1.start();
        //t2.start();
        t3.start();
    }

}
