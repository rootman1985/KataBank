package com.kata.bank.entity;


/**
 * @author rootman
 *
 */
public class Customer {

    private String customerId;
    private String name;
    private String secretCode;
    private Account account;

    public Customer() {}

    public Customer(String customerId, String name, String secretCode) {
        this.customerId = customerId;
        this.name = name;
        this.secretCode = secretCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        account.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", secretCode=" + secretCode +"]";
    }

}
