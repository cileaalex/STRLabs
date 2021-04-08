package example1;

public class TwoMonitorExecutionThread extends Thread {

    Integer monitor;
    Integer monitor2;

    int sleep, activity_min, activity_max;

    public TwoMonitorExecutionThread(Integer monitor, Integer monitor2, int sleep, int activity_min, int activity_max) {

        this.monitor = monitor;
        this.monitor2 = monitor2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {
            synchronized (monitor2) {

                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                try {
                    Thread.sleep(sleep * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(this.getName() + " - STATE 3");
    }
}

