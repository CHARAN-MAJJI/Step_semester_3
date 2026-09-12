class MessWallet {
    private double balance;

    MessWallet(double b) {
        balance = b < 0 ? 0 : b;
    }

    void topUp(double a) {
        if (a > 0)
            balance += a;
        else
            System.out.println("Top-up rejected");
    }

    void deduct(double a) {
        if (a <= balance)
            balance -= a;
        else
            System.out.println("Deduct rejected: insufficient balance");
    }

    double getBalance() {
        return balance;
    }
}

public class M2 {
    public static void main(String[] args) {
        MessWallet w = new MessWallet(500);

        w.topUp(200);
        w.deduct(1000);

        System.out.println("Final balance: " + w.getBalance());
    }
}