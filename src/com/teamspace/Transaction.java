package com.teamspace;

import java.util.Date;

/**
 * Created by localadmin on 7/28/16.
 */
public class Transaction {
    String id;
    Date date;
    float amount;
    TransactionType type;

    public Transaction(float amount, TransactionType transType) {
//        Random rand = new Random();
        this.amount = amount;
        this.type = transType;
        this.id = "123";
//        this.id = String.valueOf(Math.abs(rand.nextLong()));
        this.date = new Date();
    }


    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}

