package example4;

public class Main {
    public static void main(String[] args) {
        Integer monitor=1, monitor2=2;
        new SimpleExecutionThread(monitor,0,3,5).start();
        new SpecialExecutionThread(monitor,monitor2,7,2,3).start();
        new SimpleExecutionThread(monitor2,0,4,5).start();
    }


}
