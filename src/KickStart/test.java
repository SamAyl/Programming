package KickStart;

public class test {

    public static void main(String[] args) {

        LinkedListNode node1 = new LinkedListNode(1);
       LinkedListNode node2 = new LinkedListNode(2);
       LinkedListNode node3 = new LinkedListNode(3);
//        LinkedListNode node4 = new LinkedListNode(4);
//        LinkedListNode node5 = new LinkedListNode(7);
//        LinkedListNode node6 = new LinkedListNode(0);

        node1.next = node2;
      node2.next = null;
        node3.next = null;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = null;


        LinkedListNode head = swap_nodes(node1,2);
        System.out.println(head.value);

    }

    static LinkedListNode swap_nodes(LinkedListNode head, int k) {
        LinkedListNode fast = head;
        LinkedListNode prevF = null;
        LinkedListNode nextF = null;

        int count = 1;

        while(count<k){
            prevF = fast;
            fast = fast.next;
            count++;
        }

        nextF = fast.next;


        LinkedListNode temp = fast;

        while(temp.next!=null){
            temp = temp.next;
            count++;
        }

        LinkedListNode slow = head;
        LinkedListNode prevS = null;
        LinkedListNode nextS = null;

        k = count - (k-1);
        count = 1;

        while(count<k){
            prevS = slow;
            slow = slow.next;
            count++;
        }
        nextS = slow.next;

        fast.next = null;
        slow.next = null;

        if(prevS!=null)
        prevS.next = fast;

        if(fast.next!=fast)
        fast.next = nextS;

        if(prevF!=null)
        prevF.next = slow;

        if(slow.next!=nextF)
        slow.next = nextF;


        return head;



    }

}

class LinkedListNode{
    int value;
    LinkedListNode next;

    LinkedListNode(int value){
        this.value = value;
        next = null;
    }
}
