package wallets.portfele2;

public class Wallet {
    private Money money;

    @Override
    public String toString(){
        return ""+ money;
    }

    public Wallet(Money zlotes) {
        this.money = zlotes;
    }

    public void payIn(Money money){
        this.money.acceptMoney(money);
    }

    public void payOut(Money money) throws Exception {
            this.money.payMoney(money);
    }

    public String balance(){
        return "Na koncie posiadasz: "+ money;
    }

}
