public class Main {
    public static void main(String[] args) {
        Object monitor = new Object(),monitor2 = new Object();

        new ExecutionThread(monitor,monitor2, 4, 2, 4,6).start();
        new ExecutionThread(monitor,monitor2, 5, 3, 5,7).start();
    }
}
