package Lambdas;

public class App {

    public static void main(String[] args){

        App app = new App();
        Greet greet1 = () -> System.out.println("am in lambda,Thanks to IsBa");
        Count c1 = s -> s.length();
        app.takeGreer(greet1);
        app.takeGreer(new HelloWorld());
        app.countGreer(c1);
    }

    public void takeGreer(Greet greet){
        greet.perform();
    }

    public void countGreer(Count c){
        System.out.println(c.len("Isa"));
    }
}
