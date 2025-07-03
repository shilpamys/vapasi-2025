import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int numThread = 3;
        int numTask = 5;

        ExecutorService service = Executors.newFixedThreadPool(numThread);

        for (int i = 1; i <= numTask; i++) {
            // service.submit(new BookTicket(i));

            service.execute(new BookTicket(1)); //runnable run()
            service.execute(new BookTicket(2));
            service.execute(new BookTicket(3));

        }
        service.shutdown();
        try {
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());

        }

    }
}