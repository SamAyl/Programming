package sg_group5.CountVowels.SplitListOddEven;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(30);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node[] nodes = split(n1);

        System.out.println("printing even nodes");
       print(nodes[0]);
       System.out.println("printing odd nodes");
       print(nodes[1]);

    }

    public static Node[] split(Node head){
        Node even = null;
        Node evenTemp = even;

        Node odd = null;
        Node oddTemp = null;

        Node temp = head;
        Node prev;

        while (temp!=null){
            if(temp.v%2==0){
                if(even==null){
                    even = temp;
                    evenTemp = temp;
                }else {
                    evenTemp.next = temp;
                    evenTemp = evenTemp.next;
                }


            }else {
                if(odd == null){
                    odd = temp;
                    oddTemp =temp;
                }else {
                    oddTemp.next =temp;
                    oddTemp = oddTemp.next;
                }
            }


            prev = temp;
            temp = temp.next;
            prev.next = null;
        }


        Node[] result = new Node[2];
        result[0] = even;
        result[1] = odd;

        return result;
    }


    public static void print(Node n){
        while (n!=null){
            System.out.println(n.v);
            n = n.next;
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