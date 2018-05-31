package Simple;

public class App {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

      Node t =   reverse(n1);
        System.out.println(t.v);
    }

    public static Node reverse(Node root){

        Node temp1 = root;
        Node temp2 = null;
        Node temp3 = null;

        if(root.next!=null){
            temp2 = root.next;
        }else {
            return temp1;
        }

        if(temp2.next!=null){
            temp3 = temp2.next;
        }else {
            temp1.next = null;
            temp2.next = temp1;
            return temp2;
        }

        temp1.next = null;

        while (temp3!=null){
            temp2.next = temp1;

            temp1 = temp2;
            temp2 = temp3;

            temp3 = temp3.next;
        }


        temp2.next = temp1;

        return temp2;
    }
}

class Node{
    int v;
    Node next;

    public Node(int v){
        this.v = v;
    }
}
