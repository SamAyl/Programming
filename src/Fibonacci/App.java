package Fibonacci;

public class App {


    public static void main(String[] args){
//        int n = 13;
//        int x = 2;
//        if(n%2!=0){
//            System.out.println(x *cal(x,n-1));
//        }else {
//            System.out.println(cal(x,n));
//        }

        System.out.println(mult(12,2));
    }


    public static int cal(int x,int n){

        double val = Math.log(n)/Math.log(2);
        double ref = Math.floor(val);

        if(val-ref==0){
          return   mul(x,n);
        }else {
             int n1 = (int)(Math.round(Math.exp(ref * Math.log(2))));
             return mul(x,n1) * cal(x,(n-n1));

        }


    }
    public static int mul(int x,int n){

            while (n!=1){
                x*=x;
                n = n/2;
            }


        return x;
    }

    public static int mult(int n,int x){
        if(n==1){
            return x;
        }else {
            boolean odd = false;
            if(n%2!=0){
               n = n-1;
               odd = true;
            }
            n = n/2;
            int val = mult(n,x);
            if(odd){
                return x*val*val;
            }
            return val*val;
        }
    }
}
