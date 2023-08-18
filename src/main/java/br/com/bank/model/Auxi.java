package br.com.bank.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Auxi {
    public static void aux(){
        Stream<Long[]> st4 = Stream.iterate(new Long[] {0L,1L},
            x -> new Long[] {x[1], x[0] + x[1]});
        // O iterate é infinito, deve-se utilizar o método limit para definir a quantidade de iterações
        
        /* 
            st4 = [
                [0, 1]
                [1, 1]
                [1, 2]
                [2, 3]
                [3, 5]
                [5, 8]
                [8, 13]
                [13, 21]
                [21, 34]
                [34, 55]
                 ...
            ]
         */

        Stream<Long> st = st4.map(x -> x[0]);

        /*
            st = [0,1,1,2,3,5,8,13,21,34, ... ]         
         */

        List<Long> fbList = st.limit(20).collect(Collectors.toList());

        System.out.println("Lista da sequência de Fibonacci: " + fbList);
    }
}
