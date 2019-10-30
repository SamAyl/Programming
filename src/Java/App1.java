package Java;

public class App1 {

    public static void main(String[] args) {
        Parent p1 = new Child1();

        if (p1 instanceof Child1) {
            System.out.println(" P1 is instance of Child1");
//        }else if(p1 instanceof Child2){
//            System.out.println("P");
//        }
        }
    }


    public static boolean check(Parent p){

        if(p instanceof Child1){
            return true;
        }

        if(p instanceof Child2){

        }

        return false;
    }
}
