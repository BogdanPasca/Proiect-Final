package com.bogdan;

class InvalidAmountException extends Exception {

    public InvalidAmountException() {
        super("Fonduri insuficiente pentru a putea finaliza tranzacția.");
    }
}