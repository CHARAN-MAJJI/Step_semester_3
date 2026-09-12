class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String id, String[] seats) {
        bookingId = id;
        seatNumbers = seats.clone();
    }

    String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] seats = seatNumbers.clone();
        seats[index] = newSeat;
        return new BookingReceipt(bookingId, seats);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    int groupSize;

    GroupBookingReceipt(String id, String[] seats, int size) {
        super(id, seats);
        groupSize = size;
    }
}

public class M5 {
    static String processNightlySettlement(BookingReceipt[] r) {

        int processed = 0, skipped = 0;
        int group = 0, individual = 0;

        for (BookingReceipt x : r) {

            if (x == null) {
                skipped++;
            } else {
                processed++;

                if (x instanceof GroupBookingReceipt)
                    group++;
                else
                    individual++;
            }
        }

        return processed + " processed | " + skipped +
               " null skipped | " + group + " group | " +
               individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt[] r = {
            new GroupBookingReceipt("CH-2002",
                    new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003",
                    new String[]{"C1"})
        };

        System.out.println(processNightlySettlement(r));
    }
}