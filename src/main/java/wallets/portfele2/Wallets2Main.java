package wallets.portfele2;

import wallets.portfele.Pieniadze;

import java.math.BigDecimal;

public class Wallets2Main {

    public static void log(String text){System.out.println(text);}

    public static void main(String[] args) {


        Person person1 = new Person(new Wallet(new Money(BigDecimal.valueOf(1000), Currency.PLN)));
        Person person2 = new Person(new Wallet(new Money(BigDecimal.valueOf(200), Currency.PLN)));

        log("Osoba 1: "+person1.toString());
        log("Osoba 2: "+person2.toString());

        person1.payToPerson(person2,new Money(BigDecimal.valueOf(100),Currency.PLN));

        log("Osoba 1: "+person1.toString());
        log("Osoba 2: "+person2.toString());

    }
}
