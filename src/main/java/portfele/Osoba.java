package portfele;

public class Osoba {
    private String imie;
    private String nazwisko;
    private int ile;
    protected Portfel portfel;

    public Osoba() {

    }

    public Osoba(String imie, String nazwisko, Portfel portfel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.portfel = portfel;
    }


    public boolean polecenieWyplaty(int ile, Osoba osoba2) {

        if (portfel.przelewWychodzacy(ile)) {
            osoba2.portfel.przelewPrzychodzacy(ile);
            return true;
        } else {
            System.out.println("Nie ma tyle pieniedzy");
            return false;
        }
    }


    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + portfel;

    }

}
