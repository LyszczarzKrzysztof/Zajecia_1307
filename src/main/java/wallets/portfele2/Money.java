package wallets.portfele2;

import wallets.portfele2.exception.JestesBiednyException;
import wallets.portfele2.exception.NieTaWalutaException;

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
        this.amount = this.amount.add(money.amount);
        return money;
    }

    public Money payMoney(Money money) throws JestesBiednyException, NieTaWalutaException {
        if(canYouAfford(money)) {
            this.amount = this.amount.subtract(money.amount);
            return money;
        }else{
            throw new JestesBiednyException();
        }
    }

    public boolean canYouAfford(Money money) throws NieTaWalutaException {
        if(this.currency.compareTo(money.currency)==0) {
            if (this.amount.compareTo(money.amount) >= 0) {
                return true;
            } else {
                return false;
            }
        }else{
            throw new NieTaWalutaException();
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
//dodac metode (wyjatek lub ifa aby uniemozliwic dodanie dolarow do zlotowek