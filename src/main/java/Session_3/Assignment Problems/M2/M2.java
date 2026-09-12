class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double salary) {
        basicSalary = salary < 0 ? 0 : salary;
    }

    void creditBonus(double amount) {
        if (amount > 0) {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        } else {
            System.out.println("Bonus rejected");
        }
    }

    void deductTax(double percent) {
        if (percent >= 0 && percent <= 100) {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        } else {
            System.out.println("Invalid tax percentage");
        }
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class M2 {
    public static void main(String[] args) {

        PayrollAccount p = new PayrollAccount(50000);

        p.creditBonus(5000);
        p.deductTax(10);

        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}