package com.kata.bank.business.custom.impl;

import java.util.Map;

import com.kata.bank.entity.Account;
import com.kata.bank.entity.Customer;
import com.kata.bank.entity.DepositOperation;
import com.kata.bank.entity.WithdrawalOperation;
import com.kata.bank.exception.AccountException;
import com.kata.bank.exception.CustomerException;

public interface IActionBank {
    
    public Customer createCostumer(String customerId, String name, String secretCode) throws CustomerException;
    
    public Account createAccount(String customerId, String accountId, double balance, double overdraft) throws AccountException, CustomerException;
    
    public DepositOperation deposit(String accountId, double amount) throws AccountException;
    
    public WithdrawalOperation withdrawal(String accountId, double amount) throws AccountException;
    
    public Map<String, Customer> getCustomers();
    
    public Map<String, Account> getAccounts();
    
    public void operationsHistoryForCustomer(String customerId) throws CustomerException;
    
    public void operationsHistoryForAccount(String accountId) throws AccountException;

}
