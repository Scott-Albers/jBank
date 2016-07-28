package com.teamspace;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 7/28/16.
 */
public class AccountTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstructorWithAccountType() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        assertNotNull(a.getId());
        assertEquals(AccountType.SAVINGS, a.getType());
        assertEquals(0f, a.getBalance(), 0.0);
        assertFalse(a.isClosed());
        assertNotNull(a.getTransactions());

    }

    @Test
    public void testAccountToString() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        // check to see that it contains: "amount=50.0, type=DEPOSIT"
        // Assert.assertTrue(x.contains("foo"));
        assertTrue(a.toString().contains("type=SAVINGS, balance=0.0"));
        assertThat(a.toString(), CoreMatchers.containsString("type=SAVINGS, balance=0.0"));
    }

    @Test
    public void testAccountDepositWtihAmount() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        assertTrue(a.getTransactions().size() == 0);
        a.deposit(100f);
        assertEquals(100f, a.getBalance(), 0.0);
        assertTrue(a.getTransactions().size() == 1);
    }

    @Test
    public void testAccountDepositWtihNegativeAmount() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        a.deposit(-100f);
        assertEquals(0f, a.getBalance(), 0.0);
    }

    @Test
    public void testAccountWithdrawWtihAmount() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        assertTrue(a.getTransactions().size() == 0);
        a.deposit(100f);
        assertEquals(100f, a.getBalance(), 0.0);

        assertTrue(a.getTransactions().size() == 1);
        assertEquals(1, a.getTransactions().size());

        a.withdraw(50f);
        assertEquals(50f, a.getBalance(), 0.0);
        assertTrue(a.getTransactions().size() == 2);
    }


    @Test
    public void testAccountWithdrawWithNotEnoughFunds() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        a.deposit(100f);
        a.withdraw(101f);
        assertEquals(50f, a.getBalance(), 0.0);
        assertTrue(a.getTransactions().size() == 2);
        assertEquals(TransactionType.FEE, a.getTransactions().get(1).getType());
    }



    @Test
    public void testAccountAccountClosed() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        a.deposit(100f);
        a.withdraw(101f);
        a.withdraw(101f);
        a.withdraw(101f);
        a.withdraw(101f);
        assertTrue(a.isClosed);
        assertEquals(TransactionType.FEE, a.getTransactions().get(1).getType());
        assertEquals(TransactionType.FEE, a.getTransactions().get(2).getType());
        assertEquals(TransactionType.FEE, a.getTransactions().get(3).getType());
        assertEquals(TransactionType.FEE, a.getTransactions().get(4).getType());
    }


    @Test
    public void testAccountFilterByFee() throws Exception {

        Account a = new Account(AccountType.SAVINGS);
        a.deposit(100f);
        a.withdraw(101f);
        a.withdraw(101f);
        a.withdraw(101f);
        a.withdraw(101f);
        Float[] fees2 = a.filterTransactions(TransactionType.FEE);
        int s = fees2.length;
        int c = 4;
        assertEquals(4, a.filterTransactions(TransactionType.FEE).length);

        //Float[] fees = new Float{50f, 50f, 50f, 50f};


        //assertEquals(fees, a.filterTransactions(TransactionType.FEE));
        //assertEquals(50f, a.filterTransactions(TransactionType.FEE)[0].floatValue());


    }

}