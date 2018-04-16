package Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);



        List<List<Integer>> solutions  = new ArrayList<>();
        findnum(list,solutions,new ArrayList<>(),0,new HashSet<>());
        System.out.println(solutions);
        System.out.println(solutions.size());
    }


    public static void findnum(List<Integer> num, List<List<Integer>> solutions, List<Integer> currentSolution, int count,Set<Integer> visited){
        if(count == num.size()){
            List<Integer> tempList = new ArrayList<>(currentSolution);
            solutions.add(tempList);
            return;
        }

        for(int i = 0;i<num.size();i++){
            if(!visited.contains(i)) {
                currentSolution.add(num.get(i));
                visited.add(i);
                findnum(num, solutions, currentSolution, count + 1,visited);
                currentSolution.remove(currentSolution.size() - 1);
                visited.remove(i);
            }
        }
    }
}
