package pl.pjwstk.s24893Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S24893BankApplication {

    public S24893BankApplication(BankService bankService) {
        bankService.registerAClient(2500.00);
        bankService.registerAClient(3000.00);
        bankService.registerAClient(3500.00);
        bankService.registerAClient(-2500.00);


        bankService.clientInfo(1);
        bankService.clientInfo(2);
        bankService.clientInfo(3);

        bankService.orderTransfer(1, 2400.00);
        bankService.orderTransfer(1, 5000.00);

        bankService.clientInfo(1);

        bankService.addMoney(1, 2300.00);

        bankService.clientInfo(1);
        bankService.clientInfo(5);
    }

    public static void main(String[] args) {
        SpringApplication.run(S24893BankApplication.class, args);
    }

}
