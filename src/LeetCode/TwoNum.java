//package LeetCode;
//
//
//
//public class TwoNum {
//
//    public static void main(String[] args){
//      node n1= new node(2);
//      node n2 = new node(4);
//      node n3 = new node(3);
//     // node n4 = new node(9);
//
//
//      n1.next = n2;
//     n2.next = n3;
//
//
//
//     node n11 = new node(5);
//     node n22 = new node(6);
//     node n33 = new node(4);
//
//     n11.next = n22;
//     n22.next = n33;
//
//
//    node head1 =n1;
//    node head2 = n11;
//
//
//
//    int temp = 0;
//    node res =  null;
//    node answer = res;
//    int v;
//        while (head1!=null && head2!=null){
//             v = head1.value + head2.value + temp;
//            temp = v/10;
//            node temp1 = new node(v%10);
//            if(res==null){
//                res = temp1;
//                answer = res;
//            }else {
//                res.next = temp1;
//                res = res.next;
//            }
//            head1 = head1.next;
//            head2 = head2.next;
//
//        }
//
//        if(head1 == null && head2!=null){
//            while (head2!=null) {
//                 v = 0 + head2.value + temp;
//                temp = v/10;
//                node temp1 = new node(v%10);
//                res.next = temp1;
//                res = res.next;
//                head2 = head2.next;
//            }
//        }else if(head2==null && head1!=null){
//            while (head1!=null) {
//                 v = 0 + head1.value + temp;
//                temp = v/10;
//                node temp2 = new node(v%10);
//                res.next = temp2;
//                res = res.next;
//                head1 = head1.next;
//            }
//        }
//
//        if(temp!=0){
//            res.next = new node(temp);
//        }
//
//
//
//       print(answer);
//
//    }
//
//    public static node reverse(node head){
//        if(head==null){
//          return null;
//        }else if(head.next==null){
//            return head;
//        }
//
//        node temp1 = head;
//        node temp2 = head.next;
//        node temp3 = temp2.next;
//        head.next=null;
//
//        if(temp3==null){
//            temp2.next = temp1;
//        }
//
//        while(temp3!=null){
//            temp2.next = temp1;
//            temp1 = temp2;
//            temp2= temp3;
//            temp3 = temp3.next;
//        }
//
//       temp2.next = temp1;
//
//
//        return temp2;
//
//    }
//
//
//    public static void print(node root){
//        while (root.next!=null){
//            System.out.println(root.value);
//            root = root.next;
//        }
//
//        System.out.println(root.value);
//    }
//
//}
//
// class node {
//    int value;
//    node next;
//
//    node(int value) {
//        this.value = value;
//    }
//}
