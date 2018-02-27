package Consecutive;

import java.util.LinkedList;

public class App {

    public static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args){
        list.add(0);
        list.add(-1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(-2);
        list.add(1);
        list.add(4);
        list.add(4);



        int count = 0;
        while (count<list.size()-1){
            if(list.get(count) == list.get(count+1)){
                list.remove(count);
                list.remove(count);
                count--;
            }else {
                count++;
            }

        }

//        remove();

        System.out.println(list);

    }

    public static void remove(){

        if(list.size()==0){
            return;
        }

         boolean check  =  removeIndices();
         if(check==false){
             return;
         }
        remove();
    }

    public static boolean removeIndices(){

        boolean same = false;
        int count = 0;
        while (count<list.size()-1){
            if(list.get(count) == list.get(count+1)){
                list.remove(count);
                list.remove(count);
                same = true;
            }else {
                count++;
            }

        }


        return same;


    }


}
