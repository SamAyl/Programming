package Java;

public class App2 {

    public static void main(String[] args) throws Exception {
        check(1);
    }

    public static void check(int v) throws Exception{
        try{

            if(v==1){
                throw new Exception("it is a check");
            }
        }finally {
            System.out.println("am here");
        }

        System.out.println("am outside of the try catch");
    }
}
