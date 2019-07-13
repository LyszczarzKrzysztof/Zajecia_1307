package portfele;

public class Portfel {

    private Pieniadze zlotowki;


    public Portfel(Pieniadze zlotowki) {
        this.zlotowki = zlotowki;
    }

    public boolean przelewWychodzacy(int zaplacono) {

        if (zaplacono <= zlotowki.getKwota()) {
            zlotowki.setKwota(zlotowki.getKwota() - zaplacono);
            System.out.println("Wyplacono: " + zaplacono);
            return true;
        } else {
            int staryStan = zlotowki.getKwota();
            zlotowki.setKwota(0);
            System.out.println("Zabrakło kasy. Wyplaciles: " + (staryStan));
            return false;
        }
    }

    public boolean przelewPrzychodzacy(int zaplacono) {
        zlotowki.setKwota(zlotowki.getKwota() + zaplacono);
        return true;
    }

    @Override
    public String toString() {
        return "" + zlotowki;
    }

}
