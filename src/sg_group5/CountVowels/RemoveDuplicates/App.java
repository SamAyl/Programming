package sg_group5.CountVowels.RemoveDuplicates;

public class App {


    public static void main(String[] args) {


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(4);
        Node n6 = new Node(5);
        Node n7 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

//1->2->2->3->4
        //1->2->3->4->5
           
      checkAndRemoveDuplicates(n1);
      print(n1);



    }

    public static void checkAndRemoveDuplicates(Node head){
        if(head==null){
            return ;
        }

        if(head.next==null){
            return ;
        }

     // return
              removeDuplicates(head);
    }



    public static void removeDuplicates(Node head){

       // node temp = head;
        Node prev = head;
        head = head.next;

        Node temp1;
        while (head!=null){
            if(prev.v == head.v){
                temp1 = head; //killing the duplicate node
                prev.next = head.next;
                head = head.next;
                temp1.next = null;//killing the duplicate node
            }else {
                prev = head;
                head = head.next;
            }
        }

       // return temp;
    }

    public static void print(Node n){
        while(n!=null){
            System.out.println(n.v);
            n = n.next;
        }
    }




}

class Node{
    int v;
    Node next;

    public Node(int v){
        this.v = v;
    }
}
