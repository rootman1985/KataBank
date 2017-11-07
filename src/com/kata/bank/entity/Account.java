package com.kata.bank.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rootman
 *
 */
public class Account {
    
    private String accountId;
    private double balance;
    private double overdraft;
    private Customer customer;
    private Set<Operation> operations = new HashSet<Operation>();

    public Account() {}

    public Account(String accountId, double balance, double overdraft) {
        this.accountId = accountId;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(Operation op) {
        operations.add(op);
        op.setAccount(this);
    }
    
    public void deposit (double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", balance=" + balance + ", overdraft=" + overdraft + "]";
    }
}
