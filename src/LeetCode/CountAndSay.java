package LeetCode;

public class CountAndSay {


    public static void main(String[] args) {
        System.out.println(say(6));
        //
    }

    public static String say(int n){
        if(n == 1) {return "1";}

        String word = say(n-1);
        char[] ch = word.toCharArray();

        char prev = ch[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<ch.length;i++){
            if(prev == ch[i]){
                count++;
            } else {
                sb.append(count);
                sb.append(Integer.parseInt(String.valueOf(prev)));
                prev = ch[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(Integer.parseInt(String.valueOf(prev)));

        return sb.toString();

    }
}
