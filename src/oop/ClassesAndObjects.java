

/**
 * Classes and objects: fields hold an object's state and methods define its
 * behaviour. The BankAccount class also demonstrates encapsulation by keeping
 * its fields private and validating all changes through methods.
 */
public class ClassesAndObjects {

    private static class BankAccount {
        private final String owner;
        private double balance;

        BankAccount(String owner, double openingBalance) {
            if (openingBalance < 0) {
                throw new IllegalArgumentException("Opening balance cannot be negative");
            }
            this.owner = owner;
            this.balance = openingBalance;
        }

        public void deposit(double amount) {
            validatePositiveAmount(amount);
            balance += amount;
        }

        public boolean withdraw(double amount) {
            validatePositiveAmount(amount);
            if (amount > balance) {
                return false;
            }
            balance -= amount;
            return true;
        }

        public double getBalance() {
            return balance;
        }

        public String getOwner() {
            return owner;
        }

        private void validatePositiveAmount(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
        }
    }

    public static void main(String[] args) {
        // Each new expression creates a separate BankAccount object.
        BankAccount tharunAccount = new BankAccount("Tharun", 1_000);
        BankAccount savingsAccount = new BankAccount("Savings", 500);

        tharunAccount.deposit(250);
        boolean paymentSucceeded = tharunAccount.withdraw(400);

        System.out.println(tharunAccount.getOwner() + " balance: "
                + tharunAccount.getBalance());
        System.out.println("Payment succeeded: " + paymentSucceeded);
        System.out.println(savingsAccount.getOwner() + " balance: "
                + savingsAccount.getBalance());
    }
}
