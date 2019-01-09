package Problem10;

import static java.lang.Thread.sleep;

public class JobSceduler {

    public static void scheduleJob(Runnable runnable, int time) {
        new Thread(() -> {
            try {
                sleep(time);
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        scheduleJob(()-> System.out.println("sudip"), 5000);
    }
}
