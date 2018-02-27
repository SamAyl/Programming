package Threads;


class Run extends Thread{

    @Override
    public void run(){
        for(int i = 0;i<10;i++) {
            System.out.println("am in Run method  "+i);
        }
    }
}
public class App1 {

    public static void main(String[] args) throws InterruptedException{
        Run run = new Run();
        run.start();
        run.join();
        System.out.println("Finished task");
    }
}
