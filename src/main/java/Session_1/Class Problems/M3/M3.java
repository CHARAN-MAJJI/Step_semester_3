class Course {
    String code;
    String title;
    int credits;
    int labCredits;
    Course(String code, String title, int credits, int labCredits){
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }
    Course(String code, String title, int credits){
        this(code, title, credits,0);
    }
    int totalCredits(){
        return credits + labCredits;
    }
}
public class M3 {
    public static void main(String[] args){
        Course c1 = new Course("CS101", "Introduction to Programming", 3);
        Course c2 = new Course("CS102", "Data Structures", 3, 9);
        System.out.println("Course 1: " + c1.code + " - " + c1.title + ", Total Credits: " + c1.totalCredits());
        System.out.println("Course 2: " + c2.code + " - " + c2.title + ", Total Credits: " + c2.totalCredits());    
    }
}
