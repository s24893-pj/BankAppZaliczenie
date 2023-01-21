package pl.pjwstk.s24893Bank;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankApplication {

    private final KlientStorage klientStorage;

    public BankApplication(KlientStorage klientStorage) {
        this.klientStorage = klientStorage;
    }

    public List<Klient> getAllClients() {
        return klientStorage.getKlientList();
    }

    public Klient registerAClient(double saldo) {
        Klient klient = new Klient(saldo);
        klientStorage.getKlientList().add(klient);
        return klient;
    }

    public void orderTransfer(int id_klient, double wartosc) {
        if (klientStorage.findByID(id_klient) != null) {
            if (klientStorage.findByID(id_klient).getSaldo() >= wartosc) {
                double change = klientStorage.findByID(id_klient).getSaldo() - wartosc;
                klientStorage.findByID(id_klient).setSaldo(change);
            } else {
                System.out.println("niewystarczajaca ilosc srodkow");
            }
        } else {
            System.out.println("Taki klient nie istnieje");
        }
    }

    public void addMoney(int id_klient, double wartosc) {
        if (klientStorage.findByID(id_klient) != null) {
            double change = klientStorage.findByID(id_klient).getSaldo() + wartosc;
            klientStorage.findByID(id_klient).setSaldo(change);
        } else {
            System.out.println("Taki klient nie istnieje");
        }
    }

    public Klient klientInfo(int id_client){
        if (klientStorage.findByID(id_client) != null) {
            return klientStorage.findByID(id_client);
        } else {
            System.out.println("Taki klient nie istnieje");
            return null;
        }
    }
}
