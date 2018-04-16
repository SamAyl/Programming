package Graph;


import java.util.*;

public class Clone {

    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node (2);
        Node n3 = new Node(3);

        n1.neighbours.add(n2);
        n1.neighbours.add(n3);

        n2.neighbours.add(n1);
        n2.neighbours.add(n3);

        n3.neighbours.add(n1);
        n3.neighbours.add(n2);

        Clone clone = new Clone();



    }

    public List<Node> clone(Node root){
        Set<Node> visitedNodes = new HashSet<>();
        clone(root,visitedNodes);

      return   new ArrayList<>(visitedNodes);
    }

    public void clone(Node root,Set<Node> visitedNodes){
        Node cloneNode = new Node(root.value);

        if(!visitedNodes.contains(cloneNode)){
            visitedNodes.add(cloneNode);

            for(Node node : root.neighbours){
                clone(node,visitedNodes);
            }
        }

    }


}

class Node{
    int value;
    List<Node> neighbours = new ArrayList<>();

    public Node(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
