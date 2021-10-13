package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
       Set<int[]> set = new HashSet<>();
       int[] a = new int[2];
       a[0] = 1;
       a[1] = 2;

       set.add(a);

       int[] b = new int[2];
       b[0] = 1;
       b[1] = 2;

       set.remove(b);

        System.out.println(set.size());

    }


    public static void check() throws Exception {

    }
}


class NodeA {
    int x;
    int y;

   @Override
    public int hashCode(){
       return 31*x + y;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeA nodeA = (NodeA) o;
        return x == nodeA.x &&
                y == nodeA.y;
    }

}