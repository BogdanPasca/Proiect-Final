package entities;

import entities.account.Account;
import entities.account.AccountType;
import entities.account.AccountType;
import design.MeniuAdaugaCont;

public class Client {

    private final String prenume;
    private final String nume;
    private final String cnp;
    private final Account cont;

    public Client(String prenume, String nume, String cnp, Account account) {  //aici am modificat public
        this.prenume = prenume;
        this.nume = nume;
        this.cnp = cnp;
        this.cont = account;
    }

    @Override
    public String toString() {
        return "\nCustomer Information\n"
                + "Prenume: " + getPrenume() + "\n"
                + "Nume: " + getNume() + "\n"
                + "CNP: " + getCnp() + "\n"
                + cont;
    }

    public String basicInfo() {
        return " Account Number: " + cont.getNumarCont() + " - Nume: " + getPrenume() + " " + getNume();
    }

    public Account getCont() {
        return cont;
    }

    public String getPrenume() {  //aici am pus public
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

}
