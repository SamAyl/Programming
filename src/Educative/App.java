package Educative;

public class App {

    public static void main(String[] args) {

        int[] w = {1,2,3,4,5,6,7,8,9,10};
        int[] ans = findMaximum(w,5);
        System.out.println(ans);

    }

    public static  int findMinimumSum(int[] w,int sum){

       int lsum = 0;
       int rsum = 0;

       int l = 0;
       int r =w.length-1;


     //  while (sum>=lsum || sum)


return 0;

    }

    public static int[] findMaximum(int[] w,int d){

       int s = 0;
       int e = d-1;
       int sum = sum(w,0,e);

       int l = 0;
       int r = d-1;


       e++;
       while (e<w.length){
           int temp = sum;
           temp = temp - w[s];
           temp = temp+w[e];

           if(temp<sum){
               temp = sum;
               l = s+1;
               r = e;
           }
           s++;
           e++;
       }

       int[] ans = new int[3];
       ans[0] = s;
       ans[1] = e;
       ans[2] = sum;

       return ans;

    }

    private static int sum(int[] w,int s,int e){

        if(s>e){
            return 0;
        }
        int sum = 0;

        for(int i = s;i<=e;i++){
           sum+=w[i];
        }

        return sum;
    }




}
