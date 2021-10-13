package AlgoExpert;

public class Stringfy1 {

    public static void main(String[] args) {
        String s = "avvcsssavv";
        int[] p = new int[s.length()];

        int i = 1;
        int str = 0;
        int count = 0;
        while(i<s.length()) {
            if(s.charAt(str) == s.charAt(i)) {
                count++;
                p[i] = count;
                str++;
                i++;
            } else {
                str = 0;
                count = 0;
                i++;
            }
        }

        for (int idx : p) {
            System.out.print(idx +"---");
        }
    }
}
