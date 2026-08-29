class Payment {
    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends Payment {
    void payWithProcessingFee(double amount) {
        double total = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
        A5.totalCollected += total;
    }
}

public class A5 {
    static double totalCollected = 0;

    static void processTransaction(Payment p, double amount) {

        if (p instanceof CardPayment) {
            ((CardPayment) p).payWithProcessingFee(amount);
        } else {
            p.pay(amount);
            totalCollected += amount;
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        for (int i = 0; i < payments.length; i++)
            processTransaction(payments[i], amounts[i]);

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}