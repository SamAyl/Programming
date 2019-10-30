package GraphsCoursera;

import java.util.ArrayList;
import java.util.*;

public class Reachability {



    private static int dfs(ArrayList<Integer>[] adj,int str,int end,Set<Integer> visited){

        if(visited.contains(str)){
            return 0;
        }

        visited.add(str);
        int check = 0;
        for(Integer i : adj[str]){

            if(i==end){
                return 1;
            }else {
               check =  dfs(adj,i,end,visited);
               if(check==1){
                   return check;
               }
            }
        }

        return check;
    }
}
