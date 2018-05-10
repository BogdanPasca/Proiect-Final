package com.bogdan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bank implements Serializable {

    private DbService database = new DbService();

    Customer openAccount(String firstName, String lastName, String cnp, AccountType type, Double balance) {
        int accountId = database.addAccount(firstName, lastName, cnp, type, balance);
        Customer customer = database.getAccount(accountId);
        return customer;
    }

    boolean closeAccount(int accountId) {
        return database.deleteAccount(accountId);
    }

    Customer getCustomer(int accountId) {
        return database.getAccount(accountId);
    }

    ArrayList<Customer> getCustomers() {
        return database.getAllAccounts();
    }

    void withdraw(int accountId, double amount) throws InsufficientFundsException {
        Customer customer = getCustomer(accountId);
        double transactionFee = getTransactionFee(customer.getAccount().getAccountType());
        if (amount + transactionFee > customer.getAccount().getBalance()) {
            throw new InsufficientFundsException();
        }
        double newBalance = customer.getAccount().getBalance() - (amount + transactionFee);
        database.updateAccount(accountId, newBalance);
    }

    void deposit(int accountId, double amount) throws InvalidAmountException {
        Customer customer = getCustomer(accountId);
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        double interest = checkInterest(customer.getAccount().getBalance(), amount);
        double amountToDeposit = amount + (amount * interest);
        database.updateAccount(accountId, customer.getAccount().getBalance() + amountToDeposit);
    }

    public double checkInterest(double balance, double amount) {
        double interest = 0;
        if (balance + amount > 10000) {
            interest = 0.05;
        } else {
            interest = 0.02;
        }
        return interest;
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    double getTransactionFee(AccountType accountType) {
        double transactionFee = 0;
        switch (accountType) {
            case Depozit:
                transactionFee = 5;
                break;
            case Economii:
                transactionFee = 3;
                break;
            case Undefined:
            default:
                transactionFee = 0;
        }
        return transactionFee;
    }

}
