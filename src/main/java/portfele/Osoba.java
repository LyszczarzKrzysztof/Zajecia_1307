package portfele;

public class Osoba {
    private String imie;
    private String nazwisko;
    protected Portfel portfel;

    public Osoba() {

    }

    public Osoba(String imie, String nazwisko, Portfel portfel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.portfel = portfel;
    }


    @Override
    public String toString() {
        return imie + " " + nazwisko + " " + portfel;
    }

}
