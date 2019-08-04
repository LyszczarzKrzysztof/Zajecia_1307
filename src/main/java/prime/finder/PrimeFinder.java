package prime.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimeFinder {

    public static List<Long> finder(int start, int liczba) {

        return LongStream.range(start, liczba)
                .filter(PrimeTester::isPrime)
                .filter(l -> l % 10 == 3)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Long> finderSquare(int start, int liczba){

            return LongStream.range(start, liczba)
                    .filter(PrimeTester::isPrime)
                    .filter(l -> l % 10 == 3)
                    .map(l -> l * l)
                    .boxed()
                    .collect(Collectors.toList());
        }

    public static Long sum(int start, int liczba) {

        return LongStream.range(start, liczba)
                .filter(PrimeTester::isPrime)
                .filter(l -> l % 10 == 3)
                .map(l -> l * l)
                .boxed()
                //nizej bierze wartosc obojetna dla dodawania i dodaje do nich kazdy przefiltrowany element listy
                // dla mnozenia przez wszystkie wartosc obojetna byla by 1
                .reduce(Long.valueOf(0), (currentSum, currentElement) -> currentSum + currentElement);
    }

    public static List<Integer> listaItegerow(){

        List<Integer> integerList = new ArrayList<>();
        for (int i=0; i<100; i++){
          integerList.add(i);
        }

        return integerList.stream().filter(l->l%3==0).collect(Collectors.toList());
    }

}
