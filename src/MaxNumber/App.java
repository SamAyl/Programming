package MaxNumber;



import java.util.*;

public class App {

    public static void main(String[] args) {

        String s= "4559474444473022452645";
        int n = 4;


       String result = getComb(s,s.length()-n);
        System.out.println(result);
    }



   public static String getComb(String s, int len){

        List<String> results = new ArrayList<>();
        getComb(s.toCharArray(),0,len,new StringBuilder(),results);
        Collections.sort(results);
        return results.get(results.size()-1);

   }

   public static void getComb(char[] chars,int index,int len,StringBuilder sb,List<String> results){
       if(sb.length()==len){
           String temp = sb.toString();
           results.add(temp);
       }
       if(index>chars.length-1){
           return;
       }

       for(int i = index;i<chars.length;i++){
           sb.append(chars[i]);
           getComb(chars,i+1,len,sb,results);
           sb.deleteCharAt(sb.length()-1);

       }



   }

}
