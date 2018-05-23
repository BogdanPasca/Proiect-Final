package entities.account.type;

import entities.account.Account;
import entities.account.AccountType;

public class Depozit extends Account {

        public Depozit(int numarCont, double depozitInitial) {
        super(numarCont);
        this.setSold(depozitInitial);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Depozit;
    }
}
