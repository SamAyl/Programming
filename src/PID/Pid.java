package PID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pid {

    List<Integer> pid;
    List<Integer> ppid;


    public Pid(List<Integer> pid,List<Integer> ppid){
        this.pid = pid;
        this.ppid = ppid;
    }

    public List<Integer> deletePid(int pidNum){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<pid.size();i++){
           map.put(ppid.get(i),pid.get(i));
        }

        List<Integer> list = new ArrayList<>();
        list.add(pidNum);
         getDeletedPid(pidNum,map,list);

         return list;
    }


    public void getDeletedPid(int pid, Map<Integer,Integer> map, List<Integer> list){
        list.add(map.get(pid));

        if(map.containsKey(map.get(pid))){
            getDeletedPid(map.get(map.get(pid)),map,list);
        }

        return;
    }
}
