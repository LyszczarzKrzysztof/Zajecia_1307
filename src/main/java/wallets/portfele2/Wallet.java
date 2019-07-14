package wallets.portfele2;

import java.util.stream.Stream;

public class Wallet {
    private Money zlotes;

    @Override
    public String toString(){
        return ""+zlotes;
    }

    public Wallet(Money zlotes) {
        this.zlotes = zlotes;
    }

    public void payIn(Money money){
        money.acceptMoney(money);
    }

    public void payOut(Money money){
            money.payMoney(money);
    }

    public String balance(){
        return "Na koncie posiadasz: "+zlotes;
    }
}
