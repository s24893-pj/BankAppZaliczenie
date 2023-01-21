package pl.pjwstk.s24893Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {
    private final List<Client> clientList = new ArrayList<>();

    ClientStorage() {
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Client findByID(int id) {
        for (Client client : clientList) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
