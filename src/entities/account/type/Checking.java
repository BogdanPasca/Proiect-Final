package entities.account.type;

import entities.account.Account;
import entities.account.AccountType;

public class Checking extends Account {

        public Checking(int numarCont, double depozitInitial) {
        super(numarCont);
        this.setSold(depozitInitial);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Depozit;
    }
}
