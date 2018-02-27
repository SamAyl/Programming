package Lambdas.Runnable;

public class App {

    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am in Run method using anonymous class");
            }
        });

        Thread t2 = new Thread(()-> System.out.println("I am in Run method using lambda expression"));

        t1.start();
        t2.start();
    }
}
