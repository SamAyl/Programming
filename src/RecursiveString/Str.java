package RecursiveString;

public class Str {

    String s = "abcd";
    char[] str = s.toCharArray();

    public static void main(String[] args){
        String str = "abcd";
        Character[] s = new Character[str.length()];
        recurprint(str,s,0,0,str.length()-1);
    }


    public static void recurprint(String str,Character[] s,int j,int index,int shift){

        if(j==str.length()-1 && index < str.length()){
            s[j] = str.charAt(index);
            print(s);
            index++;
            recurprint(str,s,j,index,shift);
        }else if(index <str.length()){
            s[j] = str.charAt(index);
            j++;
            recurprint(str,s,j,index,shift);

        }else if(shift>=0 && j<str.length()){


        }

    }

    public static void print(Character[] s){
        for(int i = 0;i<s.length;i++){
            System.out.print(s[i]);
        }
        System.out.println();
    }

}
