package DailyByte;

public class StrRev {

    public static void main(String[] args) {
        String s = "The Daily Byte";
        String rev = reverse(s);
        System.out.println(rev);
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        int size = s.length();

        while(size-1>=0) {
            sb.append(s.charAt(size-1));
            size--;
        }

        return sb.toString();
    }
}
