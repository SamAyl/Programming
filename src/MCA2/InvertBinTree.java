package MCA2;

public class InvertBinTree {

    public static void main(String[] args) {
        Node$ n1 = new Node$(1);
        Node$ n2 = new Node$(2);
        Node$ n3 = new Node$(3);
        Node$ n4 = new Node$(4);
        Node$ n5 = new Node$(5);
        Node$ n6 = new Node$(6);

        n1.left = n2;
        n1.right = n3;


    }


}


class Node${
    int v;
    Node$ left;
    Node$ right;

    public Node$(int v) {
        this.v = v;
    }
}