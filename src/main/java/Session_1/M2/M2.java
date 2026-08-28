class MessWallet {
    private double balance;
    MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Invalid Balance");
        } else {
            this.balance = balance;
        }
    }
    void topup(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else {
            balance = balance + amount;
        }
    }
    void deduct(double amount) {
        if (amount >balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
        }
    }
    double getBalance(){
        return balance;
    }
}
public class M2{
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(1000);
        System.out.println("Initial Balance: " + wallet.getBalance());
        wallet.topup(500);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(200);
        System.out.println("Balance after deduction: " + wallet.getBalance());
        wallet.deduct(1500); 
        System.out.println("Final Balance: " + wallet.getBalance());
    }
}
