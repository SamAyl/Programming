package sg_group5.CountVowels.InsertedSorted;

public class App {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);

        head.next = n1;
        n1.next = n2;

        head = insert(head,4);
        System.out.println(head.v);
    }


    public static Node insert(Node head,int v){
        if(head==null){
           return new Node(v);
        }else{
           Node prev = null;
           Node curr = head;

           while (curr!=null){
               if(curr.v>=v){
                   Node temp = new Node(v);
                   temp.next = curr;
                   prev.next = temp;
                   break;
               }else {
                   prev = curr;
                   curr = curr.next;

               }
           }


           if(prev.next==null){
               prev.next = new Node(v);
           }

           return head;
        }
    }



}

class Node{
    int v;
    Node next;

    Node(int v){
        this.v = v;
    }
}
