package com.teamspace;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by localadmin on 7/28/16.
 */
public class Client {
    String id;
    String name;
    boolean isActive;
    ArrayList<Account> accounts;

    public Client(String name) {
        this.name = name;
        Random rand = new Random();
        this.id = String.valueOf(Math.abs(rand.nextLong()));
        isActive = true;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account openAccount(AccountType type) {
        Account a = new Account(type);
        this.accounts.add(a);
        return a;
    }

    public void closeAccount(string id) {


       }

    }

}
