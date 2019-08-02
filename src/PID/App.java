package PID;

import Lambdas.Functional.Int;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 3, 10, 5);
        List<Integer> list1 = Arrays.asList(3, 0, 5, 3);

        Pid pid = new Pid(list,list1);

        List<Integer> list2 = pid.deletePid(3);
        System.out.println(list2);
    }
}
