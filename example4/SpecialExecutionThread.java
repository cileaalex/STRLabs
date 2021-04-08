package example4;

public class SpecialExecutionThread extends Thread {
    Integer monitor,monitor2;
    int sleep, activity_min, activity_max;

    public SpecialExecutionThread(Integer monitor, Integer monitor2, int sleep, int activity_min, int activity_max) {
        this.monitor = monitor;
        this.monitor2= monitor2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - State 1");
        try {
            Thread.sleep(sleep * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - State 2");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor){
            synchronized(monitor2){
                monitor.notify();
                monitor2.notify();
            }
        }

        System.out.println(this.getName() + " - State 3");
    }
}
