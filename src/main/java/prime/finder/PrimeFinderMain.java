package prime.finder;

public class PrimeFinderMain {

    public static void main(String[] args) {
        int start = 200;
        int liczba = 1200;
        System.out.println(PrimeFinder.finder(start, liczba));
        System.out.println(PrimeFinder.finderSquare(start, liczba));
        System.out.println(PrimeFinder.finder(start,liczba).size());
        System.out.println(PrimeFinder.finderSquare(start,liczba).size());
        System.out.println(PrimeFinder.sum(start,liczba));
        System.out.println(PrimeFinder.listaItegerow());
    }
}
