package Lambdas.This;

public class App {

    public void execute(){
        print(p-> System.out.println(this));
    }
    public static void main(String[] args){
     App app = new App();
     app.execute();
    }

    public void print(Program p){
        p.print(2);
    }

    @Override
    public String toString() {
        return "App{I am in App class}";
    }
}
