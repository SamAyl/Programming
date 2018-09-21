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


    public enum Operations{
        INSERT("insert"),
        UPDATE("update"),
        DELETE("delete");

        private String op;

        private Operations(String op){
            this.op = op;
        }

        public String getOp(){
            return op;
        }
    }

    public static void main(String[] args){

        System.out.println(Directions.EAST.getVal());
        System.out.println(Operations.INSERT.getOp());


    }

}
