package Thread;

import java.util.concurrent.*;

public class App1 {

    public static void main(String[] args) {
       Test test = new Test();
       Thread t1 = new Thread(test);
       t1.start();

       Thread t2= new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("Isa a anonymous method");
           }
       });

       t2.start();


       Thread t3 = new Thread(()-> System.out.println("Isa a lambda method"));
       t3.start();

       new Thread(new Test2().setString("ISA ?")).start();

       Thread t4 = new Thread();
       t4.run();
    }


}
