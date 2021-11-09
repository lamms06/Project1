package org.h7;


import h7h8.bank.AccountNotFoundException;
import h7h8.bank.Bank;
import h7h8.bank.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    public Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank("Rabobank");
        for (int i = 1; i <= 2; i++) {
            BankAccount account = new BankAccount(i);
            account.setBalance(100);
            bank.addAccount(account);
        }
    }

    @Test
    public void testSearch_AccountFound_ReturnsId() {
        assertEquals(1, bank.search(1).getAccountNumber());
    }

    @Test
    public void testSearch_AccountNotFound_ThrowsException(){
        assertThrows(AccountNotFoundException.class, ()-> bank.search(11));
    }

    @Test
    public void testTransfer_Valid_Completes(){
        bank.transfer(bank.search(1), bank.search(2), 50);
        assertEquals(bank.search(1).getBalance(),50);
        assertEquals(bank.search(2).getBalance(),150);
    }

    @Test
    public void testTransfer_InsufficientAmount_DoesNotComplete(){
        bank.transfer(bank.search(1), bank.search(2), 150);
        assertEquals(bank.search(1).getBalance(),100);
        assertEquals(bank.search(2).getBalance(),100);
    }

    @Test
    public void testTransfer_NegativeAmount_PrintsMoneyAparently(){
        bank.transfer(bank.search(1), bank.search(2), -50);
        assertEquals(bank.search(1).getBalance(),150);
        assertEquals(bank.search(2).getBalance(),100);
    }

    @Test
    public void testGetTotal(){
        assertEquals(bank.getTotal(),200);
    }

    @Test
    public void testAccountsToString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Account 1 has balance: 100");
        sb.append("\n");
        sb.append("Account 2 has balance: 100");
        sb.append("\n");
        sb.append("Total is: 200");
        String expectedString = sb.toString();
        assertEquals(bank.accountsToString(),expectedString);
    }

}
