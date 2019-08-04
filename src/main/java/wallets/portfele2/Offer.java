package wallets.portfele2;

import wallets.portfele.Pieniadze;

import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Offer {

    private String stuff;

    List<Money> prices;

    public Offer(String stuff, List<Money> prices) {
        this.stuff = stuff;
        this.prices = prices;
    }

    public String toString(){
        return "Towar: "+stuff+" ceny: "+ prices;
    }

    public String getStuff() {
        return stuff;
    }

    public List<Money> getPrices() {
        return prices;
    }

    public Money makeUSD(Money money){
            if(money.getCurrency()==Currency.USD){
                money=money;
            }else{
                money = new Money(money.getAmount().multiply(money.getMapOfCurrencyRates().get(money.getCurrency())),Currency.USD);
            }

        return money;
    }


    public boolean hasLowerPrice(Offer offer){
        BigDecimal minPrice = makeUSD(offer.getPrices().get(0)).getAmount();
        int counter = 0;
        boolean condition=false;

        for (Money o: prices) {
            if(makeUSD(o).getAmount().subtract(minPrice).compareTo(new BigDecimal(0))<0){
                counter++;
            }else{
            }
        }

        if(counter>0){
            condition = true;
        }
        return condition;
    }

    public Money howMuchWillYouPayForThis(Offer offer){

       return offer.getPrices();
    }



}
