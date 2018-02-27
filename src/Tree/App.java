package Tree;

public class App {

    public static void main(String[] args){
        Tree tree = new Tree();
        Node root = new Node(-1);
        tree.add(5,root);
        tree.add(1,root);
        tree.add(10,root);
        tree.add(4,root);
        tree.add(0,root);


     //   tree.print(root);

        System.out.println(tree.height(root));

        System.out.println(tree.serialize(root));
    }
}
