package Island;

public class App {

    public static void main(String[] args) {
         int[][] a = {
                 {0,0,0},
                 {0,0,0},
                 {0,0,0}
         };

        System.out.println(getIslandCount(a));
    }

    public static int getIslandCount(int[][] a){
        int count = 0;
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                if(a[i][j]==1){
                  count(a,i,j);
                  count++;
                }
            }
        }

        return count;
    }


    public static void count(int[][] a,int i,int j){
        a[i][j] = -1;
        if(i+1<a.length && a[i+1][j] == 1){
            count(a,i+1,j);
        }

        if(i-1>=0 && a[i-1][j]==1){
            count(a,i-1,j);
        }

        if(j+1<a[0].length  && a[i][j+1]==1){
            count(a,i,j+1);
        }

        if(j-1>=0 && a[i][j-1]==1){
            count(a,i,j);
        }
    }
}
