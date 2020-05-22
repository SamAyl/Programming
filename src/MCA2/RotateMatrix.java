package MCA2;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        print(a);
        System.out.println("======================");
        rotate(a);
        print(a);
    }


    public static void rotate(int[][] a){
      int size = a.length;
      int x = 0;
      int y = 0;
      while(size>1){
          rotate(a,x,y,size);
          x++;
          y++;
          size-=2;
      }
    }

    public static void rotate(int[][] a, int i, int j, int size) {


        int x1 = i;
        int y1 = j;

        int x2 = i;
        int y2 = j+size-1;

        int x3 = i+size-1;
        int y3 = j+size-1;

        int x4 = i+size-1;
        int y4 = j;

        for(int c = 0;c<size-1;c++){

            int temp = a[x1][y1+c];

            temp =  swap(a,x2+c,y2,temp);
            temp = swap(a,x3,y3-c,temp);
            temp = swap(a,x4-c,y4,temp);
            temp = swap(a,x1,y1+c,temp);

        }
    }


    public static int swap(int[][] a,int x,int y,int temp){
        int temp1 = a[x][y];
        a[x][y] = temp;
        return temp1;
    }

    public static void print(int[][] a){
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
