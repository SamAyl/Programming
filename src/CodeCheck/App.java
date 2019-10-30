package CodeCheck;

public class App {

    public static void main(String[] args) {

        try{
            throw new RuntimeException();
        }catch (RuntimeException r){

        }catch (Exception e){
            System.out.println("am here");
        }
    }
}
