package com.bogdan;

public class Savings extends Account {

    Savings(int accountNumber, double initialDeposit) {
        super(accountNumber);
        this.setSold(initialDeposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Economii;
    }
}
