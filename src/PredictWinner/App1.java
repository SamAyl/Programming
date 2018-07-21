package PredictWinner;

public class App1 {

    public static void main(String[] args) {

    }


    public boolean findWinner(int[] num,int l,int r,int p1,int p2){

      if(l<=r){
          findWinner(num,(l+1),r,selectLeft(num,l,r),p2);
          findWinner(num,l,(r-1),selectRight(num,l,r),p2);


      }else {
          return p1>=p2?true:false;
      }


      return false;
    }


    public int selectLeft(int[] num,int l,int r){
        return num[l];
    }

    public int selectRight(int[] num,int l,int r){
        return num[r];
    }
}


