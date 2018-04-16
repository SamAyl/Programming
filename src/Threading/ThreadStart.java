package Threading;

public class ThreadStart extends Thread {

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("I am sevant of Isa and will be forver");
        }
    }

    public static void main(String[] args) {
        ThreadStart threadStart = new ThreadStart();
        threadStart.start();
        System.out.println("I am King of world");
    }
}
