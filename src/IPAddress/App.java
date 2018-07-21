package IPAddress;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        String s = "127000";
        List<String> sb = findIP(s);
        System.out.println(sb);
    }

    public static List<String> findIP(String s){
        if(s==null || s.isEmpty()){
            return null;
        }

        List<String> ips = new ArrayList<>();
        findIP(s,new StringBuilder(),ips,1,0);
        return ips;
    }


    public static void findIP(String s,StringBuilder sb,List<String> list,int pos,int index){
        if(pos == 4){
            String temp = s.substring(index,s.length());
            if(temp!=null && !temp.isEmpty() && temp.length()>3){
                return;
            }else{
                if(temp!=null && !temp.isEmpty() &&Integer.parseInt(temp)<=255){
                    sb.append(temp);
                    list.add(new String(sb.toString()));
                    sb.delete(sb.length()-temp.length(),sb.length());
                }
            }
        }

        int count  = 0;

        while (count<3 && index+count+1<=s.length()){
            String temp = s.substring(index,index+count+1);
            if(Integer.parseInt(temp)<=255){
                sb.append(temp.toString()+".");
                findIP(s,sb,list,(pos+1),index+count+1);
                sb.deleteCharAt(sb.length()-1);
                sb.delete(sb.length()-temp.length(),sb.length());
            }

            count++;

        }


    }
}
