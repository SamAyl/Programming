package Rot90;

public class App {

    public static void main(String[] args) {
        int[][] a = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};

        rotate(a,0,3);
        System.out.println(a);
    }

    public static void rotate(int[][] a,int i,int size){
        if(size<=0){
            return;
        }

        for(int j = i;j<i+size;j++) {
            swap(a, i, size, j);
        }


        rotate(a,i+1,size-2);
    }


    public static void swap(int[][] a,int i,int size,int element){

        //right
        int temp =  a[i+element][i+size];
        a[i+element][i+size] = a[i][i+element];

        //bottom
        int temp1 = a[i+size][i+size-element];
        a[i+size][i+size-element] = temp;


        //left
       temp = a[i+size-element][i] ;
       a[i+size-element][i] = temp1;


       //up
       a[i][i+element] = temp;

    }

}
