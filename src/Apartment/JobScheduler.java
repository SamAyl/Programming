package Apartment;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {

    public  static   Map<Lift,Integer> position = new HashMap<>();
    public  static   PriorityQueue<Request> queue = new PriorityQueue<>();
    public  static   List<Lift> Liftz;
    private static   ExecutorService executorService;

    public static void initiate(List<Lift> lifts){
        Liftz = lifts;
        executorService = Executors.newFixedThreadPool(lifts.size());
        for(Lift L : Liftz){
            position.put(L,0);
            executorService.execute(L);
        }

    }

    public static void schedule(Request request){
        queue.add(request);
        JobScheduler.process();

    }

    public static void process(){
        Request r = queue.remove();
        Lift requestLift = getLift(r,position);
        requestLift.resetMode = false;
        requestLift.add(r);




    }


    public static Lift getLift(Request request,Map<Lift,Integer> locMap) {

        int floorNo = request.floorCurrent;
        char dir = request.dir;
        List<Lift> lifts = new ArrayList<>();
        List<Lift> missedLift = new ArrayList<>();

        for (Map.Entry<Lift, Integer> entry : locMap.entrySet()) {

            Lift tempLift = entry.getKey();
            int tempFloor = entry.getValue();

            switch(dir){
                case 'u':
                    if((floorNo >=  tempFloor) || tempLift.resetMode==true ){
                    lifts.add(tempLift);
                       }else if(floorNo< tempFloor){
                    missedLift.add(tempLift);
                }

                break;

                case 'd':

                    if(floorNo<=tempFloor || tempLift.resetMode == true){
                        lifts.add(tempLift);
                    }else if(floorNo > tempFloor){
                        missedLift.add(tempLift);
                    }

                    break;

            }

        }





      if(!lifts.isEmpty()) {
          Collections.sort(lifts);
          return lifts.get(lifts.size() - 1);
      }else {
          System.out.println("ertyuio");
            Collections.sort(missedLift);
            return missedLift.get(0);
      }
    }



}



//         for(Map.Entry<Lift,Character> element : position.entrySet()){
//             if(element.getValue().equals('S')){
//                 r.setFlat(element.getKey());
//                 element.setValue('D');
//                 flatSearch = false;
//                 break;
//             }
//         }


