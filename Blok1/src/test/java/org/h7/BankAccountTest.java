package org.h7;

import h7h8.bank.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {


    private BankAccount target;


    @BeforeEach
    public void setup() {
        target = new BankAccount(1234);
        target.setBalance(100);
        target.setInterestRate(0.05);

    }


    @Test
    public void testBankAccount_Constructor_Completes() {
        assertEquals(1234, target.getAccountNumber());
    }

    @Test
    public void testWithdraw_EnoughBalance_ReturnsAmount(){
        assertEquals(target.withdraw(50), 50);
    }

    @Test
    public void testWithdraw_NotEnoughBalance_ReturnsZero(){
        assertEquals(target.withdraw(200),0);
    }

    @Test
    public void testDeposit_PositiveNumber_AmountIncreased(){
        target.deposit(100);
        assertEquals(target.getBalance(),200);
    }

    @Test
    public void testDeposit_NegativeNumber_AmountDecreased(){
        target.deposit(-50);
        assertEquals(target.getBalance(),50);
    }

    @Test
    public void testGetInterest(){
        assertEquals(target.getInterest(1), 100.05, 0);
    }

    @Test
    public void testToString(){
        assertEquals(target.toString(),"Account 1234 has balance: 100");
    }


}
