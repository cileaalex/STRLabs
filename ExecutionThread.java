class ExecutionThread extends Thread {

    Object monitor1, monitor2;

    int sleep_max, activity_min, activity_max1, activity_max2;

    public ExecutionThread(Object monitor1, Object monitor2, int sleep_max, int activity_min, int activity_max1, int activity_max2) {

        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max1 = activity_max1;
        this.activity_max2 = activity_max2;

    }

    public void run() {

        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max1 - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor1) {
            synchronized (monitor2) {

                System.out.println("Avoiding deadlock " + this.getName() + " occupied the monitors");
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity_max2 - activity_max1) + activity_max1);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }


                System.out.println(this.getName() + " - STATE 3");
                try {
                    Thread.sleep(Math.round(Math.random() * (sleep_max) * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName() + " released the monitors");
        }
        System.out.println(this.getName() + " - STATE 4");
    }
}