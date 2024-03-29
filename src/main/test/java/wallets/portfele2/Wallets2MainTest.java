package wallets.portfele2;

import com.sun.org.glassfish.gmbal.ManagedObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import wallets.portfele2.exception.JestesBiednyException;
import wallets.portfele2.exception.NieTaWalutaException;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class Wallets2MainTest {

    @ParameterizedTest
    @ValueSource(ints = {1001,1200,4000,5000})
    public void insufficientFunds(int number){

        Money moneytest1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money moneytest2 = new Money(new BigDecimal(200),Currency.PLN);
        Money moneytest3 = new Money(new BigDecimal(1000),Currency.USD);
        Money moneytest4 = new Money(new BigDecimal(200),Currency.USD);

        Wallet wallettest1 = new Wallet();
        wallettest1.payIn(moneytest1);
        wallettest1.payIn(moneytest3);
        Wallet wallettest2 = new Wallet();
        wallettest2.payIn(moneytest2);
        wallettest2.payIn(moneytest4);


        Person persontest1 = new Person(wallettest1);
        Person persontest2 = new Person(wallettest2);

        persontest1.payToPerson(persontest2,new Money(new BigDecimal(number),Currency.PLN));
        persontest1.payToPerson(persontest2,new Money(new BigDecimal(number),Currency.USD));

        assertEquals(new BigDecimal(1000),moneytest1.getAmount());
        assertEquals(new BigDecimal(200),moneytest2.getAmount());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000,999,100,1,0,753})
    public void sufficientFunds(int liczba){

        Money moneytest1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money moneytest2 = new Money(new BigDecimal(200),Currency.PLN);
        Money moneytest3 = new Money(new BigDecimal(1000),Currency.USD);
        Money moneytest4 = new Money(new BigDecimal(200),Currency.USD);

        Wallet wallettest1 = new Wallet();
        Wallet wallettest2 = new Wallet();

        wallettest1.payIn(moneytest1);
        wallettest2.payIn(moneytest2);
        wallettest1.payIn(moneytest3);
        wallettest2.payIn(moneytest4);

        Person persontest1 = new Person(wallettest1);
        Person persontest2 = new Person(wallettest2);

        BigDecimal moneyBeforePayment1 = moneytest1.getAmount();
        BigDecimal moneyBeforePayment2 = moneytest2.getAmount();
        BigDecimal moneyBeforePayment3 = moneytest3.getAmount();
        BigDecimal moneyBeforePayment4 = moneytest4.getAmount();

        Money moneyToPay = new Money(new BigDecimal(liczba),Currency.PLN);
        Money moneyToPay2 = new Money(new BigDecimal(liczba),Currency.USD);

        persontest1.payToPerson(persontest2,moneyToPay);
        persontest1.payToPerson(persontest2,moneyToPay2);

        BigDecimal moneyAfterPayment1 = moneytest1.getAmount();
        BigDecimal moneyAfterPayment2 = moneytest2.getAmount();
        BigDecimal moneyAfterPayment3 = moneytest3.getAmount();
        BigDecimal moneyAfterPayment4 = moneytest4.getAmount();

        assertEquals(moneyBeforePayment1.subtract(moneyToPay.getAmount()),moneyAfterPayment1);
        assertEquals(moneyBeforePayment2.add(moneyToPay.getAmount()),moneyAfterPayment2);
        assertEquals(moneyBeforePayment3.subtract(moneyToPay2.getAmount()),moneyAfterPayment3);
        assertEquals(moneyBeforePayment4.add(moneyToPay2.getAmount()),moneyAfterPayment4);
    }

    @Test
    public void canYouAffordTest() throws NieTaWalutaException {

        Money moneytest1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money moneytest2 = new Money(new BigDecimal(400),Currency.PLN);
        Money moneytest3 = new Money(new BigDecimal(300),Currency.USD);
        Money moneytest4 = new Money(new BigDecimal(1000),Currency.PLN);


        assertTrue(moneytest1.canYouAfford(moneytest4));
        assertTrue(moneytest1.canYouAfford(moneytest2));
        assertThrows(NieTaWalutaException.class, ()->moneytest1.canYouAfford(moneytest3));
    }

    @ParameterizedTest
    @CsvSource({"1000,100,900","2000,200,1800","1500,50,1450"})
    public void payOutTest(String string,String string2, String expected) throws NieTaWalutaException, JestesBiednyException {
        Money moneytest1=new Money(new BigDecimal(Integer.parseInt(string)),Currency.PLN);
        Money moneytest2 = new Money(new BigDecimal(Integer.parseInt(string2)),Currency.PLN);
        moneytest1.payMoney(moneytest2);
        assertEquals(new BigDecimal(Integer.parseInt(expected)),moneytest1.getAmount());
    }

}
