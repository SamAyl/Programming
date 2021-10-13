package LeetCode;

import java.util.*;
import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        for(int i = 0;i<0;i++){
            System.out.println("am here");
        }

        Set<Integer> set = new TreeSet<>();

        System.out.println("am done");

        Set<Character> set1 = new HashSet<Character>();
        set1.add('a');
        set1.add('2');
        set1.add('b');
        set1.add('z');
        set1.add('c');

        for(Character c : set1) {
            System.out.println(c);
        }

    }
}
