package portfele;

public class Bank {

    private Osoba osoba;

    public boolean placenie(int ilePieniedzy, Osoba osoba1, Osoba osoba2) {

        osoba1.portfel.przelewWychodzacy(ilePieniedzy);

        if(osoba1.portfel.przelewWychodzacy(ilePieniedzy)==true) {
            osoba2.portfel.przelewPrzychodzacy(ilePieniedzy);
            return true;
        }else{
            System.out.println("Niewystarczające środki na koncie: ");
            return false;
        }
    }
}
