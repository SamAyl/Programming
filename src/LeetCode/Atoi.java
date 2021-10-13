package LeetCode;

public class Atoi {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        str = str.replace(" ","");
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(count<ch.length) {
            if(count == 0 && (ch[count]=='+' || ch[count] == '-')){
                continue;
            } else if (ch[count] - '0' >=0 && ch[count]-'0'<=9) {
                sb.append(ch[count]);
                count++;
            } else {
                break;
            }
        }

        if(sb.length() == 0) {
            return 0;
        }

        Long val = Long.parseLong(sb.toString());
        if(val>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (val < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
           return Integer.parseInt(sb.toString());
        }


    }
}
