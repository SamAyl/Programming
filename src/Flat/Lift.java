package Flat;

public class Lift {

    public int floor;
    public char dir;



    public Lift(char dir){

       this.dir = dir;
       floor = (int)(Math.random()*11);

       if(floor ==0){
           dir = 'u';
       }

       if(floor == 10){
           dir = 'd';
       }
    }
}
