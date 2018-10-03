package CS_3700;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        (new Thread(new HelloRunnable())).start();
        (new HelloThread()).start();

        //SleepMessages
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            Thread.sleep(500);
            System.out.println(importantInfo[i]);
        }

        //INTERRUPT
        for (int i = 0; i < importantInfo.length; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(importantInfo[i]);
        }


        //MESSAGELOOP
        //delay, in ms before we interrupt MessageLoop thread
        long patience = 1000 * 60 * 60;

        //if command line arg present, gives patience in seconds
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer");
                System.exit(1);
            }
        }

        MessageLoop.threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        MessageLoop.threadMessage("Waiting for MessageLoop thread to finish");
        //loop until MessageLoop
        //thread exits
        while (t.isAlive()) {
            MessageLoop.threadMessage("Still waiting...");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                MessageLoop.threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        MessageLoop.threadMessage("Finally!");



    }
}



