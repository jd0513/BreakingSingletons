import java.util.stream.IntStream;
import java.lang.Runnable;

public class Main implements Runnable {
    private String name;

    public Main(String name) {
        this.name = name;
        System.out.printf("constructor %s%n", this.getName());
    }

    public static void main(String[] args) {
        /*LazyInitializedSingleton lis1 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton lis2 = LazyInitializedSingleton.getInstance();
        System.out.println(lis1.hashCode());
        System.out.println(lis2.hashCode());

    Main m1 = new Main();
    Main m2 = new Main();
    System.out.println(m1.hashCode());
    System.out.println(m2.hashCode());
    */

        IntStream.range(0, 10).forEach((int i) -> new Thread(
                new Main("Thread" + i)
        ).start());
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void run() {
        LazyInitializedSingleton ls = LazyInitializedSingleton.getInstance();
        System.out.printf("runner %s-%s%n", this.getName(), ls.hashCode());
    }
}