package ByteByByte;

import java.util.*;

public class Palindrome {


    public static void main(String[] args) {
        String s = "abcba";
        Map<Integer,int[]> map = new HashMap<>();
        fill(map,s);

        System.out.println(strMax);
        for(int k : map.keySet()) {
            System.out.println("Index "+k+"---"+"str :"+map.get(k)[0]+"  end :"+map.get(k)[1]);
        }
    }

    static int  max = 0;
    static String strMax;


    public static void fill(Map<Integer,int[]> map,String s){



        char[] ch = s.toCharArray();

        int[] refIndex = new int[2];
        refIndex[0] = -1;
        refIndex[1] = -1;




        for(int i = 0;i<ch.length;i++){
            int[] ans = getIndices(i,ch,map,refIndex);
            map.put(i,ans);
        }


    }

    public static int[] getIndices(int i,char[] ch, Map<Integer,int[]> map, int[] refIndex){


        int str = -1;
        int end = -1;

        if(refIndex[0] != -1){
            int[] tempAns = map.get(refIndex[0]);

            if(tempAns[0]< i && tempAns[1] > i){
                int mirrorIndex = (i - (refIndex[0] +refIndex[1]) + 1);
                int[] mirrorIndexAns = map.get(mirrorIndex);


                System.out.println("=================="+i);

               if((tempAns[0] < mirrorIndexAns[0] && mirrorIndexAns[0] > tempAns[1])
                  && tempAns[0] < mirrorIndexAns[1] && mirrorIndexAns[1] > tempAns[1]) {
                   str =  i - 1 - (mirrorIndex-mirrorIndexAns[0]);
                   end =  i + 1 + (mirrorIndex-mirrorIndexAns[1]);

                   int[] ans = new int[2];
                   ans[0] = str;
                   ans[1] = end;

                   checkMax(ch,ans[0],ans[1]);
                   return ans;
               } else if((tempAns[0] <= mirrorIndexAns[0] && mirrorIndexAns[0] >= tempAns[1])
                       && tempAns[0] <= mirrorIndexAns[1] && mirrorIndexAns[1] >= tempAns[1]){
                   str =  i - 1 - (mirrorIndex-mirrorIndexAns[0]);
                   end =  i + 1 + (mirrorIndex-mirrorIndexAns[1]);
               } else {
                   str = i;
                   end = i;
               }
            } else {
                str = i;
                end = i;
            }

        } else {
            str = i;
            end = i;
        }



//        int str = i;
//        int end = i;

//        if((i+1<ch.length && ch[i+1] == ch[i]) && ( i-1 >=0 && ch[i-1] == ch[i])){
//            str = i-1;
//            end = i+1;
//        } else if(i+1<ch.length && ch[i+1] == ch[i]){
//            str = i;
//            end = i+1;
//        } else if( i-1 >=0 && ch[i-1] == ch[i]){
//            str = i-1;
//            end = i;
//        }

        int[] evenAns = getAns(str,end+1,ch);
        int[] oddAns = getAns(str,end,ch);
        int[] ans = null;

        if(evenAns==null){
            ans = oddAns;
            refIndex[1] = 0;
        } else if(evenAns[1]-evenAns[0] > oddAns[1] - oddAns[0]) {
            ans = evenAns;
            refIndex[1] = 1;
        } else {
            ans = oddAns;
            refIndex[1] = 0;
        }

        checkMax(ch,ans[0],ans[1]);
        refIndex[0] = i;
        return ans;
    }

    private static void checkMax(char[] ch, int str, int end) {
        if(end-str+1 > max){
            StringBuilder sb = new StringBuilder();
            for(int i = str;i<=end;i++){
                sb.append(ch[i]);
            }

            strMax = sb.toString();
            max = strMax.length();
        }
    }


    private static int[] getAns(int str, int end ,char[] ch){
        if(end==ch.length){
            return null;
        }

        if( ch[str] != ch[end]) {
            return null;
        }

        while(str>=0 && end<ch.length){
            if(ch[str]==ch[end]){
                str--;
                end++;
            } else {
                break;
            }
        }

        int[] ans = new int[2];
        ans[0] = str+1;
        ans[1] = end-1;

        return ans;
    }
}
