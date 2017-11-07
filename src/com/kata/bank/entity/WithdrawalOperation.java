package com.kata.bank.entity;

/**
 * @author rootman
 *
 */
public class WithdrawalOperation extends Operation {

    private double amountWithdrawal;

    public WithdrawalOperation() {
        super();
    }

    public WithdrawalOperation(double amountWithdrawal) {
        super();
        this.amountWithdrawal = amountWithdrawal;
    }

    public double getAmountWithdrawal() {
        return amountWithdrawal;
    }

    public void setAmountWithdrawal(double amountWithdrawal) {
        this.amountWithdrawal = amountWithdrawal;
    }

    @Override
    public String toString() {
        return "Operation Type : Withdrawal | Date : " + super.getOperationDate() + " | Amount : " + amountWithdrawal;
    }

}
