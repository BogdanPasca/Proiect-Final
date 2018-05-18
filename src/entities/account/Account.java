package entities.account;



public abstract class Account {

    private double sold = 0;
    private int numarCont;

     public Account(int numarCont) {
        this.numarCont = numarCont;
    }

    public abstract AccountType getAccountType();

    @Override
    public String toString() {
        return "Account Type: " + getAccountType().name() + " Account\n"
                + "Account Number: " + this.getNumarCont() + "\n"
                + "Balance: " + this.getSold() + "\n";
    }

    public double getSold() {
        return sold;
    }

    public final void setSold(double sold) {
        this.sold = sold;
    }

    public int getNumarCont() {
        return numarCont;
    }
}
