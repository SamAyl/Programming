package Apartment;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lift implements Runnable,Comparable<Lift> {

    public int floorCurrent;
    public char dir;
    public int floorEnd;
    public int maxfloors;
    public int minfloors;
    boolean power = true;
    boolean resetMode = true;
    private volatile  Queue<Request> requests = new PriorityQueue<>();



    public Lift(int floorCurrent, char dir,int maxfloors,int minfloors){
        this.floorCurrent = floorCurrent;
        this.dir = dir;
        this.floorEnd = floorCurrent;
        this.maxfloors = maxfloors;
        this.minfloors = minfloors;

    }



    public void run(){
        System.out.println(" running thread "+Thread.currentThread().getName());
        while (power){
                try {
                    if ((floorCurrent != floorEnd && floorCurrent < floorEnd) && dir=='u') {
                        floorCurrent++;
                        if (floorCurrent == maxfloors) {
                            dir = 'd';
                        }
                        checkUpRequest();
                        JobScheduler.position.put(this, floorCurrent);
                       Thread.sleep(1000);
                        System.out.println("am here "+floorCurrent +"==="+Thread.currentThread().getName());
                        check();

                    } else if ((floorCurrent != floorEnd && floorCurrent > floorEnd) && dir == 'd') {
                        floorCurrent--;
                        if (floorCurrent == minfloors) {
                            dir = 'u';
                        }
                        checkDownRequest();
                        JobScheduler.position.put(this, floorCurrent);
                        Thread.sleep(1000);
                        System.out.println("am here");
                        check();
                    } else if(dir == 'D'){
                        while (floorCurrent!=floorEnd){
                            floorCurrent--;

                        }

                       dir = 'u';
                    }else {
                        if (dir == 'u') {
                            checkUpRequest();
                        } else {
                            checkDownRequest();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

        }



    }

    @Override
    public int compareTo(Lift o) {
        if(this.floorCurrent == o.floorCurrent){
            return 0;
        }else if(this.floorCurrent > o.floorCurrent){
            return 1;
        }else{
            return  -1;
        }
    }

    public synchronized void add(Request request){
        requests.add(request);
    }


    public void checkUpRequest(){
        if(!requests.isEmpty()){
            Request tempReq =  requests.remove();
            if(tempReq.floorCurrent >=this.floorCurrent && tempReq.floorEnd > this.floorEnd ){
                this.floorEnd = tempReq.floorEnd;
            }else if(tempReq.floorCurrent < this.floorCurrent){
                requests.add(new Request(this.floorEnd,'D',tempReq.floorCurrent-1));
                requests.add(tempReq);
            }else if(tempReq.dir == 'D'){
                this.dir = 'D';
                this.floorCurrent = tempReq.floorCurrent;
                this.floorEnd = tempReq.floorEnd;
            }
        }
    }


    public void checkDownRequest(){
        if(!requests.isEmpty()){
            Request tempReq =  requests.remove();
            if(tempReq.floorCurrent<=this.floorCurrent && tempReq.floorEnd < this.floorEnd){
                this.floorEnd = tempReq.floorEnd;
            }else if(tempReq.floorCurrent > this.floorCurrent){
                requests.add(tempReq);
            }
        }
    }

    public void check(){
        if(floorCurrent == floorEnd){
            System.out.println("destination reached");
        }

//        if(requests.isEmpty()){
//            Thread.
//        }

    }
}
