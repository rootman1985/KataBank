package com.kata.bank.business.custom;

import java.util.HashMap;
import java.util.Map;

import com.kata.bank.business.custom.impl.IActionBank;
import com.kata.bank.entity.*;
import com.kata.bank.exception.AccountException;
import com.kata.bank.exception.CustomerException;

public class ActionBankImpl implements IActionBank{
    
    private Map<String, Customer> customers = new HashMap<String, Customer>();
    private Map<String, Account> accounts = new HashMap<String, Account>();
    
    public Customer createCostumer(String customerId, String name, String secretCode) throws CustomerException {
        if(customers.containsKey(customerId))
            throw new CustomerException("Technical problem : Costomer already exist please change the customerId : "+customerId);
        Customer customer =  new Customer(customerId, name, secretCode);
        customers.put(customerId, customer);
        return customer;
    }
    
    public Account createAccount(String customerId, String accountId, double balance, double overdraft) throws AccountException, CustomerException {
        if(accounts.containsKey(accountId))
            throw new AccountException("Technical problem : Account already exist please change the accountId : "+accountId);
        
        if(!customers.containsKey(customerId))
            throw new CustomerException("Technical problem : make sure the customer exists : "+customerId);
            
        Account account = new Account(accountId, balance, overdraft);
        
        Customer customer = customers.get(customerId);
        customer.setAccount(account);
        
        accounts.put(accountId, account);
        
        return account;
    }
    
    public DepositOperation deposit(String accountId, double amount) throws AccountException {
        if(!accounts.containsKey(accountId))
            throw new AccountException("Technical problem : make sure the acccount exists : "+accountId);
        
        DepositOperation depositOperation = new DepositOperation(amount);
        Account account = accounts.get(accountId);
        account.deposit(amount);
        account.addOperation(depositOperation);
        
        return depositOperation;
    }
    
    public WithdrawalOperation withdrawal(String accountId, double amount) throws AccountException {
        if(!accounts.containsKey(accountId))
            throw new AccountException("Technical problem : make sure the account exists : "+accountId);
        
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation(amount);
        Account account = accounts.get(accountId);
        account.withdrawal(amount);
        account.addOperation(withdrawalOperation);
        
        return withdrawalOperation;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    @Override
    public void operationsHistoryForCustomer(String customerId) throws CustomerException {
        if(!customers.containsKey(customerId))
            throw new CustomerException("Technical problem : make sure the customer exists : "+customerId);
        
        Customer customer = customers.get(customerId);
        
        Account account = customer.getAccount();
        if(account != null)
            printOperations(account);
    }

    @Override
    public void operationsHistoryForAccount(String accountId) throws AccountException {
        
        if(!accounts.containsKey(accountId))
            throw new AccountException("Technical problem : make sure the acccount exists : "+accountId);
        
        Account account = accounts.get(accountId);
        printOperations(account);
    }

    private void printOperations(Account account) {
        for(Operation operation : account.getOperations()){
            System.err.println(operation.toString()+" | Balance : "+account.getBalance());
        }
    }

}
