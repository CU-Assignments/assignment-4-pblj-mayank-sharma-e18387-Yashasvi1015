import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingSystem {
    private static int availableSeats = 10;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread vip1 = new Thread(new BookingTask(true), "VIP Booking 1");
        Thread vip2 = new Thread(new BookingTask(true), "VIP Booking 2");
        Thread regular1 = new Thread(new BookingTask(false), "Regular Booking 1");
        Thread regular2 = new Thread(new BookingTask(false), "Regular Booking 2");

        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY);
        regular2.setPriority(Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }

    private static class BookingTask implements Runnable {
        private boolean isVIP;

        public BookingTask(boolean isVIP) {
            this.isVIP = isVIP;
        }

        @Override
        public void run() {
            while (availableSeats > 0) {
                lock.lock();
                try {
                    if (availableSeats > 0) {
                        System.out.println(Thread.currentThread().getName() + ": Seat " + availableSeats + " confirmed.");
                        availableSeats--;
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": Error: Seat already booked.");
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
