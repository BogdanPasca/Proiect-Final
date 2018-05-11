package com.bogdan;

public class Checking extends Account {

    Checking(int numarCont, double depozitInitial) {
        super(numarCont);
        this.setSold(depozitInitial);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Depozit;
    }
}
