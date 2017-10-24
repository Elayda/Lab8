
/**
 * Implement a bank class.
 * <p>
 * In this lab we will model a bank. We have two classes: Bank and BankAccount. You should finish
 * both classes, by fixing checkstyle errors, defining constructors, getters and setters, and
 * accessing private variables.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
/**
 * This is creating the bank which will hold our functionality.
 */
public class Bank {
    /**
     * This is the name of our bank which MUST be attached to all of the accounts.
     */
    public String bankName;
    /**
     * This is the default constructor.
     */
    public Bank() {
        bankName = "Illini Bank";
    }

    /**
     * Withdraw money from an account.
     * <p>
     * Subtracts the amount of money from bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to withdraw money from.
     * @param amount to withdraw (double)
     * @return boolean
     */
    public boolean withdrawMoney(final BankAccount bankAccount, final double amount) {
        /*
         * Implement this function
         */
        if ((bankAccount.getMoney() - amount) > 0) {
            bankAccount.withdrawMoney(amount);
            System.out.println(
                    "New Balance after withdrawal from account " + bankAccount.getAccountNumber()
                            + " :" + bankAccount.getMoney());
            return true;
        }
        System.out.println(bankAccount.getAccountNumber()
                + "Does not have enough money to perform this action.");
        return false;

    }

    /**
     * Deposit money in an account.
     * <p>
     * Adds the amount of money to bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to deposit money to.
     * @param amount to deposit
     * @return boolean regarding success or failure.
     */
    public boolean depositMoney(final BankAccount bankAccount, final double amount) {
        /*
         * Implement this function
         */
        bankAccount.depositMoney(amount);
        System.out.println("New Balance after deposit into account " + bankAccount.getAccountNumber()
                + " :" + bankAccount.getMoney());
        return true;
    }

    /**
     * Transfer money from one account to another.
     * <p>
     * Transfer the amount of money from one back account to another. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param source bank account to transfer money from.
     * @param destination bank account to transfer money to.
     * @param amount to transfer
     * @return boolean
     */

    public boolean transferMoney(final BankAccount source, final BankAccount destination,
            final double amount) {
        /*
         * Implement this function
         */
        if ((source.getMoney() - amount) > 0) {
            source.withdrawMoney(amount);
            destination.depositMoney(amount);
            System.out.println("New Balance after transfer out account " + source.getAccountNumber()
                    + " :" + source.getMoney());
            System.out.println(
                    "New Balance after transfer into account " + destination.getAccountNumber()
                            + " :" + destination.getMoney());
            return true;
        } else {
            System.out.println(source.getAccountNumber()
                    + "Does not have enough money to perform this action.");
            return false;
        }
    }

    /**
     * Change back account owner name.
     *
     * @param bankAccount to change
     * @param name new name to set
     */

    public void changeOwnerName(final BankAccount bankAccount, final String name) {
        /*
         * Implement this function
         */
        bankAccount.setOwner(name);
    }
    /** Declaring the number of accounts. This will be interfaced */
    public static int totalAccounts = 0;
    /**
     * Uses static variable to get number of bank accounts opened.
     *
     * @return the total number of accounts at the bank
     */
    public static int getNumberOfAccount() {
        /*
         * Implement this function
         */
        return totalAccounts;
    }

    /**
     * Main method for testing.
     *
     * @param unused unused input arguments
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(final String[] unused) {
        Bank bank = new Bank();
        System.out.println("Welcome to " + bank.bankName);
        System.out.println("We are excited to have you banking with us!\n\n");

        // Create Bank Accounts
        BankAccount account1 = new BankAccount("John Doe", BankAccount.BankAccountType.CHECKINGS);
        System.out.println("Bank account for John Doe created");

        BankAccount account2 = new BankAccount("Jony Ive", BankAccount.BankAccountType.STUDENT);
        System.out.println("Bank account for Johy Ive created\n\n");

        // Deposit money to both accounts and print new balance
        bank.depositMoney(account1, 1000.0);
        bank.depositMoney(account2, 5000.0);

        // Withdraw money from Account 2 and print new balance
        bank.withdrawMoney(account2, 200.0);

        // Transfer money from Account 2 to Account 1 and print new balances
        bank.transferMoney(account2, account1, 350.0);

        // Print number of accounts
        System.out.print("Number of active accounts at " + bank.bankName + " are ");
        System.out.println(Bank.totalAccounts);
    }
}
