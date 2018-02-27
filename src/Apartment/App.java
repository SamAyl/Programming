package Apartment;

public class App {


    public static void main(String[] args){

        Apt apt = new Apt(4,10);
        apt.schedule(3,'u',9);
        apt.schedule(4,'u',8);
        apt.schedule(0,'u',8);
        apt.schedule(5,'u',9);
       // apt.schedule(2,'u',8);
//        apt.schedule(8,'d');
    }
}
