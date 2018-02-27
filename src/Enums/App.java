package Enums;

public class App {

    public enum Directions{
        NORTH("2"),
        SOUTH("3"),
        EAST("1"),
        WEST("2");

        private Directions(String val){
          this.val = val;
        }

        private String val;


        public String getVal(){
            return  val;
        }
    }

    public static void main(String[] args){
        System.out.println(Directions.EAST.getVal());
    }
}
