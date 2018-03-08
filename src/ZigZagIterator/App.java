package ZigZagIterator;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        for(int i = 0;i<5;i++){
            list1.add(i);
        }

        List<Integer> list2 = new ArrayList<>();
        for(int i = 5;i<10;i++){
           list2.add(i);
        }

        List<Integer> list3 = new ArrayList<>();
        for(int i = 10;i<15;i++){
            list3.add(i);
        }


        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        ZigZag zigZag = new ZigZag(lists);
        while (zigZag.hasNext()){
            System.out.print(zigZag.next() + "\t");
        }
    }
}
