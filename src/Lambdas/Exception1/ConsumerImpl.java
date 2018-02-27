package Lambdas.Exception1;

public class ConsumerImpl implements Consumer{


    @Override
    public void accept(int i, int j) {
        System.out.println(i/j);
    }
}
