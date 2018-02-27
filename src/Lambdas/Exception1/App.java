package Lambdas.Exception1;

public class App {

    public static void main(String[] args){
        ConsumerImpl c1 = new ConsumerImpl();
        run(wrapConsumer(c1),4,0);

    }

    public static void run(Consumer c,int i,int j){
        c.accept(i,j);
    }
    public static Consumer wrapConsumer(ConsumerImpl c){
        return new Consumer(){

            @Override
            public void accept(int i, int j) {
                try {
                    c.accept(i, j);
                }catch (Exception e){
                    System.out.println("Exception has occurred, Kindly change the inputs");
                }
            }
        };
    }
}
