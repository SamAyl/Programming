package AlgoExpert;

public class SerializeAndDeserialize {

    public static void main(String[] args) {


//        StringBuilder sb = new StringBuilder();
//        sb.append("Isa123");
//        String s = "";

        Tree n1 = new Tree(1);
        Tree n2 = new Tree(2);
        Tree n3 = new Tree(3);
        Tree n4 = new Tree(4);
        Tree n5 = new Tree(5);
        Tree n6 = new Tree(6);


        n1.left = n2;
        n1.right = n4;

        n2.left = n6;
        n2.right = n3;


        n4.left = n5;

        String s = serialize(n1);
        Tree root = deserialize(s);
        System.out.println(root.v);
    }


    public static String serialize(Tree root) {
        StringBuilder sb1 = new StringBuilder();
        preOrder(root,sb1);

        StringBuilder sb2 = new StringBuilder();
        inOrder(root,sb2);

        String serializedStr = sb1.toString()+"--"+sb2.toString();
        return serializedStr;
    }


    public static void preOrder(Tree root, StringBuilder sb) {
        if(root == null) {
            sb.append("X");
            return;
        }


        sb.append(root.v);
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }


    public static void inOrder(Tree root, StringBuilder sb){

        if(root == null) {
            sb.append("X");
            return;
        }

        inOrder(root.left,sb);
        sb.append(root.v);
        inOrder(root.right,sb);


    }

    public static Tree deserialize(String s){
        String[] res = s.split("--");
        Tree parent = new Tree(Integer.parseInt(res[0].substring(0,1)));
        deserialize(res[0], res[1],parent);
        return parent;
    }


    public static void deserialize(String s1, String s2, Tree parent){



        String[] subTree = s2.split(s1.substring(0,1));

        String leftSubTreeInOrder = s1.substring(1,1+subTree[0].length());
        String rightSubTreeInOrder = s1.substring(1+subTree[0].length());

        if (leftSubTreeInOrder.charAt(0) != 'X') {
            Tree leftChild = new Tree(Integer.parseInt(leftSubTreeInOrder.substring(0,1)));
            parent.left = leftChild;
            deserialize(leftSubTreeInOrder,subTree[0],leftChild);
        } else {
            parent.left = null;
        }

        if (rightSubTreeInOrder.charAt(0) != 'X') {
            Tree rightChild = new Tree(Integer.parseInt(rightSubTreeInOrder.substring(0,1)));
            parent.right = rightChild;
            deserialize(rightSubTreeInOrder,subTree[1],rightChild);
        } else {
            parent.right = null;
        }
    }

}

class Tree{
    int v;
    Tree left;
    Tree right;

    public Tree(int v) {
        this.v = v;
    }
}
