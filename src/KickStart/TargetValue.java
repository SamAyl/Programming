package KickStart;

import java.util.*;

public class TargetValue {


    public static void main(String[] args) {

        generate_all_expressions("234",9);
    }
    /*
     * Complete the function below.
     */
    static String[] generate_all_expressions(String s, long target) {
        if(s==null ){
            return null;
        }

        if(s.isEmpty()){
            return new String[0];
        }

        List<String> exp = new ArrayList<>();
        generate_all_expressions(s.toCharArray(),new StringBuilder(s.charAt(0)),exp,1);
        return checkForTarget(exp,target);
    }

    static void generate_all_expressions(char[] ch,StringBuilder sb,List<String> list,int index){
        if(index==ch.length-1){
            String temp = sb.toString();
            list.add(temp);
        }

        sb.append(ch[index]);

        sb.append("");
        generate_all_expressions(ch,sb,list,index+1);
        sb.deleteCharAt(sb.length()-1);

        sb.append("*");
        generate_all_expressions(ch,sb,list,index+1);
        sb.deleteCharAt(sb.length()-1);


        sb.append("+");
        generate_all_expressions(ch,sb,list,index+1);
        sb.deleteCharAt(sb.length()-1);
    }


    static String[] checkForTarget(List<String> list,long target){
        List<String> res = new ArrayList<>();

        for(String s : list){
            long sum = getSum(s);
            if(sum==target){
                res.add(s);
            }
        }

        return res.toArray(new String[res.size()]);
    }




    static long getSum(String s){
        String[] addOperands = s.split("/+");

        if(addOperands!=null){
            for(int i = 0;i<addOperands.length;i++){
                if(addOperands[i].contains("*")){
                    String mulOperand = addOperands[i];
                    String[] operand = mulOperand.split("/*");
                    Long prod = new Long(1);
                    for(String s2:operand){
                        prod = prod * Long.parseLong(s2);
                    }
                    addOperands[i] = prod.toString();
                }
            }


            Long sum = new Long(0);
            for(String s1 : addOperands){
                sum+=Long.parseLong(s1);
            }

            return sum;
        }else{
            return Long.parseLong(s);
        }



    }




}
