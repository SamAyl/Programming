package CourseraDSAlgos.week2;

public class GcdFinal {

    public static void main(String[] args) {

        System.out.println(gcd(100,125));

    }

    public static int gcd(int x,int y){
        if(x==0){
            return y;
        }else if(y==0){
            return x;
        }

        if(x==y){
            return x;
        }


        if(x>y){
            return gcd(x%y,y);
        }else {
            return gcd(x,y%x);
        }

    }
}
