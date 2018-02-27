package Lambdas.Functional;

public class App {

    public static void main(String[] args){
        Int it = ()-> System.out.println("Isa is Will");
        App app = new App();
        app.print(it);
    }

    public void print(Int it){
        it.f1();
    }
}
