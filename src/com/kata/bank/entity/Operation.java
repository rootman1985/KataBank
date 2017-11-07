package com.kata.bank.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rootman
 *
 */
public abstract class Operation {
    
    public static final DateFormat DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");

    private String idOperation;

    private Date operationDate;

    private Account account;

    public Operation() {
        this.idOperation = String.valueOf(System.currentTimeMillis());
        this.operationDate = new Date();
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public String getOperationDate() {
        return DD_MM_YYYY.format(operationDate);
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
