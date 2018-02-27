package Prod;

public class Diff {

    public static int[] a = {1,-1,4,-9,10,0};

    public static void main(String[] args){
        Integer maxDiff = a[a.length-1]-a[a.length-2];

        for(int i=a.length-1;i>0;i--){

              int  tempDiff = getMaxDiff(i);
              if(tempDiff > maxDiff){
                  maxDiff = tempDiff;
              }

        }


        System.out.println(maxDiff);
    }


    public static int getMaxDiff(int l){
        int maxDiff;

        maxDiff = a[l]-a[l-1];

        for(int i= l-2;i>=0;i--){
            int tempDiff = a[l] - a[i];
            if(tempDiff>maxDiff){
                maxDiff = tempDiff;
            }
        }

        return maxDiff;

    }
}
