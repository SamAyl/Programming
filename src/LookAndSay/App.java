package LookAndSay;

public class App {

    public static void main(String[] args) {

        System.out.println(findNext("1"));
    }


    public static String findNext(String s){
        if(s==null || s.isEmpty()){
            return s;
        }

        int count = 0;
        int prev = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.toCharArray().length;i++){
            if(s.charAt(i)==s.charAt(prev)){
                count++;
                prev = i;
            }else {
                sb.append(Integer.toString(count));
                sb.append(s.charAt(prev));
                prev = i;
                count=1;
            }
        }

        sb.append(Integer.toString(count));
        sb.append(s.charAt(prev));




        return sb.toString();

    }


}
