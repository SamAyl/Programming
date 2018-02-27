package Flat;


import java.util.*;

public class Apt {

    public int noOfFloors;
    public List<Lift> lifts;


    public Apt(int floors){
        noOfFloors = floors;

        Lift l1 = new Lift('u');
        Lift l2 = new Lift('u');
        lifts.add(l1);
        lifts.add(l2);

        Lift l3 = new Lift('d');
        Lift l4 = new Lift('d');
        lifts.add(l3);
        lifts.add(l4);



    }


    public Lift getLift(char ch,int currFloor){

         List<Lift> lift = new ArrayList<>();
         Map<Integer,Lift> map = new TreeMap<>();

        if(ch == 'u'){
            for(Lift l : lifts){
                if(l.dir == 'u' && l.floor<=currFloor ){
                    lift.add(l);
                }
            }

            if(lift.isEmpty()){


                for(Lift l : lifts){

                    int stops = getStops(ch,currFloor,l.dir,l.floor);
                    map.put(stops,l);


                }



            }
        }


        return null;

    }


    public int getStops(char ch,int currFloor,char liftDir,int liftFloor){
        int stops;

        if(ch=='u' && liftDir == 'u'){
            stops =  (this.noOfFloors-liftFloor) + (this.noOfFloors-1)+(currFloor-1);
        }else if(ch == 'u' && liftDir == 'd'){
            stops = (liftFloor-1)+(currFloor-1);
        }else if(ch == 'd' && liftDir == 'd'){
             stops = (liftFloor -1) + (this.noOfFloors-1)+(this.noOfFloors-currFloor);

        }else {
            stops = (this.noOfFloors - liftFloor) + (this.noOfFloors-1-currFloor);
        }

        return stops;
    }



}
