package GraphsCoursera;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ConnectedComponents {

    public static void main(String[] args) {

        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[5];
        int cc= 0;
        Set<Integer> visited = new HashSet<>();


        for(int i = 0;i<adj.length;i++){
            if(!visited.contains(i)){
                cc++;
                dfs(adj,i,visited);
            }
        }

    }

    public static void dfs(ArrayList<Integer>[] adj, int v, Set<Integer> visited){

        if(visited.contains(v)){
            return;
        }

        visited.add(v);
        for(Integer i : adj[v]){
          dfs(adj,i,visited);
        }

        return;
    }
}
