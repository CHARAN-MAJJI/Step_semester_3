class FeeAccount {
    void processPayment(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    void processPayment(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class M5 {

    static int hostel = 0;
    static int dayScholar = 0;

    static void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {
            ((HostelFeeAccount) account).processPayment(amount);
            hostel++;
        } else {
            account.processPayment(amount);
            dayScholar++;
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        for (FeeAccount a : accounts)
            processPayment(a, 60000);

        System.out.println("Hostel accounts processed: " + hostel
                + " | Day-scholar accounts processed: " + dayScholar);
    }
}