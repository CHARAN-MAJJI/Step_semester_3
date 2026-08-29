class Account {
    String regNo;
    double totalFee;

    Account(String r, double f) {
        regNo = r;
        totalFee = f;
    }

    final double calculateLateFee(int daysLate) {
        return totalFee * daysLate / 100;
    }

    final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            System.out.println(regNo + " | Total Fee: Rs " + totalFee
                    + " | Late Fee: Rs " + calculateLateFee(daysLate));
        }
    }
}

public class M3 {
    public static void main(String[] args) {

        Account[] a = {
            new Account("RA001", 200000),
            new Account("RA002", 150000),
            new Account("RA003", 180000),
            new Account("RA004", 220000)
        };

        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < a.length; i++)
            a[i].printSummary(daysLate[i]);
    }
}