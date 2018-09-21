package KickStart;

public class Subset {

    public static void main(String[] args) {
        String s = "234";
        Long i = new Long(0);

        char[] c = s.toCharArray();

       printSubstring(c,0,new StringBuilder());
       StringBuilder sb = new StringBuilder();



    }


    public static void printSubstring(char[] c,int current,StringBuilder sb){
        if(current==c.length){
            return;
        }

        for (int i = current;i<c.length;i++){
            sb.append(c[i]);
            System.out.println(sb.toString());
            printSubstring(c,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
