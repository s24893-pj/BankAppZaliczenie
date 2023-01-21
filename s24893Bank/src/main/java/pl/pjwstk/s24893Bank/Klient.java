package pl.pjwstk.s24893Bank;

public class Klient {
    private static int count = 0;
    int id;
    private double saldo;

    public Klient(double saldo) {
        this.id = ++count;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
