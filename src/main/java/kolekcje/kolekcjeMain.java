package kolekcje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class kolekcjeMain {

    public static void main(String[] args) {

        List<Integer> lista1=new ArrayList<>();
        List<Integer> lista2=new ArrayList<>();
        List<Integer> lista3=new ArrayList<>();

        for(int i=0; i<=99; i++){
            lista1.add(i);

        }

        System.out.println(lista1);



//        for (int i=0; i<lista1.size(); i++) {
//            if(lista1.get(i)%2!=0){
//                lista2.add(lista1.get(i));
//            }
//        }

        for(Integer element: lista1) {
            if(element%2!=0){
                lista2.add(element);
            }
        }

        System.out.println(lista2);


        Iterator it = lista1.iterator();

        for(Integer element: lista1){
            lista3.add(element*element);
        }

        System.out.println(lista3);


        List<Integer> lista4 = IntStream.range(0,100).filter(n -> n%2==0).mapToObj(n -> n).collect(Collectors.toList());

        System.out.println(lista4);

        List<Integer> lista5 = IntStream.range(0,100)
                .filter(n -> n%2==0)
                .mapToObj(n -> n*n)
                .filter(n -> n<=701)
                .collect(Collectors.toList());

        System.out.println(lista5);


        Map<Integer, String> mapa6 = IntStream.range(0,100)
                .filter(n -> n%2==0)
                .mapToObj(n -> n*n)
                .filter(n -> n<=701)
                .collect(Collectors.toMap(
                        n->n,
                        n-> String.valueOf(Math.round(Math.sqrt(n)))
                ));

        System.out.println(mapa6);


        Map<Double, String> mapa7 = IntStream.range(0,100)
                .filter(n -> n%2==0)
                .mapToObj(n -> {
                    System.out.println("metody w lambdzie"+n*n);
                        return Math.pow(n,2);
                })
                .filter(n -> n<=701)
                .collect(Collectors.toMap(
                        n->n,
                        n-> String.valueOf(Math.round(Math.sqrt(n)))
                ));

        System.out.println(mapa7);

    }
}
