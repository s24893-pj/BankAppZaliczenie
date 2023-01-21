package pl.pjwstk.s24893Bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class S24893BankTest {





    @Mock
    private ClientStorage clientStorage;
    @InjectMocks
    BankService bankService;



    @DisplayName("minusowe saldo - rejestracja")
    @Test
    void bankTest1(){
        //given
        double saldo = -2444.00;
        //when
        Client client = bankService.registerAClient(saldo);
        //then
        assertThat(client).isEqualTo(null);
    }

    @DisplayName("klient nie istnieje przy zleceniu przelewu")
    @Test
    void bankTest2(){
        when(clientStorage.findByID(anyInt())).thenReturn(null);
        //given
        int clientId = 1;
        double price = 24.99;
        //when
        Client client = clientStorage.findByID(clientId);
        bankService.orderTransfer(clientId, price);
        //then
        assertThat(client).isEqualTo(null);
    }

    @DisplayName("klient ma wystarczającą ilość środków - przelew")
    @Test
    void bankTest3(){
        when(clientStorage.findByID(anyInt())).thenReturn(new Client(2000.00));
        //given
        int clientId = 1;
        double price = 1000.00;
        //when
        bankService.orderTransfer(clientId, price);
        //then
        assertThat(clientStorage.findByID(clientId).getSaldo()).isEqualTo(1000.00);
    }

    @DisplayName("klient ma za mało pieniędzy - przelew")
    @Test
    void bankTest4(){
        when(clientStorage.findByID(anyInt())).thenReturn(new Client(1000.00));
        //given
        int clientId = 1;
        double price = 2000.00;
        //when
        bankService.orderTransfer(clientId, price);
        //then
        assertThat(clientStorage.findByID(clientId).getSaldo()).isEqualTo(1000.00);
    }


    @DisplayName("klient nie istnieje przy dodawaniu pieniędzy")
    @Test
    void bankTest5(){
        when(clientStorage.findByID(anyInt())).thenReturn(null);
        //given
        int clientId = 1;
        double price = 2000.00;
        //when
        Client client = clientStorage.findByID(clientId);
        bankService.addMoney(clientId, price);
        //then
        assertThat(client).isEqualTo(null);
    }



    @DisplayName("klient nie istnieje przy wyświetlaniu informacji")
    @Test
    void bankTest6(){
        when(clientStorage.findByID(anyInt())).thenReturn(null);
        //given
        int clientId = 1;
        //when
        Client client = clientStorage.findByID(clientId);
        bankService.clientInfo(clientId);
        //then
        assertThat(client).isEqualTo(null);
    }
}
