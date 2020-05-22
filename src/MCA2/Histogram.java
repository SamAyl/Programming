package MCA2;

import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {
        int[] a = {2,1,5,6,1,4};

        int[] res = new int[6];
        leftTraversal(a,res);
        System.out.println(res);
        rightTraversal(a,res);
        System.out.println(res);

    }

    public static void leftTraversal(int[] a, int[] res){
        Stack<Integer> index = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for(int i = 0;i <a.length; i++){

            if(val.isEmpty()){
                val.add(a[i]);
                index.add(i);
            } else {

                while(!val.isEmpty() && a[i]< val.peek()){
                    int ans = val.pop();
                    int indexVal  = index.pop();

                    res[indexVal] = ans * (i - indexVal);

                }

                index.add(i);
                val.add(a[i]);
            }
        }


        while (!val.isEmpty()) {
            int ans = val.pop();
            int ansIndex = index.pop();

            res[ansIndex] = ans * (res.length - ansIndex);
        }
    }

   public static void rightTraversal(int[] a, int[] res){
       Stack<Integer> index = new Stack<>();
       Stack<Integer> val = new Stack<>();

       for(int i = a.length-1;i >=0 ; i--){

           if(val.isEmpty()){
               val.add(a[i]);
               index.add(i);
           } else {

               while(!val.isEmpty() && a[i]< val.peek()){
                   int ans = val.pop();
                   int indexVal  = index.pop();

                   res[indexVal] = res[indexVal] + ans * (indexVal-i) - ans;

               }

               index.add(i);
               val.add(a[i]);
           }
       }


       while (!val.isEmpty()) {
           int ans = val.pop();
           int ansIndex = index.pop();

           res[ansIndex] = res[ansIndex] +  ans * (ansIndex - 0);
       }
   }
}
