package KickStart;

import java.util.*;

public class Exp {

    public static void main(String[] args) {
        String s = "2341";

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getExp(s.toCharArray(),1,2,10,sb.append(2),list);
        System.out.println(list);
    }

    public static void getExp(char[] ch,int index,int val,int tot,StringBuilder sb,List<String> list){

        if(index == ch.length){
            if(tot == val){
                list.add(sb.toString());

            }

            return;
        }

        char c = ch[index];
        Integer num = Integer.parseInt(String.valueOf(c));

        int temp1 = val * num;
        int temp2 = val + num;

        if(temp1<=tot){
            sb.append("*");
            sb.append(num);
            getExp(ch,index+1,temp1,tot,sb,list);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }

        if(temp2<=tot){
            sb.append("+");
            sb.append(num);
            getExp(ch,index+1,temp2,tot,sb,list);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
