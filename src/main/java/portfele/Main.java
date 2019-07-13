package portfele;

public class Main {

    public static void main(String[] args) {
        Pieniadze pieniadze1 = new Pieniadze(1000, "PLN");
        Pieniadze pieniadze2 = new Pieniadze(700, "PLN ");

        Portfel portfel1 = new Portfel(pieniadze1);
        Portfel portfel2 = new Portfel(pieniadze2);

        Osoba osoba10 = new Osoba("Krzysztof", "Lyszczarz", portfel1);
        Osoba osoba20 = new Osoba("Jan", "Kowalski", portfel2);

//        System.out.println(osoba1);
//
//        portfel1.przelewWychodzacy(100);
//
//        System.out.println(osoba1);

        Bank przelew1 = new Bank();

        System.out.println(osoba10);
        System.out.println(osoba20);

        przelew1.placenie(1100, osoba10, osoba20);

        System.out.println(osoba10);
        System.out.println(osoba20);

    }

}
