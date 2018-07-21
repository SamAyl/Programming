package sg_group5.CountVowels.ArrStack;

import Lambdas.Functional.Int;

public class ArrayStack {

    int[] elements;
    int currIndex = -1;

    public ArrayStack(int size){
        elements = new int[size];
    }

    public void push(int v){
        if(currIndex==elements.length-1){
            System.out.println("stack is full");
            return;
        }
        currIndex++;
        elements[currIndex] = v;
    }

    public Integer pop(){
        if(currIndex==-1){
            return null;
        }
        currIndex--;
        return elements[currIndex+1];
    }


}
