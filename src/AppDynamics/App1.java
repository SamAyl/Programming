package AppDynamics;

/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
         String s = getNextGreaterNumber("123");
        compareAndNextBigger("213");
        System.out.println(output);
          System.out.println(s);
    }



/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://app.coderpad.io/settings

Enjoy your interview!


1. Find next greater number with same set of digits
Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"





 */



    static String output = "Not Possible";
   // static String output = "132";

    public static String getNextGreaterNumber(String num) {




        if (num == null || num.length() == 0 || num.length() == 1) {

            return num;
        }


        char[] ch = num.toCharArray();
        Arrays.sort(ch);

        Map<Character,List<Integer>> map = generateMap(ch);


        Set<Integer> visitedIdx = new HashSet<>();



        getNextNumber(num,0,ch,map,visitedIdx,new StringBuilder());

        return output;

    }


    public static void getNextNumber(String num, int idx, char[] ch,Map<Character,List<Integer>> map, Set<Integer> visitedIdx, StringBuilder sb) {

        if (idx == num.length()) {

            String temp = sb.toString();

            System.out.println("<==================>"+ temp);
            if (!temp.equalsIgnoreCase(num) && temp.compareToIgnoreCase(num)>0) {
                compareAndNextBigger(temp);
            }
            return;

        }



        char currentNumber = num.charAt(idx);
        System.out.println("================> currentNumber"+currentNumber);
        List<Integer> currentNumberIdices = map.get(currentNumber);


//   for (int singleIndex : currentNumberIdices) {
//            System.out.println("================> startIndex"+ singleIndex);
//         for (int i = singleIndex; i<ch.length;i++) {

//             if (!visitedIdx.contains(i)) {
//                 visitedIdx.add(i);
//                 sb.append(ch[i]);
//                 getNextNumber(num,idx+1,ch,map,visitedIdx,sb);
//                 sb.deleteCharAt(sb.length()-1);
//                 visitedIdx.remove(i);
//             }
//         }


        for (int i = 0; i<num.length();i++) {

            if (!visitedIdx.contains(i)) {
                visitedIdx.add(i);
                sb.append(num.charAt(i));
                getNextNumber(num,idx+1,ch,map,visitedIdx,sb);
                sb.deleteCharAt(sb.length()-1);
                visitedIdx.remove(i);

            }


        }





        return;

    }


    public static void compareAndNextBigger(String temp) {

         if (!output.equalsIgnoreCase("Not Possible") ){

        for(int i = 0; i< temp.length();i++) {
            if (temp.charAt(i) <= output.charAt(i)) {
                System.out.println("=====" +temp.charAt(i));
                System.out.println(output.charAt(i));

                continue;

            } else {

                return;
            }


        }


        output = temp;
     } else {

       output = temp;

     }

    }



    public static Map<Character,List<Integer>> generateMap(char[] ch) {


        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i = 0; i< ch.length;i++) {
            if (map.containsKey(ch[i])) {

                map.get(ch[i]).add(i);
            } else {

                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch[i],list);

            }


        }


        return map;

    }

}