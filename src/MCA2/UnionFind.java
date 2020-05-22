package MCA2;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {

    /*
    *  This is the graph, on which union find will be working on this to check if there is a circle or not.
    *
    *                                  1----2
    *                                  |     |
    *                                  |     |
    *                                  3-----4
    *                                  |
    *                                  |
    *                                  5------7
    *                                  |      |
    *                                  |      |
    *                                  0------6
    *
     */

    public static void main(String[] args) {

        Node1[] g = makeGraph();

    }


    //To know whether two
    public static boolean findCircle( ){
            return false;
    }

    private static Node1[] makeGraph(){
        Node1 n1 = new Node1();
        Node1 n2 = new Node1();
        Node1 n3 = new Node1();
        Node1 n4 = new Node1();
        Node1 n5 = new Node1();
        Node1 n6 = new Node1();
        Node1 n7 = new Node1();
        Node1 n0 = new Node1();
        //Node1 n1 = new Node1();

        n1.neighbour.add(n2);
        n1.neighbour.add(n3);

        n2.neighbour.add(n1);
        n2.neighbour.add(n4);

        n3.neighbour.add(n1);
        n3.neighbour.add(n4);
        n3.neighbour.add(n5);

        n4.neighbour.add(n3);
        n4.neighbour.add(n2);

        n5.neighbour.add(n3);
        n5.neighbour.add(n7);
        n5.neighbour.add(n0);

        n7.neighbour.add(n5);
        n7.neighbour.add(n6);

        n6.neighbour.add(n7);
        n6.neighbour.add(n0);

        n0.neighbour.add(n6);
        n0.neighbour.add(n5);

        Node1[] g = new Node1[8];

        g[0]  = n0;
        g[1] = n1;
        g[2] = n2;
        g[3] = n3;
        g[4] = n4;
        g[5] = n5;
        g[6] = n6;
        g[7] = n7;

        return g;
    }
}

class Node1 {
    List<Node1> neighbour = new ArrayList<>();
}
