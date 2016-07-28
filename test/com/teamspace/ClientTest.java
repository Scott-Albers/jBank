package com.teamspace;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 7/28/16.
 */
public class ClientTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testConstructorName() throws Exception {

        Client c = new Client("Joe");
        assertEquals("Joe", c.getName());

    }



    @Test
    public void testAddingSavingsAccountToTheClient() throws Exception {

        Client c = new Client("Joe");
        Account a = c.openAccount(AccountType.SAVINGS);
        assertEquals(AccountType.SAVINGS, a.type);
        assertEquals(0f, a.getBalance(), 0.0);

    }


    @Test
    public void testClosingSavingsAccountToTheClient() throws Exception {

        Client c = new Client("Sally");
        Account a1 = c.openAccount(AccountType.SAVINGS);
        Account a2 = c.openAccount(AccountType.CHECKING);
        a1.deposit(50f);
        a2.deposit(250f);
        Account a3 = c.openAccount(AccountType.CHECKING);
        c.closeAccount(a3.getId());
        assertEquals(2, c.getAccounts().size());
        assertEquals(250f, c.getAccounts().get(2).getBalance(), 0.0);
        assertEquals(a2.getId(), c.getAccounts().get(2).getId() );
    }

}