package h7h8.bank;

import java.util.ArrayList;
import java.util.List;

public class BankApp {

    public void start() {
        Bank bank = new Bank("Rabobank", 1, null);
        System.out.println(bank.toString());
//        List<BankAccount> list = createAccounts(10);
//        bank.addAccounts(list);
//        System.out.println(bank.toString());



    }

    public List<BankAccount> createAccounts(int amount){
        List<BankAccount> accounts = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            BankAccount account = new BankAccount(i);
            account.setBalance(100);
            accounts.add(account);
        }
        return accounts;
    }

}
