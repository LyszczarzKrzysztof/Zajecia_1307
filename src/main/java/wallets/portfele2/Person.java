package wallets.portfele2;

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
        this.wallet.payOut(money);
        person.acceptMoneyFromAnyone(money);
    }

    public void acceptMoneyFromAnyone(Money money) {

        wallet.payIn(money);

//        if(doYouHaveWallet(wallet)) {
//            wallet.payIn(money);
//        }else{
//            new Person(wallet);
//            wallet.payIn(money);
//    }
    }

}
