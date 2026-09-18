import java.util.*;

class LibraryMember {
    private static int counter = 100;
    private static int membersEnrolled = 0;

    public final String memberNumber;
    protected int borrowLimit;
    protected int booksBorrowed;
    protected String lastBorrowedGenre;

    public LibraryMember(int borrowLimit) {
        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("borrowLimit must be positive");
        }
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        this.memberNumber = "LIB-" + (++counter);
        membersEnrolled++;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {
        this.lastBorrowedGenre = genre;
        this.borrowBook(); // Delegate to no-argument version
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getLastBorrowedGenre() {
        return lastBorrowedGenre;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        if (members != null) {
            for (LibraryMember member : members) {
                if (member == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (member instanceof FacultyMember) {
                        faculty++;
                    } else {
                        regular++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }
}

class FacultyMember extends LibraryMember {
    protected String department;

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class M5 {
    public static void main(String[] args) {

        // Test 1: Member number assignment & static counter
        LibraryMember m1 = new LibraryMember(3);
        System.out.println("m1.memberNumber: " + m1.memberNumber);
        System.out.println("LibraryMember.getMembersEnrolled(): " + LibraryMember.getMembersEnrolled());

        // Test 2: Renewal code format validation
        System.out.println("\nRenewal Code Tests:");
        System.out.println("isValidRenewalCode(\"R12A\"): " + LibraryMember.isValidRenewalCode("R12A"));
        System.out.println("isValidRenewalCode(\"R1A\"): " + LibraryMember.isValidRenewalCode("R1A"));
        System.out.println("isValidRenewalCode(\"X12A\"): " + LibraryMember.isValidRenewalCode("X12A"));

        // Test 3: Overloaded borrowBook(...) delegation
        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println("\nm1.getBooksBorrowed(): " + m1.getBooksBorrowed());

        // Test 4: Nightly audit batch processing
        LibraryMember[] auditBatch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println("\nNightly Audit Result:");
        System.out.println(LibraryMember.processNightlyAudit(auditBatch));
    }
}
