package com.teamspace;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by localadmin on 7/28/16.
 */
public class Account {

    String id;
    AccountType type;
    Float balance;
    boolean isClosed;
    ArrayList<Transaction> transactions;
    int overDraftCount;

    public Account(AccountType type) {
        this.type = type;
        Random rand = new Random();
        this.id = String.valueOf(Math.abs(rand.nextLong()));
        this.balance = 0f;
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public AccountType getType() {
        return type;
    }

    public Float getBalance() {
        return balance;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }


    public void deposit(float amount) {

        if (amount < 0 ) return;

        this.balance += amount;
        this.transactions.add(new Transaction(amount, TransactionType.DEPOSIT ));

    }

    public void withdraw(float amount)  {

        if (amount < 0 || this.isClosed ) return;

        if (amount > this.balance) {
            this.overDraftCount++;
            this.balance -= 50f;
            this.transactions.add(new Transaction(50f, TransactionType.FEE ));
            this.isClosed = this.overDraftCount > 3;
            return;
        }

        this.balance -= amount;
        this.transactions.add(new Transaction(amount, TransactionType.WITHDRAW ));

    }

    public Float[] filterTransactions(TransactionType type)  {

       // ArrayList<Transaction> t2 = this.transactions.stream().filter(t -> t.getType() == type).to(Transaction[]::new)
       Float[] amounts = this.transactions.stream().filter(t -> t.getType() == type).map(t -> t.getAmount())
               .toArray(size -> new Float[size]);
        return amounts;

//        Float[] amounts = stocks.stream().map(stock -> stock.getShares() * stock.getPrice())
//                .toArray(size -> new Float[size]);

    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                ", isClosed=" + isClosed +
                ", transactions=" + transactions +
                '}';
    }
}
