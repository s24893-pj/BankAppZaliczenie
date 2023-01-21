package pl.pjwstk.s24893Bank;

public class Client {
    private static int count = 0;
    int id;
    private double saldo;

    public Client(double saldo) {
        this.id = ++count;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", saldo=" + saldo +
                '}';
    }
}
