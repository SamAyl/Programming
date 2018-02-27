package Lambdas.Functional;

@FunctionalInterface
public interface Int {

    public void f1();

    public default void f2(){
        System.out.println("am in f2");
    }

    public default  void f3(){
        System.out.println("am in f3");
    }
}
