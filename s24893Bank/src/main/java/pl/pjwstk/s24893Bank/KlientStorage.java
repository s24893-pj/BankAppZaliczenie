package pl.pjwstk.s24893Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KlientStorage {
    private final List<Klient> klientList = new ArrayList<>();

    KlientStorage() {
    }

    public List<Klient> getKlientList() {
        return klientList;
    }

    public Klient findByID(int id) {
        for (Klient klient : klientList) {
            if (klient.getId() == id) {
                return klient;
            }
        }
        return null;
    }
}
