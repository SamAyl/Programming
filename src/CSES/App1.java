package CSES;

import java.util.HashSet;
import java.util.Set;

public class App1 {

    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        int[] a = {1,2};
        int[] b = {2,4};

        int[] c = {1,2};

        set.add(a);
        if (set.contains(c)){
            System.out.println("am here");
        }


    }
}
