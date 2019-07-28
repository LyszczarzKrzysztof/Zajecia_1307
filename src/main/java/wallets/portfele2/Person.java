package wallets.portfele2;

import wallets.portfele2.exception.JestesBiednyException;
import wallets.portfele2.exception.NieTaWalutaException;

public class Person {
    private Wallet wallet;

    public Person() {
    }

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return ""+ wallet;
    }

    public boolean doYouHaveWallet(Wallet wallet) {
        if (wallet != null) {
            return true;
        } else {
            return false;
        }
    }

    public void payToPerson(Person person, Money money) {
        try {
            this.wallet.payOut(money);
            person.acceptMoneyFromAnyone(money);
        }catch (JestesBiednyException e){
            System.out.println("Nie stać Cię!");
        } catch (NieTaWalutaException e) {
            System.out.println("Nie ta waluta");
        }
    }

    public void acceptMoneyFromAnyone(Money money) {

        this.wallet.payIn(money);

//        if(doYouHaveWallet(wallet)) {
//            wallet.payIn(money);
//        }else{
//            new Person(wallet);
//            wallet.payIn(money);
//    }
    }

}
