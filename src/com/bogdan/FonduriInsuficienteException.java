package com.bogdan;

class FonduriInsuficienteException extends Exception {

    public FonduriInsuficienteException() {
        super("Nu aveți suficiente fonduri pentru a putea finaliza tranzacția.");
    }
}
