package LeetCode;



public class TwoNum {

    public static void main(String[] args){
      Node n1= new Node(2);
      Node n2 = new Node(4);
      Node n3 = new Node(3);
     // Node n4 = new Node(9);


      n1.next = n2;
     n2.next = n3;



     Node n11 = new Node(5);
     Node n22 = new Node(6);
     Node n33 = new Node(4);

     n11.next = n22;
     n22.next = n33;


    Node head1 =n1;
    Node head2 = n11;



    int temp = 0;
    Node res =  null;
    Node answer = res;
    int v;
        while (head1!=null && head2!=null){
             v = head1.value + head2.value + temp;
            temp = v/10;
            Node temp1 = new Node(v%10);
            if(res==null){
                res = temp1;
                answer = res;
            }else {
                res.next = temp1;
                res = res.next;
            }
            head1 = head1.next;
            head2 = head2.next;

        }

        if(head1 == null && head2!=null){
            while (head2!=null) {
                 v = 0 + head2.value + temp;
                temp = v/10;
                Node temp1 = new Node(v%10);
                res.next = temp1;
                res = res.next;
                head2 = head2.next;
            }
        }else if(head2==null && head1!=null){
            while (head1!=null) {
                 v = 0 + head1.value + temp;
                temp = v/10;
                Node temp2 = new Node(v%10);
                res.next = temp2;
                res = res.next;
                head1 = head1.next;
            }
        }

        if(temp!=0){
            res.next = new Node(temp);
        }



       print(answer);

    }

    public static Node reverse(Node head){
        if(head==null){
          return null;
        }else if(head.next==null){
            return head;
        }

        Node temp1 = head;
        Node temp2 = head.next;
        Node temp3 = temp2.next;
        head.next=null;

        if(temp3==null){
            temp2.next = temp1;
        }

        while(temp3!=null){
            temp2.next = temp1;
            temp1 = temp2;
            temp2= temp3;
            temp3 = temp3.next;
        }

       temp2.next = temp1;


        return temp2;

    }


    public static void print(Node root){
        while (root.next!=null){
            System.out.println(root.value);
            root = root.next;
        }

        System.out.println(root.value);
    }

}

 class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
