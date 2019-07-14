package wallets.portfele2;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;
    private Currency currency;

    @Override
    public String toString(){
        return "Kwota: "+amount+" "+currency;
    }


    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money acceptMoney(Money money) {
        amount = money.amount.add(this.amount);
        return money;
    }

    public Money payMoney(Money money){
        amount=this.amount.subtract(money.amount);
        return money;
    }

    public boolean canYouAfford(Money money){
        if(this.amount.compareTo(money.amount)==1){
            return true;
        }else{
            return false;
        }
    }

}
