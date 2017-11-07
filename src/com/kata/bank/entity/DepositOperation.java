package com.kata.bank.entity;

/**
 * @author rootman
 *
 */
public class DepositOperation extends Operation {

    private double amountDeposit;

    public DepositOperation() {
        super();
    }

    public DepositOperation(double amountDeposit) {
        super();
        this.amountDeposit = amountDeposit;
    }

    public double getAmountDeposit() {
        return amountDeposit;
    }

    public void setAmountDeposit(double amountDeposit) {
        this.amountDeposit = amountDeposit;
    }

    @Override
    public String toString() {
        return "Operation Type : Deposit | Date : " + super.getOperationDate() + " | amount : " + amountDeposit;
    }
}
