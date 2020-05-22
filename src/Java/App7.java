package Java;

public class App7 extends App8 {

    @Override
    public void take(int a){
        super.take(a);
    System.out.println(a*a);
    }

  public static void main(String[] args) {
    App7 app7 = new App7();
    app7.take(3);
  }
}
