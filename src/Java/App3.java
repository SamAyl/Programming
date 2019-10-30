package Java;

public class App3 {

    private static void check(int j) throws Exception{
        try{
            System.out.println("am here in try");
            if(j==0) {
                throw new Exception();
            }
            System.out.println("am here after the exception");
        }finally {
            System.out.println("am here in finally");
        }
    }

    public static void main(String[] args) {
        try {
            check(0);
        }catch (Exception e){

        }
    }
}
