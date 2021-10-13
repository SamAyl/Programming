package CSES;

import java.util.*;

public class App3 {
    public static void main(String[] args) {
        App3 app3 = new App3();
        app3.generateDivTags(2);
    }

    public ArrayList<String> generateDivTags(int numberOfTags) {

        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
        sb.append("</div>");

        sb.delete(sb.length()-1 - 5, sb.length());
        System.out.println(sb.toString());

        ArrayList<String> list = new ArrayList<>();
        //getCount(numberOfTags,0,0,new Stack<String>(),list);
        return list;
    }


    public void getCount(int num, int openTagCount, int closeTagCount, Stack<String> sb, List<String> list) {
        if (openTagCount == num && closeTagCount == num) {
            list.add(sb.toString());
            return;
        }

        if (openTagCount< num) {
            if (openTagCount == closeTagCount) {
                sb.push("<div>");
                getCount(num,openTagCount+1,closeTagCount,sb,list);
                sb.pop();
            } else if (openTagCount>closeTagCount) {
                sb.push("</div>");
                getCount(num,openTagCount,closeTagCount+1,sb,list);
                sb.pop();
            }
        } else if (openTagCount == num) {
            if (closeTagCount< num) {
                sb.push("</div>");
                getCount(num,openTagCount, closeTagCount+1,sb,list);
                sb.pop();
            }
        }


    }
}
