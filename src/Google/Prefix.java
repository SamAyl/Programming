package Google;

import java.util.Arrays;

public class Prefix {

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String longCommonPrefix = "";

        for(int i = 1;i<strs.length;i++){
            String commonPrefix = getCommonPrefix(strs[i-1],strs[i]);
            if(commonPrefix.equalsIgnoreCase(longCommonPrefix)){
                continue;
            } else if(i>1){
                String tempLongCommonPrefix = getCommonPrefix(longCommonPrefix,commonPrefix);

//                if(tempLongCommonPrefix.length()==0) {
//                    longCommonPrefix = longCommonPrefix.length() > commonPrefix.length() ? longCommonPrefix : commonPrefix;
//                } else {
//                    longCommonPrefix = tempLongCommonPrefix;
//                }


                longCommonPrefix = tempLongCommonPrefix;
            } else {
                longCommonPrefix = commonPrefix;
            }
        }

        return longCommonPrefix;
    }


    private static String getCommonPrefix(String s1,String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i<ch1.length && j<ch2.length){
            if(ch1[i] == ch2[j]){
                sb.append(ch1[i]);
                i++;
                j++;
            } else {
                break;
            }
        }


        return sb.toString();
    }



}
