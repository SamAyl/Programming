package RBT;

public class Node {

    int value;
    Node parent;
    Node left;
    Node right;
    char color;


    public Node(int value,char color){
        this.value = value;
        this.color = color;
    }




    public static Node getNil(){
        return new Node(-1,'b');
    }
}
