package RBT;

public class App {

    public static void main(String[] args){

        Tree tree = new Tree();
        Node node1 = new Node(5,'r');
        Node node2 = new Node(3,'r');
        Node node3 = new Node(10,'r');
        Node node4 = new Node(8,'r');
        Node node5 = new Node(11,'r');


        tree.insertCheck(node1,tree.root);
        tree.insertCheck(node2,tree.root);
        tree.insertCheck(node3,tree.root);
        tree.insertCheck(node4,tree.root);
        tree.insertCheck(node5,tree.root);


        tree.print(tree.root);
        System.out.println(node3.color);
        System.out.println(node4.color);
        System.out.println(node5.color);
        System.out.println(tree.root.value);

    }
}
