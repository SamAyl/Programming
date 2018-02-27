package Apartment;

import java.util.ArrayList;
import java.util.List;

public class Apt {

    Floor[] floors;
    int flatCount;
    int floorCount;

    public Apt(int flatCount,int floorCount ){
        this.flatCount = flatCount;
        this.floorCount = floorCount;
        floors = new Floor[floorCount];

        List<Lift> lifts = makeFlats(flatCount);
        setFloors(floors);
        floors[0].lifts = lifts;

        JobScheduler.initiate(lifts);
    }

    public List<Lift> makeFlats(int flatCount){
        List<Lift> lifts = new ArrayList<>();
        for(int i = 0;i<flatCount;i++){
            lifts.add(new Lift(0,'u',floorCount,0));
        }
        return lifts;
    }

    public void setFloors(Floor[] floors){
        for(int i = 0;i<floors.length;i++){
            floors[i] = new Floor();
            floors[i].floorNo = i;
        }
    }


    public void schedule(int floorCurrent,char dir,int floorEnd){
        Request request = new Request(floorCurrent,dir,floorEnd);
        System.out.println("am scheduling.....");
        JobScheduler.schedule(request);

    }







}
