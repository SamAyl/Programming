package Maze;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public char val;
    public List<Node> friends;

    @Override
    public String toString() {
        return "node{" +
                "val=" + val +
                '}';
    }

    Node(){
        friends = new ArrayList<>();
    }


}
