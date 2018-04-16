package Threading;

import java.util.Scanner;

public class Volatile extends Thread {

    private volatile
    boolean running = true;

    @Override
    public void run(){
        while (running){
            try {
                Thread.sleep(100);
                System.out.println("I am running ISA");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){

        running = false;
    }


    public static void main(String[] args){
        Volatile v1 = new Volatile();
        v1.start();

        System.out.println("Please press enter to break the run");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        v1.shutdown();

    }
}
