class Employee {
    String id;
    double salary;

    Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary += salary;
    }

    void display() {
        System.out.println(id + " | Final Salary: Rs " + salary);
    }
}

public class M2 {
    public static void main(String[] args) {

        Employee[] e = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        for (Employee x : e) {
            x.raiseSalary(5000);
            x.display();
        }
    }
}