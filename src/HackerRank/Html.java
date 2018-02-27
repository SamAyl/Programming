package HackerRank;

import java.util.*;

public class Html {

    public static void main(String[] args){

        html( "3 \n" +
                "<N> \n" +
" <HELLO> </HELLO>\n" +
                " <END></END>");


    }

    public static void html(String s){

        String[] lines = s.split("\n");
//        Integer lineSize = Integer.valueOf(lines[0].substring(0,1));
//
//        if(lineSize != lines.length-1){
//            System.out.println();
//        }

        Stack<Tag> tagStrings = new Stack();
        Map<String,List<Integer>> map = new HashMap<>();

        boolean allChecks = true;

        for(int j = 1;j<lines.length;j++){
            String line = lines[j];
            List<Tag> tags = new ArrayList<>();
           for(int i = 0;i<line.length();i++){
               if(line.charAt(i) == '<'){
                   String temp = getString(line,i);
                   if(temp!=null) {
                       Tag t = new Tag(temp,j);
                       tags.add(t);

                   }else {
                       System.out.println("line "+ j +": too many/few characters in tag name");
                       return;
                   }
               }
           }



           if(!tags.isEmpty()){
             allChecks =  check(tagStrings,tags,j);
           }

           if(allChecks==false){
               return;
           }

        }


        if(tagStrings.size()==0){
         allChecks = true;
        }else {
            System.out.println("line "+ tagStrings.pop().lineNo+": "+"expected </xxxx>");
            return;
        }

        if(allChecks==true){
            System.out.println("OK");
        }


    }


    public static String getString(String line, int i){
        int j = i;
        while(j<line.length() && line.charAt(j)!='>' ){
            j++;
        }

        j++;

        if(j>line.length()){
            return null;
        }

      return   line.substring(i,j);
    }


    public static boolean check(Stack<Tag> stack ,List<Tag> tags,int lineNumber){

        for(Tag s : tags){
            if(!s.str.contains("/")){
                stack.push(s);
            }else{

                Tag temp = stack.pop();
                if(temp==null){
                    System.out.println("line "+lineNumber +": no matching begin tag");
                    return false;
                }else{
                    return match(temp,s,lineNumber);
                }
            }
        }



        return true;


    }


    public static boolean match(Tag begin,Tag end,int lineNumber){

       end.str = end.str.replace("/","");



        if(begin.str.length()==2){
            System.out.println("line "+lineNumber +":too many/few characters in tag name");
            return false;
        }

        if(begin.str.length()>12){
            System.out.println("line "+lineNumber +":too many/few characters in tag name");
            return false;
        }

        if(!begin.str.equalsIgnoreCase(end.str)){
            System.out.println("line "+lineNumber +":no matching begin tag");
            return false;
        }


        for(int i = 1;i<begin.str.length()-1;i++){

            int num1 = (int)begin.str.charAt(i);
            int num2 = (int)end.str.charAt(i);

            if((num1>=65 && num1<=90) && (num2>=65 && num2<=90)){
                return true;
            }else{
                System.out.println("line "+lineNumber +":bad character in tag name");
                return false;
            }
        }


        return true;

    }



}


    class Tag{

        String str;
        int lineNo;


        Tag(String str,int lineNo){
            this.str = str;
            this.lineNo = lineNo;
        }


        }
