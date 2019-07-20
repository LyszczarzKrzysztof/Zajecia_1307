package wallets.portfele2;




import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Wallets2MainTest {

    @ParameterizedTest
    @ValueSource(ints = {1001,1200,4000,5000})
    public void insufficientFunds(int liczba){

        Money moneytest1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money moneytest2 = new Money(new BigDecimal(200),Currency.PLN);

        Wallet wallettest1 = new Wallet(moneytest1);
        Wallet wallettest2 = new Wallet(moneytest2);

        Person persontest1 = new Person(wallettest1);
        Person persontest2 = new Person(wallettest2);

        persontest1.payToPerson(persontest2,new Money(new BigDecimal(liczba),Currency.PLN));

        assertEquals(new BigDecimal(1000),moneytest1.getAmount());
        assertEquals(new BigDecimal(200),moneytest2.getAmount());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000,999,100,1,0,753})
    public void sufficientFunds(int liczba){

        Money moneytest1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money moneytest2 = new Money(new BigDecimal(200),Currency.PLN);

        Wallet wallettest1 = new Wallet(moneytest1);
        Wallet wallettest2 = new Wallet(moneytest2);

        Person persontest1 = new Person(wallettest1);
        Person persontest2 = new Person(wallettest2);

        BigDecimal moneyBeforePayment1 = moneytest1.getAmount();
        BigDecimal moneyBeforePayment2 = moneytest2.getAmount();

        Money moneyToPay = new Money(new BigDecimal(liczba),Currency.PLN);

        persontest1.payToPerson(persontest2,moneyToPay);

        BigDecimal moneyAfterPayment1 = moneytest1.getAmount();
        BigDecimal moneyAfterPayment2 = moneytest2.getAmount();

        assertEquals(moneyBeforePayment1.subtract(moneyToPay.getAmount()),moneyAfterPayment1);
        assertEquals(moneyBeforePayment2.add(moneyToPay.getAmount()),moneyAfterPayment2);
    }


}
