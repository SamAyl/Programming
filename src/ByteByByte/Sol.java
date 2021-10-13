package ByteByByte;
import java.util.*;

public class Sol {

    public static void main(String[] args) {
      //  System.out.println(calculate());
    }

        public static int calculate(String s) {


            s = s.replace(" ","");
            if(s.length()==1){
                return Integer.parseInt(s);
            } else if((!s.contains("+") && !s.contains("-"))){
                s =s.replace("(","");
                s =s.replace(")","");
                return Integer.parseInt(s);
            }
            char[] ch = s.toCharArray();

            Stack<Character> stack = new Stack<>();
            Map<Character,Integer> map = new HashMap<>();

            for(int i = 0;i<ch.length;i++){
                if(ch[i]==')'){
                    List<Character> list = new ArrayList<>();
                    while(stack.peek()!='('){
                        list.add(stack.pop());
                    }

                    stack.pop();
                    stack.push(addElements(list,map));
                }else{
                    stack.push(ch[i]);
                }
            }


            if(stack.size()==1){
                return map.get(stack.pop());
            } else {
                List<Character> list1 = new ArrayList<>();
                while(!stack.isEmpty()){
                    list1.add(stack.pop());
                }

              return  map.get(addElements(list1,map));
            }
        }


        public static char addElements(List<Character> list,Map<Character,Integer> map){
            int pSum =0;
            int nSum = 0;

            int i =list.size()-1;
            while(i>=0){
//                if(i==0){
//                    if(map.containsKey(list.get(i))){
//                        pSum+=map.get(list.get(i));
//                    } else{
//                        pSum+=Integer.parseInt(list.get(i).toString());
//                    }
//                    i++;
                 if(list.get(i) == '+' || list.get(i) == '-'){
                    i--;
                } else {
                    if(i == list.size()-1 || list.get(i+1) == '+'){
                        if(map.containsKey(list.get(i))){
                            pSum+=map.get(list.get(i));
                        } else{
                            pSum+=Integer.parseInt(list.get(i).toString());
                        }
                    } else {
                        if(map.containsKey(list.get(i))){
                            nSum+=map.get(list.get(i));
                        } else{
                            nSum+=Integer.parseInt(list.get(i).toString());
                        }
                    }

                    i--;
                }
            }

            int ans = pSum-nSum;
            char ch = (char) (map.size()+'a');
            map.put(ch,ans);
            return ch;
        }




}
