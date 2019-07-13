package portfele;

public class Bank {

    private Osoba osoba;

    public boolean placenie(int ilePieniedzy, Osoba osoba1, Osoba osoba2) {
        osoba1.portfel.przelewWychodzacy(ilePieniedzy);
        osoba2.portfel.przelewPrzychodzacy(ilePieniedzy);
        return true;
    }
}
