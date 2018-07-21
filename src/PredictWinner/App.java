package PredictWinner;

public class App
{

    public static void main(String[] args) {

        int[] num = {2,4,55,6,8};
        System.out.println(findWinner(num));
    }

    public static boolean findWinner(int[] num){

        if(num.length==1){
            return true;
        }


        int indexMax = getScore(0,num.length-1,num);
        int indexMin = getScoreMin(0,num.length-1,num);

        boolean result1 = false;
        boolean result2 = false;

        if(indexMax == 1){
            result1 = findWinner(num,1,num.length-1,num[0],0);
        }else {
            result1 = findWinner(num,0,num.length-2,num[num.length-1],0);
        }

        if(indexMin == 1){
            result2 = findWinner(num,1,num.length-1,num[0],0);
        }else {
            result2 = findWinner(num,0,num.length-2,num[num.length-1],0);
        }


        if(result1 || result2){
            return true;
        }

        return false;


    }

    public static boolean findWinner(int[] num,int l,int r,int p1,int p2){


        while (l<r){

            int posForPlayer2 = getScore(l,r,num);
            if(posForPlayer2==1){
                p2+=num[l];
                l++;
            }else {
                p2+=num[r];
                r--;
            }


            int posForPlayer1 = getScore(l,r,num);

            if(posForPlayer1 ==1){
                p1+=num[l];
                l++;
            }else {
                p1+=num[r];
                r--;
            }



        }

        return p1>=p2?true:false;
    }


    public static int getScore(int l,int r, int[] num){

        return num[l]>num[r]?1:-1;
    }



    public static int getScoreMin(int l,int r,int[] num){
        return num[l]<num[r]?1:-1;
    }
}
