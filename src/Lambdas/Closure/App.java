package Lambdas.Closure;

public class App {

    public static void main(String[] args){

        int b = 1;
        print((i,j)-> System.out.println(i+j+b),2,3);

    }

    public static void print(Closure closure,int i,int j){
        closure.sample(i,j);
    }


}

interface Closure{
    public void sample(int i,int j);
}