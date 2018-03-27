package Clone;

import java.util.LinkedList;


public class Node {

    public int value;
    LinkedList<Integer> children = new LinkedList<>();


    public Node(int value){
        this.value = value;
    }
}
