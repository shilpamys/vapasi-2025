import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BookTicket implements Runnable {
    private final String movieGoer;
    private int bookingId;

    private static final String WHITE = "\u001B[37m";
    private static final String RESET = "\u001B[0m";

    public BookTicket(String bookingName) {
        this.movieGoer = bookingName;
    }

    @Override
    public void run() {

        // System.out.println(bookingId + "  Booking recieved " + Thread.currentThread().getName());

        try {
            System.out.println(WHITE + movieGoer + " books a ticket. Their Booking is received by " + Thread.currentThread().getName() + RESET);
            Thread.sleep(1000);

            System.out.println(WHITE + movieGoer + " pays for the ticket. Their Payment is processed by " + Thread.currentThread().getName() + RESET);
            Thread.sleep(1000);

            System.out.println(WHITE + movieGoer + " receives the Ticket. Their Ticket is confirmed by " + Thread.currentThread().getName() + RESET);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("Exception occured: ");
        }
        // System.out.println(bookingId + "  Booking recieved " + Thread.currentThread().getName());

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            System.out.println(e.getStackTrace());
//        }
//        System.out.println(bookingId + " Payement recieved " + Thread.currentThread().getName());
//
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            System.out.println(e.getStackTrace());
//        }
//        System.out.println(bookingId + " Ticket confirmed " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            System.out.println(e.getStackTrace());
//        }
    }
}

