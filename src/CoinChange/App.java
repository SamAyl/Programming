package CoinChange;


import java.util.HashMap;
import java.util.Map;

public class App {


     static Map<FindIndexSum,Integer> memory = new HashMap<>();

    public static void main(String[] args){
       int[] num = {1,2,3,4};
       int sum = 6;


        System.out.println(find(num,sum,0));
    }



    public static int find(int[] num,int sum,int start){
         int count = 0;
         for(int i = start;i<num.length;i++){
             if(sum == num[i]){
                 count++;
                 continue;
             }else if(sum < num[i]){
                 continue;
             }else {
                 if(memory.containsKey(new FindIndexSum(i,sum-num[i]))){
                     count+=memory.get(new FindIndexSum(i,sum-num[i]));
                 }else {
                     count += find(num, sum - num[i], i);
                 }
             }
         }
         memory.put(new FindIndexSum(start,sum),count);
         return count;
    }


}


class FindIndexSum{
    int start;
    int sum;

    public FindIndexSum(int start,int sum){
        this.start = start;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FindIndexSum that = (FindIndexSum) o;

        if (start != that.start) return false;
        return sum == that.sum;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + sum;
        return result;
    }
}


