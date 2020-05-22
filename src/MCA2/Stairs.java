package MCA2;

import java.util.ArrayList;
import java.util.List;

public class Stairs {

    public static void main(String[] args) {
       // System.out.println(count(3));
        List<String> ans = new ArrayList<>();
        count(4,new StringBuilder(),ans);
        CommonUtils.printString(ans);
    }

    public static int count(int steps) {
        if(steps == 0 || steps == 1) {
            return steps;
        }

        int numberOfSteps1 = 1 + count(steps-1);
        int numberOfSteps2 = 1 + count(steps-2);

        return numberOfSteps1>numberOfSteps2 ? numberOfSteps2 : numberOfSteps1;
    }


    public static void count(int steps, StringBuilder sb, List<String> ans){
        if(steps == 0){
            ans.add(sb.toString());
            return;
        }

        if(steps<0){
            return;
        }


        sb.append(1);
        count(steps-1,sb,ans);

        sb.deleteCharAt(sb.length()-1);
        sb.append(2);
        count(steps-2,sb,ans);
        sb.deleteCharAt(sb.length()-1);
    }



}
