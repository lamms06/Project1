package h7h8.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<>();
    private long id = 10L;
    private String name;

    public Bank() {

    }

    public Bank(String name) {
        this(name, 0, new ArrayList<>());
    } // code layout (spaties etc.)

    public Bank(long id) {
        this("", id, new ArrayList<>());
    }

    public Bank(String name, long id) {
        this(name, id, new ArrayList<>());
    }

    public Bank(String name, long id, List<BankAccount> accounts) {
        this.name = name;
        this.id = id;
        this.accounts = accounts;
    }

    private Map<Long, BankAccount> accounts2 = new HashMap<>();

    public BankAccount search(long nr) throws AccountNotFoundException {
        // tip: als je vaak zoekt op een specifiek veld kun je ipv een arraylist ook een map gebruiken;
        // een map is een soort tabel met een key en een value en heeft een zoekfunctie (get):
        // private Map<Long, BankAccount> accounts = new HashMap<>();
        // BankAccount bankAccount = accounts.get(nr);
        // dit is ook lekker snel,omdat de hashmap als key een hashcode gebruikt die snel gevonden kan worden.
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == nr) {
                return account;
            }
        }

        throw new AccountNotFoundException("AccountNotFound: " + nr);

        // ook zou je dit met een stream kunnen doen:
        // accounts.stream()
        //         .filter(a -> a.getAccountNumber() == nr)
        //         .findFirst()
        //         .orElseThrow(() -> new AccountNotFoundException("AccountNotFound: " + nr));
    }

    public void addAccount(BankAccount a) {
        this.accounts.add(a);
    }

    public void addAccounts(List<BankAccount> list) {
        this.accounts.addAll(list);
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
    public String toString() {
        return ("Name: " + name + ", Id: " + id + ", Accounts: " + accounts.size() + ", Details: " + "\n" + accountsToString());
    }

}

