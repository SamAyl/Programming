package DailyByte;

public class RoboPath {

    public static void main(String[] args) {
        String path = "RUULLDRD";
        System.out.println(check(path,0,0,0));


    }


    public static boolean check(String s, int idx, int pox, int poy) {

        if (idx == s.length()) {
            if (pox == 0 && poy == 0) {
                return  true;
            } else {
                return false;
            }
        }

        if (s.charAt(idx) == 'U') {
            return check(s,idx+1,pox,poy+1);
        } else if (s.charAt(idx) == 'D') {
            return check(s,idx+1,pox,poy-1);
        } else if (s.charAt(idx) == 'L') {
            return check(s,idx+1,pox+1,poy);
        } else {
            return check(s,idx+1,pox-1,poy);
        }


    }
}
