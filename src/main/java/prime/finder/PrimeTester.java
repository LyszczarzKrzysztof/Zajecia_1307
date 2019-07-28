package prime.finder;

public class PrimeTester {
    public static boolean isPrime(long liczba) {

        if (liczba>1) {

            int licznik = 0;
            for (int i = 1; i <= liczba; i++) {
                if (liczba % i == 0) {
                    licznik++;
                }
            }

            if (licznik <= 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }
}
