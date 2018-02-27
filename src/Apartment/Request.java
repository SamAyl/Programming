package Apartment;

public class Request implements Comparable<Request>{

    int floorCurrent;
    char dir;
    int floorEnd;


    public Request(int floorCurrent,char dir,int floorEnd){
        this.floorCurrent = floorCurrent;
        this.dir = dir;
        this.floorEnd = floorEnd;
    }




    @Override
    public int compareTo(Request o) {
        if(this.floorEnd > o.floorEnd){
            return 1;
        }else if(this.floorEnd < o.floorEnd){
            return -1;
        }else {
            return 0;
        }
    }
}
