package com.bogdan;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bank{

    private DbService database = new DbService();

    Client deschideCont(String prenume, String nume, String cnp, AccountType type, Double sold) {
        int accountId = database.addAccount(prenume, nume, cnp, type, sold);
        Client client = database.getAccount(accountId);
        return client;
    }

    boolean stergeCont(int accountId) {
        return database.deleteAccount(accountId);
    }

    Client getClient(int accountId) {
        return database.getAccount(accountId);
    }

    ArrayList<Client> getClienti() {
        return database.getAllAccounts();
    }

    void retrageBani(int accountId, double suma) throws FonduriInsuficienteException {
        Client client = getClient(accountId);
        double comisionTranzactie = getComision(client.getCont().getAccountType());
        if (suma + comisionTranzactie > client.getCont().getSold()) {
            throw new FonduriInsuficienteException();
        }
        double noulSold = client.getCont().getSold() - (suma + comisionTranzactie);
        database.updateAccount(accountId, noulSold);
    }

    void adaugaBani(int accountId, double suma) throws InvalidAmountException {
        Client client = getClient(accountId);
        if (suma <= 0) {
            throw new InvalidAmountException();
        }
        double dobanda = verificaDobanda(client.getCont().getSold(), suma);
        double amountToDeposit = suma + (suma * dobanda);
        database.updateAccount(accountId, client.getCont().getSold() + amountToDeposit);
    }

    public double verificaDobanda(double balance, double amount) {
        double dobanda = 0;
        if (balance + amount > 10000) {
            dobanda = 0.05;
        } else {
            dobanda = 0.02;
        }
        return dobanda;
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    double getComision(AccountType accountType) {
        double comision = 0;
        switch (accountType) {
            case Depozit:
                comision = 5;
                break;
            case Economii:
                comision = 3;
                break;
            case Undefined:
            default:
                comision = 0;
        }
        return comision;
    }

}
