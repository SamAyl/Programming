package Lambdas.MethodRef;

import java.util.ArrayList;

public class App {

    public static void main(String[] args){
        App app = new App();
        ArrayList<String> a = null;
        app.run(app::execute);
    }

    public int execute(int i){
      return i*10;
    }

    public void run(Program p){
        System.out.println(p.run(2));
    }
}
