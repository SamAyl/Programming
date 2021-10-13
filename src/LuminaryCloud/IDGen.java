package LuminaryCloud;

public class IDGen {


    // 64bit ==>

    static int count =1000;
    static int[] buffer = new int[1000];
    static int currCount = 1001;



   static int[] bufferNewSet = new int[1000];
   static boolean bufferNewSetFilled = false;



    public static void getIDs(int count, int[] buffer) {

    }


    public static int getOneID() {
        if (currCount <= count) {
            return getElement(buffer);
        } else {

            //waiting for the scheduler based on flag
             while (!bufferNewSetFilled) {
                 //wait
             }



            int[] temp = buffer;
            buffer = bufferNewSet;
            bufferNewSet = temp;

            //reseting the flag
            bufferNewSetFilled = false;

            currCount = 0;
           return getElement(buffer);
        }

    }


    public static int getElement(int[] buffer) {
        int element =  buffer[currCount];
        currCount++;
        return element;
    }
}


class Scheduler{

    public void checkCurrCountAndUpdate() {
        if (IDGen.currCount >750 && !IDGen.bufferNewSetFilled) {
            IDGen.getIDs(IDGen.count,IDGen.bufferNewSet);
            IDGen.bufferNewSetFilled = true;
        }
    }

}