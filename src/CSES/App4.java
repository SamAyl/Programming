package CSES;

public class App4 {

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 1, 9, 5, 6};
        App4 app4 = new App4();
        System.out.println(app4.countInversions(a));
    }


    public int countInversions(int[] array) {
        int[] count = new int[1];
        Nod root = new Nod(array[0]);
        for (int i = 1; i< array.length; i++) {
            add(array[i],root,count);
        }
        return count[0];
    }

    public void add(int val, Nod root, int[] count) {

        if (root.v < val) {
            count[0]+=1;
            count[0]+=root.rightCount;

            if (root.left != null) {
                add(val,root.left,count);
                return;
            } else {
                root.left = new Nod(val);
                return;
            }

        }else if (root.v == val) {
            count[0]+=root.rightCount;
            if (root.left != null) {
                add(val,root.left,count);
                return;
            }else {
                root.left = new Nod(val);
                return;
            }
        }	else {
            root.rightCount++;
            if (root.right != null) {
                add(val,root.right,count);
                return;
            } else {
                root.right = new Nod(val);
                return;
            }

        }
    }
}



class Nod {
    int v;
    Nod left;
    Nod right;

    int rightCount=0;

    public Nod(int v) {
        this.v = v;
    }
}
