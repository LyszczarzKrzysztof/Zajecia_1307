package portfele;

public class Bank {

    private Osoba osoba;

    public boolean placenie(int ilePieniedzy, Osoba osoba1, Osoba osoba2) {
        osoba1.polecenieWyplaty(ilePieniedzy,osoba2);
        return true;
    }
}
