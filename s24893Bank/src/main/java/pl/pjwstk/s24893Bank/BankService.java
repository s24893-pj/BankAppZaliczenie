package pl.pjwstk.s24893Bank;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankService {

    private final ClientStorage clientStorage;
    private final String declined = "TRANSACTION DECLINED:";
    private final String accepted = "TRANSACTION ACCEPTED";

    public BankService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public List<Client> getAllClients() {
        return clientStorage.getClientList();
    }

    public Client registerAClient(double saldo) {
        if (saldo >= 0) {
            Client client = new Client(saldo);
            clientStorage.getClientList().add(client);
            System.out.println("zarejestrowano nowego klienta");
            return client;
        }else {
            System.out.println("Nie można dodać minusowego salda");
            return null;
        }
    }

    public void orderTransfer(int id_client, double value) {
        if (clientStorage.findByID(id_client) != null) {
            if (clientStorage.findByID(id_client).getSaldo() >= value) {
                double change = clientStorage.findByID(id_client).getSaldo() - value;
                clientStorage.findByID(id_client).setSaldo(change);
                System.out.println(accepted);
            } else {
                System.out.println(declined + "niewystarczająca ilosc srodkow");
            }
        } else {
            System.out.println(declined +"Taki klient nie istnieje");
        }
    }

    public void addMoney(int id_client, double value) {
        if (clientStorage.findByID(id_client) != null) {
            if (value >= 0) {
                double change = clientStorage.findByID(id_client).getSaldo() + value;
                clientStorage.findByID(id_client).setSaldo(change);
                System.out.println(accepted);
            }else {
                System.out.println(declined +"nie można dodać ujemnej wartości");
            }
        } else {
            System.out.println(declined +"Taki klient nie istnieje");
        }
    }

    public void clientInfo(int id_client) {
        if (clientStorage.findByID(id_client) != null) {
            Client client = clientStorage.findByID(id_client);
            System.out.println("id klienta: " + client.getId() + " saldo: " + client.getSaldo());
        } else {
            System.out.println("Taki klient nie istnieje");
        }
    }
}
