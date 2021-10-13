package DailyByte;

public class ReverseList {

//    public static void main(String[] args) {
//        node n1 = new node(1);
//        node n2 = new node(2);
//        node n3 = new node(3);
//        node n4 = new node(4);
//        node n5 = new node(5);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//
//        node n = reverse(n1);
//
//        print(n);
//    }
//
//    public static void print(node root) {
//        while(root != null) {
//            System.out.println(root.v);
//            root = root.next;
//        }
//    }
//    public static node reverse(node root) {
//
//        if (root.next == null) {
//            return root;
//        }
//
//        node thirdPointer = root.next;
//        node secondPointer = root;
//        node firstPointer = null;
//
//        while (thirdPointer != null) {
//            node tempPointer = thirdPointer.next;
//            thirdPointer.next = secondPointer;
//            secondPointer.next = firstPointer;
//
//            firstPointer = secondPointer;
//            secondPointer = thirdPointer;
//            thirdPointer = tempPointer;
//
//        }
//
//        return secondPointer;
//    }
}
