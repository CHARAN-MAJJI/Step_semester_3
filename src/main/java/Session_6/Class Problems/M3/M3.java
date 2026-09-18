import java.util.*;

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int sum = 0;
        for (int i = 0; i < fineCount; i++) {
            sum += fineHistory[i];
        }
        return sum;
    }
}

class StudentMember extends LibraryMember {
    protected String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class M3 {
    public static void main(String[] args) {


        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println("Test 1 [s.getTotalFine() after chargeFine(100)]: " + s.getTotalFine());

        int[] history = s.getFineHistory();
        System.out.println("History before external edit: " + Arrays.toString(s.getFineHistory()));

        history[0] = 999;

        System.out.println("History after external edit attempt (history[0] = 999): " + Arrays.toString(s.getFineHistory()));
    }
}
