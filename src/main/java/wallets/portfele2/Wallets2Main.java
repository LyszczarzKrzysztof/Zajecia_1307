package wallets.portfele2;



import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Wallets2Main {

    public static void log(String text){System.out.println(text);}

    public static void main(String[] args) {




        //Money money1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money money2 = new Money(new BigDecimal(200),Currency.PLN);
        Money money3 = new Money(new BigDecimal(4000),Currency.USD);
        Money money4 = new Money(new BigDecimal(500),Currency.USD);

        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();


       // wallet1.payIn(money1);
        wallet2.payIn(money2);
        wallet1.payIn(money3);
        wallet2.payIn(money4);




        Person person1 = new Person(wallet1);
        Person person2 = new Person(wallet2);

        log("Osoba 1: "+person1.toString());
        log("Osoba 2: "+person2.toString());

        person1.payToPerson(person2,new Money(BigDecimal.valueOf(100),Currency.PLN));
        person1.payToPerson(person2,new Money(BigDecimal.valueOf(1200),Currency.USD));

        log("Osoba 1: "+person1.toString());
        log("Osoba 2: "+person2.toString());

    }
}
