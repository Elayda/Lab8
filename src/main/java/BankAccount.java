import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * Class implementing a bank account.
 * <p>
 * Complete and document this class as part of Lab 8.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
public class BankAccount {

    /*
     * You may want to use this to distinguish between different kinds of accounts.
     */
    /**
     * This is the way we can call a bank account base don its desired usage.
     */
    public enum BankAccountType {
        /**
         * Should be used for credit cards and common transactions.
         */
        CHECKINGS,
        /**
         * Keep money here to get pretty ok interest.
         */
        SAVINGS,
        /**
         * Put your money here if you are crying from student debt.
         */
        STUDENT,
        /**
         * If your a megacorp put your money her and laugh cruelly.
         */
        WORKPLACE
    }
    /** This is the identifier for an account. */
    private int accountNumber;
    /** This is the designated account type which can be changed from outside the accessor. */
    public BankAccountType accountType;
    /** This is how much money a person has. */
    private double accountBalance;
    /** This is who owns an account. */
    private String ownerName;
    /** This is who owned an account. */
    private String ownerHistory;
    /** How much interest a person earns. */
    public double interestRate;
    /** This is how much earned interestn an accont holds. */
    private double interestEarned;
        /**
     * @param name The person who will own the account.
     * @param accountCategory What type of account are they making
     */
    public BankAccount(final String name, final BankAccountType accountCategory) {
        /*
         * Implement this function
         */
        ownerName = name;
        ownerHistory = "";
        accountType = accountCategory;
        Bank.totalAccounts += 1;
        accountNumber = Bank.totalAccounts;
        accountBalance = 0.0;
        interestRate = 1.0;
        interestEarned = 0.0;
        System.out.println("New Account Created!");

    }

    /*
     * Implement getters and setters as appropriate for private variables.
     */
    /**
     * Finds out the balance of an account.
     *
     * @return The balance of the account
     */
    public double getMoney() {
        return this.accountBalance;
    }
    /**
     * Finds out the balance of an account.
     *
     * @return The balance of the account
     */
    public double getInterest() {
        return this.interestRate;
    }
    /**
     * Finds out the balance of an account.
     *
     * @return The balance of the account
     */
    public double getInterestEarned() {
        return this.interestEarned;
    }
    /**
     * Finds out the balance of an account.
     *
     * @return The balance of the account
     */
    public String getName() {
        return this.ownerName;
    }
    /**
     * This lets you figure out how many accounts there are and the number of the next account to be
     * created.
     *
     * @return The total number of accounts made
     */

    /**
     * This tells you the account number for a given account.
     *
     * @return The given accounts account number
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }
    /**
     * This adds money to an account.
     * @param deposit This is the amount being deposited
     */
    public void depositMoney(final double deposit) {
        this.accountBalance += deposit;
    }
    /**
     * This takes money from an account.
     * @param withdraw The amount being taken.
     */
    public void withdrawMoney(final double withdraw) {
        this.accountBalance -= withdraw;
    }
    /**
     * Change an account to a new owner.
     * @param newOwner The new owner of an account
     */
    public void setOwner(final String newOwner) {
        this.ownerHistory += this.ownerName + "\n";
        this.ownerName = newOwner;

    }

}