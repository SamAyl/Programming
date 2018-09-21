package StepsAgain;



import java.util.*;

public class App {

    public static void main(String[] args) {
        findTotalSteps(5);
    }

    public static void findTotalSteps(int n){
        List<LinkedList<Integer>> steps = new ArrayList<>();
        totalSteps(n,new LinkedList<>(),steps);
        System.out.println(steps);
    }


    public static void totalSteps(int n, LinkedList<Integer> step,List<LinkedList<Integer>> steps){
        int tempSum = getSum(step);
        if(tempSum==n){
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.addAll(step);
            steps.add(linkedList);
            return;
        }else if(tempSum>n){
            return;
        }

        int start = 1;

        while (start<=n){
            step.add(start);
            totalSteps(n,step,steps);
            step.removeLast();
            start++;
        }

    }


    public static int getSum(LinkedList<Integer> list){
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()){
           sum+=it.next();
        }

        return sum;
    }
}
