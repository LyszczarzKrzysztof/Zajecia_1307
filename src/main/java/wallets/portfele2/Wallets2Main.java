package wallets.portfele2;



import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallets2Main {

    public static final Logger logger = LoggerFactory.getLogger(Wallets2Main.class);

    public static void log(String text){System.out.println(text);}

    public static void main(String[] args) {




        Money money1 = new Money(new BigDecimal(1000),Currency.PLN);
        Money money2 = new Money(new BigDecimal(200),Currency.PLN);
        Money money3 = new Money(new BigDecimal(4000),Currency.USD);
        Money money4 = new Money(new BigDecimal(500),Currency.USD);

        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();


        wallet1.payIn(money1);
        wallet2.payIn(money2);
        wallet1.payIn(money3);
        wallet2.payIn(money4);




        Person person1 = new Person(wallet1);
        Person person2 = new Person(wallet2);

        logger.info("Osoba 1: {}"+person1.toString());
        logger.info("Osoba 2: {}"+person2.toString());

        person1.payToPerson(person2,new Money(BigDecimal.valueOf(1100),Currency.PLN));
        person1.payToPerson(person2,new Money(BigDecimal.valueOf(1200),Currency.USD));


        logger.info("Osoba 1: {}"+person1.toString());
        logger.debug("Osoba 2: {}"+person2.toString());


        //----------------------------------------------------------------------------------------------


        List<Money> listOfPrices1 = new ArrayList<>();


        Money priceglasses1 = new Money(new BigDecimal(100), Currency.PLN);
        Money priceglasses2 = new Money(new BigDecimal(28), Currency.USD);
        Money priceglasses3 = new Money(new BigDecimal(23), Currency.EUR);

        listOfPrices1.add(priceglasses1);
        listOfPrices1.add(priceglasses2);
        listOfPrices1.add(priceglasses3);


        Offer offer1 = new Offer("glasses",listOfPrices1);

        List<Offer> listForSale1 = new ArrayList<>();

        listForSale1.add(offer1);

        List<Offer> listToBuy = new ArrayList<>();

        List<String> listOfStuff1 = new ArrayList<>();

        Person personBuyingSelling1 = new Person(wallet1,listOfStuff1,listForSale1,listToBuy);

        logger.info("Handlarz 1: {}"+personBuyingSelling1);


    }
}
