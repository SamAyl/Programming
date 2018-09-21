package sg_group5.CountVowels.MergeLists;

public class App {
    public static void main(String[] args) {


        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n5 = new Node(3);

        n1.next = n3;
        n3.next = n5;

        Node n2 = new Node(2);
        Node n4 = new Node(4);
        n2.next = n4;


        Node n = merge(n1,n2);
        print(n);
    }

    //Time complexity O(M+N) and even the space O(M+N)
    public static Node merge(Node n1,Node n2){

        if(n1==null && n2 == null){
            return null;
        }

        if(n1==null && n2!=null){
            return n2;
        }

        if(n1!=null && n2==null){
            return n1;
        }

        //actual merging takes place
        Node str = null;
        Node head = null;

        while (n1!=null && n2!=null){
            if(n1.v<=n2.v){
                if(str==null){
                   str=n1;
                   head =str;
                }else {
                    str.next = n1;
                    str= str.next;
                }

                    n1 = n1.next;
                    str.next = null;

            }else {
                if(str==null){
                    str=n2;
                    head = str;
                }else {
                    str.next = n2;
                    str= str.next;
                }

                  n2 = n2.next;
                  str.next = null;
                }
            }



        if(n1!=null && n2==null){
            str.next = n1;
        }else if(n2!=null && n1==null){
            str.next = n2;
        }

        return head;

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


/*

while()
{

}

while(){

}



//a,b,c,d

//a,b,c,a -> while
//a,b,c,b -> while

 */


//mergeFunc(n1,n2)
//mergerFun(n1.next,n2)
//mf(n1.next.next,n2);
//mf(n1.next.next,n2.next)