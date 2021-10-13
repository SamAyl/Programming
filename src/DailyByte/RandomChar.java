package DailyByte;

public class RandomChar {

    public static void main(String[] args) {
        String w = "abc";
        String t = "abcd";


        int sum = 0;

        int idx = 0;

        while (idx < w.length()){
            sum+=((w.charAt(idx)) - 'a');
            idx++;
        }

        idx = 0;

        while (idx < t.length()) {
            sum-=(t.charAt(idx) - 'a');
            idx++;
        }

        sum = -1 * sum;
        int str = 'a';
        sum+=str;

        char ch = (char)sum;
        System.out.println(ch);
    }
}
