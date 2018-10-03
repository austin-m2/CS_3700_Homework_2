package CS_3700;

public class MessageLoop implements Runnable {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        try {
            for (int i = 0; i < importantInfo.length; i++) {
                Thread.sleep(500);
                System.out.println(importantInfo[i]);
            }
        } catch (InterruptedException e) {
            threadMessage("I wasn't done!");
        }
    }
}
