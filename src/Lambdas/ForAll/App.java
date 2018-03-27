package Lambdas.ForAll;

import Lambdas.Functional.Int;

import java.util.stream.IntStream;

public class App {

    public static void main(String[] args){

        int a[] = {1,2,3,4,5,6,7,8,9};
        int b[] = {-1,-2,-3,-4,-5,-6,-7,-8,-9};
        int c[] = new int[9];

        IntStream.range(0,9)
                .parallel()
                .forEach(i->c[i] = a[i]+b[i]);



        for(int i : c){
            System.out.println(i);
        }
    }



}
