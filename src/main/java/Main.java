public class Main {

    public static void main(String[] args) {
        Pieniadze pieniadze1 = new Pieniadze(1000, "PLN");
        Pieniadze pieniadze2 = new Pieniadze(700, "PLN ");

        Portfel portfel1 = new Portfel(pieniadze1);
        Portfel portfel2 = new Portfel(pieniadze2);

        Osoba osoba1 = new Osoba("Krzysztof", "Lyszczarz", portfel1);
        Osoba osoba2 = new Osoba("Jan", "Kowalski", portfel2);

//        System.out.println(osoba1);
//
//        portfel1.przelewWychodzacy(100);
//
//        System.out.println(osoba1);

        Bank przelew1 = new Bank();

        System.out.println(osoba1);
        System.out.println(osoba2);

        przelew1.placenie(1100, osoba1, osoba2);

        System.out.println(osoba1);
        System.out.println(osoba2);

    }

}
