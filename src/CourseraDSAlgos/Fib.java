package CourseraDSAlgos;

public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }


    public static int fib(int x){
        if(x==1 || x==0){
            return x;
        }else {
            return fib(x-1)+fib(x-2);
        }
    }
}
