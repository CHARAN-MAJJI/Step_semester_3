class Course {
    String code, title;
    int credits, labCredits;

    Course(String c, String t, int cr, int lab) {
        code = c;
        title = t;
        credits = cr;
        labCredits = lab;
    }

    Course(String c, String t, int cr) {
        this(c, t, cr, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }
}

public class M3 {
    public static void main(String[] args) {
        Course c1 = new Course("21CSC201J", "Data Structures", 4);
        Course c2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(c1.totalCredits());
        System.out.println(c2.totalCredits());
    }
}