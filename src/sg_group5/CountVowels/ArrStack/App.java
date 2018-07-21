package sg_group5.CountVowels.ArrStack;

public class App {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for(int i = 0;i<11;i++){
            arrayStack.push(i);
        }

        int count = 0;

        while (count<10){
            System.out.println(arrayStack.pop());
            count++;
        }
    }





}
