package h7h8.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<>();
    private long id = 10L;
    private String name;

    public Bank() {

    }

    public Bank(String name) {
        this(name,0,null);
    }

    public Bank(long id) {
        this("", id,null);
    }

    public Bank(String name, long id){
        this(name, id, null);
    }

    public Bank(String name, long id, List<BankAccount> accounts){
        this.name = name;
        this.id = id;
        this.accounts = accounts;
    }

    public BankAccount search(long nr) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == nr) {
                return account;
            }
        }

        throw new AccountNotFoundException("Account met nummer " + nr + " is niet gevonden!");
    }

    public void addAccount(BankAccount a) {
        this.accounts.add(a);
    }

    public void addAccounts(List<BankAccount> list){
        for (BankAccount account : list){
            addAccount(account);
        }
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        if (from.withdraw(amount) > 0) {
            to.deposit(amount);
        }
    }

    public String accountsToString() {
        StringBuilder sb = new StringBuilder();

        for (BankAccount account : accounts) {
            sb.append(account).append("\n");
        }
        sb.append("Total is: ");
        sb.append(getTotal());

        return sb.toString();
    }

    public long getTotal() {
        long total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    @Override
    public String toString(){
        return ("Name: "+this.name+", Id: "+this.id+".");
    }

}

