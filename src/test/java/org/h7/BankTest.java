package org.h7;


import h7h8.bank.AccountNotFoundException;
import h7h8.bank.Bank;
import h7h8.bank.BankAccount;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    public Bank bank;

    @Before
    public void setup() {
        bank = new Bank("Rabobank");
        for (int i = 0; i < 10; i++) {
            BankAccount account = new BankAccount(i);
            account.setBalance(100);
            bank.addAccount(account);
        }
    }

    @Test
    public void testSearch_AccountFound_ReturnsId() {
        assertEquals(1, bank.search(1).getAccountNumber());
    }

    @Test(expected = AccountNotFoundException.class)
    public void testSearch_AccountNotFound_ThrowsException(){
        bank.search(11);
    }

    @Test
    public void testTransfer_Valid_Completes(){
        bank.transfer(bank.search(1), bank.search(2), 50);
        assertEquals(bank.search(1).getBalance(),50);
        assertEquals(bank.search(2).getBalance(),150);
    }

}
