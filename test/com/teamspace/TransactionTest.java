package com.teamspace;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 7/28/16.
 */
public class TransactionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstructorWithAmountAndType() throws Exception {

        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertNotNull(t.getId());
        assertNotNull(t.getDate());
        assertEquals(50f, t.getAmount(), 0.0);
        assertEquals(TransactionType.DEPOSIT, t.getType());
    }


    @Test
    public void testTransactionToString() throws Exception {

        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        // check to see that it contains: "amount=50.0, type=DEPOSIT"
        // Assert.assertTrue(x.contains("foo"));
        assertTrue(t.toString().contains("amount=50.0, type=DEPOSIT"));
        assertThat(t.toString(), CoreMatchers.containsString("amount=50.0, type=DEPOSIT"));
    }

}