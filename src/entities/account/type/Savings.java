package entities.account.type;

import entities.account.Account;
import entities.account.AccountType;

public class Savings extends Account {

    public Savings(int accountNumber, double initialDeposit) {
        super(accountNumber);
        this.setSold(initialDeposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Economii;
    }
}
