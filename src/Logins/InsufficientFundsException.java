package Logins;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carl
 */
class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Nu aveți suficiente fonduri pentru a putea finaliza tranzacția.");
    }
    
}


