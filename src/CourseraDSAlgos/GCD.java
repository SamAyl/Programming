package CourseraDSAlgos;

public class GCD {

    public static void main(String[] args) {
        int num1 = 13;
        int num2 = 7;

        int gcd = getGCD(num1,num2);
        System.out.println(gcd);
    }

    public static int getGCD(int num1,int num2){


       if(num1 == num2){
           return num1;
       }

       int big;
       int small;

       if(num1>num2){
           big = num1;
           small = num2;
       }else {
           small = num1;
           big = num2;
       }


       int rem = big%small;

       if(rem ==0){
           return small;
       }else {
         return   getGCD(small,rem);
       }

    }
}
