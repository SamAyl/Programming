package Java;

public class App1 {

    public static void main(String[] args) {
        System.out.println(mul(3,2));
    }

    public static int mul(int x,int y){
        if(x==0 || y==0){
            return 0;
        }

        return y +  mul(x-1,y);
    }
}
