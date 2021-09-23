package h7h8.bank;

public class BankAccount {
    private long accountNumber;
    private int balance;
    private double interestRate;

    public BankAccount(long id) {
        this.accountNumber = id;
    }

    public int withdraw(int amount) {
        if (this.getBalance() - amount > 0) {
            setBalance(-amount); // dit is verwarrend; bij een setter is het gebruikelijk c.q. te verwachten dat je een waarde overschrijft, maar jij gaat hem bijwerken
                                 // je zu dan beter, naast de normale setter, een nieuwe methode kunnen maken, bijv. updateBalance(..)
            return amount;
        } else {
            return 0; // is 0 wel een goede "foutcode"? wat nou als je 100 euro opneemt terwijl je balance 100 was?
        }
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return balance * Math.pow(1 + interestRate / 100, years);
    }

    @Override
    public String toString() {
        return "Account " + accountNumber + " has balance: " + balance;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount){
       balance = getBalance() + amount;
    }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

}
