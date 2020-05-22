package Java;

public class App11 {

  public static enum isa {
    isa1,isa2
  };
  public static void main(String[] args) {


    System.out.println(mul(10,0));
  }


  public static int mul(int x, int y){


    if(x == 0 || y== 0){
      return 0;
    }

    if( y== 1){
      return x;
    }

    return x + mul(x, y-1);

  }
}
