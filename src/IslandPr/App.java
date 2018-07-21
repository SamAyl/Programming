package IslandPr;

public class App {

    public static void main(String[] args) {
        int[][] is =      { {1,2,3},
                            {4,5,6},
                            {7,8,9}};

        rotate(is,0,0,0);
        System.out.println(is);

    }

    public static void rotate(int[][] a,int row,int column,int start){

        if(start==a.length){
            return;
        }

        for(int i =start;i<a.length;i++){
           swap(a,i,column,row,i);
        }

        rotate(a,row+1,column+1,start+1);
    }


    public static void swap(int[][] a,int r1,int c1,int r2,int c2){
        int temp = a[r1][c1];
        a[r1][c1] = a[r2][c2];
        a[r2][c2] = temp;
    }
}
