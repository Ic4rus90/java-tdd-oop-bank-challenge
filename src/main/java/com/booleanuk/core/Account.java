package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
    protected int balance;
    protected ArrayList<Transaction> transactionHistory;
    protected boolean canOverdraft;
    protected Branch ownerBranch;

    public Account(Branch branch){
        this.ownerBranch = branch;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
        this.canOverdraft = false;
    }

    public int getBalance(){ return this.balance; }
    public ArrayList<Transaction> getTransactionHistory(){ return this.transactionHistory; }
    public boolean getCanOverdraft(){ return this.canOverdraft; }
    public Branch getOwnerBranch(){ return this.ownerBranch; }

    public void deposit(int amount){
        int currentBalance = calculateCurrentBalance();
        Transaction t = new Transaction(amount, currentBalance);
        this.transactionHistory.add(t);
    }

    public void withdraw(int amount){
        int currentBalance = calculateCurrentBalance();
        Transaction t = new Transaction(-amount, currentBalance);
        this.transactionHistory.add(t);
    }

    public int calculateCurrentBalance(){
        int currentBalance = 0;

        for (Transaction t : this.transactionHistory){
            currentBalance += t.getAmount();
        }
        return currentBalance;
    }
}
