package example4;

public class SimpleExecutionThread extends Thread {
    Integer monitor;
    int sleep, activity_min, activity_max;

    public SimpleExecutionThread(Integer monitor, int sleep, int activity_min, int activity_max) {
        this.monitor = monitor;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {

        System.out.println(this.getName() + " - State 1");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " - State 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - State 3");

    }
}

