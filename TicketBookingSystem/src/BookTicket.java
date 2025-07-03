import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BookTicket implements Runnable {
    private int bookingId;

    public BookTicket(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public void run() {
        System.out.println(bookingId + "  Booking recieved " + Thread.currentThread().getName());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println(bookingId + " Payement recieved " + Thread.currentThread().getName());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        System.out.println(bookingId + " Ticket confirmed " + Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }
}

