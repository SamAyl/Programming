package DailyByte;

public class RemoveElementsFromLL {

    public static void main(String[] args) {
            Nod1 n1 = new Nod1(1);
            Nod1 n2 = new Nod1(1);
            Nod1 n3 = new Nod1(1);
            Nod1 n4 = new Nod1(1);
            Nod1 n5 = new Nod1(1);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;

            Nod1 root = remove(n1,1);

            while (root!= null) {
                System.out.println(root.v);
                root = root.next;
            }
    }

    public static Nod1 remove(Nod1 root, int v) {

        Nod1 movingRoot = root;

        while (movingRoot.next != null) {

            if (movingRoot.next.v ==v) {
                movingRoot.next = movingRoot.next.next;

            } else {
                movingRoot = movingRoot.next;
            }
        }

        if (root.v == v) {
            root = root.next;
        }

        return root;
    }
}

class Nod1 {
    int v;
    Nod1 next;

    public Nod1(int v) {
        this.v = v;
    }
}
