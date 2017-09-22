package day2.webscraper;

public class Tester extends Thread {

    public static void main(String[] args) throws InterruptedException {
        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        //tc1.run();
        tc1.start();
        TagCounter tc2 = new TagCounter("http://www.google.com");
        //tc2.run();
        tc2.start();
        TagCounter tc3 = new TagCounter("http://politiken.dk/");
        //tc3.run();
        tc3.start();

        long start = System.nanoTime();
        tc1.join();
        tc2.join();
        tc3.join();

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());

        long end = System.nanoTime();
        System.out.println("Time Sequential: " + (end - start));
        
        //A) Calling the 3 run() Methods in a sequence. So they have to wait for each other.
        //B) I just have to make TagCounter extend Thread, and override the run method, so I can call .start().
        //C) run() runs in a squence, start() creates a new thread that can run at the same time.
        //   the main method will be completed before the threads are done working.
        // The methods are running at the same time, therefore there are almost no wait time inbetween the threads.
        
        
        
    }
}
