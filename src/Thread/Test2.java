package Thread;

public class Test2 implements Runnable {

    private String string;
    @Override
    public void run() {
        System.out.println("Isa method for fluent inteface "+string);

    }

    public Test2 setString(String string){
        this.string = string;
        return this;
    }
}
