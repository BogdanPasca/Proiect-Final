package Logins;

class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Nu aveți suficiente fonduri pentru a putea finaliza tranzacția.");
    }
}
