package Lambdas.Exception;

import java.util.function.BiConsumer;


public class App {

    public static void main(String[] args){
//        print((i,j)->{
//            try{
//            System.out.println(i/j);
//                         }catch (Exception e){
//                            e.printStackTrace();
//            }},10,0);

        print((i,j)-> System.out.println(i/j),4,2);

    }

    public static void print(BiConsumer<Integer,Integer> consumer,int val,int key){
        consumer.accept(val,key);
    }


    public static BiConsumer<Integer,Integer> wrapConsumer(BiConsumer<Integer,Integer> consumer){
        return (i,j)->{
            try {
                consumer.accept(i,j);
            }catch (Exception e){

            }
        };
    }
}
